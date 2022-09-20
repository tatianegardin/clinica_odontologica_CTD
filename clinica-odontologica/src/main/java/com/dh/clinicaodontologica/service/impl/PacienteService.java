package com.dh.clinicaodontologica.service.impl;

import com.dh.clinicaodontologica.dto.endereco.EnderecoResponseDto;
import com.dh.clinicaodontologica.dto.paciente.PacienteRequestDto;
import com.dh.clinicaodontologica.dto.paciente.PacienteResponseDto;
import com.dh.clinicaodontologica.exception.NotFoundException;
import com.dh.clinicaodontologica.model.Paciente;
import com.dh.clinicaodontologica.repository.PacienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PacienteService {
    @Autowired
    PacienteRepository pacienteRepository;

    public Paciente findById(long id) {
        return pacienteRepository.findById(id).orElseThrow(() ->
        {
            throw new NotFoundException("Paciente não encontrado 😥");
        });
    }

    public PacienteResponseDto findBy(long id) {
        Paciente paciente = findById(id);
        pacienteRepository.findById(id);
        return new PacienteResponseDto(paciente);
    }

    private Paciente mapperDtoToEntity(PacienteResponseDto pacienteResponseDto) {
        ObjectMapper objectMapper = new ObjectMapper();
        Paciente paciente = objectMapper.convertValue(pacienteResponseDto, Paciente.class);

        return paciente;
    }

    private PacienteResponseDto mapperDtoToEntity(Paciente paciente) {
        ObjectMapper objectMapper = new ObjectMapper();
        PacienteResponseDto pacienteResponseDto = objectMapper.convertValue(paciente, PacienteResponseDto.class);

        return pacienteResponseDto;
    }

    public PacienteResponseDto salvarPaciente(PacienteRequestDto pacienteRequestDto) {
        Paciente paciente = Paciente.builder()
                .nome(pacienteRequestDto.getNome())
                .sobrenome(pacienteRequestDto.getSobrenome())
                .endereco(pacienteRequestDto.getEndereco())
                .build();

        pacienteRepository.saveAndFlush(paciente);

        return new PacienteResponseDto(paciente);
    }

    public PacienteResponseDto atualizarPaciente(PacienteRequestDto pacienteRequestDto, long id) {
        Paciente paciente = findById(id);
        paciente.setNome(pacienteRequestDto.getNome());
        paciente.setSobrenome(pacienteRequestDto.getSobrenome());
        paciente.setEndereco(pacienteRequestDto.getEndereco());

        pacienteRepository.save(paciente);

        return new PacienteResponseDto(paciente);
    }

    public List<PacienteResponseDto> listarTodos() {
        List<Paciente> pacienteEntities = pacienteRepository.findAll();
        List<PacienteResponseDto> pacienteDtos = new ArrayList<>();

        for (Paciente paciente : pacienteEntities) {
            PacienteResponseDto pacienteResponseDto = new PacienteResponseDto(paciente);
            pacienteDtos.add(pacienteResponseDto);
        }
        return pacienteDtos;
    }

    public PacienteResponseDto deleteById(long id) {
        Paciente paciente = findById(id);
        pacienteRepository.deleteById(paciente.getId());
        return new PacienteResponseDto(paciente);
    }

}