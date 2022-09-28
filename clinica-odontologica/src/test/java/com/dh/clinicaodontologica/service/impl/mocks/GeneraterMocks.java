package com.dh.clinicaodontologica.service.impl.mocks;

import com.dh.clinicaodontologica.dto.consulta.ConsultaRequestDto;
import com.dh.clinicaodontologica.dto.consulta.ConsultaResponseDto;
import com.dh.clinicaodontologica.dto.dentista.DentistaDTO;
import com.dh.clinicaodontologica.dto.endereco.EnderecoRequestDto;
import com.dh.clinicaodontologica.dto.endereco.EnderecoResponseDto;
import com.dh.clinicaodontologica.dto.paciente.PacienteRequestDto;
import com.dh.clinicaodontologica.dto.paciente.PacienteResponseDto;
import com.dh.clinicaodontologica.model.*;

import java.time.LocalDate;
import java.time.LocalTime;

public class GeneraterMocks {

    public static Dentista newDentista() {
        return Dentista.builder()
                .id(1L)
                .nome("Daniel")
                .sobrenome("Alves")
                .cro("12345")
                .build();
    }

    public static Paciente newPaciente() {
        return Paciente.builder()
                .id(1L)
                .nome("José")
                .sobrenome("Maria")
                .rg("123")
                .endereco(newEndereco())
                .build();
    }

    public static Endereco newEndereco() {
        return Endereco.builder()
                .id(1L)
                .bairro("Bairro")
                .cidade("Cidade")
                .estado("Estado")
                .numero("Numero")
                .rua("Rua")
                .build();
    }

    public static Paciente newPacienteSemId() {
        return Paciente.builder()
                .nome("José")
                .sobrenome("Maria")
                .rg("123")
                .endereco(newEnderecoSemId())
                .build();
    }

    public static Endereco newEnderecoSemId() {
        return Endereco.builder()
                .bairro("Bairro")
                .cidade("Cidade")
                .estado("Estado")
                .numero("Numero")
                .rua("Rua")
                .build();
    }

    public static Procedimento newProcedimento() {
        return Procedimento.builder()
                .id(1L)
                .descricao("Manutenção de aparelho")
                .tipo("Ortodontia")
                .build();
    }

    public static Consulta newConsulta() {
        return Consulta.builder()
                .id(1L)
                .dentista(newDentista())
                .paciente(newPaciente())
                .hora(LocalTime.now())
                .data(LocalDate.now())
                .procedimento(newProcedimento())
                .build();
    }

    public static ConsultaRequestDto newConsultaRequestDto() {
        return ConsultaRequestDto.builder()
                .dentistaId(1L)
                .pacienteId(1L)
                .procedimentoId(1L)
                .hora(LocalTime.now())
                .data(LocalDate.now())
                .build();
    }

    public static ConsultaResponseDto newConsultaResponseDto() {
        return ConsultaResponseDto.builder()
                .dentista("Daniel Alves")
                .paciente("José Maria")
                .hora(LocalTime.now())
                .data(LocalDate.now())
                .procedimento("Manutenção de aparelho")
                .build();
    }

    public static PacienteRequestDto newPacienteRequestDto() {
        return PacienteRequestDto.builder()
                .nome("José")
                .sobrenome("Maria")
                .rg("123")
                .endereco(newEnderecoSemId())
                .build();
    }

    public static PacienteResponseDto newPacienteResponseDto() {
        return PacienteResponseDto.builder()
                .nome("José")
                .sobrenome("Maria")
                .endereco(newEndereco())
                .build();
    }

    public static DentistaDTO newDentistaDto () {
        return DentistaDTO.builder()
                .nome("Daniel")
                .sobrenome("Alves")
                .cro("123")
                .build();
    }
}
