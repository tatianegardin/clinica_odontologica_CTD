package com.dh.clinicaodontologica.controller;

import com.dh.clinicaodontologica.dto.consulta.ConsultaRequestDto;
import com.dh.clinicaodontologica.dto.paciente.PacienteRequestDto;
import com.dh.clinicaodontologica.dto.paciente.PacienteResponseDto;
import com.dh.clinicaodontologica.model.Paciente;
import com.dh.clinicaodontologica.repository.PacienteRepository;
import com.dh.clinicaodontologica.service.impl.PacienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static com.dh.clinicaodontologica.service.impl.mocks.GeneraterMocks.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class PacienteControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private WebApplicationContext context;

    @MockBean
    private PacienteRepository repository;

    @MockBean
    private PacienteService service;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();
    }

    @Test
    void cadastrarPaciente() throws Exception {
        when(service.salvarPaciente(any(PacienteRequestDto.class)))
                .thenReturn(newPacienteResponseDto());

        mockMvc.perform(post("/paciente/cadastrar")
                        .content(objectMapper.writeValueAsString(newPacienteRequestDto()))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());
    }
}