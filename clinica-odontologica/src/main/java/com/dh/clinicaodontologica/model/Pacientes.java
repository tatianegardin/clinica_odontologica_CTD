package com.dh.clinicaodontologica.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Pacientes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String sobrenome;

    @OneToOne(mappedBy = "paciente", cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @Column(nullable = false)
    private LocalDateTime dataAlta;

    @OneToMany(mappedBy = "dentista")
    List<Consulta> consultaList;

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
