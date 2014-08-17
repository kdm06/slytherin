package com.slytherin.dto;

public class ReportMonthAndTypeDTO {
    private int totalEvents;
    private String crimeType;
    public int getTotalEvents() {
        return totalEvents;
    }
    public void setTotalEvents(int totalEvents) {
        this.totalEvents = totalEvents;
    }
    public String getCrimeType() {
        return crimeType;
    }
    public void setCrimeType(String crimeType) {
        this.crimeType = crimeType;
    }
    
    
}