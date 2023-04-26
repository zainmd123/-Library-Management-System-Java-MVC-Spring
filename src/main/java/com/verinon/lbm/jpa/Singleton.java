package com.verinon.lbm.jpa;

import com.verinon.lbm.services.SmartServices;

public class Singleton {
	private static SmartServices obj;
	
	private Singleton()
	{
		
	}
	
	 public static SmartServices getInstance() {

	      // create object if it's not already created
	      if(obj == null) {
	         obj = new SmartServices();
	      }

	       // returns the singleton object
	       return obj;
	   }
}
