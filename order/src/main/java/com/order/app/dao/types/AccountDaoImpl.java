package com.order.app.dao.types;

import com.order.app.dao.AccountDao;
import com.order.app.dao.BaseDao;
import com.order.app.models.Account;
import com.order.app.models.utilities.EncryptionUtil;

import org.springframework.stereotype.Repository;

import java.util.List;

import javax.transaction.Transactional;

/**
 * Created by bryan.bernabe on 3/27/2017.
 */
@Repository
@Transactional
public class AccountDaoImpl extends BaseDao implements AccountDao {
  @Override
  public void create(Account account) {
    account.setPassword(EncryptionUtil.encrypt(account.getPassword()));
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
  public List<Account> getAll(){
    return (List<Account>) getSession().createQuery("FROM Account").list();
  }

  @Override
  public Account login(Account inputAccount) {
    Account loginAccount = null;
    boolean authPass = false;
    if (inputAccount != null) {
      loginAccount = (Account) getSession().createQuery(
        "FROM Account WHERE username = :username")
        .setParameter("username", inputAccount.getUsername())
        .uniqueResult();
      if(loginAccount != null){
        authPass = EncryptionUtil.checkPassword(inputAccount.getPassword(), loginAccount.getPassword());
      }
      if (!authPass) {
        loginAccount = null;
      }
    }
    return loginAccount;
  }

}
