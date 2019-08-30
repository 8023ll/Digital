package com.digital.dao.impl;
import java.util.List;
import org.hibernate.*;
import com.digital.dao.*;
import com.digital.entity.*;
import java.nio.channels.SeekableByteChannel;
      public class TypeDAOImpl implements TypeDAO {
      SessionFactory sessionFactory;
      public void setSessionFactory(SessionFactory sessionFactory) {
      this. sessionFactory = sessionFactory;
      }
      
      @Override
      public List<Type> getAll() {
      List<Type> typeList = null;
      Session session =sessionFactory.getCurrentSession() ;
      Criteria c=session.createCriteria(Type.class);
      typeList=c.list();
      return typeList;
      }
}

