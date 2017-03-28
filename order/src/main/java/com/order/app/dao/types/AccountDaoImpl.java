package com.order.app.dao.types;

import com.order.app.dao.AccountDao;
import com.order.app.models.Account;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by bryan.bernabe on 3/27/2017.
 */
@Repository
@Transactional
public class AccountDaoImpl implements AccountDao {

  @Override
  public void create(Account account) {
    account.setPassword(BCrypt.hashpw(account.getPassword(), BCrypt.gensalt()));
    getSession().save(account);
  }

  @Override
  public void update(Account account) {
    getSession().update(account);
  }


  @Override
  public Account findById(Integer userId) {
    return (Account) getSession().createQuery(
      "FROM Account WHERE user_id = :userId")
      .setParameter("userId", userId)
      .uniqueResult();
  }

  @Override
  public Account login(Account account) {
    Account loginAccount = (Account) getSession().createQuery(
      "FROM Account WHERE username = :username")
      .setParameter("username", account.getUsername())
      .uniqueResult();
    if (BCrypt.checkpw(account.getPassword(), loginAccount.getPassword())) {
      return loginAccount;
    } else {
      return null;
    }
  }

  @Autowired
  private SessionFactory _sessionFactory;

  protected Session getSession() {
    return _sessionFactory.getCurrentSession();
  }

}
