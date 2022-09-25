package com.dh.clinicaodontologica.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class HandlerException {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDetails> handlerNotFoundException(NotFoundException ex) {
        return new ResponseEntity<>(
                ExceptionDetails.builder()
                        .titulo("Não encontrado!")
                        .mensagem(ex.getMessage())
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.NOT_FOUND.value())
                        .build(),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ExceptionDetails> handlerConsultaException(BadRequestException ex) {
        return new ResponseEntity<>(
                ExceptionDetails.builder()
                        .titulo("Erro na requisição!")
                        .mensagem(ex.getMessage())
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.BAD_REQUEST.value())
                        .build(),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MyException.class)
    public ResponseEntity<ExceptionDetails> handlerEnderecoException(MyException ex) {
        return new ResponseEntity<>(
                ExceptionDetails.builder()
                        .titulo("Verifique a requisição!")
                        .mensagem(ex.getMessage())
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.BAD_REQUEST.value())
                        .build(),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionDetails> handlerEnderecoException(MethodArgumentNotValidException ex) {
        return new ResponseEntity<>(
                ExceptionDetails.builder()
                        .titulo("Verifique a requisição!")
                        .mensagem(ex.getMessage())
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.BAD_REQUEST.value())
                        .build(),
                HttpStatus.BAD_REQUEST);
    }
}
