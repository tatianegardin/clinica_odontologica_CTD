package com.dh.clinicaodontologica.controller;

import com.dh.clinicaodontologica.dto.consulta.ConsultaRequestDto;
import com.dh.clinicaodontologica.dto.consulta.ConsultaResponseDto;
import com.dh.clinicaodontologica.service.impl.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {
    @Autowired
    ConsultaService consultaService;

    @PostMapping("/cadastrar")
    public ResponseEntity<ConsultaResponseDto> cadastrarConsulta(@RequestBody ConsultaRequestDto consultaRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(consultaService.salvarConsulta(consultaRequestDto));
    }
}
