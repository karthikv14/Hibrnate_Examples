package com.hib.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hib.util.HibernateUtil;

public class DoctorPatient {

	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

//		Patient patient = new Patient();
//		patient.setFname("James");
//		patient.setLname("Airwin");
//		
//		Patient patient1 = new Patient();
//		patient1.setFname("Mark");
//		patient1.setLname("Henry");
//
//		Doctor doctor = new Doctor();
//		doctor.setName("Peter");
//		doctor.getPatients().add(patient);
//		
//		Doctor doctor1 = new Doctor();
//		doctor1.setName("Peter");
//		doctor1.getPatients().add(patient);
//
//		session.save(doctor);
//		session.save(patient);
//		
//		session.save(doctor1);
//		session.save(patient1);
		
		Doctor doctor = session.load(Doctor.class, 1L);
		session.delete(doctor);
		
		session.getTransaction().commit();
		session.close();
		sf.close();
	}
}