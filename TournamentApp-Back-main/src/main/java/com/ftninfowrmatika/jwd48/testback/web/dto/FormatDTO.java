package com.ftninfowrmatika.jwd48.testback.web.dto;

import javax.validation.constraints.Positive;

public class FormatDTO {

	@Positive(message = "Id mora biti pozitivan broj.")
    private Long id;
	
	private Integer brojUcesnika;
	
	private String tipTakmicenja;
	
	public FormatDTO() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getBrojUcesnika() {
		return brojUcesnika;
	}

	public void setBrojUcesnika(Integer brojUcesnika) {
		this.brojUcesnika = brojUcesnika;
	}

	public String getTipTakmicenja() {
		return tipTakmicenja;
	}

	public void setTipTakmicenja(String tipTakmicenja) {
		this.tipTakmicenja = tipTakmicenja;
	}
	
}
