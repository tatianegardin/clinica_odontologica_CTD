package com.dh.clinicaodontologica.model;

import dto.EnderecoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name= "Endereco")
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

    public Endereco(EnderecoDTO enderecoDTO) {
        this.id = enderecoDTO.getId();
        this.rua = enderecoDTO.getRua();
        this.numero = enderecoDTO.getNumero();
        this.bairro = enderecoDTO.getBairro();
        this.cidade = enderecoDTO.getCidade();
        this.estado = enderecoDTO.getEstado();
    }
}