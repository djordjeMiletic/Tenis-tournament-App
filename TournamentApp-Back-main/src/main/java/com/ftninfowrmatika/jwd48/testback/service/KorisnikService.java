package com.ftninfowrmatika.jwd48.testback.service;

import org.springframework.data.domain.Page;

import com.ftninfowrmatika.jwd48.testback.model.Korisnik;
import com.ftninfowrmatika.jwd48.testback.web.dto.KorisnikPromenaLozinkeDto;

import java.util.List;
import java.util.Optional;

public interface KorisnikService {

    Optional<Korisnik> findOne(Long id);

    List<Korisnik> findAll();

    Page<Korisnik> findAll(int brojStranice);

    Korisnik save(Korisnik korisnik);

    void delete(Long id);

    Optional<Korisnik> findbyKorisnickoIme(String korisnickoIme);

    boolean changePassword(Long id, KorisnikPromenaLozinkeDto korisnikPromenaLozinkeDto);
}
