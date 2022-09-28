package com.dh.clinicaodontologica.integracao;

import static com.dh.clinicaodontologica.service.impl.mocks.GeneraterMocks.newDentista;
import static com.dh.clinicaodontologica.service.impl.mocks.GeneraterMocks.newDentistaDto;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.dh.clinicaodontologica.service.impl.DentistaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@AutoConfigureMockMvc
@SpringBootTest
class DentistaControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private WebApplicationContext context;


    @Autowired
    private DentistaService service;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @Test
    @WithMockUser(username = "batata", password = "batata123", roles = "ADMIN")
    void cadastrarDentista() throws Exception {
        mockMvc.perform(post("/dentista/cadastrar")
                        .content(objectMapper.writeValueAsString(newDentistaDto()))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    @WithMockUser(username = "batata", password = "batata123", roles = "ADMIN")
    void atualizarDentista() throws Exception {
        service.salvarDentista(newDentistaDto());
        mockMvc.perform(put("/dentista/atualizar/{id}", 1 )
                        .content(objectMapper.writeValueAsString(newDentista()))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    @WithMockUser(username = "batata", password = "batata123", roles = "ADMIN")
    void buscarDentista() throws Exception {
        service.salvarDentista(newDentistaDto());
        mockMvc.perform(get("/dentista/findById/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    @WithMockUser(username = "batata", password = "batata123", roles = "ADMIN")
    void deletar() throws Exception {
        service.salvarDentista(newDentistaDto());
        mockMvc.perform(get("/dentista/deleteById")
                        .param("id", "1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());
    }
}