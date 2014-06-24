/**
 * 
 */
package elen7045.group5.project.aps.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import elen7045.group5.project.aps.jpa.model.Customer;
import elen7045.group5.project.aps.jpa.model.Notification;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}