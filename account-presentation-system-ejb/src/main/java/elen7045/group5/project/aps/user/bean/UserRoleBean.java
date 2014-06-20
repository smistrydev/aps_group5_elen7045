package elen7045.group5.project.aps.user.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Specifies a role in the application that is assigned to a user and
 * defines what parts of the application they can access.
 */
@Entity
@Table(name="USER_ROLES")
@NamedQueries({
	@NamedQuery(name="UserRoleBean.findAll", query="SELECT x FROM UserRoleBean x ORDER BY roleName"),
	@NamedQuery(name="UserRoleBean.findByRole", query="SELECT x FROM UserRoleBean x WHERE roleName = :roleName")
})
public class UserRoleBean implements Serializable
{
	private static final long serialVersionUID = 1234567L;
	private String roleName,
					roleDescription;

	/**
	 * The name of the role
	 * @return the roleName
	 */
	@Id
	@Column(name="ROLE_NAME")
	public String getRoleName()
	{
		return roleName;
	}

	/**
	 * A description of what the role entails
	 * @return the roleDescription
	 */
	@Column(name="DESCRIPTION")
	public String getRoleDescription()
	{
		return roleDescription;
	}

	/**
	 * @param roleName the roleName to set
	 */
	public void setRoleName(String roleName)
	{
		this.roleName = roleName;
	}

	/**
	 * @param roleDescription the roleDescription to set
	 */
	public void setRoleDescription(String roleDescription)
	{
		this.roleDescription = roleDescription;
	}
}
