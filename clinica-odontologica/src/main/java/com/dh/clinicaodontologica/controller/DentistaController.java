package com.dh.clinicaodontologica.controller;

import com.dh.clinicaodontologica.dto.dentista.DentistaDTO;
import com.dh.clinicaodontologica.exception.ErrorDentista;
import com.dh.clinicaodontologica.exception.NotFoundException;
import com.dh.clinicaodontologica.model.Dentista;
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
    public ResponseEntity<DentistaDTO> salvarDentista(@RequestBody DentistaDTO dentistaDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(dentistaService.salvarDentista(dentistaDTO));
    }
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<DentistaDTO> atualizarDentista(@RequestBody Dentista dentista, @PathVariable long id) {
        DentistaDTO dentistaRequestDto1 = dentistaService.atualizarDentista(dentista, id);
        return ResponseEntity.ok().body(dentistaRequestDto1);
    }
    @GetMapping
    public ResponseEntity<List<DentistaDTO>> listarTodos() {
        return ResponseEntity.ok().body(dentistaService.listarTodos());
    }
    @GetMapping("/findById/{id}")
    public ResponseEntity<DentistaDTO> findBy(@PathVariable long id) {
        DentistaDTO DentistaDTO = dentistaService.findBy(id);
        return ResponseEntity.ok().body(DentistaDTO);
    }
    @GetMapping("/deleteById")
    public ResponseEntity<String> deleteById (@RequestParam(value = "id") long id) {
        DentistaDTO DentistaDTO = dentistaService.deleteById(id);
        return new ResponseEntity<String>("Dentista deletado com sucesso!", HttpStatus.OK);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorDentista> handlerException (NotFoundException ex) {
        ErrorDentista errorDentista = new ErrorDentista(HttpStatus.NOT_FOUND.value(), ex.getMessage(), new Date());
        return new ResponseEntity<ErrorDentista>(errorDentista, HttpStatus.NOT_FOUND);
    }

}
