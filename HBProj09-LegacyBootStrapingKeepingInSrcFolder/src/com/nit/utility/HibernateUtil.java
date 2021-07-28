package com.nit.utility;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
public static SessionFactory factory;
static {
	try {
		Configuration cfg=new Configuration();
		cfg.addFile("src/com/nit/entity/Product.hbm.xml");
		factory=cfg.buildSessionFactory();
		
	}catch(HibernateException he ) {
		he.printStackTrace();
	}catch(Exception e) {
		e.printStackTrace();
	}
}
	public static SessionFactory getSessionFactory() {
			return factory;
	}
	public static Session getSession(){
		Session ses=null;
		if(factory!=null)
			ses=factory.openSession();
      	return ses;
			
	}
	
	public static void closeSession(Session ses) {
		if(ses!=null) {
			ses.close();
		}
	}
	public static void closeSessionFactory() {
		if(factory!=null) {
			factory.close();
		}
	}
}//class

