package elen7045.group5.project.aps.jpa.service;

import java.util.List;

import elen7045.group5.project.aps.jpa.model.Account;

public interface AccountService
{

	public Account create(Account created);

	public Account delete(int id) throws NotFoundException;

	public List<Account> findAll();

	public Account findById(Integer id);

	public Account update(Account updated) throws NotFoundException;
}
