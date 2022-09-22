package com.dh.clinicaodontologica.service.impl;

import com.dh.clinicaodontologica.dto.dentista.DentistaDTO;

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

    public DentistaDTO findBy(long id) {
        Dentista dentista = findById(id);
        dentistaRepository.findById(id);
        return new DentistaDTO(dentista);
    }

    private Dentista mapperDtoToEntity(DentistaDTO dentistaResponseDto) {
        ObjectMapper objectMapper = new ObjectMapper();
        Dentista dentista = objectMapper.convertValue(dentistaResponseDto, Dentista.class);

        return dentista;
    }

    private DentistaDTO mapperDtoToEntity(Dentista dentista) {
        ObjectMapper objectMapper = new ObjectMapper();
        DentistaDTO dentistaResponseDto = objectMapper.convertValue(dentista, DentistaDTO.class);

        return dentistaResponseDto;
    }

     public DentistaDTO atualizarDentista(Dentista dentistaRequest, long id) {
        findById(id);

        dentistaRepository.save(dentistaRequest);

        return new DentistaDTO(dentistaRequest);
    }

    public DentistaDTO salvarDentista(DentistaDTO dentistaRequestDto) {
        Dentista dentista = Dentista.builder()
                .nome(dentistaRequestDto.getNome())
                .sobrenome(dentistaRequestDto.getSobrenome())
                .cro(dentistaRequestDto.getCro())
                .build();

        dentistaRepository.saveAndFlush(dentista);

        return new DentistaDTO(dentista);
    }

    public List<DentistaDTO> listarTodos() {
        List<Dentista> dentistaEntities = dentistaRepository.findAll();
        List<DentistaDTO> dentistaDtos = new ArrayList<>();

        for (Dentista dentista : dentistaEntities) {
            DentistaDTO dentistaResponseDto = new DentistaDTO(dentista);
            dentistaDtos.add(dentistaResponseDto);
        }
        return dentistaDtos;
    }

    public DentistaDTO deleteById(long id) {
        Dentista dentista = findById(id);
        dentistaRepository.deleteById(dentista.getId());
        return new DentistaDTO(dentista);
    }

}