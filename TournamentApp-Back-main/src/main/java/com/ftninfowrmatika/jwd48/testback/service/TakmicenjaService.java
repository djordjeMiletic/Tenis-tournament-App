package com.ftninfowrmatika.jwd48.testback.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;

import com.ftninfowrmatika.jwd48.testback.model.Takmicenje;

public interface TakmicenjaService {

	List<Takmicenje> findAll();
	
	Takmicenje findOneById(Long id);

	Page<Takmicenje> find(LocalDate datumOd, String mestoOdrzavanja, Long formatId, int pageNo);
	
	Takmicenje save(Takmicenje takmicenje);
	
	Takmicenje update(Takmicenje takmicenje);
	
	Takmicenje delete(Long id);
}
