package com.nit.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nit.entity.Product;
import com.nit.Util.HibernateUtil;

public class DeleteObject {
public static void main(String[] args) {
	//Buil session Factory
	SessionFactory factory=HibernateUtil.getSessionFactory();
	//Create Session Object
	Session ses=HibernateUtil.getSession();
	Transaction tx=null;
	try(factory;ses){
		//create Object 
		Product pro= new Product();
		pro.setPid(2000);
		tx=ses.beginTransaction();
		ses.delete(pro);
		tx.commit();
		System.out.println("Record Deleted Successfully");
	}catch(HibernateException he) {
		if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly()==true)
			tx.rollback();
		System.out.println("Object Is  Not Delete");
		
	}	
}//main
}//classss
