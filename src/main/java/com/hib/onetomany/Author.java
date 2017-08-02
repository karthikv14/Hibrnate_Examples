package com.hib.onetomany;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long AuthorId;

	private String name;
	private String age;
	
	@ManyToOne
	@JoinColumn(name = "book_id")
	private Book book;
	
	public Author() {

	}

	public Author(String name, String age, Book book) {
		super();
		this.name = name;
		this.age = age;
		this.book = book;

	}

	public Long getAuthorId() {
		return AuthorId;
	}

	public void setAuthorId(Long authorId) {
		AuthorId = authorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
	
}
