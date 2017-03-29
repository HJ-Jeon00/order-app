package com.order.app.dao;

import com.order.app.models.Account;

import java.util.List;

/**
 * Created by bryan.bernabe on 3/27/2017.
 */
public interface AccountDao {
  boolean create(Account account);

  void update(Account account);

  Account findById(Integer userId);

  Account login(Account account);

  List<Account> getAll();
}
