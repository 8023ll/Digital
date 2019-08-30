package com.digital.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.digital.entity.CartItemBean;
import com.digital.entity.OrderDetail;
import com.digital.entity.OrderInfo;
import com.digital.entity.UserInfo;
import com.digital.service.OrderDetailService;
import com.opensymphony.xwork2.ActionSupport;

public class OrderAction extends ActionSupport implements RequestAware,SessionAware{

      OrderDetailService orderDetailService;
      public void setOrderDetailService(OrderDetailService orderDetailService) {
    	  this.orderDetailService=orderDetailService;
      }
      
      Map<String, Object> session;
      @Override
      public void setSession(Map<String, Object> session) {
  		// TODO Auto-generated method stub
    	  this.session=session;
      }
      Map<String, Object> request;
      @Override
  		public void setRequest(Map<String, Object> request) {
  		// TODO Auto-generated method stub
    	  this.request=request;
      }
      
      
      public String addOrderInfo() {
    	  
    	  OrderInfo orderInfo=new OrderInfo();

          orderInfo.setStatus("Œ¥¥¶¿Ì");
          
          SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
          orderInfo.setOrdertime(sdf.format(new Date())); 

          UserInfo userInfo=(UserInfo)session.get("CURRENT_USER");
          orderInfo.setUserInfo(userInfo);
          orderInfo.setOrderprice((Double)session.get("sumPrice"));
          Map cart= (HashMap)session.get("cart");
          
          Iterator iter=cart.keySet().iterator();
          try {
        	  while (iter.hasNext()) {
                  Object key=iter.next();
                  CartItemBean  cartItem=(CartItemBean)cart.get(key);
                  OrderDetail orderDetail=new OrderDetail();
        		  orderDetail.setProductInfo(cartItem.getPi());
                  orderDetail.setNum(cartItem.getQuantity());
                  orderDetail.setOrderInfo(orderInfo);
                  orderDetailService.addOrderDetail(orderDetail);
        	  } 
          }catch (Exception e) {
        	  e.printStackTrace();
          }
          session.remove("cart") ;
          return  "index";
          }
      

	
	
}
