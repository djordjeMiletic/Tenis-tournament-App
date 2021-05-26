package com.ftninfowrmatika.jwd48.testback.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninfowrmatika.jwd48.testback.model.Format;
import com.ftninfowrmatika.jwd48.testback.web.dto.FormatDTO;

@Component
public class FormatToFormatDto implements Converter<Format, FormatDTO>{

	@Override
	public FormatDTO convert(Format source) {
		FormatDTO dto = new FormatDTO();
		dto.setBrojUcesnika(source.getBrojUcesnika());
		dto.setId(source.getId());
		dto.setTipTakmicenja(String.valueOf(source.getTipTakmicenja()));
		return dto;
	}
	
	public List<FormatDTO> convert(List<Format> formati){
		List<FormatDTO> dto = new ArrayList<FormatDTO>();
		for(Format f : formati) {
			dto.add(convert(f));
		}
		return dto;
	}

}
