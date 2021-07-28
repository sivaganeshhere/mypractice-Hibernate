package com.nit.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nit.entity.Product;

public class LodingObject_Using_SesgetMethod {
public static void main(String[] args) {
//Activate Hibernate Configuration 
	Configuration cfg=new Configuration();
	//specift the hibernate Configuration file
	cfg.configure("com/nit/cfgs/Hibernate.cfg.xml");
	//Create SessionFactory Object
	SessionFactory factory=cfg.buildSessionFactory();
//create session Object
	Session ses=factory.openSession();
	//prepare Product Object
	Product product=ses.get(Product.class, 2000);
	try {
	if(product==null) {
		System.out.println("Records Not Found");
	}else {
		System.out.println("Records Are::"+product.getPid()+" "+product.getPname()+" "+product.getPrice()+" "+product.getQty()+" "+product.getStatus());
	}
	}catch(HibernateException he) {
		he.printStackTrace();
	}catch(Exception e) {
		e.printStackTrace();
	}finally{
		ses.close();
		factory.close();
	}
	
}//main
}//class
