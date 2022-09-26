package com.dh.clinicaodontologica.dto.dentista;

import com.dh.clinicaodontologica.model.Dentista;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DentistaDTO {

    private Long id;

    @NotBlank(message = "O campo 'nome' não pode ser nulo!")
    private String nome;

    @NotBlank(message = "O campo 'sobrenome' não pode ser nulo!")
    private String sobrenome;

    @NotBlank(message = "O campo 'cro' não pode ser nulo!")
    private String cro;

    public DentistaDTO(Dentista dentista) {
        this.id = dentista.getId();
        this.nome = dentista.getNome();
        this.sobrenome = dentista.getSobrenome();
        this.cro = dentista.getCro();
    }
}
