package com.nit.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nit.entity.ProgmrprojId;
import com.nit.entity.ProgrammersProjectInfo;
import com.nit.utility.HibernateUtil;

public class CompositeIdSaveObjectTest {
public static void main(String[] args) {
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		try(factory;ses){
			tx=ses.beginTransaction();
			ProgmrprojId id=new ProgmrprojId(101,1001);
			ProgrammersProjectInfo ppinfo=new ProgrammersProjectInfo(id,"sivaganesh","Openx",10);
			ProgmrprojId idval=(ProgmrprojId)ses.save(ppinfo);
			tx.commit();
			System.out.println("Object Saved Having Composite Id"+idval);
		}catch(HibernateException he) {
			he.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
}
}
