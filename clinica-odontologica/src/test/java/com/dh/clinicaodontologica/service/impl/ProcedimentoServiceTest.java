package com.dh.clinicaodontologica.service.impl;


import com.dh.clinicaodontologica.exception.NotFoundException;
import com.dh.clinicaodontologica.repository.ProcedimentoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.dh.clinicaodontologica.service.impl.mocks.GeneraterMocks.newConsulta;
import static com.dh.clinicaodontologica.service.impl.mocks.GeneraterMocks.newProcedimento;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProcedimentoServiceTest {
    @InjectMocks
    private ProcedimentoService procedimentoService;

    @Mock
    private ProcedimentoRepository procedimentoRepository;

    @Test
    void findById_QuandoExistirProcedimento() {
        when(procedimentoRepository.findById(anyLong()))
                .thenReturn(Optional.of(newProcedimento()));

        var response = procedimentoService.findById(1L);

        assertThat(response.getId()).isEqualTo(newProcedimento().getId());
        verify(procedimentoRepository, times(1)).findById(anyLong());
    }

    @Test
    void findById_LancarExcecao_QuandoProcedimentoNaoExistir() {
        when(procedimentoRepository.findById(anyLong()))
                .thenReturn(Optional.empty());

        var response = assertThrows(NotFoundException.class, () -> {
            procedimentoService.findById(1L);
        });

        assertThat(response.getMessage())
                .isEqualTo("Procedimento não encontrado!");
        verify(procedimentoRepository, times(1)).findById(anyLong());
    }
}