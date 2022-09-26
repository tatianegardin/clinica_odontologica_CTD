package com.dh.clinicaodontologica.dto.endereco;

import com.dh.clinicaodontologica.model.Endereco;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EnderecoRequestDto {
    //private Long id;
    @NotBlank(message = "O campo 'rua' não pode ser nulo!")
    private String rua;
    @NotBlank(message = "O campo 'numero' não pode ser nulo!")
    private String numero;
    @NotBlank(message = "O campo 'bairro' não pode ser nulo!")
    private String bairro;
    @NotBlank(message = "O campo 'cidade' não pode ser nulo!")
    private String cidade;
    @NotBlank(message = "O campo 'estado' não pode ser nulo!")
    private String estado;

}
