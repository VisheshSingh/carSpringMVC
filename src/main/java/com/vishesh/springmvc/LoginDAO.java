package com.vishesh.springmvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class LoginDAO {
	String url = "jdbc:mysql://localhost:3306/car_dealership";
	String uname = "root";
	String pass = "admin";
	String sql = "Select * from login_details where username=? and password=?";
	String sql2 = "SELECT * FROM model";

	public boolean checkCredentials(String username, String password) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class)
				.buildSessionFactory();

		// create a session
		Session session = factory.getCurrentSession();
		try {
			// use the session object to save java object

			// create student object
			System.out.println("Checking to see if the user exists...");
			User newUser = new User();
			newUser.setUsername(username);
			newUser.setPassword(password);

			// Start a transaction
			session.beginTransaction();

			// the query should include name of the CLASS and NOT TABLE in DATABASE
			Query query = session.createQuery("from User where username = :username and password = :password");
			query.setParameter("username", username);
			query.setParameter("password", password);
			query.list();

			// commit the transaction
			session.getTransaction().commit();

			System.out.println("Done!");
			return true;
		} catch (HibernateException e) {
			System.out.println(e.getMessage());
			System.out.println("error");
		} finally {
			factory.close();
		}
		return false;
	}

	public void addUserDetails(String username, String password) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class)
				.buildSessionFactory();

		// create a session
		Session session = factory.getCurrentSession();
		try {
			// use the session object to save java object

			// create student object
			System.out.println("Creating a new user in database...");
			User newUser = new User();
			newUser.setUsername(username);
			newUser.setPassword(password);

			// Start a transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Saving the user...");
			session.save(newUser);

			// commit the transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} catch (HibernateException e) {
			System.out.println(e.getMessage());
			System.out.println("error");
		} finally {
			factory.close();
		}

	}

	// GETTING THE CARS
	public ResultSet getCars() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// 1. Get a connection to database
			Connection myConn = DriverManager.getConnection(url, uname, pass);

			// 2. Create a statement
			PreparedStatement myStmt = myConn.prepareStatement(sql2);

			// 3. Execute SQL query
			ResultSet myRS = myStmt.executeQuery();

			return myRS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
}
