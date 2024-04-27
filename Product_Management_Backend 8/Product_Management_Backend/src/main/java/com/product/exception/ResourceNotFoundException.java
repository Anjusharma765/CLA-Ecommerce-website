package com.product.exception;

public class ResourceNotFoundException extends RuntimeException {
	String resourceName;
	String fieldName;
	Integer fieldValue;
	public  ResourceNotFoundException (String resourceName,String fieldName,Integer id) {
		super(String.format("%s not found with %s:%s",resourceName,fieldName,id ));
		this.resourceName=resourceName;
		this.fieldName=fieldName;
		this.fieldValue=id;
	}
	
}
