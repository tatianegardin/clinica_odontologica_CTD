package com.dh.clinicaodontologica.exception;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionDetails {
    private String titulo;
    private String mensagem;
    private int status;
    private LocalDateTime timestamp;
}
