package com.order.app.services.types;

import com.order.app.dao.AccountDao;
import com.order.app.models.Account;
import com.order.app.services.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by bryan.bernabe on 3/27/2017.
 */
@Component
public class AccountServiceImpl implements AccountService{
  private AccountDao accountDao;

  @Autowired
  public AccountServiceImpl(AccountDao accountDao) {
    this.accountDao = accountDao;
  }


  @Override
  public void create(Account account) {
    accountDao.create(account);
  }

  @Override
  public void update(Account account) {

  }

  @Override
  public Account findById(Integer userId) {
    return accountDao.findById(userId);
  }

  @Override
  public Account login(Account account) {
    return accountDao.login(account);
  }
}
