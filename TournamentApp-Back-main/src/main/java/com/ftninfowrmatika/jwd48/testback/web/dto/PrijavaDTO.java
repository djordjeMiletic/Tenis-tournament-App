package com.ftninfowrmatika.jwd48.testback.web.dto;

import java.time.LocalDate;

import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Length;

public class PrijavaDTO {

	@Positive(message = "Id mora biti pozitivan broj.")
    private Long id;
	
	private LocalDate datumPrijave;
	
	@Length(min = 3, max = 3, message = "Oznaka drzave mora imati 3 slova.")
	private String drzavaTakmicara;
	
	private String kontakt;
	
	private Long takmicenjeId;
	
	private String takmicenjeNaziv;

	public PrijavaDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDatumPrijave() {
		return datumPrijave;
	}

	public void setDatumPrijave(LocalDate datumPrijave) {
		this.datumPrijave = datumPrijave;
	}

	public String getDrzavaTakmicara() {
		return drzavaTakmicara;
	}

	public void setDrzavaTakmicara(String drzavaTakmicara) {
		this.drzavaTakmicara = drzavaTakmicara;
	}

	public String getKontakt() {
		return kontakt;
	}

	public void setKontakt(String kontakt) {
		this.kontakt = kontakt;
	}

	public Long getTakmicenjeId() {
		return takmicenjeId;
	}

	public void setTakmicenjeId(Long takmicenjeId) {
		this.takmicenjeId = takmicenjeId;
	}

	public String getTakmicenjeNaziv() {
		return takmicenjeNaziv;
	}

	public void setTakmicenjeNaziv(String takmicenjeNaziv) {
		this.takmicenjeNaziv = takmicenjeNaziv;
	}
	
}
