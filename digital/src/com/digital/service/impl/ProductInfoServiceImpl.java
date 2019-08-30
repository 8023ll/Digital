package com.digital.service.impl;
import java.util.ArrayList;
import java.util.List;

import com.digital.dao.ProductInfoDAO;
import com.digital.entity.*;
import com.digital.service.ProductInfoService;
public class ProductInfoServiceImpl implements ProductInfoService {
	ProductInfoDAO productInfoDAO;
    public void setProductInfoDAO(ProductInfoDAO productInfoDAO) {
    this. productInfoDAO = productInfoDAO;
    }
    
    @Override
    public List<ProductInfo> getAllProductInfo() {
	return productInfoDAO.getAll();
    }

	@Override
	public ProductInfo getProductInfoByPiId(int piId) {
		// TODO Auto-generated method stub
		return productInfoDAO.getProductInfoByPiId(piId);
	}
}



