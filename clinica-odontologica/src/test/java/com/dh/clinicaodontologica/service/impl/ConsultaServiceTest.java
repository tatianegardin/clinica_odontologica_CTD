package com.dh.clinicaodontologica.service.impl;

import com.dh.clinicaodontologica.exception.BadRequestException;
import com.dh.clinicaodontologica.exception.NotFoundException;
import com.dh.clinicaodontologica.model.Consulta;
import com.dh.clinicaodontologica.repository.ConsultaRepositoy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.dh.clinicaodontologica.service.impl.mocks.GeneraterMocks.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ConsultaServiceTest {
    @InjectMocks
    private ConsultaService consultaService;

    @Mock
    private ConsultaRepositoy consultaRepositoy;

    @Mock
    private DentistaService dentistaService;

    @Mock
    private PacienteService pacienteService;

    @Mock
    private ProcedimentoService procedimentoService;

    @Test
    void salvarConsulta_QuandoAConsultaForValida() {
        var request = newCosnultaRequestDto();

        when(consultaRepositoy.save(ArgumentMatchers.any(Consulta.class)))
                .thenReturn(newConsulta());
        when(dentistaService.findById(ArgumentMatchers.anyLong()))
                .thenReturn(newDentista());
        when(pacienteService.findById(ArgumentMatchers.anyLong()))
                .thenReturn(newPaciente());
        when(procedimentoService.findById(ArgumentMatchers.anyLong()))
                .thenReturn(newProcedimento());

        var response = consultaService.salvarConsulta(request);

        assertThat(response).isNotNull();
        assertThat(response.getData()).isEqualTo(request.getData());
        verify(consultaRepositoy, times(1)).save(any(Consulta.class));
    }

    @Test
    void salvarConsulta_LancarExcecao_QuandoJaExistirConsultaCadastrada() {
        var request = newCosnultaRequestDto();

        when(dentistaService.findById(ArgumentMatchers.anyLong()))
                .thenReturn(null);
        when(consultaRepositoy.findByConsultaByDentistaAndHorario(anyLong(), any(), any()))
                .thenReturn(newConsulta());

        var response = assertThrows(BadRequestException.class, () -> {
                    consultaService.salvarConsulta(request);
                });

        assertThat(response.getMessage())
                .isEqualTo("Já existe uma consulta cadastrada para esse dentista nesse horário!");
        verify(consultaRepositoy, never()).save(any(Consulta.class));
        verify(pacienteService, never()).findById(anyLong());
        verify(procedimentoService, never()).findById(anyLong());
    }
    @Test
    void findById_QuandoExistirConsulta() {
        var consulta = newConsulta();
        when(consultaRepositoy.findById(anyLong()))
                .thenReturn(Optional.of(newConsulta()));

        var response = consultaService.findById(1L);

        assertNotNull(response);
        assertThat(response.getId()).isEqualTo(consulta.getId());
        verify(consultaRepositoy, times(1)).findById(anyLong());
    }

    @Test
    void findById_LancarExcecao_QuandoAConsultaNaoExistir() {
        var consulta = newConsulta();
        when(consultaRepositoy.findById(anyLong()))
                .thenReturn(Optional.empty());

        var response = assertThrows(NotFoundException.class, () -> {
            consultaService.findById(1L);
        });

        assertThat(response.getMessage())
                .isEqualTo("Consulta não encontrada");
        verify(consultaRepositoy, times(1)).findById(anyLong());
    }
}