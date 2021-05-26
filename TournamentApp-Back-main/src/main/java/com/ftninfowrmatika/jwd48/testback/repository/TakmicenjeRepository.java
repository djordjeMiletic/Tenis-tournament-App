package com.ftninfowrmatika.jwd48.testback.repository;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ftninfowrmatika.jwd48.testback.model.Takmicenje;

@Repository
public interface TakmicenjeRepository extends JpaRepository<Takmicenje, Long> {

	Takmicenje findOneById(Long id);

	@Query("SELECT t FROM Takmicenje t WHERE " + 
			"(:mestoOdrzavanja = NULL OR t.mestoOdrzavanja LIKE %:mestoOdrzavanja%) AND " +
			"(:datumOd = NULL OR t.datumPocetka > :datumOd) AND " +
			"(:formatId = NULL OR t.format.id = :formatId)" + 
			" ORDER BY t.naziv")
	Page<Takmicenje> search(
			@Param("datumOd") LocalDate datumOd,
			@Param("mestoOdrzavanja") String mestoOdrzavanja,
			@Param("formatId") Long formatId,
			Pageable pageable);
}
