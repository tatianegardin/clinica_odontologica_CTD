package com.dh.clinicaodontologica.controller;

import dto.EnderecoDTO;
import com.dh.clinicaodontologica.service.impl.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping
    public EnderecoDTO create(@RequestBody EnderecoDTO enderecoDTO) {
        return enderecoService.create(enderecoDTO);
    }

    @GetMapping
    public List<EnderecoDTO> getAll() {
        return enderecoService.getAll();
    }

    @PutMapping("/update/{id}")
    public EnderecoDTO update(@RequestBody EnderecoDTO enderecoDTO, @PathVariable Long id) {
        return enderecoService.update(enderecoDTO, id);
    }
}
