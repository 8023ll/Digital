package com.digital.service.impl;

import com.digital.dao.OrderDetailDAO;
import com.digital.entity.OrderDetail;
import com.digital.service.OrderDetailService;

public class OrderDetailServiceImpl implements OrderDetailService {

		OrderDetailDAO orderDetailDAO;
		public void setOrderDetailDAO(OrderDetailDAO orderDetailDAO) {
			// TODO Auto-generated method stub
			this.orderDetailDAO=orderDetailDAO;
		}

	@Override
	public void addOrderDetail(OrderDetail orderDetail) {
		// TODO Auto-generated method stub
		orderDetailDAO.addOrderDetail(orderDetail);
	}

}
