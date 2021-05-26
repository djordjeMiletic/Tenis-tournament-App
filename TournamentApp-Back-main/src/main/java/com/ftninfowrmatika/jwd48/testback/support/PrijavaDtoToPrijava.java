package com.ftninfowrmatika.jwd48.testback.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninfowrmatika.jwd48.testback.model.Prijava;
import com.ftninfowrmatika.jwd48.testback.service.PrijavaService;
import com.ftninfowrmatika.jwd48.testback.service.TakmicenjaService;
import com.ftninfowrmatika.jwd48.testback.web.dto.PrijavaDTO;

@Component
public class PrijavaDtoToPrijava implements Converter<PrijavaDTO, Prijava> {
	
	@Autowired
	private PrijavaService prijavaService;
	
	@Autowired
	private TakmicenjaService takmicenjeService;

	@Override
	public Prijava convert(PrijavaDTO dto) {
		Prijava entity;
		
		if(dto.getId() == null) {
			entity = new Prijava();
		} else {
			entity = prijavaService.findOne(dto.getId());
		}
		
		if(entity != null) {
			entity.setDatumPrijave(dto.getDatumPrijave());
			entity.setDrzavaTakmicara(dto.getDrzavaTakmicara().toUpperCase());
			entity.setKontakt(dto.getKontakt());
			entity.setTakmicenje(takmicenjeService.findOneById(dto.getTakmicenjeId()));
			return entity;
		}
		return null;
	}

}
