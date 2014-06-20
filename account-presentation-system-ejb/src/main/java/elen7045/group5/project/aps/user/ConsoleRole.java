package elen7045.group5.project.aps.user;

import java.util.List;

import javax.ejb.Remote;

import elen7045.group5.project.aps.user.bean.UserRoleBean;

/**
 * Outlines all the roles that can be added/assigned to users
 */
@Remote
public interface ConsoleRole
{
	/**
	 * Retrieves all the roles from the database
	 * @return Returns the user role, null if none is found
	 */
	public List<UserRoleBean> findAllRoles();

	/**
	 * Locates a role based on the unique role name
	 * @param roleName - The name of the role
	 * @return Returns the user role, null if none is found
	 */
	public UserRoleBean findRole(String roleName);

	/**
	 * Adds a role to the database
	 * @param role - Bean with the relevant data to persist
	 * @return Returns the number of records persisted
	 */
	public int addRole(UserRoleBean role);

	/**
	 * This method updates the passed role
	 * @param role - Role to update on the database
	 * @return Returns the number of records updated
	 */
	public int updateRole(UserRoleBean role);

	/**
	 * This method deletes the passed role from the database
	 * @param role - Role to delete
	 * @return Returns the number of records deleted
	 */
	public int deleteRole(UserRoleBean role);
}
