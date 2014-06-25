package elen7045.group5.project.aps.jpa.service;

import java.util.List;

import elen7045.group5.project.aps.jpa.model.Customer;

public interface CustomerService
{

	public Customer create(Customer created);

	public Customer delete(int id) throws NotFoundException;

	public List<Customer> findAll();

	public Customer findById(Integer id);

	public Customer findByEmailAddres(String emailAddress);

	public Customer update(Customer updated) throws NotFoundException;
}
