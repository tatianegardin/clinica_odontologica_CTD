package com.dh.clinicaodontologica.dto.paciente;

import com.dh.clinicaodontologica.model.Endereco;
import com.dh.clinicaodontologica.model.Paciente;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PacienteResponseDto {
    private long id;
    private String nome;
    private String sobrenome;
    private Endereco endereco;
    private LocalDateTime dataAlta;


    public PacienteResponseDto() {
    }

    public PacienteResponseDto(Paciente paciente) {
        this.id = paciente.getId();
        this.nome = paciente.getNome();
        this.sobrenome = paciente.getSobrenome();
        this.endereco = paciente.getEndereco();
        this.dataAlta = paciente.getDataAlta();
    }
}