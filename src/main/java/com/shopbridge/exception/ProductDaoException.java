package com.shopbridge.exception;

public class ProductDaoException extends DaoException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ProductDaoException(String msg) {
		super(msg);
		
	}
	public ProductDaoException(String msg, Throwable clause) {
		
		super(msg,clause);
	}
	
}
