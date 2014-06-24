package elen7045.group5.project.aps.jpa.service;

import java.util.List;

import elen7045.group5.project.aps.jpa.model.Statement;

public interface StatementService
{

	public Statement create(Statement created);

	public Statement delete(int id) throws NotFoundException;

	public List<Statement> findAll();

	public Statement findById(Integer id);

	public Statement findByEmailAddres(String emailAddress);

	public Statement update(Statement updated) throws NotFoundException;
}
