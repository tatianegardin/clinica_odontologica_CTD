package com.dh.clinicaodontologica.controller;

import com.dh.clinicaodontologica.dto.endereco.EnderecoRequestDto;
import com.dh.clinicaodontologica.dto.endereco.EnderecoResponseDto;
import com.dh.clinicaodontologica.exception.ErrorEndereco;
import com.dh.clinicaodontologica.exception.NotFoundException;
import com.dh.clinicaodontologica.model.Endereco;
import com.dh.clinicaodontologica.service.impl.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/endereco")
//@RequestMapping(value = "/endereco", method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
public class EnderecoController {

    @Autowired
    EnderecoService enderecoService;

    @PostMapping("/cadastrar")
    public ResponseEntity<EnderecoResponseDto> salvarEndereco(@RequestBody EnderecoRequestDto enderecoRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoService.salvarEndereco(enderecoRequestDto));
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
    public ResponseEntity<EnderecoResponseDto> findBy(@PathVariable long id) {
        EnderecoResponseDto enderecoResponseDto = enderecoService.findBy(id);
        return ResponseEntity.ok().body(enderecoResponseDto);
    }


    @GetMapping("/deleteById")
    public ResponseEntity<String> deleteById(@RequestParam(value = "id") long id) {
        EnderecoResponseDto enderecoResponseDto = enderecoService.deleteById(id);
        return new ResponseEntity<String>("Endereço deletado com sucesso 😀!", HttpStatus.OK);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorEndereco> handleException (NotFoundException ex) {
        ErrorEndereco errorEndereco = new ErrorEndereco(HttpStatus.NOT_FOUND.value(), ex.getMessage(), new Date());
        return new ResponseEntity<ErrorEndereco>(errorEndereco, HttpStatus.NOT_FOUND);
    }


}














