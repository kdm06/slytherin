package com.slytherin.view.managed;

import java.util.List;

import javax.annotation.PostConstruct;

import com.slytherin.entity.Crime;
import com.slytherin.rest.SigawFacadeRest;

public class CrimeBean {

	private List<Crime> crimes;
	private SigawFacadeRest sigawFacade;
	
	public List<Crime> getCrimes() {
		return crimes;
	}

	public void setCrimes(List<Crime> crimes) {
		this.crimes = crimes;
	}
	
	@PostConstruct
	public void init(){
		sigawFacade = new SigawFacadeRest();
		crimes = sigawFacade.allCrimes();
	}
}
