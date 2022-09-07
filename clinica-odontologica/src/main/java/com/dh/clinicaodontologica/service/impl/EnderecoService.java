package com.dh.clinicaodontologica.service.impl;

import com.dh.clinicaodontologica.repository.IEnderecoRepository;
import com.dh.clinicaodontologica.dto.endereco.EnderecoDto;
import com.dh.clinicaodontologica.model.Endereco;
import com.dh.clinicaodontologica.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnderecoService implements IService<EnderecoDto> {
    @Autowired
    private IEnderecoRepository enderecoRepository;

    @Override
    public EnderecoDto create(EnderecoDto enderecoDTO) {
        Endereco endereco = new Endereco(enderecoDTO);
        enderecoRepository.save(endereco);
        return enderecoDTO;
    }

    @Override
    public EnderecoDto getById(Long id) {
        return null;
    }

    @Override
    public List<EnderecoDto> getAll() {
        List<Endereco> enderecoEntities = enderecoRepository.findAll();
        List<EnderecoDto> enderecoDtos = new ArrayList<>();

        for (Endereco endereco : enderecoEntities) {
            EnderecoDto enderecoDTO = new EnderecoDto(endereco);
            enderecoDtos.add(enderecoDTO);
        }

        return enderecoDtos;
    }

    @Override
    public String delete(Long id) {
        return null;
    }

    @Override
    public EnderecoDto update(EnderecoDto enderecoDTO, Long id) {
        Endereco endereco = new Endereco(enderecoDTO);
        endereco.setId(id);
        enderecoRepository.saveAndFlush(endereco);
        return enderecoDTO;
    }
}
