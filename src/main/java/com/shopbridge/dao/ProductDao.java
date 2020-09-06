package com.shopbridge.dao;

import java.util.List;

import com.shopbridge.dto.Product;
import com.shopbridge.exception.ProductDaoException;
public interface ProductDao {
	public List<Product> findAll() throws ProductDaoException;
	public Product getProductById(int id) throws ProductDaoException;
}
