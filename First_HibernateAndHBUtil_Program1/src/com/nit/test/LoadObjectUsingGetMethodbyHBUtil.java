package com.nit.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.nit.entity.Product;
import com.nt.Util.Hibernate_Util;
public class LoadObjectUsingGetMethodbyHBUtil {
	public static void main(String[] args) {
		try (
		//Build sessionfactory Object
	SessionFactory factory=Hibernate_Util.getSessionFactory();
	//Create Session
	Session ses=Hibernate_Util.getSession();
//Load Object using ses.get(-,-);
	){
	Product pro=ses.get(Product.class, 2000);
	if(pro==null) {
		System.out.println("No record Found");
	}else {
		System.out.println("Records Are::"+pro.getPid()+" "+pro.getPname()+" "+pro.getPrice()+" "+pro.getStatus()+" "+pro.getQty());
	}
	}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	/*	finally {
			Hibernate_Util.closeSession(ses);
			Hibernate_Util.closeSessionFactory();
		}*///try with resoursce
	}//main
}//class
