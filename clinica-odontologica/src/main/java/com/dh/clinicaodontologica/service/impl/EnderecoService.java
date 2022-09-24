package com.dh.clinicaodontologica.service.impl;

import com.dh.clinicaodontologica.dto.endereco.EnderecoResponseDto;
import com.dh.clinicaodontologica.exception.NotFoundException;
import com.dh.clinicaodontologica.repository.EnderecoRepository;
import com.dh.clinicaodontologica.dto.endereco.EnderecoRequestDto;
import com.dh.clinicaodontologica.model.Endereco;
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
        Optional<Endereco> obj = enderecoRepository.findById(id);
        return obj.orElseThrow(() ->
        {
            throw new NotFoundException("Endereço não encontrado");
        });
    }

    public EnderecoResponseDto salvarEndereco(EnderecoRequestDto enderecoRequestDto) {

        Endereco endereco = Endereco.builder()
                .rua(enderecoRequestDto.getRua())
                .numero(enderecoRequestDto.getNumero())
                .bairro(enderecoRequestDto.getBairro())
                .cidade(enderecoRequestDto.getCidade())
                .estado(enderecoRequestDto.getEstado())
                .build();

        var enderecoResponse = new EnderecoResponseDto(enderecoRepository.save(endereco));
        return enderecoResponse;
    }

    public EnderecoResponseDto atualizarEndereco(EnderecoRequestDto enderecoRequestDto, long id) {
        Endereco endereco = findById(id);
        endereco.setRua(enderecoRequestDto.getRua());
        endereco.setNumero(enderecoRequestDto.getNumero());
        endereco.setBairro(enderecoRequestDto.getBairro());
        endereco.setCidade(enderecoRequestDto.getCidade());
        endereco.setEstado(enderecoRequestDto.getEstado());

        var enderecoResponse = new EnderecoResponseDto(enderecoRepository.save(endereco));
        return enderecoResponse;
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