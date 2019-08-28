package com.example.service;

import com.example.domain.Entity;

import java.util.stream.Stream;

public interface Service<T extends Entity> {

    Stream<T> findAll();

    T find(Long id);

    void delete(Long id);

    T CreateOrUpdate(T obj);
}
