package elen7045.group5.project.aps.user.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * This is a customer who has registered with the application and who
 * has one or more accounts at various billing companies
 */
@Entity
@Table(name="CUSTOMER")
public class CustomerBean implements Serializable
{
	private static final long serialVersionUID = 1L;

}
