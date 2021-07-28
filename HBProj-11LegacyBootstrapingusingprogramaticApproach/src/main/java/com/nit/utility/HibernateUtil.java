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
		cfg.setProperty("hibernate.connection.driver_class", "oracle.jdbc.driver.OracleDriver");
		cfg.setProperty("hibernate.connection.url", "jdbc:oracle:thin:@localhost:1521:xe");
		cfg.setProperty("hibernate.connection.username","system" );
		cfg.setProperty("hibernate.connection.password", "siva");
		cfg.setProperty("hibernate.show_sql","true");
		cfg.setProperty("hibernate.format_sql","true");
		cfg.setProperty("hibernate.dialect","org.hibernate.dialect.Oracle10gDialect");
		cfg.addFile("src/main/java/com/nit/entity/Product.hbm.xml");
		factory =cfg.buildSessionFactory();
	}catch(HibernateException he ) {
	he.printStackTrace();	
	}catch(Exception e) {
		e.printStackTrace();
	}
	
}//static
public  static  SessionFactory getSessionFactory() {
    return factory;
}
public  static   Session  getSession() {
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
 if(factory!=null)
	  factory.close();
}

}//class
