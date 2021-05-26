package com.ftninfowrmatika.jwd48.testback.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;

@Entity
public class Prijava {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(nullable = false)
	private String drzavaTakmicara;
	
	@Column(nullable = false, unique = true)
	@Email
	private String kontakt;
	
	@Column(nullable = false)
	private LocalDate datumPrijave;
	
	@ManyToOne
	private Takmicenje takmicenje;

	public Prijava() {
	}

	public Prijava(String drzavaTakmicara, @Email String kontakt, LocalDate datumPrijave, Takmicenje takmicenje) {
		this.drzavaTakmicara = drzavaTakmicara;
		this.kontakt = kontakt;
		this.datumPrijave = datumPrijave;
		this.takmicenje = takmicenje;
	}

	public Prijava(Long id, String drzavaTakmicara, @Email String kontakt, LocalDate datumPrijave,
			Takmicenje takmicenje) {
		this.id = id;
		this.drzavaTakmicara = drzavaTakmicara;
		this.kontakt = kontakt;
		this.datumPrijave = datumPrijave;
		this.takmicenje = takmicenje;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prijava other = (Prijava) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public LocalDate getDatumPrijave() {
		return datumPrijave;
	}

	public void setDatumPrijave(LocalDate datumPrijave) {
		this.datumPrijave = datumPrijave;
	}

	public Takmicenje getTakmicenje() {
		return takmicenje;
	}

	public void setTakmicenje(Takmicenje takmicenje) {
		this.takmicenje = takmicenje;
	}

	@Override
	public String toString() {
		return "Prijava [id=" + id + ", drzavaTakmicara=" + drzavaTakmicara + ", kontakt=" + kontakt + ", datumPrijave="
				+ datumPrijave + ", takmicenje=" + takmicenje + "]";
	}
	
}
