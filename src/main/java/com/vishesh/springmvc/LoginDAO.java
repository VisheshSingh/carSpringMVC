package com.vishesh.springmvc;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class LoginDAO {
	// String url = "jdbc:mysql://localhost:3306/car_dealership";
	// String uname = "root";
	// String pass = "admin";
	// String sql = "Select * from login_details where username=? and password=?";
	// String sql2 = "SELECT * FROM model";

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
	public ArrayList<Car> getCars() {
		ArrayList<Car> carlist = new ArrayList<Car>();
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Car.class)
				.buildSessionFactory();

		// create a session
		Session session = factory.getCurrentSession();
		try {
			System.out.println("Please wait...while we fetch the inventory details");
			// Start a transaction
			session.beginTransaction();
			// Save the list of cars to Arraylist: Query result is saved in the form of list
			carlist = (ArrayList<Car>) session.createQuery("FROM Car").list();

			// commit the transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} catch (HibernateException e) {
			System.out.println(e.getMessage());
			System.out.println("error");
		} finally {
			factory.close();
		}

		return carlist;
	}
}
