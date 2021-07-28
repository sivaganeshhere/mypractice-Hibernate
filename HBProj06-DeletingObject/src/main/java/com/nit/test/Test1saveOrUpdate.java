package com.nit.test;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nit.Util.HibernateUtil;
import com.nit.entity.Product;

public class Test1saveOrUpdate {
public static void main(String[] args) {
	SessionFactory factory=HibernateUtil.getSessionFactory();
	Session ses=HibernateUtil.getSession();
	Transaction tx=null;
	try(factory;ses){
		Product pro=new Product();
        pro.setPid(2000);
		pro.setPname("Fans");
		pro.setPrice(1000.0);
		pro.setQty(3.0);
		pro.setStatus("Not Available");
		tx=ses.beginTransaction();
		ses.saveOrUpdate(pro);
		tx.commit();
		System.out.println("SaveOrUpdate is done");
	}catch(HibernateException he) {
		if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly());
		tx.rollback();
		System.out.println("saveOrUpdate is not done");
	}
}//main
}//class
