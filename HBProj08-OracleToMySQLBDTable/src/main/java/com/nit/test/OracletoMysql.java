package com.nit.test;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nit.Util.HibernateUtil_Mysql;
import com.nit.Util.HibernateUtil_Oracle;
import com.nit.entity.Product;

public class OracletoMysql {
public static void main(String[] args) {
	SessionFactory factory=HibernateUtil_Mysql.getSessionFactory();
	Session ses=HibernateUtil_Mysql.getSession();
	SessionFactory fact=HibernateUtil_Oracle.getSessionFactory();
	Session ses1=HibernateUtil_Oracle.getSession();
	Transaction Tx=null;
	try(fact;factory;ses;ses1){
		Product pro=ses1.get(Product.class, 2010);
		if(pro!=null) {
			Tx=ses.beginTransaction();
			ses.save(pro);
			Tx.commit();
			System.out.println("Product is Transfered from Oracle Database to Mysql");
		}else {
			System.out.println("Product is not transfered");
		}	
	}catch(HibernateException he) {
	if(Tx!=null && Tx.getStatus()!=null && Tx.getRollbackOnly())
		Tx.rollback();
	he.printStackTrace();
	}catch(Exception  e) {
		e.printStackTrace();
		}
}//main
}//class
