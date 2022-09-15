package com.dh.clinicaodontologica.service.impl;

import com.dh.clinicaodontologica.exception.NotFoundException;
import com.dh.clinicaodontologica.model.Dentista;
import com.dh.clinicaodontologica.repository.DentistaRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DentistaService {
    @Autowired
    DentistaRepositoy dentistaRepo;

    public Dentista findById(long id){
        return dentistaRepo.findById(id).orElseThrow(() ->{
            throw new NotFoundException("Dentista não cadastrado!");
        });
    }
}
