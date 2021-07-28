package com.nit.Util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
private static SessionFactory factory;
static {
	try {
		//Activate Hibernate Configuration
		Configuration cfg= new Configuration();
		cfg.configure("com/nit/cfgs/Hibernate.cfg.xml");
		factory =cfg.buildSessionFactory();
	}catch(HibernateException he) {
		he.printStackTrace();
	}catch(Exception e) {
		e.printStackTrace();
	}
}//static
	public static SessionFactory getSessionFactory() {
		if(factory!=null) {
			return factory;
		}else {
			throw new RuntimeException("Invalid Session factory Object Creation ");	
			}
	}
	public static Session getSession() {
		Session ses=null;
		if(factory!=null) 
			ses=factory.openSession();
		
			return ses;	
	}
	public static void  closeSessionFactory() {
		if(factory!=null) {
			factory.close();
		}
	}
	public static void closeSession( Session ses) {
		if(ses!=null)
			ses.close();
	}

	
}//class
