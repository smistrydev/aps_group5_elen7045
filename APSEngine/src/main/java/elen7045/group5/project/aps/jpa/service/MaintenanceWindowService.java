package elen7045.group5.project.aps.jpa.service;

import java.util.List;

import elen7045.group5.project.aps.jpa.model.MaintenanceWindow;

public interface MaintenanceWindowService
{

	public MaintenanceWindow create(MaintenanceWindow created);

	public MaintenanceWindow delete(int id) throws NotFoundException;

	public List<MaintenanceWindow> findAll();

	public MaintenanceWindow findById(Integer id);
	
	public MaintenanceWindow findByEmailAddres(String emailAddress);

	public MaintenanceWindow update(MaintenanceWindow updated) throws NotFoundException;
}
