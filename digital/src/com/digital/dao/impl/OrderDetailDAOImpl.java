package com.digital.dao.impl;

import com.digital.dao.OrderDetailDAO;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.digital.entity.OrderDetail;
import com.digital.entity.ProductInfo;

public class OrderDetailDAOImpl implements OrderDetailDAO {
    SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory) {
        this. sessionFactory = sessionFactory;
        }
	
	@Override
	public void addOrderDetail(OrderDetail orderDetail) {
		// TODO Auto-generated method stub
		Session session =sessionFactory.getCurrentSession();
  	  session.saveOrUpdate(orderDetail);
	}

}
