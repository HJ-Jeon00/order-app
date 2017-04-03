package com.order.app.services;

import com.order.app.models.User;
import com.order.app.models.display.UserDisplayData;

import java.util.List;

/**
 * Created by bryan.bernabe on 3/27/2017.
 */
public interface UserService {
  boolean create(User user);
  void update(User user);
  UserDisplayData findById(Integer userId);
  UserDisplayData login(User user);
  List<UserDisplayData> getAll();
}
