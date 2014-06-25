package elen7045.group5.project.aps.jpa.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import elen7045.group5.project.aps.jpa.model.Notification;
import elen7045.group5.project.aps.jpa.repository.NotificationRepository;

@Service
public class RepositoryNotificationService implements NotificationService
{

	@Resource
	private NotificationRepository	notificationRepository;

	@Transactional
	@Override
	public Notification create(Notification notification)
	{
		return notificationRepository.save(notification);
	}

	@Transactional(rollbackFor = NotFoundException.class)
	@Override
	public Notification delete(int id) throws NotFoundException
	{
		Notification deleted = notificationRepository.findOne(id);

		if (deleted == null)
		{
			throw new NotFoundException();
		}

		notificationRepository.delete(deleted);

		return deleted;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Notification> findAll()
	{
		return notificationRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Notification findById(Integer id)
	{
		return notificationRepository.findOne(id);
	}

	@Transactional(rollbackFor = NotFoundException.class)
	@Override
	public Notification update(Notification updated) throws NotFoundException
	{
		Notification notification = notificationRepository.findOne(updated.getNotificationId());

		if (notification == null)
		{
			throw new NotFoundException();
		}

		notification.setNotificationDescription(updated.getNotificationDescription());

		return notification;
	}

	/**
	 * This setter method should be used only by unit tests.
	 * 
	 * @param notificationRepository
	 */
	protected void setNotificationRepository(NotificationRepository notificationRepository)
	{
		this.notificationRepository = notificationRepository;
	}

}
