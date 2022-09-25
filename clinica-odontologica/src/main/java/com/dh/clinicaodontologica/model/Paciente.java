package com.dh.clinicaodontologica.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Table(name="Paciente")
@Builder
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String sobrenome;

    @Column(nullable = false)
    private String rg;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @Column(nullable = true)
    private LocalDateTime dataAlta;

    @OneToMany(mappedBy = "dentista")
    List<Consulta> consultaList;
}
