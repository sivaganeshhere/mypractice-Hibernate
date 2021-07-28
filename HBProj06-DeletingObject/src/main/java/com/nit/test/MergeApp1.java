package com.nit.test;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nit.Util.HibernateUtil;
import com.nit.entity.Product;

public class MergeApp1 {
public static void main(String[] args) {
	SessionFactory factory = HibernateUtil.getSessionFactory();
	Session ses=HibernateUtil.getSession();
	Transaction txt=null;
	try(factory;ses){
		txt=ses.beginTransaction();
		Product prod=ses.get(Product.class, 2000);
		prod.setPname("cooler");
		prod.setPrice(75000.00);
		prod.setQty(8.0);
		Product p1=(Product) ses.merge(prod);
		System.out.println(p1);
		txt.commit();
		System.out.println("Object  Merged Successfully");
	}//try
	catch(HibernateException he) {
		if(txt!=null&&txt.getStatus()!=null&&txt.getRollbackOnly()==true){
			txt.rollback();
			System.out.println("Object is Not Merged");
			}
		}catch(Exception e){
			e.printStackTrace();
			}
	}//main
}//class
