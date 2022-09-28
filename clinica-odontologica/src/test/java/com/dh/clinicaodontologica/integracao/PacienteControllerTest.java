package com.dh.clinicaodontologica.integracao;

import static com.dh.clinicaodontologica.service.impl.mocks.GeneraterMocks.*;
import static com.dh.clinicaodontologica.service.impl.mocks.GeneraterMocks.newDentista;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.dh.clinicaodontologica.dto.paciente.PacienteRequestDto;
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
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@AutoConfigureMockMvc
@SpringBootTest
class PacienteControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private PacienteRepository repository;


    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @Test
    @WithMockUser(username = "batata", password = "batata123", roles = "ADMIN")
    void cadastrarPaciente() throws Exception {
        mockMvc.perform(post("/paciente/cadastrar")
                        .content(objectMapper.writeValueAsString(newPacienteRequestDto()))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());
    }
    @Test
    @WithMockUser(username = "batata", password = "batata123", roles = "ADMIN")
    void atualizarPaciente() throws Exception {
        repository.save(newPacienteSemId());
        mockMvc.perform(put("/paciente/atualizar/{id}", 1 )
                        .content(objectMapper.writeValueAsString(newPacienteRequestDto()))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    @WithMockUser(username = "batata", password = "batata123", roles = "ADMIN")
    void buscarPaciente() throws Exception {
        repository.save(newPacienteSemId());
        mockMvc.perform(get("/paciente/findById/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    @WithMockUser(username = "batata", password = "batata123", roles = "ADMIN")
    void deletar() throws Exception {
        repository.save(newPacienteSemId());
        mockMvc.perform(get("/paciente/deleteById")
                        .param("id", "1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());
    }
}