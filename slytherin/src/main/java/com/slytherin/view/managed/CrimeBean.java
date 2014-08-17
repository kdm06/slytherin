package com.slytherin.view.managed;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.slytherin.entity.Address;
import com.slytherin.entity.CrimeEvent;
import com.slytherin.rest.SigawFacadeRest;
import com.slytherin.util.RestClientConstants;

public class CrimeBean {

	private List<CrimeEvent> crimes;
	private SigawFacadeRest sigawFacade;
	private String crimeType;
    private Map<String,String> crimeCategories;
	private CrimeEvent crimeToAdd;
	private CrimeEvent crime;
    
	public List<CrimeEvent> getCrimes() {
		return crimes;
	}

	public void setCrimes(List<CrimeEvent> crimes) {
		this.crimes = crimes;
	}
	
	public String getCrimeType() {
		return crimeType;
	}

	public void setCrimeType(String crimeType) {
		this.crimeType = crimeType;
	}

	public Map<String, String> getCrimeCategories() {
		return crimeCategories;
	}

	public void setCrimeCategories(Map<String, String> crimeCategories) {
		this.crimeCategories = crimeCategories;
	}

	public CrimeEvent getCrimeToAdd() {
		return crimeToAdd;
	}

	public void setCrimeToAdd(CrimeEvent crimeToAdd) {
		this.crimeToAdd = crimeToAdd;
	}

	public CrimeEvent getCrime() {
		return crime;
	}

	public void setCrime(CrimeEvent crime) {
		this.crime = crime;
	}

	@PostConstruct
	public void init(){
		crimeToAdd = new CrimeEvent();
		crimeToAdd.setCrimeLocation(new Address());
		crimeToAdd.setUserLocation(new Address());
		sigawFacade = new SigawFacadeRest();
		crimes = sigawFacade.allCrimes();
		
		crimeCategories = new HashMap<String, String>();
		
		for(int i = 0; i < RestClientConstants.CRIME_TYPE.length; i++){
			crimeCategories.put(RestClientConstants.CRIME_TYPE[i], RestClientConstants.CRIME_TYPE[i]);
		}
	}
	
	public String goToReports(){
		return "reports";
	}
	
	public String goToCreate(){
		return "createCrime";
	}
	
	public String goToHome(){
		return "welcome";
	}
	
	public String goToHomepage(){
		return "home";
	}
	
	public String createReport(String userId){
		String forward = null;
		FacesMessage msg = null;
		FacesContext context = FacesContext.getCurrentInstance();
		crimeToAdd.setUserId(userId);
		
		if(sigawFacade.createCrime(crimeToAdd)){
			forward = "createCrime";
			msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Crime successfully created!", "");
			context.addMessage("createCrimeMessages", msg);
		}
		
		//reset values
		crimeToAdd = null;
		
		return forward;
	}
	
	public String getCrime(String crimeId){
		String forward = null;
		FacesContext context = FacesContext.getCurrentInstance();
		
		try{
			crime = new CrimeEvent();
			crime = sigawFacade.getCrime(crimeId);
			forward = "viewCrime";
			context.getExternalContext().getSessionMap().put("crime", crime);
		} catch (Exception e){
			e.printStackTrace();
		}
		
		
		return forward;
	}
}
