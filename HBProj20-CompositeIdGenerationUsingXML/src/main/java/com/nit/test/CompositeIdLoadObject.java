package com.nit.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.nit.entity.ProgmrprojId;
import com.nit.entity.ProgrammersProjectInfo;
import com.nit.utility.HibernateUtil;

public class CompositeIdLoadObject {
public static void main(String[] args) {
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session ses=HibernateUtil.getSession();
		try(factory;ses){
			ProgmrprojId id=new ProgmrprojId(101,1001);
			ProgrammersProjectInfo ppinfo=ses.get(ProgrammersProjectInfo.class,id);
			if(ppinfo==null) {
				System.out.println("Record Not Found");
			}else {
				System.out.println(ppinfo);
			}
		}catch(HibernateException he) {
			he.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
}
}
