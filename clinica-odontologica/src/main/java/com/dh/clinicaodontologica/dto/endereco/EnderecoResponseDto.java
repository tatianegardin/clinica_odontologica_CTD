package com.dh.clinicaodontologica.dto.endereco;

import com.dh.clinicaodontologica.model.Endereco;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

//@JsonIgnoreProperties(ignoreUnknown = true)

@Data
@AllArgsConstructor
@Builder
public class EnderecoResponseDto {
    private Long id;
    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;

    public EnderecoResponseDto() {
    }

    public EnderecoResponseDto(Endereco endereco) {
        this.id = endereco.getId();
        this.rua = endereco.getRua();
        this.numero = endereco.getNumero();
        this.bairro = endereco.getBairro();
        this.cidade = endereco.getCidade();
        this.estado = endereco.getEstado();
    }

}
