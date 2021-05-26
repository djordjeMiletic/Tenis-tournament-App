package com.ftninfowrmatika.jwd48.testback.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Takmicenje {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(unique = true)
	private String naziv;
	
	@Column(nullable = false)
	private String mestoOdrzavanja;
	
	@Column(nullable = false)
	private LocalDate datumPocetka;
	
	@Column(nullable = false)
	private LocalDate datumZavrsetka;
	
	@ManyToOne
	private Format format;
	
	@OneToMany(mappedBy = "takmicenje", cascade = CascadeType.ALL)
	private List<Prijava> prijave = new ArrayList<Prijava>();

	public Takmicenje() {
	}

	public Takmicenje(String naziv, String mestoOdrzavanja, LocalDate datumPocetka, LocalDate datumZavrsetka,
			Format format, List<Prijava> prijave) {
		this.naziv = naziv;
		this.mestoOdrzavanja = mestoOdrzavanja;
		this.datumPocetka = datumPocetka;
		this.datumZavrsetka = datumZavrsetka;
		this.format = format;
		this.prijave = prijave;
	}

	public Takmicenje(Long id, String naziv, String mestoOdrzavanja, LocalDate datumPocetka, LocalDate datumZavrsetka,
			Format format, List<Prijava> prijave) {
		this.id = id;
		this.naziv = naziv;
		this.mestoOdrzavanja = mestoOdrzavanja;
		this.datumPocetka = datumPocetka;
		this.datumZavrsetka = datumZavrsetka;
		this.format = format;
		this.prijave = prijave;
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
		Takmicenje other = (Takmicenje) obj;
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

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getMestoOdrzavanja() {
		return mestoOdrzavanja;
	}

	public void setMestoOdrzavanja(String mestoOdrzavanja) {
		this.mestoOdrzavanja = mestoOdrzavanja;
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

	public Format getFormat() {
		return format;
	}

	public void setFormat(Format format) {
		this.format = format;
	}

	public List<Prijava> getPrijave() {
		return prijave;
	}

	public void setPrijave(List<Prijava> prijave) {
		this.prijave = prijave;
	}

	@Override
	public String toString() {
		return "Takmicenje [id=" + id + ", naziv=" + naziv + ", mestoOdrzavanja=" + mestoOdrzavanja + ", datumPocetka="
				+ datumPocetka + ", datumZavrsetka=" + datumZavrsetka + ", format=" + format + ", prijave=" + prijave
				+ "]";
	}
	
	public void obrisiPrijavu(Long id) {
		for(Prijava p : this.prijave) {
			if(p.getId() == id) {
				this.prijave.remove(p);
				return;
			}
		}
	}
}
