package com.ftninfowrmatika.jwd48.testback.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ftninfowrmatika.jwd48.testback.model.Format;
import com.ftninfowrmatika.jwd48.testback.model.Takmicenje;
import com.ftninfowrmatika.jwd48.testback.repository.TakmicenjeRepository;
import com.ftninfowrmatika.jwd48.testback.service.FormatService;
import com.ftninfowrmatika.jwd48.testback.service.TakmicenjaService;

@Service
public class JpaTakmicenjeSrvice implements TakmicenjaService {

	@Autowired
	private TakmicenjeRepository takmicenjeRepository;
	
	@Autowired
	private FormatService formatService;
	
	@Override
	public List<Takmicenje> findAll() {
		return takmicenjeRepository.findAll();
	}

	@Override
	public Takmicenje findOneById(Long id) {
		return takmicenjeRepository.findOneById(id);
	}

	@Override
	public Page<Takmicenje> find(LocalDate datumOd, String mestoOdrzavanja, Long formatId, int pageNo) {
		return takmicenjeRepository.search(datumOd, mestoOdrzavanja, formatId, PageRequest.of(pageNo, 4));
	}

	@Override
	public Takmicenje save(Takmicenje takmicenje) {
		return takmicenjeRepository.save(takmicenje);
	}

	@Override
	public Takmicenje update(Takmicenje takmicenje) {
		return takmicenjeRepository.save(takmicenje);
	}

	@Override
	public Takmicenje delete(Long id) {
		Takmicenje takmicenje = takmicenjeRepository.findOneById(id);
		
		if(takmicenje != null) {
			
			Format format = takmicenje.getFormat();
			format.obrisiTakmicenje(id);
			formatService.update(format);
			
			takmicenjeRepository.deleteById(id);
			
			return takmicenje;
		}
		return null;
	}

}
