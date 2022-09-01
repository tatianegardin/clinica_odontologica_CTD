package com.dh.clinicaodontologica.model;

import java.time.LocalDateTime;

public class Pacientes {
    private long id;
    private String nome;
    private String sobrenome;
    private Endereco endereco;
    private LocalDateTime dataAlta;

    public Pacientes(long id, String nome, String sobrenome, Endereco endereco, LocalDateTime dataAlta) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.endereco = endereco;
        this.dataAlta = dataAlta;
    }

    public long getId() {return id;}

    public void setId(long id) {this.id = id;}

    public String getNome() {return nome;}

    public void setNome(String nome) {this.nome = nome;}

    public String getSobrenome() {return sobrenome;}

    public void setSobrenome(String sobrenome) {this.sobrenome = sobrenome;}

    public Endereco getEndereco() {return endereco;}

    public void setEndereco(Endereco endereco) {this.endereco = endereco;}

    public LocalDateTime getDataAlta() {return dataAlta;}

    public void setDataAlta(LocalDateTime dataAlta) {this.dataAlta = dataAlta;}
}
