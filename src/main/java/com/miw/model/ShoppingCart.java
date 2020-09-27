package com.miw.model;

import java.util.HashMap;

public class ShoppingCart {
	
	private HashMap<String, Integer> list;
	
	public ShoppingCart() {
		this.list = new HashMap<String, Integer>();
	}
	
	public HashMap<String, Integer> getList(){
		return list;
	}
	
	public void add(String element) {
		Integer num = list.get(element);
		if( num != null ) {
			list.remove(element);
			num++;
			list.put(element, num);
		}
		else {
			list.put(element, 1);
		}
	}

}
