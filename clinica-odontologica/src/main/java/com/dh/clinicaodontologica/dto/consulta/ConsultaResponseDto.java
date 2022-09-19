package com.dh.clinicaodontologica.dto.consulta;

import com.dh.clinicaodontologica.model.Consulta;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConsultaResponseDto {
    private String paciente;
    private String dentista;
    private String procedimento;
    private LocalDate data;
    private LocalTime hora;

    public ConsultaResponseDto(Consulta consulta) {
        this.dentista = consulta.getDentista().getNome() + " " + consulta.getDentista().getSobrenome();
        this.paciente = consulta.getPaciente().getNome() + " " + consulta.getPaciente().getSobrenome();
        this.procedimento = consulta.getProcedimento().getDescricao();
        this.data = consulta.getData();
        this.hora = consulta.getHora();
    }
}
