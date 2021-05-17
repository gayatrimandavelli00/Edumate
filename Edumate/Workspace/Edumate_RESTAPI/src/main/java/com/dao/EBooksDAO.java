package com.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.ts.db.HibernateTemplate;
import com.ts.dto.EBooks;
//import com.ts.dto.ItemDetails;
import com.ts.dto.TimeTable;

public class EBooksDAO {
private SessionFactory factory = null;
	
//	public List<ItemDetails> getAllItemDetails(String x) {
//		System.out.println(x);
//		List<ItemDetails> itemDetails=(List)HibernateTemplate.getObjectListByQuery("From ItemDetails where itemName="+x+" and itemId=(select max(itemId) from ItemDetails where itemName="+x+")");
//		return itemDetails;	
//	}
//	
	
	public int additem(EBooks ebook) {
		System.out.println(ebook); 
		return HibernateTemplate.addObject(ebook);
	}

	public List<EBooks> getAllBooks() {
		//System.out.println("Inside dao " + dept);
		List<EBooks> books=(List)HibernateTemplate.getObjectListByQuery("From EBooks");
		System.out.println("Inside All Employees ..."+books);
		return books;
	}
	
	public long getCount() {
		return HibernateTemplate.getCount1();
		}

}