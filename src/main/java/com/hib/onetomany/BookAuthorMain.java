package com.hib.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hib.util.HibernateUtil;

public class BookAuthorMain {

	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		Book book = new Book();
		book.setName("Five Point Someone");

		Author author = new Author();
		author.setName("chetan");
		author.setBook(book);

		Author author1 = new Author();
		author1.setName("karthik");
		author1.setBook(book);

		Author author2 = new Author();
		author2.setName("aditya");
		author2.setBook(book);
		
		book.getAuthors().add(author);
		book.getAuthors().add(author1);
		book.getAuthors().add(author2);
		
		session.save(book);
		
		session.getTransaction().commit();
		session.close();
		sf.close();

	}

}
