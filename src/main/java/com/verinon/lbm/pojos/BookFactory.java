package com.verinon.lbm.pojos;

public class BookFactory {
	public Book getBook(String type) {
		if(type.equalsIgnoreCase("BOOK"))
		{
			return new Book();
		}
		else
			return null;
	}
}
