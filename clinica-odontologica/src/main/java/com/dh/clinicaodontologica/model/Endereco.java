package com.dh.clinicaodontologica.model;

import com.dh.clinicaodontologica.dto.endereco.EnderecoResponseDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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

    @NotBlank(message = "O campo 'rua' precisa ser preenchido!")
    @Column(nullable = false)
    private String rua;
    @NotBlank(message = "O campo 'numero' precisa ser preenchido!")
    @Column(nullable = false)
    private String numero;
    @NotBlank(message = "O campo 'bairro' precisa ser preenchido!")
    @Column(nullable = false)
    private String bairro;
    @NotBlank(message = "O campo 'cidade' precisa ser preenchido!")
    @Column(nullable = false)
    private String cidade;
    @NotBlank(message = "O campo 'estado' precisa ser preenchido!")
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