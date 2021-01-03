package com.stdioh321.sboot.services;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GenericService<T>{



    public List<T> getAll();

    public T add(T entity);

    /*public T getById(String id);

    public T add(T entity);

    public T put(T entity);

    public T delete(T entity);*/
}
