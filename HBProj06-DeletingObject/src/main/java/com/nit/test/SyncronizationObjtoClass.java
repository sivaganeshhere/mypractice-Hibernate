package com.nit.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nit.Util.HibernateUtil;
import com.nit.entity.Product;

public class SyncronizationObjtoClass {
public static void main(String[] args) {
	
	SessionFactory factory=HibernateUtil.getSessionFactory();
	Session ses =HibernateUtil.getSession();
	Transaction txt=null;
	try(factory;ses){
		txt=ses.beginTransaction();
		//load the object
		Product pro=ses.get(Product.class, 2002);
		//modify the object
		pro.setPrice(5000.00);
		txt.commit();
		System.out.println("Object is Updated Successfully");
	}//try
	catch(HibernateException he) {
		if(txt!=null&&txt.getStatus()!=null&&txt.getRollbackOnly()==true) {
			txt.rollback();
			System.out.println("Object is not Updated");
		}
	}catch (Exception e) {
		e.printStackTrace();
	}
}//main
}//class
