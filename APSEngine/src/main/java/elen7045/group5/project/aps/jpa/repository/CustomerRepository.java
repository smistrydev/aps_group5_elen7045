/**
 * 
 */
package elen7045.group5.project.aps.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import elen7045.group5.project.aps.jpa.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>
{

	Customer findByEmailAddress(String emailAddress);

}