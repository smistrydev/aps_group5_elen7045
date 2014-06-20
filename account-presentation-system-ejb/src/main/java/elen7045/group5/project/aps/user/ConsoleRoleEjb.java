package elen7045.group5.project.aps.user;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import elen7045.group5.project.InvalidDataException;
import elen7045.group5.project.aps.user.bean.UserRoleBean;

/**
 * Ejb used in managing all aspects of a Role in the application
 */
@Stateless(name="ConsoleRole")
public class ConsoleRoleEjb implements ConsoleRole
{
	@PersistenceContext(unitName="apsPU")
	private EntityManager em;

	/**
	 * @see elen7045.group5.project.aps.user.ConsoleRole#findAllRoles()
	 */
	public List<UserRoleBean> findAllRoles()
	{
		Query query = em.createNamedQuery("UserRoleBean.findAll");
		List<UserRoleBean> roles = (List<UserRoleBean>)query.getResultList();
		return roles;
	}

	/**
	 * @see elen7045.group5.project.aps.user.ConsoleRole#addRole(cib.paybot.beans.UserRoleBean)
	 */
	public int addRole(UserRoleBean role)
	{
		precondition(role != null, "Role bean passed cannot be null");

		em.persist(role);
		return 1;
	}

	/**
	 * @see elen7045.group5.project.aps.user.ConsoleRole#findRole(java.lang.String)
	 */
	public UserRoleBean findRole(String roleName)
	{
		UserRoleBean ur = em.find(UserRoleBean.class, roleName);
		return ur;
	}

	/**
	 * @see elen7045.group5.project.aps.user.ConsoleRole#deleteRole(cib.paybot.beans.UserRoleBean)
	 */
	public int deleteRole(UserRoleBean role)
	{
		em.remove(em.merge(role));
		return 1;
	}

	/**
	 * @see elen7045.group5.project.aps.user.ConsoleRole#updateRole(cib.paybot.beans.UserRoleBean)
	 */
	public int updateRole(UserRoleBean role)
	{
		em.merge(role);
		em.flush();
		//em.persist(usr); //don't know why this is not updating properly so have to delete and then add again
		return 1;
	}
	
	/**
	 * This method checks for any preconditions that need to be satisfied when
	 * entering methods. If the condition passed is false, this method throws
	 * a InvalidDataException (extends RuntimeException) containing <code>msg</code>.
	 * @param cond - A condition that needs to be true in order to succeed
	 * @param msg - Any message that must be included in the passed exception
	 */
	private void precondition(boolean cond, String msg)
	{
		if(!cond) throw new InvalidDataException(this + ": " + msg);
	}
}
