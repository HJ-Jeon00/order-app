package com.order.app.services.types;

import com.order.app.dao.AccountDao;
import com.order.app.mappers.AccountDisplayDataMapper;
import com.order.app.models.Account;
import com.order.app.models.display.AccountDisplayData;
import com.order.app.services.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bryan.bernabe on 3/27/2017.
 */
@Component
public class AccountServiceImpl implements AccountService{
  private AccountDao accountDao;
  private AccountDisplayDataMapper accountDisplayDataMapper;

  @Autowired
  public AccountServiceImpl(AccountDao accountDao, AccountDisplayDataMapper accountDisplayDataMapper) {
    this.accountDao = accountDao;
    this.accountDisplayDataMapper = accountDisplayDataMapper;
  }


  @Override
  public boolean create(Account account) {
    return accountDao.create(account);
  }

  @Override
  public void update(Account account) {

  }

  @Override
  public AccountDisplayData findById(Integer userId) {
    return accountDisplayDataMapper.map(accountDao.findById(userId));
  }

  @Override
  public AccountDisplayData login(Account account) {
    return accountDisplayDataMapper.map(accountDao.login(account));
  }

  @Override
  public List<AccountDisplayData> getAll() {
    List<Account> accounts = accountDao.getAll();
    List<AccountDisplayData> accountDisplayList = null;
    if(accounts != null && !accounts.isEmpty()){
      accountDisplayList = new ArrayList<AccountDisplayData>();
      for(Account tempAccount : accounts){
        accountDisplayList.add(accountDisplayDataMapper.map(tempAccount));
      }
    }
    return accountDisplayList;
  }
}
