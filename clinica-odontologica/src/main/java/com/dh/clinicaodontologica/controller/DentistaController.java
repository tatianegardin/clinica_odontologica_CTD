package com.dh.clinicaodontologica.controller;


import com.dh.clinicaodontologica.service.impl.DentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping ("/dentista")
public class DentistaController {

    @Autowired
    DentistaService dentistaService;

    @PostMapping("/cadastrar")
    public ResponseEntity<DentistaResponseDto> salvarDentista(@RequestBody DentistaRequestDto dentistaRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(dentistaService.salvardentista(dentistaRequestDto));
    }


}
