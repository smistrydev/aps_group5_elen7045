package elen7045.group5.project.aps.jpa.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import elen7045.group5.project.aps.jpa.model.Customer;
import elen7045.group5.project.aps.jpa.repository.CustomerRepository;

@Service
public class RepositoryCustomerService implements CustomerService
{

	@Resource
	private CustomerRepository	customerRepository;

	@Transactional
	@Override
	public Customer create(Customer customer)
	{
		return customerRepository.save(customer);
	}

	@Transactional(rollbackFor = NotFoundException.class)
	@Override
	public Customer delete(int id) throws NotFoundException
	{
		Customer deleted = customerRepository.findOne(id);

		if (deleted == null)
		{
			throw new NotFoundException();
		}

		customerRepository.delete(deleted);

		return deleted;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Customer> findAll()
	{
		return customerRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Customer findById(Integer id)
	{
		return customerRepository.findOne(id);
	}

	@Transactional(rollbackFor = NotFoundException.class)
	@Override
	public Customer update(Customer updated) throws NotFoundException
	{
		Customer customer = customerRepository.findOne(updated.getCustomerId());

		if (customer == null)
		{
			throw new NotFoundException();
		}

		customer.setEmailAddress(updated.getEmailAddress());
		customer.setName(updated.getName());
		customer.setPassword(updated.getPassword());
		customer.setSurname(updated.getSurname());
		
		return customer;
	}

	public void setCustomerRepository(CustomerRepository customerRepository)
	{
		this.customerRepository = customerRepository;
	}
}
