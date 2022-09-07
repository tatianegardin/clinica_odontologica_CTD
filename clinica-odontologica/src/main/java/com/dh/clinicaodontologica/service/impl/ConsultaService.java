package com.dh.clinicaodontologica.service.impl;

import com.dh.clinicaodontologica.dto.consulta.ConsultaRequestDto;
import com.dh.clinicaodontologica.dto.consulta.ConsultaResponseDto;
import com.dh.clinicaodontologica.exception.NotFoundException;
import com.dh.clinicaodontologica.model.Consulta;
import com.dh.clinicaodontologica.repository.ConsultaRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultaService {
    @Autowired
    ConsultaRepositoy consultaRepositoy;



    //TODO precisa esperar a criação desses repository para dar continuidade
//    @Autowired
//    DentistaRepository dentistaRepository;
//    @Autowired
//    PacienteRepository pacienteRepository;
//    @Autowired
//    ProcedimentoRepository procedimentoRepository;

    public ConsultaResponseDto salvarConsulta(ConsultaRequestDto consultaRequestDto) {
        //Dentista dentista = findById(dentistaRepository.getDentistaId());
        //Pacientes paciente = findById(pacienteRepository.getPacienteId());
        //Procedimento paciente = findById(procedimentoRepository.getPacienteId());

        Consulta consulta = Consulta.builder()
//                .dentista(dentista)
//                .paciente(paciente)
//                .procedimento(procedimento)
                .data(consultaRequestDto.getData())
                .hora(consultaRequestDto.getHora())
                .build();

        return new ConsultaResponseDto(consulta);
    }

    public Consulta findById(long id){
        return consultaRepositoy.findById(id).orElseThrow(() ->
        {
            throw new NotFoundException("consulta não encontrada");
        });
    }
}
