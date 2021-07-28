package com.nt.Util;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class Hibernate_Util {
private static SessionFactory factory;
		static{
			try {
				//Activate Hibernate Configuration
				Configuration cfg=new Configuration();
				//Congigure the Hibernate cfg file
				cfg.configure("com/nit/cfgs/Hibernate.cfg.xml");
				//BuildSession Factory Object
				factory =cfg.buildSessionFactory();
			}//try1
			catch(HibernateException he) {
				he.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}//end catch
			
		}//static
public static SessionFactory getSessionFactory() {
	if(factory!=null) 
		return factory;
	else
		throw new RuntimeException("Invalid Session factory Object Creation");
}
public static Session getSession() {
	Session ses=null;
	if(factory!=null) 
		ses=factory.openSession();
	
		return ses;	
}
public static void closeSession(Session ses) {
	if(ses!=null)
		ses.close();
}
public static void closeSessionFactory() {
	if(factory!=null) {
		factory.close();
	}
}
}//class
