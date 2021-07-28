package com.nit.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import com.nit.entity.Product;
import com.nit.utility.HibernateUtil;

public class SaveObjectTest {
	public static void main(String[] args) {
		SessionFactory factory =HibernateUtil.getSessionFactory();
		Session ses=HibernateUtil.getSession();
		Product p = new Product();
		p.setPid(2003);
		p.setPname("table1");
		p.setPrice(3000.00);
		p.setQty(4.0);
		p.setStatus("Aval");
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
