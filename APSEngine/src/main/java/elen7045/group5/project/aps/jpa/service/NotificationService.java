package elen7045.group5.project.aps.jpa.service;

import java.util.List;

import elen7045.group5.project.aps.jpa.model.Notification;

public interface NotificationService
{

	public Notification create(Notification created);

	public Notification delete(int id) throws NotFoundException;

	public List<Notification> findAll();

	public Notification findById(Integer id);

	public Notification update(Notification updated) throws NotFoundException;
}
