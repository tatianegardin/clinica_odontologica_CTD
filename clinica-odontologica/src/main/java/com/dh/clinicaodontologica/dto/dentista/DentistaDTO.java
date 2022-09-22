package com.dh.clinicaodontologica.dto.dentista;

import com.dh.clinicaodontologica.model.Dentista;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DentistaDTO {
    private Long id;
    private String nome;
    private String sobrenome;
    private String cro;

    public DentistaDTO(Dentista dentista) {
        this.id = dentista.getId();
        this.nome = dentista.getNome();
        this.sobrenome = dentista.getSobrenome();
        this.cro = dentista.getCro();
    }
}
