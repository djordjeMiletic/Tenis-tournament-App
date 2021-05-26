package com.ftninfowrmatika.jwd48.testback.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ftninfowrmatika.jwd48.testback.model.Format;
import com.ftninfowrmatika.jwd48.testback.service.FormatService;
import com.ftninfowrmatika.jwd48.testback.support.FormatToFormatDto;
import com.ftninfowrmatika.jwd48.testback.web.dto.FormatDTO;

@RestController
@RequestMapping(value = "/api/formati", produces = MediaType.APPLICATION_JSON_VALUE)
public class FormatController {
	
	@Autowired
	private FormatService formatService;
	
	@Autowired
	private FormatToFormatDto toDto;
	
	@PreAuthorize("hasAnyRole('ADMIN', 'KORISNIK')")
	@GetMapping
	public ResponseEntity<List<FormatDTO>> convert(){
		
		List<Format> formati = formatService.findAll();
		
		return new ResponseEntity<List<FormatDTO>>(toDto.convert(formati), HttpStatus.OK);
	}

}
