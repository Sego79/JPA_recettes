package com.jpa.recette.dao;

import java.util.List;
import java.util.Optional;

public interface CrudDao<E> {

    List<E> findAll();

    Optional<E> findById(Long id);

    boolean delete(Long id);

    E update(E element);

    E create(E element);
}
