package com.company.enroller.persistence;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.company.enroller.model.Participant;

public class DatabaseConnector {

	protected static DatabaseConnector instance = null;

	public static DatabaseConnector getInstance() {
		if (instance == null) {
			instance = new DatabaseConnector();
		}
		return instance;
	}

	private Session session;

	private DatabaseConnector() {
		session = HibernateUtil.getSessionFactory().openSession();
	}

	public void teardown() {
		session.close();
		HibernateUtil.shutdown();
		instance = null;
	}

	public Session getSession() {
		return session;
	}	

}
