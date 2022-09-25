package com.dh.clinicaodontologica.service.impl;

import com.dh.clinicaodontologica.dto.paciente.PacienteRequestDto;
import com.dh.clinicaodontologica.dto.paciente.PacienteResponseDto;
import com.dh.clinicaodontologica.exception.NotFoundException;
import com.dh.clinicaodontologica.model.Paciente;
import com.dh.clinicaodontologica.repository.PacienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static com.dh.clinicaodontologica.service.impl.mocks.GeneraterMocks.newPaciente;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@AutoConfigureMockMvc
@SpringBootTest
public class PacienteServiceTest {

    public static final String PACIENTE_NAO_ENCONTRADO = "Paciente não encontrado.";

    public static final Long ID = 1L;

    @Autowired
    ModelMapper mapper;

    @InjectMocks
    private PacienteService service;

    @Mock
    private PacienteRepository repository;


    private Optional<Paciente> optionalPaciente;

    private void startPatient() {
        optionalPaciente = Optional.of(newPaciente());
    }

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startPatient();
    }

    @Test
    @DisplayName("Retorna uma instancia de Paciente ao buscar por Id")
    void whenFindByIdThenReturnAnPacientInstance() {

        when(repository.findById(anyLong())).thenReturn(optionalPaciente);

        Paciente response = service.findById(newPaciente().getId());

        assertNotNull(response);
        assertEquals(Paciente.class, response.getClass());
        assertEquals(1L, response.getId());
        assertEquals(newPaciente().getNome(), response.getNome());
        assertEquals(newPaciente().getSobrenome(), response.getSobrenome());
    }

    @Test
    @DisplayName("Retorna NotFoundException quando Id não encontrado")
    void whenFindByIdThenReturnAnObjectNotFoundException() {
        when(repository.findById(anyLong())).thenThrow(new NotFoundException(PACIENTE_NAO_ENCONTRADO));

        try {
            service.findById(ID);
        } catch (Exception ex) {
            assertEquals(NotFoundException.class, ex.getClass());
            assertEquals(PACIENTE_NAO_ENCONTRADO, ex.getMessage());
        }
    }

    @Test
    @DisplayName("Retorna uma lista de Pacientes")
    void whenFindAllThenrReturnAnPacientList() {
        when(repository.findAll()).thenReturn(List.of(newPaciente()));

        List<PacienteResponseDto> response = service.listarTodos();

        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals(PacienteResponseDto.class, response.get(0).getClass());
        assertEquals(ID, response.get(0).getId());
        assertEquals(newPaciente().getNome(), response.get(0).getNome());
        assertEquals(newPaciente().getSobrenome(), response.get(0).getSobrenome());
    }

    @Test
    @DisplayName("Retorna Sucesso ao salvar um paciente")
    void whenCreateThenReturnSuccess() {
        var request = mapper.map(newPaciente(), PacienteRequestDto.class);
        when(repository.save(any(Paciente.class))).thenReturn(newPaciente());
        var response = service.salvarPaciente(request);

        assertThat(response).isNotNull();
        assertEquals(PacienteResponseDto.class, response.getClass());
        assertEquals(1L, response.getId());
        assertEquals(newPaciente().getNome(), response.getNome());
        assertEquals(newPaciente().getSobrenome(), response.getSobrenome());

        verify(repository, times(1)).save(any(Paciente.class));
    }
    @Test
    void atualizarPaciente() {
    }

    @Test
    void deleteById() {
    }

}