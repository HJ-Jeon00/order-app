package com.order.app.dao.types;

import com.order.app.dao.UserDao;
import com.order.app.dao.BaseDao;
import com.order.app.exceptions.DatabaseException;
import com.order.app.models.User;
import com.order.app.models.utilities.EncryptionUtil;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

/**
 * Created by bryan.bernabe on 3/27/2017.
 */
@Repository
@Transactional
public class UserDaoImpl extends BaseDao implements UserDao {

  @Override
  public boolean create(User user) {
    user.setPassword(EncryptionUtil.encrypt(user.getPassword()));

    boolean result = true;
    Session session = null;
    try {
      session = super.sessionFactory.openSession();
      session.getTransaction().begin();
      session.save(user);
      session.getTransaction().commit();
    } catch (HibernateException e) {
      result = false;
      List<String> errors = new ArrayList<>();
      errors.add(e.getCause().getMessage());
      throw new DatabaseException(errors);
    } finally {
      if (session != null)
        session.close();
    }
    return result;
  }

  @Override
  public void update(User user) {
    getSession().update(user);
  }


  @Override
  public User findById(Integer userId) {
    Session session = null;
    User user = null;
    try {
      session = super.sessionFactory.openSession();
      user = (User) session.createQuery(
        "FROM User WHERE user_id = :userId")
        .setParameter("userId", userId)
        .uniqueResult();
    } catch (HibernateException e) {
      List<String> errors = new ArrayList<>();
      errors.add(e.getCause().getMessage());
      throw new DatabaseException(errors);
    } finally {
      if (session != null)
        session.close();
    }
    return user;
  }

  @Override
  public List<User> getAll() {
    List<User> users = null;
    Session session = null;
    try{
      session = super.sessionFactory.openSession();
      users = (List<User>) session.createQuery("FROM User").list();
    } catch (HibernateException e){
      List<String> errors = new ArrayList<>();
      errors.add(e.getCause().getMessage());
      throw new DatabaseException(errors);
    } finally {
      if (session != null)
        session.close();
    }
    return users;
  }

  @Override
  public User login(User inputUser) {
    User loginUser = null;
    boolean authPass = false;
    Session session = null;
    try{
      if (inputUser != null) {
        session = super.sessionFactory.openSession();
        loginUser = (User) session.createQuery(
          "FROM User WHERE username = :username")
          .setParameter("username", inputUser.getUsername())
          .uniqueResult();
        if (loginUser != null) {
          authPass = EncryptionUtil.checkPassword(inputUser.getPassword(), loginUser
            .getPassword());
        }
        if (!authPass) {
          loginUser = null;
        }
      }
    }catch (HibernateException e){
      List<String> errors = new ArrayList<>();
      errors.add(e.getCause().getMessage());
      throw new DatabaseException(errors);
    }finally {
      if (session != null)
        session.close();
    }

    return loginUser;
  }

}
