package com.dh.clinicaodontologica.repository;

import com.dh.clinicaodontologica.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    //@Query ("FROM Paciente e where e. id = :id")
    //Paciente deleteById(long id);
}