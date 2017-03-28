package com.order.app.services;

import com.order.app.models.Account;

/**
 * Created by bryan.bernabe on 3/27/2017.
 */
public interface AccountService {
  void create(Account account);
  void update(Account account);
  Account findById(Integer userId);
  Account login(Account account);
}
