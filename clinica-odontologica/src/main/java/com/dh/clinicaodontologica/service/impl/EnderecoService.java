package com.dh.clinicaodontologica.service.impl;

import com.dh.clinicaodontologica.repository.IEnderecoRepository;
import dto.EnderecoDTO;
import com.dh.clinicaodontologica.model.Endereco;
import com.dh.clinicaodontologica.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnderecoService implements IService<EnderecoDTO> {
    @Autowired
    private IEnderecoRepository enderecoRepository;

    @Override
    public EnderecoDTO create(EnderecoDTO enderecoDTO) {
        Endereco endereco = new Endereco(enderecoDTO);
        enderecoRepository.save(endereco);
        return enderecoDTO;
    }

    @Override
    public EnderecoDTO getById(Long id) {
        return null;
    }

    @Override
    public List<EnderecoDTO> getAll() {
        List<Endereco> enderecoEntities = enderecoRepository.findAll();
        List<EnderecoDTO> enderecoDTOS = new ArrayList<>();

        for (Endereco endereco : enderecoEntities) {
            EnderecoDTO enderecoDTO = new EnderecoDTO(endereco);
            enderecoDTOS.add(enderecoDTO);
        }

        return enderecoDTOS;
    }

    @Override
    public String delete(Long id) {
        return null;
    }

    @Override
    public EnderecoDTO update(EnderecoDTO enderecoDTO, Long id) {
        Endereco endereco = new Endereco(enderecoDTO);
        endereco.setId(id);
        enderecoRepository.saveAndFlush(endereco);
        return enderecoDTO;
    }
}
