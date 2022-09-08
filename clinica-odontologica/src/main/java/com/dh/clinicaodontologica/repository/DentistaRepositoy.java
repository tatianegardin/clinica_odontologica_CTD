package com.dh.clinicaodontologica.repository;

import com.dh.clinicaodontologica.model.Consulta;
import com.dh.clinicaodontologica.model.Dentista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DentistaRepositoy extends JpaRepository <Dentista, Long> {
}
