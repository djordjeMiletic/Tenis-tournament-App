package com.ftninfowrmatika.jwd48.testback.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftninfowrmatika.jwd48.testback.model.Prijava;
import com.ftninfowrmatika.jwd48.testback.repository.PrijavaRepository;
import com.ftninfowrmatika.jwd48.testback.service.PrijavaService;

@Service
public class JpaPrijavaService implements PrijavaService {

	@Autowired
	private PrijavaRepository prijavaRepository;
	
	@Override
	public List<Prijava> findAll() {
		return prijavaRepository.findAll();
	}

	@Override
	public Prijava findOne(Long id) {
		return prijavaRepository.findOneById(id);
	}

	@Override
	public Prijava save(Prijava prijava) {
		return prijavaRepository.save(prijava);
	}

}
