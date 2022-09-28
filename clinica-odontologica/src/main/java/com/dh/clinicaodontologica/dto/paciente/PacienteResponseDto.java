package com.dh.clinicaodontologica.dto.paciente;

import com.dh.clinicaodontologica.model.Endereco;
import com.dh.clinicaodontologica.model.Paciente;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PacienteResponseDto {
    private long id;
    private String nome;
    private String sobrenome;
    private String rg;
    private Endereco endereco;
    private LocalDateTime dataAlta;

    public PacienteResponseDto(Paciente paciente) {
        this.id = paciente.getId();
        this.nome = paciente.getNome();
        this.sobrenome = paciente.getSobrenome();
        this.rg = paciente.getRg();
        this.endereco = paciente.getEndereco();
        this.dataAlta = paciente.getDataAlta();
    }

}
