package com.dh.clinicaodontologica.dto.consulta;

import com.dh.clinicaodontologica.model.Consulta;

import java.time.LocalDate;
import java.time.LocalTime;

public class ConsultaResponseDto {
    private String dentista;
    private String paciente;
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
