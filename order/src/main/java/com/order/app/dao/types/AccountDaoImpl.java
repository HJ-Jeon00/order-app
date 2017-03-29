package com.order.app.dao.types;

import com.order.app.dao.AccountDao;
import com.order.app.dao.BaseDao;
import com.order.app.exceptions.DatabaseException;
import com.order.app.models.Account;
import com.order.app.models.utilities.EncryptionUtil;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

/**
 * Created by bryan.bernabe on 3/27/2017.
 */
@Repository
@Transactional
public class AccountDaoImpl extends BaseDao implements AccountDao {

  @Override
  public boolean create(Account account) {
    account.setPassword(EncryptionUtil.encrypt(account.getPassword()));

    boolean result = true;
    Session session = null;
    try {
      session = super.sessionFactory.openSession();
      session.getTransaction().begin();
      session.save(account);
      session.getTransaction().commit();
    } catch (HibernateException e) {
      result = false;
      List<String> errors = new ArrayList<>();
      errors.add(e.getCause().getMessage());
      throw new DatabaseException(errors);
    } finally {
      if (session != null)
        session.close();
    }
    return result;
  }

  @Override
  public void update(Account account) {
    getSession().update(account);
  }


  @Override
  public Account findById(Integer userId) {
    Session session = null;
    Account account = null;
    try {
      session = super.sessionFactory.openSession();
      account = (Account) session.createQuery(
        "FROM Account WHERE user_id = :userId")
        .setParameter("userId", userId)
        .uniqueResult();
    } catch (HibernateException e) {
      List<String> errors = new ArrayList<>();
      errors.add(e.getCause().getMessage());
      throw new DatabaseException(errors);
    } finally {
      if (session != null)
        session.close();
    }
    return account;
  }

  @Override
  public List<Account> getAll() {
    List<Account> accounts = null;
    Session session = null;
    try{
      session = super.sessionFactory.openSession();
      accounts = (List<Account>) session.createQuery("FROM Account").list();
    } catch (HibernateException e){
      List<String> errors = new ArrayList<>();
      errors.add(e.getCause().getMessage());
      throw new DatabaseException(errors);
    } finally {
      if (session != null)
        session.close();
    }
    return accounts;
  }

  @Override
  public Account login(Account inputAccount) {
    Account loginAccount = null;
    boolean authPass = false;
    Session session = null;
    try{
      if (inputAccount != null) {
        session = super.sessionFactory.openSession();
        loginAccount = (Account) session.createQuery(
          "FROM Account WHERE username = :username")
          .setParameter("username", inputAccount.getUsername())
          .uniqueResult();
        if (loginAccount != null) {
          authPass = EncryptionUtil.checkPassword(inputAccount.getPassword(), loginAccount
            .getPassword());
        }
        if (!authPass) {
          loginAccount = null;
        }
      }
    }catch (HibernateException e){
      List<String> errors = new ArrayList<>();
      errors.add(e.getCause().getMessage());
      throw new DatabaseException(errors);
    }finally {
      if (session != null)
        session.close();
    }

    return loginAccount;
  }

}
