package com.dh.clinicaodontologica.controller;

import com.dh.clinicaodontologica.dto.endereco.EnderecoRequestDto;
import com.dh.clinicaodontologica.dto.endereco.EnderecoResponseDto;
import com.dh.clinicaodontologica.model.Endereco;
import com.dh.clinicaodontologica.service.impl.EnderecoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
    @Autowired
    ModelMapper mapper;

    @Autowired
    EnderecoService enderecoService;

    @PostMapping("/cadastrar")
    public ResponseEntity<EnderecoResponseDto> salvarEndereco(@RequestBody EnderecoRequestDto enderecoRequestDto) {
        ResponseEntity responseEntity = null;

            var salvar = enderecoService.salvarEndereco(enderecoRequestDto);
            responseEntity = new ResponseEntity<>(salvar, HttpStatus.CREATED);

        return responseEntity;

    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<EnderecoResponseDto> atualizarEndereco(@RequestBody EnderecoRequestDto enderecoRequestDto,
                                                                 @PathVariable long id){
        EnderecoResponseDto enderecoRequestDto1 = enderecoService.atualizarEndereco(enderecoRequestDto, id);
        return ResponseEntity.ok().body(enderecoRequestDto1);
    }
    @GetMapping
    public ResponseEntity<List<EnderecoResponseDto>> listarTodos(){
        return ResponseEntity.ok().body(enderecoService.listarTodos());
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Endereco> findById(@PathVariable long id) {
        Endereco enderecoResponseDto = enderecoService.findById(id);
        return ResponseEntity.ok().body(mapper.map(enderecoResponseDto, Endereco.class));
    }

    @GetMapping("/deleteById")
    public ResponseEntity<String> deleteById(@RequestParam(value = "id") long id) {
        EnderecoResponseDto enderecoResponseDto = enderecoService.deleteById(id);
        return new ResponseEntity<String>("Endereço deletado com sucesso!", HttpStatus.OK);
    }
}














