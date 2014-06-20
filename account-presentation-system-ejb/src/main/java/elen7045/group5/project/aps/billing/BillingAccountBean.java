package elen7045.group5.project.aps.billing;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import elen7045.group5.project.aps.user.bean.CustomerBean;

/**
 * This bean represents an account that a customer holds at a billing company
 */
@Entity
@Table(name="BILLING_ACCOUNT")
public class BillingAccountBean implements Serializable
{
	private static final long serialVersionUID = 143434L;
	private int billindId;
	private String accountUserId,
					accountPassword,
					accountNumber; //are we sure that these are the only things we need to get into an account?
	private CustomerBean customer;
	private BillingCompanyBean billingCompany;
}
