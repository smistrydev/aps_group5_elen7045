package elen7045.group5.project.aps.jpa.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the statement_provider database table.
 * 
 */
@Entity
@Table(name = "statement_provider")
@NamedQuery(name = "StatementProvider.findAll", query = "SELECT s FROM StatementProvider s")
public class StatementProvider implements Serializable
{
	private static final long	serialVersionUID	= 1L;

	@Id
	@Column(name = "statement_provider_id")
	private int					statementProviderId;

	@Column(name = "statement_provider_description")
	private String				statementProviderDescription;

	// bi-directional many-to-one association to Statement
	@OneToMany(mappedBy = "statementProvider")
	private List<Statement>		statements;

	public StatementProvider()
	{
	}

	public int getStatementProviderId()
	{
		return this.statementProviderId;
	}

	public void setStatementProviderId(int statementProviderId)
	{
		this.statementProviderId = statementProviderId;
	}

	public String getStatementProviderDescription()
	{
		return this.statementProviderDescription;
	}

	public void setStatementProviderDescription(String statementProviderDescription)
	{
		this.statementProviderDescription = statementProviderDescription;
	}

	public List<Statement> getStatements()
	{
		return this.statements;
	}

	public void setStatements(List<Statement> statements)
	{
		this.statements = statements;
	}

	public Statement addStatement(Statement statement)
	{
		getStatements().add(statement);
		statement.setStatementProvider(this);

		return statement;
	}

	public Statement removeStatement(Statement statement)
	{
		getStatements().remove(statement);
		statement.setStatementProvider(null);

		return statement;
	}

}