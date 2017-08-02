package com.hib.manytomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long patientId;
	private String fname;
	private String lname;
	
	@ManyToMany(fetch = FetchType.LAZY,cascade =
        {
                CascadeType.DETACH,
                CascadeType.MERGE,
                CascadeType.REFRESH,
                CascadeType.PERSIST
        }, targetEntity=Doctor.class)
	@JoinTable(name = "Doctor_Patient", joinColumns = {
			@JoinColumn(name = "PatientId", nullable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "DoctorId", nullable = false) 
	})	
	private List<Doctor> doctors = new ArrayList<>();
	
	public Patient(){
		
	}
	
	public Patient(String fname, String lname){
		this.fname = fname;
		this.lname = lname;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public List<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}
	
	
}


