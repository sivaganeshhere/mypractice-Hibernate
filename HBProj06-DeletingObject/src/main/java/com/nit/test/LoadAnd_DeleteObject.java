package com.nit.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nit.entity.Product;
import com.nit.Util.HibernateUtil;

public class LoadAnd_DeleteObject {
public static void main(String[] args) {
	SessionFactory factory =HibernateUtil.getSessionFactory();
	Session ses=HibernateUtil.getSession();
	Transaction txt=null;
	try(factory;ses){
		Product pro=ses.get(Product.class,2001 );
		if(pro==null) {
			System.out.println(" Records NOT available");
		}else {
			txt=ses.beginTransaction();
			ses.delete(pro);
			txt.commit();
			System.out.println("Records Are Successfully Deleted");
		}
		
	}//try1
	catch(HibernateException he) {
		if(txt!=null || txt.getStatus()!=null || txt.getRollbackOnly());
		txt.rollback();
		System.out.println("Object is Not Deleted");
	}
}//main
}//classss
