package com.dh.clinicaodontologica.service.impl;

import com.dh.clinicaodontologica.dto.endereco.EnderecoResponseDto;
import com.dh.clinicaodontologica.dto.dentista.DentistaRequestDto;
import com.dh.clinicaodontologica.dto.dentista.DentistaResponseDto;
import com.dh.clinicaodontologica.exception.NotFoundException;
import com.dh.clinicaodontologica.model.Dentista;
import com.dh.clinicaodontologica.repository.DentistaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DentistaService {
    @Autowired
    DentistaRepository dentistaRepository;

    public Dentista findById(long id) {
        return dentistaRepository.findById(id).orElseThrow(() ->
        {
            throw new NotFoundException("Dentista não encontrado 😥");
        });
    }

    public DentistaResponseDto findBy(long id) {
        Dentista dentista = findById(id);
        dentistaRepository.findById(id);
        return new DentistaResponseDto(paciente);
    }

    private Dentista mapperDtoToEntity(DentistaResponseDto dentistaResponseDto) {
        ObjectMapper objectMapper = new ObjectMapper();
        Dentista dentista = objectMapper.convertValue(dentistaResponseDto, Dentista.class);

        return dentista;
    }

    private DentistaResponseDto mapperDtoToEntity(Dentista dentista) {
        ObjectMapper objectMapper = new ObjectMapper();
        DentistaResponseDto dentistaResponseDto = objectMapper.convertValue(dentista, DentistaResponseDto.class);

        return dentistaResponseDto;
    }

    public DentistaResponseDto salvarDentista(DentistaRequestDto dentistaRequestDto) {
        Dentista dentista = Dentista.builder()
                .nome(dentistaRequestDto.getNome())
                .sobrenome(dentistaRequestDto.getSobrenome())
                .endereco(dentistaRequestDto.getEndereco())
                .build();

        dentistaRepository.saveAndFlush(dentista);

        return new DentistaResponseDto(dentista);
    }

    public DentistaResponseDto atualizarDentista(DentistaRequestDto dentistaRequestDto, long id) {
        Dentista dentista = findById(id);
        dentista.setNome(dentistaRequestDto.getNome());
        dentista.setSobrenome(dentistaRequestDto.getSobrenome());
        dentista.setEndereco(dentistaRequestDto.getEndereco());

        dentistaRepository.save(dentista);

        return new DentistaResponseDto(dentista);
    }

    public List<DentistaResponseDto> listarTodos() {
        List<Dentista> dentistaEntities = dentistaRepository.findAll();
        List<DentistaResponseDto> dentistaDtos = new ArrayList<>();

        for (Dentista dentista : dentistaEntities) {
            DentistaResponseDto dentistaResponseDto = new DentistaResponseDto(dentista);
            pacienteDtos.add(pacienteResponseDto);
        }
        return dentistaDtos;
    }

    public DentistaResponseDto deleteById(long id) {
        Dentista dentista = findById(id);
        dentistaRepository.deleteById(dentista.getId());
        return new DentistaResponseDto(dentista);
    }

}