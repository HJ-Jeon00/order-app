package com.order.app.dao;

import com.order.app.models.User;

import java.util.List;

/**
 * Created by bryan.bernabe on 3/27/2017.
 */
public interface UserDao {
  boolean create(User user);

  void update(User user);

  User findById(Integer userId);

  User login(User user);

  List<User> getAll();
}
