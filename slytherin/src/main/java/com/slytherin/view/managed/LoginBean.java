package com.slytherin.view.managed;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.slytherin.entity.Identity;
import com.slytherin.rest.SigawFacadeRest;
import com.slytherin.util.Misc;

public class LoginBean implements Serializable {
	private static final long serialVersionUID = -187727278191L;
	
	public static final String AUTH_KEY = "slytherin";
	String userName;
	String password;
	Identity member;
	SigawFacadeRest sigawFacade;

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Identity getMember() {
		return member;
	}
	public void setMember(Identity member) {
		this.member = member;
	}
	
	public String goToLogin(){
		return "login";
	}
	
	public String goToHome(){
		return "home";
	}
	
	public String processLogin(){
		String forward = null;
		FacesMessage msg = null;
		FacesContext context = FacesContext.getCurrentInstance();
		sigawFacade = new SigawFacadeRest();
		member = sigawFacade.getMemberDetails(userName);
		
		if(Misc.isNotEmpty(member) && Misc.ifNotEmpty(member.getPassword())){
			context.getExternalContext().getSessionMap().put(AUTH_KEY, member);
			context.getExternalContext().getSessionMap().put("userName", member.getUserName());
			msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "User: " + member.getUserName() + "succesfully logged in.", "Success");
			forward = "welcome";
		} else{
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(AUTH_KEY, null);
			msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Invalid Login.", "Please Try Again.");
			context.addMessage("rightSignInMessages", msg);
			member = null;	
		}
		return forward;
	}
	
	public String processLogout(){
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(AUTH_KEY, null);
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/view/main/home.xhtml?faces-redirect=true";
	}
}
