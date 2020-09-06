package com.shopbridge.dao.spring;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.shopbridge.dao.ProductDao;
import com.shopbridge.dto.Product;
import com.shopbridge.exception.ProductDaoException;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
@Scope("singleton")
@Service
public class ProductDaoImpl extends AbstractDAO implements RowMapper<Product>, ProductDao {
	@Autowired
	protected DataSource ds;
	@Autowired
	protected JdbcTemplate jdbcTemplate;


	public String getTableName() {
		return "Shop_Bridge.dbo.product";

	}	

	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		Product  dto = new Product() ;
		dto.setProductId(rs.getInt(1));
		dto.setName(rs.getString(2));
		dto.setPrice(rs.getInt(3));
		dto.setDescription(rs.getString(4));
		dto.setImage(rs.getBytes(5));
		dto.setIsDeleted(rs.getBoolean(6));
		return dto;
	}
	@Override
	public List<Product> findAll() throws ProductDaoException {
		List<Product> list = jdbcTemplate.query("SELECT PRODUCT_ID, NAME, PRICE, DESCRIPTION, ISDELETED, ISDELETED FROM " + getTableName(), this);          
		return list;
	}
	
	@Override
	public Product getProductById(int id) throws ProductDaoException {
		List<Product> list = jdbcTemplate.query("SELECT PRODUCT_ID, NAME, PRICE, DESCRIPTION, ISDELETED, ISDELETED FROM " + getTableName() + " Where PRODUCT_ID = " + id, this);          
		return list.get(0);
	}

}
