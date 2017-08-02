package com.hib.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hib.model.User;
import com.hib.util.HibernateUtil;

public class User_Main {

	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		Transaction tran = s.beginTransaction();
		User user = new User();
		user.setUserName("voore");
		s.save(user);
		
//		User user = s.get(User.class, 1L);
//		System.out.println(user.getUserName());
		
		tran.commit();
		s.close();
		sf.close();
	}

}
