package com.shopbridge.dao;

import java.util.List;

import com.shopbridge.dto.Product;
import com.shopbridge.exception.ProductDaoException;
public interface ProductDao {
	public List<Product> findAll() throws ProductDaoException;
	public Product findProductById(int id) throws ProductDaoException;
	public Boolean deleteProductById(int id) throws ProductDaoException;
	public Product addProduct(Product product, int id) throws ProductDaoException;
}
