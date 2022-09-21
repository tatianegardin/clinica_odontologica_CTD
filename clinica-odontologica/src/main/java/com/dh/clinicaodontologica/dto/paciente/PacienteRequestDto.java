package com.dh.clinicaodontologica.dto.paciente;

import com.dh.clinicaodontologica.model.Endereco;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PacienteRequestDto {
    private String nome;
    private String sobrenome;
    private Endereco endereco;
}
