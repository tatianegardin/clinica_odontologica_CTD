package com.dh.clinicaodontologica.model;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Dentista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "O campo 'nome' não pode ser nulo!")
    @Column(nullable = false)
    private String nome;

    @NotNull(message = "O campo 'sobrenome' não pode ser nulo!")
    @Column(nullable = false)
    private String sobrenome;

    @NotNull(message = "O campo 'cro' não pode ser nulo!")
    @Column(nullable = false)
    private String cro;

    @OneToMany(mappedBy = "dentista")
    List<Consulta> consultaList;
}
