package com.dh.clinicaodontologica.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ErrorPaciente {
    private int statusCode;
    private String message;
    private Date date;
}
