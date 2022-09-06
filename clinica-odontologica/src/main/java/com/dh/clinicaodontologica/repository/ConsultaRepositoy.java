package com.dh.clinicaodontologica.repository;

import com.dh.clinicaodontologica.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaRepositoy extends JpaRepository <Consulta, Long> {
}
