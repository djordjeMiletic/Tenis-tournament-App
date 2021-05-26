package com.ftninfowrmatika.jwd48.testback.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.ftninfowrmatika.jwd48.testback.enumeration.TipTakmicenja;

@Entity
public class Format {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private TipTakmicenja tipTakmicenja;
	
	@Column
	private Integer brojUcesnika;
	
	@OneToMany(mappedBy = "format", cascade = CascadeType.ALL)
	private List<Takmicenje> takmicenja = new ArrayList<Takmicenje>();

	public Format() {
	}

	public Format(TipTakmicenja tipTakmicenja, Integer brojUcesnika, List<Takmicenje> takmicenja) {
		this.tipTakmicenja = tipTakmicenja;
		this.brojUcesnika = brojUcesnika;
		this.takmicenja = takmicenja;
	}

	public Format(Long id, TipTakmicenja tipTakmicenja, Integer brojUcesnika, List<Takmicenje> takmicenja) {
		this.id = id;
		this.tipTakmicenja = tipTakmicenja;
		this.brojUcesnika = brojUcesnika;
		this.takmicenja = takmicenja;
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
		Format other = (Format) obj;
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

	public TipTakmicenja getTipTakmicenja() {
		return tipTakmicenja;
	}

	public void setTipTakmicenja(TipTakmicenja tipTakmicenja) {
		this.tipTakmicenja = tipTakmicenja;
	}

	public Integer getBrojUcesnika() {
		return brojUcesnika;
	}

	public void setBrojUcesnika(Integer brojUcesnika) {
		this.brojUcesnika = brojUcesnika;
	}

	public List<Takmicenje> getTakmicenja() {
		return takmicenja;
	}

	public void setTakmicenja(List<Takmicenje> takmicenja) {
		this.takmicenja = takmicenja;
	}

	@Override
	public String toString() {
		return "Format [id=" + id + ", tipTakmicenja=" + tipTakmicenja + ", brojUcesnika=" + brojUcesnika
				+ ", takmicenja=" + takmicenja + "]";
	}
	
	public void obrisiTakmicenje(Long id) {
		for(Takmicenje t : this.takmicenja) {
			if(t.getId() == id) {
				this.takmicenja.remove(t);
				return;
			}
		}
	}
}
