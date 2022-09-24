package com.dh.clinicaodontologica.controller;

import com.dh.clinicaodontologica.dto.endereco.EnderecoRequestDto;
import com.dh.clinicaodontologica.dto.paciente.PacienteRequestDto;
import com.dh.clinicaodontologica.dto.paciente.PacienteResponseDto;
import com.dh.clinicaodontologica.exception.ErrorPaciente;
import com.dh.clinicaodontologica.exception.NotFoundException;
import com.dh.clinicaodontologica.service.impl.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping ("/paciente")
public class PacienteController {

    @Autowired
    PacienteService pacienteService;

    @PostMapping("/cadastrar")
    public ResponseEntity<PacienteResponseDto> salvarPaciente(@RequestBody PacienteRequestDto pacienteRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteService.salvarPaciente(pacienteRequestDto));
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<PacienteResponseDto> atualizarPaciente(@RequestBody PacienteRequestDto pacienteRequestDto, @PathVariable long id) {
        PacienteResponseDto pacienteRequestDto1 = pacienteService.atualizarPaciente(pacienteRequestDto, id);
        return ResponseEntity.ok().body(pacienteRequestDto1);
    }

    @GetMapping
    public ResponseEntity<List<PacienteResponseDto>> listarTodos() {
        return ResponseEntity.ok().body(pacienteService.listarTodos());
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<PacienteResponseDto> findBy(@PathVariable long id) {
        PacienteResponseDto pacienteResponseDto = pacienteService.findBy(id);
        return ResponseEntity.ok().body(pacienteResponseDto);
    }

    @GetMapping("/deleteById")
    public ResponseEntity<String> deleteById (@RequestParam(value = "id") long id) {
        PacienteResponseDto pacienteResponseDto = pacienteService.deleteById(id);
        return new ResponseEntity<String>("Paciente deletado com sucesso!", HttpStatus.OK);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorPaciente> handlerException (NotFoundException ex) {
        ErrorPaciente errorPaciente = new ErrorPaciente(HttpStatus.NOT_FOUND.value(), ex.getMessage(), new Date());
        return new ResponseEntity<ErrorPaciente>(errorPaciente, HttpStatus.NOT_FOUND);
    }
}
