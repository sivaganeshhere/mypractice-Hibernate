package com.nit.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nit.entity.Product;
import com.nt.Util.Hibernate_Util;

public class HBUtil_sesUpdateMethod {
public static void main(String[] args) {
	//Buil session Factory
	SessionFactory factory=Hibernate_Util.getSessionFactory();
	//Create Session Object
	Session ses=Hibernate_Util.getSession();
	Transaction tx=null;
	try(factory;ses){
		//create Object 
		Product pro=new Product();
		pro.setPid(2000);pro.setPname("ak47");
		pro.setPrice(5000.0);pro.setQty(4.0);
		pro.setStatus("Not Available");
		tx=ses.beginTransaction();
		ses.update(pro);
		tx.commit();
		System.out.println("Record Inerted Successfully");
	}catch(HibernateException he) {
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
