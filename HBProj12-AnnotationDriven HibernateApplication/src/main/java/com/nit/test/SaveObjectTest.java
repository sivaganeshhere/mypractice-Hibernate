package com.nit.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nit.entity.ARTIST_INFO;

import com.nit.utility.HibernateUtil;

public class SaveObjectTest {
	public static void main(String[] args) {
		SessionFactory factory =HibernateUtil.getSessionFactory();
		Session ses=HibernateUtil.getSession();
		ARTIST_INFO product=new ARTIST_INFO();
		product.setAid(2010);
		product.setName("siva ganesh");
		product.setAddrs("puttaparthi");
		product.setMobileno(886630);
		product.setPincode(515134);
		// save object
		Transaction tx = null;
		boolean flag = false;
		try {
			tx = ses.beginTransaction();
			ses.save(product);
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
