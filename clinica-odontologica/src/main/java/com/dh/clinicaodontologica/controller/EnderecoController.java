package com.dh.clinicaodontologica.controller;

import com.dh.clinicaodontologica.dto.endereco.EnderecoDto;
import com.dh.clinicaodontologica.service.impl.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    EnderecoService enderecoService;

    @PostMapping("/cadastrar")
    public EnderecoDto create(@RequestBody EnderecoDto enderecoDTO) {
        return enderecoService.create(enderecoDTO);
    }

    @GetMapping
    public List<EnderecoDto> getAll() {
        return enderecoService.getAll();
    }

    @PutMapping("/atualizar/{id}")
    public EnderecoDto update(@RequestBody EnderecoDto enderecoDTO, @PathVariable Long id) {
        return enderecoService.update(enderecoDTO, id);
    }
}
