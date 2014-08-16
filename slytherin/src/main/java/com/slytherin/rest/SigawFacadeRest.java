package com.slytherin.rest;

import java.util.ArrayList;
import java.util.List;

import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;

import com.slytherin.entity.Crime;
import com.slytherin.entity.Identity;
import com.slytherin.util.RestClientConstants;

public class SigawFacadeRest {

	ClientRequest request = null;
	ClientResponse response = null;

	public Identity getMemberDetails(String userName) {
		Identity member = new Identity();

		// try {
		// request = new ClientRequest(RestClientConstants.GET_USER_URL);
		// response = request.get();
		// response.getEntity();
		// } catch (Exception e) {
		// e.printStackTrace();
		// }

		member.setFirstName("First");
		member.setLastName("Last");
		member.setMemberRole("admin");
		member.setUserName("admin");
		member.setPassword("admin");
		return member;
	}
	
	public List<Crime> allCrimes() {
		List<Crime> crimeList = new ArrayList<Crime>();
		
//		try {
//			request = new ClientRequest(RestClientConstants.GET_USER_URL);
//			response = request.get();
//			response.getEntity();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		return crimeList;
	}
	
	public void registerMember(Identity member){
		 try {
			response = request.body("application/json", member).post();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}