package com.digital.dao;
import com.digital.entity.*;
import java.util.List;
public interface ProductInfoDAO {
	public List<ProductInfo> getAll();
	public ProductInfo getProductInfoByPiId(int piId);
}


