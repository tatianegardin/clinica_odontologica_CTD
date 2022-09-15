package com.dh.clinicaodontologica.model;

import com.dh.clinicaodontologica.dto.endereco.EnderecoResponseDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name= "Endereco")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String rua;
    @Column(nullable = false)
    private String numero;
    @Column(nullable = false)
    private String bairro;
    @Column(nullable = false)
    private String cidade;
    @Column(nullable = false)
    private String estado;


    public Endereco(EnderecoResponseDto enderecoResponseDTO) {
        this.id = enderecoResponseDTO.getId();
        this.rua = enderecoResponseDTO.getRua();
        this.numero = enderecoResponseDTO.getNumero();
        this.bairro = enderecoResponseDTO.getBairro();
        this.cidade = enderecoResponseDTO.getCidade();
        this.estado = enderecoResponseDTO.getEstado();
    }
}