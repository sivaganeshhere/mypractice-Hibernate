package com.nit.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nit.Util.HibernateUtil;
import com.nit.entity.Product;

public class SyncronizationDbTabToObj {
public static void main(String[] args) {
	//Build Session Factory
	SessionFactory factory =HibernateUtil.getSessionFactory();
	//Create Session Object
	Session ses=HibernateUtil.getSession();
	Transaction txt=null;
	try(factory;ses){
	//load the object
		Product pro=ses.get(Product.class, 2002);
		System.out.println(pro);
		System.out.println("=======================");
		System.out.println("Modify 2002 pid value containing object in the Sleep Time");
		Thread.sleep(50000);
		ses.refresh(pro);
	}//try
	catch (HibernateException he) {
          he.printStackTrace();
 
	}catch(Exception e) {
		e.printStackTrace();
	}
}//main
}//class
