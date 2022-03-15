package com.greatlearning.crmapp.service;

import java.util.List;

import com.greatlearning.crmapp.entity.Customer;

public interface CustomerService {
	public List<Customer> findAll();

	public Customer findById(int id);

	public void save(Customer customer);

	public void deleteById(int id);
}