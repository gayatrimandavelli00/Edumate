package com.dao;

import java.util.List;

import org.hibernate.SessionFactory;


import com.ts.db.HibernateTemplate;
import com.ts.dto.ItemDetails;

public class ItemDAO {
private SessionFactory factory = null;
	
	public List<ItemDetails> getAllItemDetails(String x) {
		System.out.println(x);
		List<ItemDetails> itemDetails=(List)HibernateTemplate.getObjectListByQuery("From ItemDetails where itemName="+x);
		return itemDetails;	
	}
	
	
	public int additem(ItemDetails item) {
		System.out.println(item); 
		return HibernateTemplate.addObject(item);
	}
	
	public long getCount3() {
		return HibernateTemplate.getCount3();
		}

	
}