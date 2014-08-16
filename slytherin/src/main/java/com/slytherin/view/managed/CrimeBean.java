package com.slytherin.view.managed;

import java.util.List;

import javax.annotation.PostConstruct;

import com.slytherin.entity.CrimeEvent;
import com.slytherin.rest.SigawFacadeRest;

public class CrimeBean {

	private List<CrimeEvent> crimes;
	private SigawFacadeRest sigawFacade;
	
	public List<CrimeEvent> getCrimes() {
		return crimes;
	}

	public void setCrimes(List<CrimeEvent> crimes) {
		this.crimes = crimes;
	}
	
	@PostConstruct
	public void init(){
		sigawFacade = new SigawFacadeRest();
		crimes = sigawFacade.allCrimes();
	}
}
