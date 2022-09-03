package com.dh.clinicaodontologica.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoDTO {
    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
}
