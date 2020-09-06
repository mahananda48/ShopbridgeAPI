package com.shopbridge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopbridge.dao.spring.ProductDaoImpl;
import com.shopbridge.dto.Product;
import com.shopbridge.exception.ProductDaoException;
import org.springframework.web.bind.annotation.CrossOrigin;
@RestController
@RequestMapping(value="/product")
public class ProductController {
	@Autowired
	ProductDaoImpl productDaoImpl;
	@GetMapping(value="/list")
	List<Product> findAllProduct(){
		System.out.println("findAllList Method clalled");
		List<Product> list=null;
		
		try {
			
			list = productDaoImpl.findAll();
			
		} catch (ProductDaoException e) {
			// TODO Auto-generated catch block
			
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return list; 
	}
	
	@GetMapping(value="/getproductbyid:id")
	List<Product> findProductById(int id){
		System.out.println("findProductById Method clalled");
		List<Product> list=null;
		
		try {
			
			list = productDaoImpl.findAll();
			
		} catch (ProductDaoException e) {
			// TODO Auto-generated catch block
			
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return list; 
	}
} 
