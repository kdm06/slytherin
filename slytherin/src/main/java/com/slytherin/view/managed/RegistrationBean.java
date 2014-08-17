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
	
	public static final String AUTH_KEY = "slytherin";
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
		FacesMessage	 msg = null;
		FacesContext context = FacesContext.getCurrentInstance();
		RequestContext rcontext = RequestContext.getCurrentInstance(); 
		boolean memberCreated = false;
		sigawFacade = new SigawFacadeRest();
		
		if(Misc.isEmpty(sigawFacade.getMemberDetails(memberToAdd.getUserName()))){
			msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Username already exists", "Duplicate User Name");
			context.addMessage("registrationCreateNewMessages", msg);
		} else if(Misc.ifNotEmpty(memberToAdd.getPassword()) && memberToAdd.getPassword().equals(newMemberReenterPassword)){
			memberToAdd.setUserRole(RestClientConstants.MEMBER_REGISTERED);
			memberToAdd.setUserType(RestClientConstants.TYPE_CITIZEN);
			memberToAdd.setStatus(RestClientConstants.MEMBER_ENABLED);
			memberCreated = sigawFacade.registerMember(memberToAdd);
			
			if(memberCreated){
				context.getExternalContext().getSessionMap().put(AUTH_KEY, memberToAdd);
				context.getExternalContext().getSessionMap().put("member", memberToAdd);
				forward = "welcome";
			} else {
				msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Password should have at least 8 chars. It should also consist of an upper case, digits, punctuation, and special characters.", "");
				context.addMessage("registrationCreateNewMessages", msg);
			}
			
			//reset values
			memberToAdd = new Identity();
			newMemberReenterPassword = null;
		} else{
			msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Passwords do not match.", "");
			context.addMessage("registrationCreateNewMessages", msg);
		}
		
		return forward;
	}
}
