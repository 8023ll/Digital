package com.digital.dao.impl;
import java.util.List;
import org.hibernate.*;
import com.digital.dao.*;
import com.digital.entity.*;
      public class ProductInfoDAOImpl implements ProductInfoDAO {
      SessionFactory sessionFactory;
      public void setSessionFactory(SessionFactory sessionFactory) {
      this. sessionFactory = sessionFactory;
      }
      
      @Override
      public List<ProductInfo> getAll() {
      List<ProductInfo> piList = null;
      Session session =sessionFactory.getCurrentSession() ;
      Criteria c=session.createCriteria(ProductInfo.class);
      piList=c.list();
      return piList;
      }

      @Override
      public ProductInfo getProductInfoByPiId(int piId) {
		// TODO Auto-generated method stub
    	  Session session =sessionFactory.getCurrentSession();
    	  return (ProductInfo)session.get(ProductInfo.class, piId);
      }
}

