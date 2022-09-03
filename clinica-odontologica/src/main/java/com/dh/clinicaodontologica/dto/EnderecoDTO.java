package com.dh.clinicaodontologica.dto;

import com.dh.clinicaodontologica.model.Endereco;
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

    public EnderecoDTO(Endereco endereco) {
        this.rua = endereco.getRua();
        this.numero = endereco.getNumero();
        this.bairro = endereco.getBairro();
        this.cidade = endereco.getCidade();
        this.estado = endereco.getEstado();
    }
}
