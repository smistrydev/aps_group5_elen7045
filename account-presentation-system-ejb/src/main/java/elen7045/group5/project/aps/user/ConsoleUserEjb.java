package elen7045.group5.project.aps.user;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import elen7045.group5.project.InvalidDataException;
import elen7045.group5.project.InvalidUserException;
import elen7045.group5.project.aps.user.bean.UserBean;

/**
 * Implementation of the console user interface
 */
@Stateless(name="ConsoleUser")
public class ConsoleUserEjb implements ConsoleUser
{
	@PersistenceContext(unitName="apsPU")
	private EntityManager em;
	@Resource
	private SessionContext ctx;

	/**
	 * @see elen7045.group5.project.aps.user.ConsoleUser#addUser(elen7045.group5.project.aps.user.bean.UserBean)
	 */
	public int addUser(UserBean usr)
	{
		em.persist(usr);
		return 1;
	}

	/**
	 * @see elen7045.group5.project.aps.user.ConsoleUser#deleteUser(cib.UserBean.entity.User)
	 */
	public int deleteUser(UserBean usr)
	{
		em.remove(em.merge(usr));
		return 1;
	}

	/**
	 * @see elen7045.group5.project.aps.user.ConsoleUser#updateUser(cib.UserBean.entity.User)
	 */
	public int updateUser(UserBean usr)
	{
		em.remove(em.merge(usr));
		em.flush();
		em.persist(usr); //don't know why this is not updating properly so have to delete and then add again
		return 1;
	}

	/**
	 * @see elen7045.group5.project.aps.user.ConsoleUser#findUser(java.lang.String)
	 */
	public UserBean findUser(String userName)
	{
		precondition(userName != null, "Username passed cannot be null");

		UserBean user = em.find(UserBean.class, userName.toLowerCase());
		return user;
	}

	/**
	 * @see elen7045.group5.project.aps.user.ConsoleUser#findAllUsers()
	 */
	public List<UserBean> findAllUsers()
	{
		Query q = em.createNamedQuery("UserBean.findAll");
		List lst = q.getResultList();
		if(lst.size() == 0)
			return null;
		else
			return (List<UserBean>)lst;
	}

	/**
	 * @see elen7045.group5.project.aps.user.ConsoleUser#findAllUsersForList(java.util.List)
	 */
	public List<UserBean> findAllUsersForList(List<String> ids)
	{
		precondition(ids != null, "List of IDs passed cannot be null");

		Query q = em.createNamedQuery("UserBean.findByMultiId");
		q.setParameter("userIds", ids);

		List lst = q.getResultList();
		if(lst == null || lst.size() == 0)
			return null;
		else
			return (List<UserBean>)lst;
	}

	/**
	 * @see elen7045.group5.project.aps.user.ConsoleUser#findUsersForRole(java.lang.String)
	 */
	public List<UserBean> findUsersForRole(String... role)
	{
		//TODO: implementation required?
		return null;
	}

	/**
	 * @see elen7045.group5.project.aps.user.ConsoleUser#loginUser(java.lang.String, java.lang.String, java.lang.String)
	 */
	public UserBean loginUser(String userName, String password) throws InvalidUserException
	{
		precondition(userName != null, "User name passed cannot be null");
		precondition(password != null, "Password passed cannot be null");

		UserBean u = findUser(userName);
		//TODO: validate the password against the encrypted on on the database				
		return u;
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