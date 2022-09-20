package com.dh.clinicaodontologica.controller;

import com.dh.clinicaodontologica.dto.dentista.DentistaRequestDto;
import com.dh.clinicaodontologica.dto.dentista.DentistaResponseDto;
import com.dh.clinicaodontologica.exception.ErrorDentista;
import com.dh.clinicaodontologica.exception.NotFoundException;
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
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<DentistaResponseDto> atualizarDentista(@RequestBody DentistaRequestDto dentistaRequestDto, @PathVariable long id) {
        DentistaResponseDto dentistaRequestDto1 = dentistaService.atualizarDentista(dentistaRequestDto, id);
        return ResponseEntity.ok().body(dentistaRequestDto1);
    }
    @GetMapping
    public ResponseEntity<List<DentistaResponseDto>> listarTodos() {
        return ResponseEntity.ok().body(dentistaService.listarTodos());
    }
    @GetMapping("/findById/{id}")
    public ResponseEntity<DentistaResponseDto> findBy(@PathVariable long id) {
        DentistaResponseDto dentistaResponseDto = dentistaService.findBy(id);
        return ResponseEntity.ok().body(dentistaResponseDto);
    }
    @GetMapping("/deleteById")
    public ResponseEntity<String> deleteById (@RequestParam(value = "id") long id) {
        DentistaResponseDto dentistaResponseDto = dentistaService.deleteById(id);
        return new ResponseEntity<String>("Dentista deletado com sucesso!", HttpStatus.OK);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorDentista> handlerException (NotFoundException ex) {
        ErrorDentista errorDentista = new ErrorDentista(HttpStatus.NOT_FOUND.value(), ex.getMessage(), new Date());
        return new ResponseEntity<ErrorDentista>(errorDentista, HttpStatus.NOT_FOUND);
    }

}
