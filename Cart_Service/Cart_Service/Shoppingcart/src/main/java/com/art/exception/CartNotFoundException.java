package com.art.exception;

public class CartNotFoundException extends RuntimeException{
	
	public CartNotFoundException(String str)
	{
		super(str);
	}

}
