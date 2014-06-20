package elen7045.group5.project.aps.user;

import java.util.List;

import javax.ejb.Remote;

import elen7045.group5.project.DataAccessException;
import elen7045.group5.project.InvalidUserException;
import elen7045.group5.project.aps.user.bean.UserBean;

/**
 * Outlines the attributes of a user operating or working in the UI console.
 */
@Remote
public interface ConsoleUser
{
	/**
	 * This method logs the user into the console, validating the credentials and
	 * returning the profile of the user. Note that if the user is valid on the domain
	 * but they have no profile, you will get nothing returned
	 * @param userName - The username of the person logging in
	 * @param password - Their password
	 * @return Returns a User object containing all roles in the application, null if
	 * the user is not defined in the application.
	 * @throws InvalidUserException - If the passed credentials are not valid
	 * @throws DataAccessException - If an error occurs accessing the database
	 */
	public UserBean loginUser(String userName, String password) throws InvalidUserException, DataAccessException;

	/**
	 * This method finds a user based on the user name passed
	 * @param id - UserId to search for on the database
	 * @return Returns the {@link UserBean} matching the passed ID, null if none located
	 */
	public UserBean findUser(String id);

	/**
	 * This method retrieves all users from the database
	 * @return Returns a List of users, null if none is found
	 */
	public List<UserBean> findAllUsers();

	/**
	 * This method retrieves a subset of users from the database, based on the
	 * list of user Ids passed
	 * @return Returns a List of users matching the passed Ids, null if none is found
	 */
	public List<UserBean> findAllUsersForList(List<String> ids);

	/**
	 * Method is responsible for retrieving all users associated with a particular
	 * role
	 * @param role - One or more roles we are interested in. Note that if we
	 * @return Returns a list of {@link UserBean} objects associated with this role, null
	 * if none are found
	 */
	public List<UserBean> findUsersForRole(String... role);

	/**
	 * This method adds a user to the database
	 * @param usr - User object to persist
	 * @return Returns the number of records persisted
	 */
	public int addUser(UserBean usr);

	/**
	 * This method updates the passed user
	 * @param usr - User to update on the database
	 * @return Returns the number of records updated
	 */
	public int updateUser(UserBean usr);

	/**
	 * This method deletes the passed user from the database
	 * @param usr - User to delete
	 * @return Returns the number of records deleted
	 */
	public int deleteUser(UserBean usr);
}