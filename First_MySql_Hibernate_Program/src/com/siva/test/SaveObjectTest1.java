package com.siva.test;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.siva.entity.Product1;

public class SaveObjectTest1 {
	public static void main(String[] args)throws Exception {
		//loading class
	//	Class.forName("com.mysql.jdbc.Driver");
		// Activate Hibernate Configuration
		Configuration cfg = new Configuration();
		// specify hibernate configuration Name and file location
		cfg.configure("com/siva/cfgs/Hibernate1.cfg.xml");
		// CreateHibernate Session Factory Object
		SessionFactory factory = cfg.buildSessionFactory();
		// Create session object
		Session ses = factory.openSession();
		// prepare Entity class object having data
		Product1 p = new Product1();
		p.setPid(200);
		p.setPname("car");
		p.setPrice(2000.00);
		p.setQty(1.0);
		p.setStatus("Non Avail");
		// save object
		Transaction tx = null;
		boolean flag = false;
		try {
			tx = ses.beginTransaction();
			ses.save(p);
			flag = true;
		} catch (HibernateException he) {
			he.printStackTrace();
			flag = false;
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		} finally {
			if (flag) {
				tx.commit();
				System.out.println("Object is saved record inderted");
			} else {
				tx.rollback();
				System.out.println("Object is not saved Record Is not inserted");
			}
			//close HB objects
			ses.close();
			factory.close();
		} // finally
	}// main
}// class
