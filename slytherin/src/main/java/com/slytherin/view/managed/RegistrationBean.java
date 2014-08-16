package com.slytherin.view.managed;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import com.slytherin.entity.Identity;
import com.slytherin.rest.SigawFacadeRest;
import com.slytherin.util.Misc;
import com.slytherin.util.RestClientConstants;

public class RegistrationBean implements Serializable {

	public static final long serialVersionUID = 99282617118L;
	
	SigawFacadeRest sigawFacade;
	private List<Identity> membersList = new ArrayList<Identity>();
	private Identity memberToAdd;
	private String newMemberReenterPassword;
	public List<Identity> getMembersList() {
		return membersList;
	}
	public void setMembersList(List<Identity> membersList) {
		this.membersList = membersList;
	}
	public Identity getMemberToAdd() {
		return memberToAdd;
	}
	public void setMemberToAdd(Identity memberToAdd) {
		this.memberToAdd = memberToAdd;
	}
	public String getNewMemberReenterPassword() {
		return newMemberReenterPassword;
	}
	public void setNewMemberReenterPassword(String newMemberReenterPassword) {
		this.newMemberReenterPassword = newMemberReenterPassword;
	}
	
	public RegistrationBean(){
		memberToAdd = new Identity();
	}
	
	public String goToRegister(){
		return "registration";
	}
	
	public String goToHome(){
		return "home";
	}
	
	public String createMemberAccount(){
		String forward = null;
		FacesMessage msg = null;
		FacesContext context = FacesContext.getCurrentInstance();
		RequestContext rcontext = RequestContext.getCurrentInstance(); 
		boolean memberCreated = false;
		sigawFacade = new SigawFacadeRest();
		
		if(Misc.isEmpty(sigawFacade.getMemberDetails(memberToAdd.getUserName()))){
			msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Username already exists", "Duplicate User Name");
			context.addMessage("registrationCreateNewMessages", msg);
		} else if(Misc.ifNotEmpty(memberToAdd.getPassword()) && memberToAdd.getPassword().equals(newMemberReenterPassword)){
			memberToAdd.setMemberRole(RestClientConstants.MEMBER_REGISTERED);
			memberToAdd.setUserType(RestClientConstants.TYPE_CITIZEN);
			memberToAdd.setStatus(RestClientConstants.YES);
			sigawFacade.registerMember(memberToAdd);
			memberCreated = true;
			
			//reset values
			memberToAdd = new Identity();
			newMemberReenterPassword = null;
			forward = "welcome";
		} else{
			msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Passwords do not Match.", " Incorrect Password");
			context.addMessage("registrationCreateNewMessages", msg);
		}
		
		return forward;
	}
}
