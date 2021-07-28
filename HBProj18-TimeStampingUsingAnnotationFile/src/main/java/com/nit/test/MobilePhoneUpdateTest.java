package com.nit.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nit.entity.MobilePhoneUser;
import com.nit.utility.HibernateUtil;

public class MobilePhoneUpdateTest {

	public static void main(String[] args) {
		//create SessionFactory ,Session objs
		 SessionFactory factory=HibernateUtil.getSessionFactory();
		 Session ses=HibernateUtil.getSession();
		 Transaction tx=null;
		 try(factory;ses){
			 //begin Tx
			 tx=ses.beginTransaction();
			  //prepare object
			 MobilePhoneUser user=ses.get(MobilePhoneUser.class,1020L);
			if(user!=null) {
				user.setMobileno(1094634L);
				ses.update(user);
				tx.commit();
				System.out.println("Object is Updated "+user.getLastUpdated()+"seconds"+user.getDoj()+"count"+user.getUpdationCount());
			}else {
				System.out.println("Object is Not Updated");
			}
		 }
		 catch(HibernateException he){
			 if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly())
				   tx.rollback();
			 he.printStackTrace();
		 }

	}//main
}//class