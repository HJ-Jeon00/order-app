package com.order.app.services;

import com.order.app.models.Account;
import com.order.app.models.display.AccountDisplayData;

import java.util.List;

/**
 * Created by bryan.bernabe on 3/27/2017.
 */
public interface AccountService {
  boolean create(Account account);
  void update(Account account);
  AccountDisplayData findById(Integer userId);
  AccountDisplayData login(Account account);
  List<AccountDisplayData> getAll();
}
