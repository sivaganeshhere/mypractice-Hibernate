package com.nit.Util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil_Mysql {
public static SessionFactory factory;
static {
	try {
		Configuration cfg=new Configuration();
		cfg.configure("com/nit/cfgs/Hibernate-Mysql.xml");
		factory =cfg.buildSessionFactory();
	}catch(HibernateException he) {
		he.printStackTrace();
	}catch(Exception  e) {
		e.printStackTrace();
	}//catch close
	}//static
	public static SessionFactory getSessionFactory() {
		if(factory!=null) {
			return factory;
		}else {
		throw new RuntimeException(" invalid Session mysql Creation");
		}
	}
	public  static Session getSession() {
		Session ses=null;
		if(factory!=null) 
		ses=factory.openSession();

		return ses;
	}
	public static void closeSessionfactory() {
		if(factory!=null) {
			factory.close();
		}
	}
	public static void closeSession(Session ses) {
		if(ses!=null)
			ses.close();
	}
	
	
}//class
