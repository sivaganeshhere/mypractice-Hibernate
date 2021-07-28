package com.nit.test;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nit.entity.Product;
import com.nit.utility.HibernateUtil;

public class SaveObjectTest {
public static void main(String[] args) {
	SessionFactory  factory=HibernateUtil.getSessionFactory();
	Session ses =HibernateUtil.getSession();
	Transaction tx=null;
	try(factory;ses){
		
		Product product=new Product();
		product.setPid(2010);
		product.setPname("siva ganesh");
		product.setPrice(20000.00);
		product.setQty(50.00);
		product.setStatus("AVAILABLE");
		tx=ses.beginTransaction();
		int idval=(int)ses.save(product);
		System.out.println("generated id value::"+idval);
		tx.commit();
	}//try
	catch(HibernateException he ) {
		he.printStackTrace();
		if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly())
			tx.rollback();
			
	}catch(Exception e) {
		e.printStackTrace();
	}
			
}//main
}//class
