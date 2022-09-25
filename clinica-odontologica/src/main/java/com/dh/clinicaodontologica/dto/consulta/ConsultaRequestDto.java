package com.dh.clinicaodontologica.dto.consulta;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConsultaRequestDto {
    @NotNull(message = "Dentista não pode ser nulo!")
    private Long dentistaId;

    @NotNull(message = "Paciente não pode ser nulo!")
    private Long pacienteId;

    @NotNull(message = "Procedimento não pode ser nulo!")
    private Long procedimentoId;

    @NotNull(message = "Data não pode ser nulo!")
    private LocalDate data;

    @NotNull(message = "Hora não pode ser nulo!")
    private LocalTime hora;
}
