package com.dh.clinicaodontologica.repository;

import com.dh.clinicaodontologica.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    @Query("FROM Endereco e where e.id = :id")
    Endereco deleteById(long id);
}
