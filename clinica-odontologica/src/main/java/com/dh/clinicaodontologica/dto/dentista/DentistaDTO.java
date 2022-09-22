package com.dh.clinicaodontologica.dto.dentista;

import com.dh.clinicaodontologica.model.Dentista;
import lombok.Data;

@Data
public class DentistaDTO {
    private Long id;
    private String nome;
    private String sobrenome;
    private String cro;

    public DentistaDTO(Dentista dentista) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cro = cro;
    }
}
