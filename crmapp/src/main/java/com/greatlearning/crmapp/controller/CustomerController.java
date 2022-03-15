package com.greatlearning.crmapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.crmapp.entity.Customer;
import com.greatlearning.crmapp.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/list")
	public String showCustomerList(Model theModel) {
		List<Customer> customers = customerService.findAll();
		theModel.addAttribute("Customers", customers);
		return "customer-list";
	}
	
	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Customer customer = new Customer();
		theModel.addAttribute("Customer", customer);
		return "customer-form";
	}
	
	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int id, Model theModel) {
		Customer customer = customerService.findById(id);
		theModel.addAttribute("Customer", customer);
		return "customer-form";
	}
	
	@PostMapping("/save")
	public String saveCustomer(@RequestParam("id") int id, @RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("email") String email) {
		Customer customer;
		if (id != 0) {
			customer = customerService.findById(id);
			customer.setFirstName(firstName);
			customer.setLastName(lastName);
			customer.setEmail(email);
		} else {
			customer = new Customer(firstName, lastName, email);
		}
		customerService.save(customer);
		return "redirect:/customer/list";
	}
	
	@RequestMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int id) {
		customerService.deleteById(id);
		return "redirect:/customer/list";
	}
}