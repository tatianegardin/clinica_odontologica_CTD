package com.dh.clinicaodontologica.controller;


import com.dh.clinicaodontologica.dto.dentista.DentistaDTO;

import com.dh.clinicaodontologica.model.Dentista;
import com.dh.clinicaodontologica.repository.DentistaRepository;
import com.dh.clinicaodontologica.service.impl.DentistaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.istack.NotNull;
import com.sun.xml.bind.v2.model.core.ID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.persistence.Id;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static com.dh.clinicaodontologica.service.impl.mocks.GeneraterMocks.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

    @AutoConfigureMockMvc
    @SpringBootTest
    class DentistaControllerTest {
        private MockMvc mockMvc;

        @Autowired
        private ObjectMapper objectMapper;

        @Autowired
        private WebApplicationContext context;

        @MockBean
        private DentistaService service;

        @BeforeEach
        public void setup() {
            mockMvc = MockMvcBuilders
                    .webAppContextSetup(context)
                    .build();
        }

        @Test
        void cadastrarDentista() throws Exception {
            when(service.salvarDentista(any(DentistaDTO.class)))
                    .thenReturn(new DentistaDTO());

            mockMvc.perform(post("/dentista/cadastrar")
                            .content(objectMapper.writeValueAsString(newDentista()))
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().is2xxSuccessful());
        }

        @Test
        void listarAtualizarSalvarDentista() {
            DentistaRepository dentistaRepository;
            dentistaRepository = new DentistaRepository() {
                @Override
                public List<Dentista> findAll() {
                    return null;
                }

                @Override
                public List<Dentista> findAll(Sort sort) {
                    return null;
                }

                @Override
                public List<Dentista> findAllById(Iterable<Long> longs) {
                    return null;
                }

                @Override
                public <S extends Dentista> List<S> saveAll(Iterable<S> entities) {
                    return null;
                }

                @Override
                public void flush() {

                }

                @Override
                public <S extends Dentista> S saveAndFlush(S entity) {
                    return null;
                }

                @Override
                public <S extends Dentista> List<S> saveAllAndFlush(Iterable<S> entities) {
                    return null;
                }

                @Override
                public void deleteAllInBatch(Iterable<Dentista> entities) {

                }

                @Override
                public void deleteAllByIdInBatch(Iterable<Long> longs) {

                }

                @Override
                public void deleteAllInBatch() {

                }

                @Override
                public Dentista getOne(Long aLong) {
                    return null;
                }

                @Override
                public Dentista getById(Long aLong) {
                    return null;
                }

                @Override
                public Dentista getReferenceById(Long aLong) {
                    return null;
                }

                @Override
                public <S extends Dentista> List<S> findAll(Example<S> example) {
                    return null;
                }

                @Override
                public <S extends Dentista> List<S> findAll(Example<S> example, Sort sort) {
                    return null;
                }

                @Override
                public Page<Dentista> findAll(Pageable pageable) {
                    return null;
                }

                @Override
                public <S extends Dentista> S save(S entity) {
                    return null;
                }

                @Override
                public Optional<Dentista> findById(Long aLong) {
                    return Optional.empty();
                }

                @Override
                public boolean existsById(Long aLong) {
                    return false;
                }

                @Override
                public long count() {
                    return 0;
                }

                @Override
                public void deleteById(Long aLong) {

                }

                @Override
                public void delete(Dentista entity) {

                }

                @Override
                public void deleteAllById(Iterable<? extends Long> longs) {

                }

                @Override
                public void deleteAll(Iterable<? extends Dentista> entities) {

                }

                @Override
                public void deleteAll() {

                }

                @Override
                public <S extends Dentista> Optional<S> findOne(Example<S> example) {
                    return Optional.empty();
                }

                @Override
                public <S extends Dentista> Page<S> findAll(Example<S> example, Pageable pageable) {
                    return null;
                }

                @Override
                public <S extends Dentista> long count(Example<S> example) {
                    return 0;
                }

                @Override
                public <S extends Dentista> boolean exists(Example<S> example) {
                    return false;
                }

                @Override
                public <S extends Dentista, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
                    return null;
                }

                @Test
                void update_updateUserReturnsProposedDataforUpdate() {
                    DentistaRepository userRepository = new DentistaRepository() {
                        @Override
                        public List<Dentista> findAll() {
                            return null;
                        }

                        @Override
                        public List<Dentista> findAll(Sort sort) {
                            return null;
                        }

                        @Override
                        public List<Dentista> findAllById(Iterable<Long> longs) {
                            return null;
                        }

                        @Override
                        public <S extends Dentista> List<S> saveAll(Iterable<S> entities) {
                            return null;
                        }

                        @Override
                        public void flush() {

                        }

                        @Override
                        public <S extends Dentista> S saveAndFlush(S entity) {
                            return null;
                        }

                        @Override
                        public <S extends Dentista> List<S> saveAllAndFlush(Iterable<S> entities) {
                            return null;
                        }

                        @Override
                        public void deleteAllInBatch(Iterable<Dentista> entities) {

                        }

                        @Override
                        public void deleteAllByIdInBatch(Iterable<Long> longs) {

                        }

                        @Override
                        public void deleteAllInBatch() {

                        }

                        @Override
                        public Dentista getOne(Long aLong) {
                            return null;
                        }

                        @Override
                        public Dentista getById(Long aLong) {
                            return null;
                        }

                        @Override
                        public Dentista getReferenceById(Long aLong) {
                            return null;
                        }

                        @Override
                        public <S extends Dentista> List<S> findAll(Example<S> example) {
                            return null;
                        }

                        @Override
                        public <S extends Dentista> List<S> findAll(Example<S> example, Sort sort) {
                            return null;
                        }

                        @Override
                        public Page<Dentista> findAll(Pageable pageable) {
                            return null;
                        }

                        @Override
                        public <S extends Dentista> S save(S entity) {
                            return null;
                        }

                        @Override
                        public Optional<Dentista> findById(Long aLong) {
                            return Optional.empty();
                        }

                        @Override
                        public boolean existsById(Long aLong) {
                            return false;
                        }

                        @Override
                        public long count() {
                            return 0;
                        }

                        @Override
                        public void deleteById(Long aLong) {

                        }

                        @Override
                        public void delete(Dentista entity) {

                        }

                        @Override
                        public void deleteAllById(Iterable<? extends Long> longs) {

                        }

                        @Override
                        public void deleteAll(Iterable<? extends Dentista> entities) {

                        }

                        @Override
                        public void deleteAll() {

                        }

                        @Override
                        public <S extends Dentista> Optional<S> findOne(Example<S> example) {
                            return Optional.empty();
                        }

                        @Override
                        public <S extends Dentista> Page<S> findAll(Example<S> example, Pageable pageable) {
                            return null;
                        }

                        @Override
                        public <S extends Dentista> long count(Example<S> example) {
                            return 0;
                        }

                        @Override
                        public <S extends Dentista> boolean exists(Example<S> example) {
                            return false;
                        }

                        @Override
                        public <S extends Dentista, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
                            return null;
                        }
                    };
                    Dentista dentista = new Dentista();
                    dentista.setNome("Jardel");
                    dentista.setSobrenome("teste");
                    dentista.setCro("12345");
                    Assertions.assertEquals(dentista,DentistaRepository.class);
            };
        };}}


