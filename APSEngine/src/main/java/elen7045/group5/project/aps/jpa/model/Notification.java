package elen7045.group5.project.aps.jpa.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the notification database table.
 * 
 */
@Entity
@NamedQuery(name="Notification.findAll", query="SELECT n FROM Notification n")
public class Notification implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="notification_id")
	private int notificationId;

	@Column(name="notification_description")
	private String notificationDescription;

	//bi-directional many-to-one association to AuditLog
	@OneToMany(mappedBy="notification")
	private List<AuditLog> auditLogs;

	public Notification() {
	}

	public int getNotificationId() {
		return this.notificationId;
	}

	public void setNotificationId(int notificationId) {
		this.notificationId = notificationId;
	}

	public String getNotificationDescription() {
		return this.notificationDescription;
	}

	public void setNotificationDescription(String notificationDescription) {
		this.notificationDescription = notificationDescription;
	}

	public List<AuditLog> getAuditLogs() {
		return this.auditLogs;
	}

	public void setAuditLogs(List<AuditLog> auditLogs) {
		this.auditLogs = auditLogs;
	}

	public AuditLog addAuditLog(AuditLog auditLog) {
		getAuditLogs().add(auditLog);
		auditLog.setNotification(this);

		return auditLog;
	}

	public AuditLog removeAuditLog(AuditLog auditLog) {
		getAuditLogs().remove(auditLog);
		auditLog.setNotification(null);

		return auditLog;
	}

}