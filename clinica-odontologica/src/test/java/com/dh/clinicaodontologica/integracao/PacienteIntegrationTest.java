package com.dh.clinicaodontologica.integracao;

import com.dh.clinicaodontologica.controller.PacienteController;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@WebMvcTest(PacienteController.class)
class PacienteIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void buscarTodosPacientesAPI() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/paciente")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void contextLoads() {

    }
}
