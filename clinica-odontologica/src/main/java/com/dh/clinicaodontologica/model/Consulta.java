package com.dh.clinicaodontologica.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Dentista dentista;

    @ManyToOne
    private Pacientes paciente;

    @ManyToOne
    private Procedimento procedimento;
    private LocalDate data;
    private LocalTime hora;
}