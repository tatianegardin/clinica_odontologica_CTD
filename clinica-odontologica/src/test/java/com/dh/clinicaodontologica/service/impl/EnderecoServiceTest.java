package com.dh.clinicaodontologica.service.impl;

import com.dh.clinicaodontologica.dto.endereco.EnderecoRequestDto;
import com.dh.clinicaodontologica.dto.endereco.EnderecoResponseDto;
import com.dh.clinicaodontologica.exception.NotFoundException;
import com.dh.clinicaodontologica.model.Endereco;
import com.dh.clinicaodontologica.repository.EnderecoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static com.dh.clinicaodontologica.service.impl.mocks.GeneraterMocks.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@AutoConfigureMockMvc
@SpringBootTest
public class EnderecoServiceTest {

    public static final String ENDERECO_NAO_ENCONTRADO = "Endereço não encontrado";
    public static final Long ID = 1L;
    @Autowired
    ModelMapper mapper;
    @InjectMocks
    private EnderecoService service;
    @Mock
    private EnderecoRepository repository;
    private Optional<Endereco> optionalEndereco;

    private void startAddress() {
        optionalEndereco = Optional.of(newEndereco());
    }

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startAddress();
    }

    @Test
    @DisplayName("Retorna uma instancia de Endereco ao buscar por Id")
    void whenFindByIdThenReturnAnAddressInstance() {

        when(repository.findById(anyLong())).thenReturn(optionalEndereco);

        Endereco response = service.findById(newEndereco().getId());

        assertNotNull(response);
        assertEquals(Endereco.class, response.getClass());
        assertEquals(1L, response.getId());
        assertEquals(newEndereco().getRua(), response.getRua());
        assertEquals(newEndereco().getNumero(), response.getNumero());
        assertEquals(newEndereco().getBairro(), response.getBairro());
        assertEquals(newEndereco().getCidade(), response.getCidade());
        assertEquals(newEndereco().getEstado(), response.getEstado());
    }

    @Test
    @DisplayName("Retorna NotFoundException quando Id não encontrado")
    void whenFindByIdThenReturnAnObjectNotFoundException() {
        when(repository.findById(anyLong())).thenThrow(new NotFoundException(ENDERECO_NAO_ENCONTRADO));

        try {
            service.findById(ID);
        } catch (Exception ex) {
            assertEquals(NotFoundException.class, ex.getClass());
            assertEquals(ENDERECO_NAO_ENCONTRADO, ex.getMessage());

        }
    }

    @Test
    @DisplayName("Retorna uma lista de Endereços")
    void whenFindAllThenrReturnAnAddressList() {
        when(repository.findAll()).thenReturn(List.of(newEndereco()));

        List<EnderecoResponseDto> response = service.listarTodos();

        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals(EnderecoResponseDto.class, response.get(0).getClass());
        assertEquals(ID, response.get(0).getId());
        assertEquals(newEndereco().getRua(), response.get(0).getRua());
        assertEquals(newEndereco().getNumero(), response.get(0).getNumero());
        assertEquals(newEndereco().getBairro(), response.get(0).getBairro());
        assertEquals(newEndereco().getCidade(), response.get(0).getCidade());
        assertEquals(newEndereco().getEstado(), response.get(0).getEstado());
    }

    @Test
    @DisplayName("Retorna Sucesso ao salvar um endereço")
    void whenCreateThenReturnSuccess() {
        var request = mapper.map(newEndereco(), EnderecoRequestDto.class);
        when(repository.save(any(Endereco.class))).thenReturn(newEndereco());
        var response = service.salvarEndereco(request);

        assertThat(response).isNotNull();
        assertEquals(EnderecoResponseDto.class, response.getClass());
        assertEquals(1L, response.getId());
        assertEquals(request.getRua(), response.getRua());
        assertEquals(request.getNumero(), response.getNumero());
        assertEquals(request.getBairro(), response.getBairro());
        assertEquals(request.getCidade(), response.getCidade());
        assertEquals(request.getEstado(), response.getEstado());

        verify(repository, times(1)).save(any(Endereco.class));
    }

    @Test
    void atualizarEndereco() {
    }

    @Test
    void deleteById() {
    }
}

























