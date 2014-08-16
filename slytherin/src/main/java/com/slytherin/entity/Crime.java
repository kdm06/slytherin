package com.slytherin.entity;

public class Crime {
	private long crimeId;
	private String title;
	private String reporter;
	private String report;
	
	public long getCrimeId() {
		return crimeId;
	}
	public void setCrimeId(long crimeId) {
		this.crimeId = crimeId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getReporter() {
		return reporter;
	}
	public void setReporter(String reporter) {
		this.reporter = reporter;
	}
	public String getReport() {
		return report;
	}
	public void setReport(String report) {
		this.report = report;
	}
	
	
}
