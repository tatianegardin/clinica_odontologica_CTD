package com.dh.clinicaodontologica.repository;

import com.dh.clinicaodontologica.model.Procedimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcedimentoRepository extends JpaRepository<Procedimento, Long> {
}
