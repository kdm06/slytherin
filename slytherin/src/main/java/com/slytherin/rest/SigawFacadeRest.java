package com.slytherin.rest;

import java.util.ArrayList;
import java.util.List;

import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import org.jboss.resteasy.util.GenericType;

import com.slytherin.entity.CrimeEvent;
import com.slytherin.entity.Identity;
import com.slytherin.entity.Report;
import com.slytherin.util.RestClientConstants;

public class SigawFacadeRest {

	ClientRequest request = null;
	ClientResponse response = null;

	public Identity getMemberDetails(String userName) {
		Identity member = new Identity();

		try {
			request = new ClientRequest(RestClientConstants.IP_ADDRESS
					+ RestClientConstants.GET_USER_URL + userName);
			response = request.get();
			member = (Identity) response.getEntity(Identity.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return member;
	}

	public boolean registerMember(Identity member) {
		boolean created = false;

		try {
			request = new ClientRequest(RestClientConstants.IP_ADDRESS
					+ RestClientConstants.CREATE_USER_URL);
			response = request.body("application/json", member).post();

			if (response == null || (response != null && response.getStatus() != RestClientConstants.STATUS_OK)) {
				created = false;
			} else {
				created = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return created;
	}

	public List<CrimeEvent> allCrimes() {
		List<CrimeEvent> crimeList = new ArrayList<CrimeEvent>();

		try {
			request = new ClientRequest(RestClientConstants.IP_ADDRESS + RestClientConstants.GET_LIST_CRIMES);
			response = request.get();
			crimeList = (List<CrimeEvent>) response.getEntity(new GenericType<List<CrimeEvent>>(){});
		} catch (Exception e) {
			e.printStackTrace();
		}

		return crimeList;
	}

	public List<Report> reportMonthType(int month, int year){
		List<Report> reportList = new ArrayList<Report>();
		
		try {
			request = new ClientRequest(RestClientConstants.IP_ADDRESS + RestClientConstants.REPORT_MONTH_TYPE + "8/2014");
			response = request.get();
			reportList = (List<Report>) response.getEntity(new GenericType<List<Report>>(){});
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return reportList;
	}
	
	public boolean createCrime(CrimeEvent crime) {
		boolean created = false;

		try {
			request = new ClientRequest(RestClientConstants.IP_ADDRESS + RestClientConstants.CREATE_CRIME);
			response = request.body("application/json", crime).post();

			if (response != null && response.getStatus() == RestClientConstants.STATUS_OK) {
				created = true;
			}
		} catch (Exception e) {

		}

		return created;
	}
	
	public CrimeEvent getCrime(String crimeId){
		CrimeEvent crime = new CrimeEvent();
		
		try {
			request = new ClientRequest(RestClientConstants.IP_ADDRESS + RestClientConstants.GET_CRIME_BY_ID + crimeId);
			response = request.get();
			crime = (CrimeEvent) response.getEntity(CrimeEvent.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return crime;
	}
	
}