package com.dh.clinicaodontologica.dto.consulta;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConsultaRequestDto {
    private long dentistaId;
    private long pacienteId;
    private long procedimentoId;
    private LocalDate data;
    private LocalTime hora;
}
