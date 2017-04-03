package com.order.app.services.types;

import com.order.app.dao.UserDao;
import com.order.app.mappers.UserDisplayDataMapper;
import com.order.app.models.User;
import com.order.app.models.display.UserDisplayData;
import com.order.app.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bryan.bernabe on 3/27/2017.
 */
@Component
public class UserServiceImpl implements UserService {
  private UserDao userDao;
  private UserDisplayDataMapper userDisplayDataMapper;

  @Autowired
  public UserServiceImpl(UserDao userDao, UserDisplayDataMapper userDisplayDataMapper) {
    this.userDao = userDao;
    this.userDisplayDataMapper = userDisplayDataMapper;
  }


  @Override
  public boolean create(User user) {
    return userDao.create(user);
  }

  @Override
  public void update(User user) {

  }

  @Override
  public UserDisplayData findById(Integer userId) {
    return userDisplayDataMapper.map(userDao.findById(userId));
  }

  @Override
  public UserDisplayData login(User user) {
    return userDisplayDataMapper.map(userDao.login(user));
  }

  @Override
  public List<UserDisplayData> getAll() {
    List<User> users = userDao.getAll();
    List<UserDisplayData> accountDisplayList = null;
    if(users != null && !users.isEmpty()){
      accountDisplayList = new ArrayList<UserDisplayData>();
      for(User tempUser : users){
        accountDisplayList.add(userDisplayDataMapper.map(tempUser));
      }
    }
    return accountDisplayList;
  }
}
