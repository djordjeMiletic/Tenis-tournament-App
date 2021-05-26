package com.ftninfowrmatika.jwd48.testback.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninfowrmatika.jwd48.testback.model.Prijava;
import com.ftninfowrmatika.jwd48.testback.web.dto.PrijavaDTO;

@Component
public class PrijavaToPrijavaDto implements Converter<Prijava, PrijavaDTO>{

	@Override
	public PrijavaDTO convert(Prijava source) {
		PrijavaDTO dto = new PrijavaDTO();
		dto.setDatumPrijave(source.getDatumPrijave());
		dto.setDrzavaTakmicara(source.getDrzavaTakmicara());
		dto.setId(source.getId());
		dto.setKontakt(source.getKontakt());
		dto.setTakmicenjeId(source.getTakmicenje().getId());
		dto.setTakmicenjeNaziv(source.getTakmicenje().getNaziv());
		
		return dto;
	}
	
	public List<PrijavaDTO> convert(List<Prijava> prijave){
		List<PrijavaDTO> dto = new ArrayList<PrijavaDTO>();
		for(Prijava p : prijave) {
			dto.add(convert(p));
		}
		return dto;
	}

}
