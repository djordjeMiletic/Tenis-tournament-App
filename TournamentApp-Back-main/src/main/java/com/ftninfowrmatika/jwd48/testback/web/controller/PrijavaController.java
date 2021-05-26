package com.ftninfowrmatika.jwd48.testback.web.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Calendar;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ftninfowrmatika.jwd48.testback.model.Prijava;
import com.ftninfowrmatika.jwd48.testback.service.PrijavaService;
import com.ftninfowrmatika.jwd48.testback.support.PrijavaDtoToPrijava;
import com.ftninfowrmatika.jwd48.testback.support.PrijavaToPrijavaDto;
import com.ftninfowrmatika.jwd48.testback.web.dto.PrijavaDTO;

@RestController
@RequestMapping(value = "/api/prijave", produces = MediaType.APPLICATION_JSON_VALUE)
public class PrijavaController {

	@Autowired
	private PrijavaService prijavaService;
	
	@Autowired
	private PrijavaToPrijavaDto toDto;
	
	@Autowired
	private PrijavaDtoToPrijava toPrijava;
	
	@PreAuthorize("hasRole('KORISNIK')")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PrijavaDTO> convert(@Valid @RequestBody PrijavaDTO dto){
		
		Prijava prijava = toPrijava.convert(dto);
		
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
		prijava.setDatumPrijave(getLocalDate(timeStamp));
		
		Prijava dodata = prijavaService.save(prijava);
		
		return new ResponseEntity<PrijavaDTO>(toDto.convert(dodata), HttpStatus.CREATED);
	}
	
	private LocalDate getLocalDate(String date) throws DateTimeParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(date, formatter);
	}
}
