package com.dh.clinicaodontologica.repository;

import com.dh.clinicaodontologica.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;

@Repository
public interface ConsultaRepository extends JpaRepository <Consulta, Long> {
    @Query(nativeQuery = true, value = "select * from consulta c " +
            "WHERE dentista_id = :dentista " +
            "AND `data` = :data " +
            "AND hora = :hora")
    Consulta findByConsultaByDentistaAndHorario(long dentista, LocalDate data, LocalTime hora);
}
