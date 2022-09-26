package com.dh.clinicaodontologica.service.impl;

import com.dh.clinicaodontologica.dto.dentista.DentistaDTO;
import com.dh.clinicaodontologica.exception.NotFoundException;
import com.dh.clinicaodontologica.model.Dentista;
import com.dh.clinicaodontologica.repository.DentistaRepository;
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

import static com.dh.clinicaodontologica.service.impl.mocks.GeneraterMocks.newDentista;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@AutoConfigureMockMvc
@SpringBootTest
public class DentistaServiceTest {

    public static final String DENTISTA_NAO_ENCONTRADO = "Dentista não encontrado.";

    public static final Long ID = 1L;

    @Autowired
    ModelMapper mapper;

    @InjectMocks
    private DentistaService service;

    @Mock
    private DentistaRepository repository;


    private Optional<Dentista> optionalDentista;

    private void startDentist() {
        optionalDentista = Optional.of(newDentista());
    }

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startDentist();
    }

    @Test
    @DisplayName("Retorna uma instancia de Dentista ao buscar por Id")
    void whenFindByIdThenReturnAnDentistInstance() {

        when(repository.findById(anyLong())).thenReturn(optionalDentista);

        Dentista response = service.findById(newDentista().getId());

        assertNotNull(response);
        assertEquals(Dentista.class, response.getClass());
        assertEquals(1L, response.getId());
        assertEquals(newDentista().getNome(), response.getNome());
        assertEquals(newDentista().getSobrenome(), response.getSobrenome());
        assertEquals(newDentista().getCro(), response.getCro());
    }

    @Test
    @DisplayName("Retorna NotFoundException quando Id não encontrado")
    void whenFindByIdThenReturnAnObjectNotFoundException() {
        when(repository.findById(anyLong())).thenThrow(new NotFoundException(DENTISTA_NAO_ENCONTRADO));

        try {
            service.findById(ID);
        } catch (Exception ex) {
            assertEquals(NotFoundException.class, ex.getClass());
            assertEquals(DENTISTA_NAO_ENCONTRADO, ex.getMessage());
        }
    }

    @Test
    @DisplayName("Retorna uma lista de Dentistas")
    void whenFindAllThenReturnAnDentistList() {
        when(repository.findAll()).thenReturn(List.of(newDentista()));

        List<DentistaDTO> response = service.listarTodos();

        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals(DentistaDTO.class, response.get(0).getClass());
        assertEquals(ID, response.get(0).getId());
        assertEquals(newDentista().getNome(), response.get(0).getNome());
        assertEquals(newDentista().getSobrenome(), response.get(0).getSobrenome());
        assertEquals(newDentista().getCro(), response.get(0).getCro());
    }

    @Test
    @DisplayName("Retorna Sucesso ao salvar um dentista")
    void whenCreateThenReturnSuccess() {
        var request = mapper.map(newDentista(), DentistaDTO.class);
        when(repository.save(any(Dentista.class))).thenReturn(newDentista());
        var response = service.salvarDentista(request);

        assertThat(response).isNotNull();
        assertEquals(DentistaDTO.class, response.getClass());
        assertEquals(1L, response.getId());
        assertEquals(newDentista().getNome(), response.getNome());
        assertEquals(newDentista().getSobrenome(), response.getSobrenome());
        assertEquals(newDentista().getCro(), response.getCro());

        verify(repository, times(1)).save(any(Dentista.class));
    }
    @Test
    void atualizarDentista() {
    }

    @Test
    void deleteById() {
    }

}