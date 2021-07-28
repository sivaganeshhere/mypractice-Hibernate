package com.nit.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nit.entity.Product;
import com.nt.Util.Hibernate_Util;

public class HBUtil_LoadObjectandsesUpdateMethod {
public static void main(String[] args) {
	//Buil session Factory
	SessionFactory factory=Hibernate_Util.getSessionFactory();
	//Create Session Object
	Session ses=Hibernate_Util.getSession();
	Transaction tx=null;
	try(factory;ses){
		//create Object 
		Product pro=ses.get(Product.class, 2000);
	if(pro==null) {
		System.out.println("Record Not Updated");
	}else {
		tx=ses.beginTransaction();
		pro.setPname("Ak47");
		//pro.setPrice(8000.0);
		ses.update(pro);
		tx.commit();
		System.out.println("Record Inerted Successfully");
		}//else
	}//try
	catch(HibernateException he) {
		if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly()==true)
			tx.rollback();
		System.out.println("Object Is  Not Updated");
		he.printStackTrace();
	}catch(Exception e) {
		if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly()==true)
			tx.rollback();
		System.out.println("Object Is  Not Updated");
		e.printStackTrace();
	}
	
}//main
}//class
