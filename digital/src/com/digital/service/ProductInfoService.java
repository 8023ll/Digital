package com.digital.service;
import java.util.List;
import com.digital.entity.ProductInfo;

public interface ProductInfoService {
	
	public List<ProductInfo> getAllProductInfo();
	public ProductInfo getProductInfoByPiId(int piId);
}
