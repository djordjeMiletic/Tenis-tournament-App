package com.ftninfowrmatika.jwd48.testback.web.dto;

import java.time.LocalDate;

import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Length;

public class TakmicenjeDTO {

	@Positive(message = "Id mora biti pozitivan broj.")
    private Long id;
	
	private LocalDate datumPocetka;
	
	private LocalDate datumZavrsetka;
	
	@Length(max = 50, message = "Mesto odrzavanja moze imati maksimalno 50 karaktera.")
	private String mestoOdrzavanja;
	
	private String naziv;
	
	private Long formatId;
	
	private String formatTipTakmicenja;
	
	private Integer formatBrojUcesnika;
	
	private Integer brojUcesnika;

	public TakmicenjeDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDatumPocetka() {
		return datumPocetka;
	}

	public void setDatumPocetka(LocalDate datumPocetka) {
		this.datumPocetka = datumPocetka;
	}

	public LocalDate getDatumZavrsetka() {
		return datumZavrsetka;
	}

	public void setDatumZavrsetka(LocalDate datumZavrsetka) {
		this.datumZavrsetka = datumZavrsetka;
	}

	public String getMestoOdrzavanja() {
		return mestoOdrzavanja;
	}

	public void setMestoOdrzavanja(String mestoOdrzavanja) {
		this.mestoOdrzavanja = mestoOdrzavanja;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Long getFormatId() {
		return formatId;
	}

	public void setFormatId(Long formatId) {
		this.formatId = formatId;
	}

	public String getFormatTipTakmicenja() {
		return formatTipTakmicenja;
	}

	public void setFormatTipTakmicenja(String formatTipTakmicenja) {
		this.formatTipTakmicenja = formatTipTakmicenja;
	}

	public Integer getFormatBrojUcesnika() {
		return formatBrojUcesnika;
	}

	public void setFormatBrojUcesnika(Integer formatBrojUcesnika) {
		this.formatBrojUcesnika = formatBrojUcesnika;
	}

	public Integer getBrojUcesnika() {
		return brojUcesnika;
	}

	public void setBrojUcesnika(Integer brojUcesnika) {
		this.brojUcesnika = brojUcesnika;
	}
	
}
