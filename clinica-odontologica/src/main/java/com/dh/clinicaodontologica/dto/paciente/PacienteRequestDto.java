package com.dh.clinicaodontologica.dto.paciente;

import com.dh.clinicaodontologica.model.Endereco;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
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
    @NotBlank(message = "O campo 'nome' precisa ser preenchido!")
    private String nome;
    @NotBlank(message = "O campo 'sobrenome' precisa ser preenchido!")
    private String sobrenome;
    @NotBlank(message = "O campo 'RG' precisa ser preenchido!")
    private String rg;
    @Valid
    private Endereco endereco;
}
