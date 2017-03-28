package com.order.app.mappers;

import com.order.app.models.Account;
import com.order.app.models.display.AccountDisplayData;

import org.springframework.stereotype.Component;

/**
 * Created by bryan.bernabe on 3/28/2017.
 */
@Component
public class AccountDisplayDataMapper {

  public AccountDisplayData map(Account account){
    AccountDisplayData accountDisplayData = null;
    if(account != null){
      accountDisplayData = new AccountDisplayData();
      accountDisplayData.setUserId(account.getUser_id());
      accountDisplayData.setUsername(account.getUsername());
      accountDisplayData.setLastName(account.getLast_name());
      accountDisplayData.setFirstName(account.getFirst_name());
      accountDisplayData.setEmail(account.getEmail());
      account.setRole(account.getRole());
    }
    return accountDisplayData;
  }
}
