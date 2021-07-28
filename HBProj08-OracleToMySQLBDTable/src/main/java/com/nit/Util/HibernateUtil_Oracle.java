package com.nit.Util;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil_Oracle {
public static SessionFactory fact;
static {
	try {
		Configuration cfg=new Configuration();
		cfg.configure("com/nit/cfgs/Hibernate-Oracle.xml");
		fact =cfg.buildSessionFactory();
	}catch(HibernateException he) {
		he.printStackTrace();
	}catch(Exception  e) {
		e.printStackTrace();
	}//catch close
	}//static
	public static SessionFactory getSessionFactory() {
		if(fact!=null) {
			return fact;
		}else {
		throw new RuntimeException(" invalid  Object Creation");
		}
	}
	public  static Session getSession() {
		Session ses1=null;
		if(fact!=null) 
		ses1=fact.openSession();

		return ses1;
	}
	public static void closeSessionfactory() {
		if(fact!=null) {
			fact.close();
		}
	}
	public static void closeSession(Session ses) {
		if(ses!=null)
			ses.close();
	}
	
	
}//class
