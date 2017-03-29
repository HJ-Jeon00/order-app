package com.order.app.dao.types;

import com.order.app.dao.ProductDao;
import com.order.app.models.Product;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Joel.Gonzales on 3/29/2017.
 */
@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

  @Override
  public List<Product> browse(String type) {
    Query query = getSession().createQuery("FROM Product WHERE type = :type");
    query.setParameter("type", type);

    return query.list();
  }

  @Override
  public void add(Product product) {
    getSession().save(product);
  }

  @Override
  public void update(Product product) {
    getSession().update(product);
  }

  @Override
  public void delete(Integer product_id) {
    Product product = new Product();
    product.setProduct_id(product_id);
    getSession().delete(product);
  }

  @Autowired
  private SessionFactory _sessionFactory;

  protected Session getSession() {
    return _sessionFactory.getCurrentSession();
  }
}
