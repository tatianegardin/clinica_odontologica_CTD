package com.dh.clinicaodontologica.service.impl;

import com.dh.clinicaodontologica.exception.NotFoundException;
import com.dh.clinicaodontologica.model.Procedimento;
import com.dh.clinicaodontologica.repository.ProcedimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProcedimentoService {
    @Autowired
    ProcedimentoRepository procedimentoRepo;

    public Procedimento findById(long id) {
        return procedimentoRepo.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Procedimento não encontrado!");
        });
    }
}
