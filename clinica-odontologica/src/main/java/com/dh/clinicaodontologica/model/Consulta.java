package com.dh.clinicaodontologica.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Consulta {
    private Long id;
    private String sobrenome;
    private String nome;
    private Endereco endereco;
    private LocalDateTime dataAlta;

    public Consulta(Long id, String sobrenome, String nome, Endereco endereco, LocalDateTime dataAlta) {
        this.id = id;
        this.sobrenome = sobrenome;
        this.nome = nome;
        this.endereco = endereco;
        this.dataAlta = dataAlta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public LocalDateTime getDataAlta() {
        return dataAlta;
    }

    public void setDataAlta(LocalDateTime dataAlta) {
        this.dataAlta = dataAlta;
    }
}