package com.ftninfowrmatika.jwd48.testback.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninfowrmatika.jwd48.testback.model.Takmicenje;
import com.ftninfowrmatika.jwd48.testback.service.FormatService;
import com.ftninfowrmatika.jwd48.testback.service.TakmicenjaService;
import com.ftninfowrmatika.jwd48.testback.web.dto.TakmicenjeDTO;

@Component
public class TakmicenjeDtoToTakmicenje implements Converter<TakmicenjeDTO, Takmicenje> {
	
	@Autowired
	private TakmicenjaService takmicenjaService;

	@Autowired
	private FormatService formatService;
	
	@Override
	public Takmicenje convert(TakmicenjeDTO dto) {
		Takmicenje entity;
		
		if(dto.getId() == null) {
			entity = new Takmicenje();
		} else {
			entity = takmicenjaService.findOneById(dto.getId());
		} 
		
		if(entity != null) {
			entity.setDatumPocetka(dto.getDatumPocetka());
			entity.setDatumZavrsetka(dto.getDatumZavrsetka());
			entity.setFormat(formatService.findOne(dto.getFormatId()));
			entity.setMestoOdrzavanja(dto.getMestoOdrzavanja());
			entity.setNaziv(dto.getNaziv());
			return entity;
		}
		return null;
	}

}
