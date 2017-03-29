package com.order.app.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by bryan.bernabe on 3/28/2017.
 */
public abstract class BaseDao {

  @Autowired
  protected SessionFactory sessionFactory;

  protected Session getSession() {
    return sessionFactory.getCurrentSession();
  }
}
