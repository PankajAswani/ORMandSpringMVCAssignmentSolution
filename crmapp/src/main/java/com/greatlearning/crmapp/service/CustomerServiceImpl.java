package com.greatlearning.crmapp.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.greatlearning.crmapp.entity.Customer;

@Repository
public class CustomerServiceImpl implements CustomerService {
	private SessionFactory sessionFactory;
	private Session session;

	public CustomerServiceImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		session = this.sessionFactory.openSession();
	}

	@Override
	public List<Customer> findAll() {
		Transaction transaction = session.beginTransaction();
		List<Customer> customers = session.createQuery("from Customer", Customer.class).list();
		transaction.commit();
		return customers;
	}

	@Override
	public Customer findById(int id) {
		Transaction transaction = session.beginTransaction();
		Customer customer = session.get(Customer.class, id);
		transaction.commit();
		return customer;
	}

	@Override
	public void save(Customer customer) {
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(customer);
		transaction.commit();
	}

	@Override
	public void deleteById(int id) {
		Transaction transaction = session.beginTransaction();
		try {
			Customer customer = session.get(Customer.class, id);
			session.delete(customer);
		} finally {
			transaction.commit();
		}
	}
}