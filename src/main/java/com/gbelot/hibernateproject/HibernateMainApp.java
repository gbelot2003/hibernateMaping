package com.gbelot.hibernateproject;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.gbelot.models.StudentDetails;


public class HibernateMainApp 
{
    public static void main( String[] args )
    {
    	
    	StudentDetails student = new StudentDetails();
    	student.setId(15);
    	student.setStudentName("Gerardo Belot");
    	student.setStudentSubject("Computacion");
    	
    	Session session = sessionConfiguration();
		sessionTransaction(student, session);	
    	
        System.out.println( "Student Name is = " + student.getStudentName() );
    }

	/**
	 * @param student
	 * @param session
	 */
	private static void sessionTransaction(StudentDetails student, Session session) {
		Transaction tx = session.beginTransaction();
    	session.save(student);
    	tx.commit();
	}

	/**
	 * @return
	 * @throws HibernateException
	 */
	private static Session sessionConfiguration() throws HibernateException {
		Configuration cfg = new Configuration();
    	cfg.configure("./hibernate.cfg.xml");
    	StandardServiceRegistry serReg = new StandardServiceRegistryBuilder().
    			applySettings(cfg.getProperties()).build();
    	
    	
    	SessionFactory sessionFac = cfg.buildSessionFactory(serReg);
    	Session session = sessionFac.getCurrentSession();
		return session;
	}
}
