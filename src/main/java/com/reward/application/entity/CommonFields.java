package com.reward.application.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
/**
 * Represents an Common fields which needed for other entities.
 * Used to store created/updated by and date.
 */
@MappedSuperclass
public class CommonFields {
	@Column(name = "CREATED_DATE")
	@Temporal(TemporalType.DATE)
	protected Date createdDt;
	@Column(name = "UPDATED_DATE")
	@Temporal(TemporalType.DATE)
	protected Date updatedDt;
	@Column(name = "CREATED_BY")
	protected String createdBy;
	@Column(name = "UPDATED_BY")
	protected String updatedBy;
	
	/**
	 * Assigns the values to the fields before persisting to the database.
	 * Used to set values in created/updated by and date fields.
	 */
	@PrePersist
	protected void onCreate() {
		//createdDt = new Date();
		updatedDt = new Date();
		createdBy = "System";
		updatedBy = "System";
	}
	
	public Date getCreatedDt() {
		return createdDt;
	}
	public void setCreatedDt(Date createdDt) {
		this.createdDt = createdDt;
	}
	public Date getUpdatedDt() {
		return updatedDt;
	}
	public void setUpdatedDt(Date updatedDt) {
		this.updatedDt = updatedDt;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
}
