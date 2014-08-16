package com.slytherin.rest;

import java.util.ArrayList;
import java.util.List;

import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;

import com.slytherin.entity.CrimeEvent;
import com.slytherin.entity.Identity;
import com.slytherin.util.RestClientConstants;

public class SigawFacadeRest {

	ClientRequest request = null;
	ClientResponse response = null;

	public Identity getMemberDetails(String userName) {
		Identity member = new Identity();

		try {
			request = new ClientRequest(RestClientConstants.GET_USER_URL + userName);
			response = request.get();
			member = (Identity) response.getEntity(Identity.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return member;
	}

	public List<CrimeEvent> allCrimes() {
		List<CrimeEvent> crimeList = new ArrayList<CrimeEvent>();

		// try {
		// request = new ClientRequest(RestClientConstants.GET_USER_URL);
		// response = request.get();
		// response.getEntity();
		// } catch (Exception e) {
		// e.printStackTrace();
		// }

		return crimeList;
	}

	public boolean registerMember(Identity member) {
		boolean created = false;

		try {
			request = new ClientRequest(RestClientConstants.CREATE_USER_URL);
			response = request.body("application/json", member).post();

			if (response == null
					|| (response != null && response.getStatus() != RestClientConstants.STATUS_OK)) {
				created = false;
			} else {
				created = true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return created;
	}
}