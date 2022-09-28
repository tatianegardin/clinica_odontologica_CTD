package com.dh.clinicaodontologica.service.impl;

import com.dh.clinicaodontologica.dto.paciente.PacienteResponseDto;
import com.dh.clinicaodontologica.exception.NotFoundException;
import com.dh.clinicaodontologica.model.Paciente;
import com.dh.clinicaodontologica.repository.PacienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static com.dh.clinicaodontologica.service.impl.mocks.GeneraterMocks.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PacienteServiceTest {

    public static final Long ID = 1L;

    @Autowired
    ModelMapper mapper;

    @InjectMocks
    private PacienteService pacienteService;

    @Mock
    private PacienteRepository pacienteRepository;


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
    @DisplayName("Validando paciente cadastrado.")
    void findById_QuandoExistirPaciente() {
        var paciente = newPaciente();
        when(pacienteRepository.findById(anyLong()))
                .thenReturn(Optional.of(newPaciente()));

        var response = pacienteService.findById(1L);

        assertNotNull(response);
        assertThat(response.getId()).isEqualTo(paciente.getId());
        verify(pacienteRepository, times(1)).findById(anyLong());
    }
    @Test
    void findById_LancarExcecao_QuandoPacienteNaoExistir() {
        var paciente = newPaciente();
        when(pacienteRepository.findById(anyLong()))
                .thenReturn(Optional.empty());

        var response = assertThrows(NotFoundException.class, () -> {
            pacienteService.findById(1L);
        });

        assertThat(response.getMessage())
                .isEqualTo("Paciente não encontrado 😥");
        verify(pacienteRepository, times(1)).findById(anyLong());
    }

    @Test
    @DisplayName("Retorna uma instancia de Paciente ao buscar por Id")
    void FindByIdThenReturnAnPacientInstance() {

        when(pacienteRepository.findById(anyLong())).thenReturn(optionalPaciente);

        Paciente response = pacienteService.findById(newPaciente().getId());

        assertNotNull(response);
        assertEquals(Paciente.class, response.getClass());
        assertEquals(1L, response.getId());
        assertEquals(newPaciente().getNome(), response.getNome());
        assertEquals(newPaciente().getSobrenome(), response.getSobrenome());
    }

    @Test
    @DisplayName("Retorna Sucesso ao salvar um paciente")
    void whenCreateThenReturnSuccess() {
        when(pacienteRepository.saveAndFlush(any(Paciente.class))).thenReturn(newPaciente());
        var response = pacienteService.salvarPaciente(newPacienteRequestDto());

        assertThat(response).isNotNull();
        assertEquals(PacienteResponseDto.class, response.getClass());
        assertEquals(newPaciente().getNome(), response.getNome());
        assertEquals(newPaciente().getSobrenome(), response.getSobrenome());

        verify(pacienteRepository, times(1)).saveAndFlush(any(Paciente.class));
    }
    @Test
    void atualizarPaciente() {
        when(pacienteRepository.save(any(Paciente.class))).thenReturn(newPaciente());
        when(pacienteRepository.findById(anyLong())).thenReturn(Optional.of(newPaciente()));
        var response = pacienteService.atualizarPaciente(newPacienteRequestDto(), 1L);

        assertThat(response).isNotNull();
        assertEquals(PacienteResponseDto.class, response.getClass());
        assertEquals(newPaciente().getNome(), response.getNome());
        assertEquals(newPaciente().getSobrenome(), response.getSobrenome());

        verify(pacienteRepository, times(1)).save(any(Paciente.class));
    }

    @Test
    @DisplayName("Retorna uma lista de Pacientes")
    void whenFindAllThenReturnAnPacientList() {
        when(pacienteRepository.findAll()).thenReturn(List.of(newPaciente()));

        List<PacienteResponseDto> response = pacienteService.listarTodos();

        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals(PacienteResponseDto.class, response.get(0).getClass());
        assertEquals(ID, response.get(0).getId());
        assertEquals(newPaciente().getNome(), response.get(0).getNome());
        assertEquals(newPaciente().getSobrenome(), response.get(0).getSobrenome());
    }
    @Test
    @DisplayName("Deletar paciente com sucesso")
    void deletePacienteWithSucess() {
        when(pacienteRepository.findById(anyLong())).thenReturn(Optional.ofNullable(newPaciente()));
        doNothing().when(pacienteRepository).deleteById(anyLong());

        pacienteService.deleteById(1L);
        verify(pacienteRepository, times(1)).deleteById(anyLong());
    }
}