package com.dh.clinicaodontologica.service;

import java.util.List;

public interface IService<T>{
    T create(T t);
    T getById(Long id);
    List<T> getAll();
    String delete(Long id);
    T update(T t, Long id);

}