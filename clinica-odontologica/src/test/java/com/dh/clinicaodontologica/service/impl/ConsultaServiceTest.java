package com.dh.clinicaodontologica.service.impl;

import com.dh.clinicaodontologica.exception.NotFoundException;
import com.dh.clinicaodontologica.model.Consulta;
import com.dh.clinicaodontologica.repository.ConsultaRepositoy;
import com.dh.clinicaodontologica.repository.DentistaRepositoy;
import com.dh.clinicaodontologica.repository.PacienteRepository;
import com.dh.clinicaodontologica.repository.ProcedimentoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.dh.clinicaodontologica.service.impl.mocks.TestsMocks.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ConsultaServiceTest {
    @InjectMocks
    private ConsultaService consultaService;

    @Mock
    private ConsultaRepositoy consultaRepositoy;

    @Mock
    private DentistaRepositoy dentistaRepositoy;

    @Mock
    private PacienteRepository pacienteRepository;

    @Mock
    private ProcedimentoRepository procedimentoRepository;

    @Test
    void salvarConsulta() {
        var request = newCosnultaRequestDto();

        when(consultaRepositoy.save(ArgumentMatchers.any(Consulta.class)))
                .thenReturn(newConsulta());
        when(dentistaRepositoy.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(newDentista()));
        when(pacienteRepository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(newPaciente()));
        when(procedimentoRepository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(newProcedimento()));

        var response = consultaService.salvarConsulta(request);

        assertThat(response).isNotNull();
        assertThat(response.getData()).isEqualTo(request.getData());
        verify(consultaRepositoy, times(1)).save(any(Consulta.class));
    }

    @Test
    void findById() {

    }
}