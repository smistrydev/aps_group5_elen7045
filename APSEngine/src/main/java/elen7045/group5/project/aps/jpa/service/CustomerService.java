package elen7045.group5.project.aps.jpa.service;

import java.util.List;

import elen7045.group5.project.aps.jpa.model.Customer;
import elen7045.group5.project.aps.jpa.model.Notification;

public interface CustomerService
{

	public Customer create(Customer Customer);

	public Customer delete(int id) throws NotFoundException;

	public List<Customer> findAll();

	public Customer findById(Integer id);

	public Customer update(Customer updated) throws NotFoundException;
}
