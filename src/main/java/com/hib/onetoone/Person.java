package com.hib.onetoone;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Person implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long PersonId;
	private String fName;
	private String lName;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "person")
	private PersonDetail PersonDetail;

	public Long getPersonId() {
		return PersonId;
	}

	public void setPersonId(Long personId) {
		PersonId = personId;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public PersonDetail getPersonDetail() {
		return PersonDetail;
	}

	public void setPersonDetail(PersonDetail personDetail) {
		PersonDetail = personDetail;
	}

}
