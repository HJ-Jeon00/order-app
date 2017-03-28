package com.order.app.dao;

import com.order.app.models.Account;

/**
 * Created by bryan.bernabe on 3/27/2017.
 */
public interface AccountDao {
  void create(Account account);

  void update(Account account);

  Account findById(Integer userId);

  Account login(Account account);
}
