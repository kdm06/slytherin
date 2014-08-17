package com.slytherin.entity;

import java.util.Date;

public class CrimeEvent {
	private String id;
    private String crimeType;
    private String title;
    private String details;
    private Date reportDate;
    private Address crimeLocation;
    private Address userLocation;
    private int reliabilityScore;
    private String reliabilityLevel;
    private String userId;
    private Identity userDTO;
    private String reportDateString;
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCrimeType() {
		return crimeType;
	}
	public void setCrimeType(String crimeType) {
		this.crimeType = crimeType;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public Date getReportDate() {
		return reportDate;
	}
	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}
	public Address getCrimeLocation() {
		return crimeLocation;
	}
	public void setCrimeLocation(Address crimeLocation) {
		this.crimeLocation = crimeLocation;
	}
	public Address getUserLocation() {
		return userLocation;
	}
	public void setUserLocation(Address userLocation) {
		this.userLocation = userLocation;
	}
	public int getReliabilityScore() {
		return reliabilityScore;
	}
	public void setReliabilityScore(int reliabilityScore) {
		this.reliabilityScore = reliabilityScore;
	}
	public String getReliabilityLevel() {
		return reliabilityLevel;
	}
	public void setReliabilityLevel(String reliabilityLevel) {
		this.reliabilityLevel = reliabilityLevel;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Identity getUserDTO() {
		return userDTO;
	}
	public void setUserDTO(Identity userDTO) {
		this.userDTO = userDTO;
	}
	public String getReportDateString() {
		return reportDateString;
	}
	public void setReportDateString(String reportDateString) {
		this.reportDateString = reportDateString;
	}
}
