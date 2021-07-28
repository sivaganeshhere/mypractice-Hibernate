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
		Transaction tx=ses.beginTransaction();
		try (factory;ses){
		ARTIST_INFO product=ses.load(ARTIST_INFO.class,2010);

    tx.commit();
		} catch (HibernateException he) {
			if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly())
				tx.rollback();
			he.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		} 
	}// main
}// class
