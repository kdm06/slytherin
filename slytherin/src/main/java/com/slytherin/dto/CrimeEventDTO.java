package com.slytherin.dto;

import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;

public class CrimeEventDTO {
    
    private String id;
    private String crimeType;
    
    @NotBlank(message="No title provided")
    private String title;
    
    private String details;
    private Date reportDate;
    private AddressDTO crimeLocation;
    private AddressDTO userLocation;
    private int reliabilityScore;
    private String reliabilityLevel;
    private String userId;
    
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
    public AddressDTO getCrimeLocation() {
        return crimeLocation;
    }
    public void setCrimeLocation(AddressDTO crimeLocation) {
        this.crimeLocation = crimeLocation;
    }
    public AddressDTO getUserLocation() {
        return userLocation;
    }
    public void setUserLocation(AddressDTO userLocation) {
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
}
