package com.ftninfowrmatika.jwd48.testback.web.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ftninfowrmatika.jwd48.testback.model.Takmicenje;
import com.ftninfowrmatika.jwd48.testback.service.TakmicenjaService;
import com.ftninfowrmatika.jwd48.testback.support.TakmicenjeDtoToTakmicenje;
import com.ftninfowrmatika.jwd48.testback.support.TakmicenjeToTakmicenjeDto;
import com.ftninfowrmatika.jwd48.testback.web.dto.TakmicenjeDTO;

@RestController
@RequestMapping(value = "/api/takmicenja", produces = MediaType.APPLICATION_JSON_VALUE)
public class TakmicenjeController {

	@Autowired
	private TakmicenjaService takmicenjaService;
	
	@Autowired
	private TakmicenjeDtoToTakmicenje toTakmicenje;
	
	@Autowired
	private TakmicenjeToTakmicenjeDto toDto;
	
	@PreAuthorize("hasAnyRole('ADMIN', 'KORISNIK')")
	@GetMapping
	public ResponseEntity<List<TakmicenjeDTO>> getAll(
			@RequestParam(defaultValue = "0", value = "pageNo") int pageNo,
			@RequestParam(required = false) String mestoOdrzavanja,
			@RequestParam(required = false) Long formatId,
			@RequestParam(required = false) String datumOd
			){
		
		Page<Takmicenje> takmicenja;
		
		if(datumOd != null) {
			LocalDate datum = getLocalDate(datumOd);
			takmicenja = takmicenjaService.find(datum, mestoOdrzavanja, formatId, pageNo);
		} else {
			takmicenja = takmicenjaService.find(null, mestoOdrzavanja, formatId, pageNo);
		}
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Total-Pages", String.valueOf(takmicenja.getTotalPages()));
		
		return new ResponseEntity<List<TakmicenjeDTO>>(toDto.convert(takmicenja.getContent()), headers, HttpStatus.OK);
	}
	
	@PreAuthorize("hasAnyRole('ADMIN', 'KORISNIK')")
	@GetMapping("/{id}")
	public ResponseEntity<TakmicenjeDTO> getOne(@PathVariable Long id){
		
		Takmicenje takmicenje = takmicenjaService.findOneById(id);
		
		return new ResponseEntity<TakmicenjeDTO>(toDto.convert(takmicenje), HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TakmicenjeDTO> create(@Valid @RequestBody TakmicenjeDTO dto){
		
		Takmicenje takmicenje = toTakmicenje.convert(dto);
		Takmicenje dodato = takmicenjaService.save(takmicenje);
		
		return new ResponseEntity<TakmicenjeDTO>(toDto.convert(dodato), HttpStatus.CREATED);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TakmicenjeDTO> update(@PathVariable Long id, @Valid @RequestBody TakmicenjeDTO dto){
		
		if(id != dto.getId()) {
			return new ResponseEntity<TakmicenjeDTO>(HttpStatus.BAD_REQUEST);
		}
		
		Takmicenje takmicenje = toTakmicenje.convert(dto);
		Takmicenje izmenje = takmicenjaService.update(takmicenje);
		
		return new ResponseEntity<TakmicenjeDTO>(toDto.convert(izmenje), HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		
		Takmicenje takmicenje = takmicenjaService.delete(id);
		
		if(takmicenje != null) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	private LocalDate getLocalDate(String date) throws DateTimeParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(date, formatter);
	}
}
