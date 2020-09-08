package com.shopbridge.dao.spring;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

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
	public Product findProductById(int id) throws ProductDaoException {
		List<Product> list = jdbcTemplate.query("SELECT PRODUCT_ID, NAME, PRICE, DESCRIPTION, ISDELETED, ISDELETED FROM " + getTableName() + " Where PRODUCT_ID=" + id, this);         
		return list.get(0);
	}
	
	@Override
	public Boolean deleteProductById(int id) throws ProductDaoException {
		jdbcTemplate.query("DELETE FROM " + getTableName() + " WHERE PRODUCT_ID=" + id, this);         
		return true;
	}
	
	@Override
	public Product addProduct(@RequestBody Product newProduct) throws ProductDaoException {
		List<Product> list = jdbcTemplate.query("INSERT INTO FROM " + getTableName() + " (NAME, PRICE, DESCRIPTION, ISDELETED, IMAGE) " + 
				"VALUES ('" + newProduct.getName() + "', '" + newProduct.getPrice() + "', '" + "', '" + newProduct.getDescription() +"', '" + false +"', '" + newProduct.getImage() + "');", this);
		System.out.println("List of product" +list);
		return list.get(0);
	}
}
