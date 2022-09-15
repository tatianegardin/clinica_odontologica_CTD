package com.dh.clinicaodontologica.repository;

import com.dh.clinicaodontologica.model.Dentista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DensitaRepository extends JpaRepository<Dentista, Long> {
}
