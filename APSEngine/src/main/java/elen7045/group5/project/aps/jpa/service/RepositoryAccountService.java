package elen7045.group5.project.aps.jpa.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import elen7045.group5.project.aps.jpa.model.Account;
import elen7045.group5.project.aps.jpa.repository.AccountRepository;

@Service
public class RepositoryAccountService implements AccountService
{

	@Resource
	private AccountRepository	repository;

	@Transactional
	@Override
	public Account create(Account created)
	{
		return repository.save(created);
	}

	@Transactional(rollbackFor = NotFoundException.class)
	@Override
	public Account delete(int id) throws NotFoundException
	{
		Account deleted = repository.findOne(id);

		if (deleted == null)
		{
			throw new NotFoundException();
		}

		repository.delete(deleted);

		return deleted;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Account> findAll()
	{
		return repository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Account findById(Integer id)
	{
		return repository.findOne(id);
	}

	@Transactional(rollbackFor = NotFoundException.class)
	@Override
	public Account update(Account updated) throws NotFoundException
	{
		Account original = repository.findOne(updated.getAccountId());

		if (original == null)
		{
			throw new NotFoundException();
		}

		original.setAccountNumber(updated.getAccountNumber());
		original.setCustomerLoginName(updated.getCustomerLoginName());
		original.setCustomerLoginPassword(updated.getCustomerLoginPassword());

		return original;
	}

	public void setAccountRepository(AccountRepository repository)
	{
		this.repository = repository;
	}

}
