package com.dh.clinicaodontologica.service.impl;

import com.dh.clinicaodontologica.dto.endereco.EnderecoResponseDto;
import com.dh.clinicaodontologica.exception.BadRequestException;
import com.dh.clinicaodontologica.exception.MyException;
import com.dh.clinicaodontologica.exception.NotFoundException;
import com.dh.clinicaodontologica.repository.EnderecoRepository;
import com.dh.clinicaodontologica.dto.endereco.EnderecoRequestDto;
import com.dh.clinicaodontologica.model.Endereco;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {
    @Autowired
    EnderecoRepository enderecoRepository;

    public Endereco findById(long id) {

        return enderecoRepository.findById(id).orElseThrow(() ->
        {
            throw new MyException("Endereço não encontrado");
        });
    }

    //Alternativa para não passar uma Entity pelo metodo "findById" da Controller
    public EnderecoResponseDto findBy(long id) {
        Endereco endereco = findById(id);
        enderecoRepository.findById(id);
        return new EnderecoResponseDto(endereco);
    }


    private Endereco mapperDtoToEntity(EnderecoResponseDto enderecoResponseDto) {
        ObjectMapper objectMapper = new ObjectMapper();
        Endereco endereco = objectMapper.convertValue(enderecoResponseDto, Endereco.class);

        return endereco;
    }

    private EnderecoResponseDto mapperEntityToDto(Endereco endereco) {
        ObjectMapper objectMapper = new ObjectMapper();
        EnderecoResponseDto enderecoResponseDto = objectMapper.convertValue(endereco,
                EnderecoResponseDto.class);

        return enderecoResponseDto;
    }

    public EnderecoResponseDto salvarEndereco(EnderecoRequestDto enderecoRequestDto) {

        Endereco endereco = Endereco.builder()
                .rua(enderecoRequestDto.getRua())
                .numero(enderecoRequestDto.getNumero())
                .bairro(enderecoRequestDto.getBairro())
                .cidade(enderecoRequestDto.getCidade())
                .estado(enderecoRequestDto.getEstado())
                .build();

        enderecoRepository.saveAndFlush(endereco);

        return new EnderecoResponseDto(endereco);
    }

    public EnderecoResponseDto atualizarEndereco(EnderecoRequestDto enderecoRequestDto, long id) {
        Endereco endereco = findById(id);
        endereco.setRua(enderecoRequestDto.getRua());
        endereco.setNumero(enderecoRequestDto.getNumero());
        endereco.setBairro(enderecoRequestDto.getBairro());
        endereco.setCidade(enderecoRequestDto.getCidade());
        endereco.setEstado(enderecoRequestDto.getEstado());

        enderecoRepository.save(endereco);

        return new EnderecoResponseDto(endereco);
    }


    public List<EnderecoResponseDto> listarTodos() {
        List<Endereco> enderecoEntities = enderecoRepository.findAll();
        List<EnderecoResponseDto> enderecoDtos = new ArrayList<>();

        for (Endereco endereco : enderecoEntities) {
            EnderecoResponseDto enderecoResponseDto = new EnderecoResponseDto(endereco);
            enderecoDtos.add(enderecoResponseDto);
        }

        return enderecoDtos;
    }

    public EnderecoResponseDto deleteById(long id) {
        Endereco endereco = findById(id);
        enderecoRepository.deleteById(endereco.getId());
        return new EnderecoResponseDto(endereco);
    }

}































