package com.dh.clinicaodontologica.service.impl;

import com.dh.clinicaodontologica.dto.EnderecoDTO;
import com.dh.clinicaodontologica.model.Endereco;
import com.dh.clinicaodontologica.repository.EnderecoRepository;
import com.dh.clinicaodontologica.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnderecoService implements IService<EnderecoDTO> {
    @Autowired
    private EnderecoRepository enderecoRepository;

    @Override
    public EnderecoDTO create(EnderecoDTO enderecoDTO) {
        Endereco endereco = new Endereco(enderecoDTO);
        enderecoRepository.create(endereco);
        return enderecoDTO;
    }

    @Override
    public EnderecoDTO getById(int id) {
        return null;
    }

    @Override
    public List<EnderecoDTO> getAll() {
        List<Endereco> enderecoEntities = enderecoRepository.getaAll();
        List<EnderecoDTO> enderecoDTOS = new ArrayList<>();

        for (Endereco endereco : enderecoEntities) {
            EnderecoDTO enderecoDTO = new EnderecoDTO(endereco);
            enderecoDTOS.add(enderecoDTO);
        }

        return enderecoDTOS;
    }

    @Override
    public String delete(int id) {
        return null;
    }

    @Override
    public EnderecoDTO update(EnderecoDTO enderecoDTO, int id) {
        Endereco endereco = new Endereco(enderecoDTO);
        endereco.setId(id);
        enderecoRepository.update(endereco);
        return enderecoDTO;
    }
}
