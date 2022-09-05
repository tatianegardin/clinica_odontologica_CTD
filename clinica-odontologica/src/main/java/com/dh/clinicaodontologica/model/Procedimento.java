package com.dh.clinicaodontologica.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Procedimento {
    private long id;
    private String tipo;
    private String descricao;
}