package com.dh.clinicaodontologica.service.impl;

import com.dh.clinicaodontologica.dto.consulta.ConsultaRequestDto;
import com.dh.clinicaodontologica.dto.consulta.ConsultaResponseDto;
import com.dh.clinicaodontologica.exception.BadRequestException;
import com.dh.clinicaodontologica.exception.NotFoundException;
import com.dh.clinicaodontologica.model.Consulta;
import com.dh.clinicaodontologica.model.Dentista;
import com.dh.clinicaodontologica.model.Paciente;
import com.dh.clinicaodontologica.model.Procedimento;
import com.dh.clinicaodontologica.repository.ConsultaRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ConsultaService {
    @Autowired
    ConsultaRepositoy consultaRepositoy;

    @Autowired
    DentistaService dentistaService;

    @Autowired
    PacienteService pacienteService;

    @Autowired
    ProcedimentoService procedimentoService;

    public ConsultaResponseDto salvarConsulta(ConsultaRequestDto consultaRequestDto) {

        Dentista dentista = verificaDisponibilidadeDentista(consultaRequestDto);
        Paciente paciente = pacienteService.findById(consultaRequestDto.getPacienteId());
        Procedimento procedimento = procedimentoService.findById(consultaRequestDto.getProcedimentoId());

        Consulta consulta = Consulta.builder()
                .dentista(dentista)
                .paciente(paciente)
                .procedimento(procedimento)
                .data(consultaRequestDto.getData())
                .hora(consultaRequestDto.getHora())
                .build();
        var consultaResponse = new ConsultaResponseDto(consultaRepositoy.save(consulta));
        return consultaResponse;
    }

    private Dentista verificaDisponibilidadeDentista (ConsultaRequestDto consultaRequestDto) {
        Dentista dentista = dentistaService.findById(consultaRequestDto.getDentistaId());
        Consulta consulta = consultaRepositoy.findByConsultaByDentistaAndHorario
                (consultaRequestDto.getDentistaId(),
                        consultaRequestDto.getData(),
                        consultaRequestDto.getHora());
        if(Objects.nonNull(consulta)) {
            throw new BadRequestException("Já existe uma consulta cadastrada para esse dentista nesse horário!");
        }
        return dentista;
    }

    public Consulta findById(long id){
        return consultaRepositoy.findById(id).orElseThrow(() ->
        {
            throw new NotFoundException("Consulta não encontrada");
        });
    }
}
