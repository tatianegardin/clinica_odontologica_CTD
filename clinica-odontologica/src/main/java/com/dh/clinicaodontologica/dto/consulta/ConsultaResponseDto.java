package com.dh.clinicaodontologica.dto.consulta;

import com.dh.clinicaodontologica.model.Consulta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConsultaResponseDto {
    private String paciente;
    private String dentista;
    private String procedimento;
    private LocalDate data;
    private LocalTime hora;

    public ConsultaResponseDto(Consulta consulta) {
        this.dentista = consulta.getDentista().getNome();
        this.paciente = consulta.getPaciente().getNome();
        this.procedimento = consulta.getProcedimento().getDescricao();
        this.data = consulta.getData();
        this.hora = consulta.getHora();
    }
}
