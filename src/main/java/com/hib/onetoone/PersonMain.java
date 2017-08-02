package com.hib.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hib.util.HibernateUtil;

public class PersonMain {

	public static void main(String[] args) {
		System.out.println("Hibernate one to one (Annotation)");
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session =sf.openSession();

		session.beginTransaction();
		
		Person person = new Person();
		person.setfName("karthik");
		person.setlName("voore");
		
		PersonDetail pd = new PersonDetail();
		pd.setAddress("Lewisville");
		pd.setState("TX");
		
		person.setPersonDetail(pd);
		pd.setPerson(person);
		
		session.save(person);
		
		Person p = session.get(Person.class, 1L);
		System.out.println(p.getfName());
		System.out.println(p.getPersonDetail().getAddress());
		session.getTransaction().commit();
		session.close();
		sf.close();
		

		System.out.println("Done");
		
	}
	
}
