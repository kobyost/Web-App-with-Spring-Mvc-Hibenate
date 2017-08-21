package com.koby.springdemo.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.koby.springdemo.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDAO {

	//Need to inject the hibernate session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		
		//get the current hibernate session
		Session currentSession=sessionFactory.getCurrentSession();
		
		//create query sroted by lastName
		Query<Customer> theQuery=currentSession.createQuery("from Customer order by lastName",Customer.class);
		
		//execute the query and get result list
		List<Customer> customers=theQuery.getResultList();
		
		//return the results
		return customers;
		
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		
		// get current hibernate session
		Session currentSession=sessionFactory.getCurrentSession();
		
		//save/update the customer to db
		currentSession.saveOrUpdate(theCustomer);
		
	}

	@Override
	public Customer getCustomer(int theId) {
		
		// get current hibernate session
		Session currentSession=sessionFactory.getCurrentSession();
		
		//read from db using the id
		Customer theCustomer=currentSession.get(Customer.class, theId);
		
		return theCustomer;
		
	}

	@Override
	public void deleteCustomer(int theId) {
		
		// get current hibernate session
		Session currentSession=sessionFactory.getCurrentSession();
		
		//Delete the customer with the id
		Query theQuery=
				currentSession.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", theId);
		
		theQuery.executeUpdate();
	}

}
