package elen7045.group5.project.aps.user.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import elen7045.group5.project.InvalidDataException;

/**
 * Represents a user who has access to the APS console.
 */
@Entity
@Table(name="APS_USERS")
@NamedQueries({
	@NamedQuery(name="UserBean.findAll", query="SELECT x FROM UserBean x ORDER BY x.userId"),
	@NamedQuery(name="UserBean.findByMultiId", query="SELECT x FROM UserBean x WHERE x.userId IN (:userIds) ORDER BY x.userId")
})
public class UserBean implements Serializable
{
	private static final long serialVersionUID = 12345L;
	private String userId,
					name,
					surname,
					email;
	private List<UserRoleBean> roles = new ArrayList<UserRoleBean>();
	
	/**
	 * Username or unique ID of the user - usually the domain ID of the user
	 * @return the userName
	 */
	@Id
	@Column(name="USER_ID")
	public String getUserId()
	{
		return userId;
	}
	
	/**
	 * The name of the user accessing the application
	 * @return the name
	 */
	@Column(name="NAME")		
	public String getName()
	{
		return name;
	}
	
	/**
	 * The surname of the user accessing the application
	 * @return the surname
	 */
	@Column(name="SURNAME")
	public String getSurname()
	{
		return surname;
	}
	
	/**
	 * The email address of the user accessing the application
	 * @return the email address
	 */
	@Column(name="EMAIL")
	public String getEmail()
	{
		return email;
	}
	
	/**
	 * A list of roles that has been allocated to this user.
	 * @return the roleNames
	 */
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="CORE_USER_ROLES", joinColumns=@JoinColumn(name="USER_ID"), 
				inverseJoinColumns=@JoinColumn(name="ROLE_NAME"))
	public List<UserRoleBean> getRoles()
	{
		return roles;
	}
	
	/**
	 * Extracts the names of the roles from the list obtained from the database. Note
	 * that I am not using getXX (which would be easier as it is ultimately required by
	 * the UI) as because of annotations, this will be assumed to be a column on the db
	 * @return Returns a list of role names, an empty list if no roles exist for this
	 * user as yet 
	 */
	public List<String> retrieveRoleNames()
	{
		List<String> r = new ArrayList<String>();
		if(roles != null)
		{
			for(UserRoleBean ur : roles)
			{
				r.add(ur.getRoleName());
			}
		}
		
		return r;
	}
	
	/**
	 * This method checks if the passed role passed is part of this user's profile. It
	 * will also accept <b>*</b> as a wildcard to represent multiple roles e.g. you can
	 * use <code>app*</code> to represent <code>app.user</code> and <code>app.admin</code>
	 * but a couple of rules apply:
	 * <ol>
	 * <li>The wildcard cannot be the only character for the roleName passed
	 * <li>The wildcard cannot be at the start of the roleName
	 * <li>There must be at least 3 characters in the roleName before the wildcard
	 * </ol> 
	 * @param roleName - Role to check
	 * @return Returns true if the role is part of the profile, false otherwise
	 */
	public boolean isUserRole(String roleName)
	{
		boolean ok = false;
		if(roleName != null)
		{
			int ind = roleName.indexOf("*");			
			for(UserRoleBean aRole : roles)
			{
				if(ind > 2)
				{
					if(aRole.getRoleName().startsWith(roleName.substring(0, ind)))
					{
						ok = true;
						break;
					}
				}
				else
				{
					if(aRole.getRoleName().equalsIgnoreCase(roleName))
					{
						ok = true;
						break;
					}
				}
			}
		}
		
		return ok;
	}
	
	/**
	 * @param userName the userName to set
	 */
	public void setUserId(String userName)
	{
		if(userName != null)
			this.userId = userName.toLowerCase();
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname)
	{
		this.surname = surname;
	}
	
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	/**
	 * @param roleNames the roleNames to set
	 */
	public void setRoles(List<UserRoleBean> roles)
	{
		this.roles = roles;
	}
	
	/**
	 * Method adds in one role into the existing list
	 * @param aRole - Role to add
	 */
	public void addRole(UserRoleBean aRole)
	{
		if(aRole != null)
		{
			this.roles.add(aRole);
		}
	}
	
	/**
	 * This method replaces all existing roles assigned to the user with the
	 * passed list of roles 
	 * @param names - List of role names
	 */
	public void replaceExistingRolesWithThese(List<String> names)
	{
		precondition(names != null, "Names passed cannot be null");
		precondition(names.size() > 0, "At least one role name must be included. The list passed is empty");
		
		UserRoleBean ur = null;		
		this.roles = new ArrayList<UserRoleBean>();
		for(String str : names)
		{
			ur = new UserRoleBean();
			ur.setRoleName(str);
			roles.add(ur);
		}
	}
	
	/**
	 * This method checks for any preconditions that need to be satisfied when 
	 * entering methods. If the condition passed is false, this method throws 
	 * a InvalidDataException (extends RuntimeException) containing <code>msg</code>.
	 * @param cond A condition that needs to be true in order to succeed
	 * @param msg Any message that must be included in the passed exception
	 */
	private void precondition(boolean cond, String msg) 
	{
		if(!cond) throw new InvalidDataException(this + ": " + msg);
	}
}