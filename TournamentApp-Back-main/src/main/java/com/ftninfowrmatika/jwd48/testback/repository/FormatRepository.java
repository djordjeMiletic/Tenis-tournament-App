package com.ftninfowrmatika.jwd48.testback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftninfowrmatika.jwd48.testback.model.Format;

@Repository
public interface FormatRepository extends JpaRepository<Format, Long> {

	Format findOneById(Long id);
}
