package com.slytherin.view.managed;

import java.util.ArrayList;
import java.util.List;

import com.slytherin.entity.CrimeEvent;
import com.slytherin.entity.Report;
import com.slytherin.rest.SigawFacadeRest;

public class ReportBean {
	private List<Report> monthReport;
	private SigawFacadeRest sigawFacade;

	public List<Report> getMonthReport() {
		return monthReport;
	}

	public void setMonthReport(List<Report> monthReport) {
		this.monthReport = monthReport;
	}
	
	public String getMonthAndType(int month, int year){
		String forward = null;
		sigawFacade = new SigawFacadeRest();
		monthReport = new ArrayList<Report>();
		
		try{
			monthReport = sigawFacade.reportMonthType(month, year);
			forward = "reports";
		} catch (Exception e){
			e.printStackTrace();
		}
		
		return forward;
	}
}
