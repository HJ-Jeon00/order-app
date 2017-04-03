package com.order.app.mappers;

import com.order.app.models.User;
import com.order.app.models.display.UserDisplayData;

import org.springframework.stereotype.Component;

/**
 * Created by bryan.bernabe on 3/28/2017.
 */
@Component
public class UserDisplayDataMapper {

  public UserDisplayData map(User user){
    UserDisplayData userDisplayData = null;
    if(user != null){
      userDisplayData = new UserDisplayData();
      userDisplayData.setUserId(user.getUser_id());
      userDisplayData.setUsername(user.getUsername());
      userDisplayData.setLastName(user.getLast_name());
      userDisplayData.setFirstName(user.getFirst_name());
      userDisplayData.setEmail(user.getEmail());
      user.setRole(user.getRole());
    }
    return userDisplayData;
  }
}
