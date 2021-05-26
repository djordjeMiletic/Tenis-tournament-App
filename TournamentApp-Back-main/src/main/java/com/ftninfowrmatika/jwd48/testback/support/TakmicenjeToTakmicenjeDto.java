package com.ftninfowrmatika.jwd48.testback.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninfowrmatika.jwd48.testback.model.Takmicenje;
import com.ftninfowrmatika.jwd48.testback.web.dto.TakmicenjeDTO;

@Component
public class TakmicenjeToTakmicenjeDto implements Converter<Takmicenje, TakmicenjeDTO>{

	@Override
	public TakmicenjeDTO convert(Takmicenje source) {
		TakmicenjeDTO dto = new TakmicenjeDTO();
		dto.setDatumPocetka(source.getDatumPocetka());
		dto.setDatumZavrsetka(source.getDatumZavrsetka());
		dto.setFormatId(source.getFormat().getId());
		dto.setFormatTipTakmicenja(String.valueOf(source.getFormat().getTipTakmicenja()));
		dto.setFormatBrojUcesnika(source.getFormat().getBrojUcesnika());
		dto.setBrojUcesnika(source.getPrijave().size());
		dto.setId(source.getId());
		dto.setMestoOdrzavanja(source.getMestoOdrzavanja());
		dto.setNaziv(source.getNaziv());
		
		return dto;
	}
	
	public List<TakmicenjeDTO> convert(List<Takmicenje> takmicenja){
		List<TakmicenjeDTO> dto = new ArrayList<TakmicenjeDTO>();
		for(Takmicenje t : takmicenja) {
			dto.add(convert(t));
		}
		return dto;
	}

}
