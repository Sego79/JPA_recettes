package com.jpa.recette.dao;


import com.jpa.recette.entity.Ingredient;

import java.util.List;
import java.util.Optional;

public class IngredientJpaCrudDao implements CrudDao<Ingredient>{
    @Override
    public List<Ingredient> findAll() {
        return null;
    }

    @Override
    public Optional<Ingredient> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public Ingredient update(Ingredient element) {
        return null;
    }

    @Override
    public Ingredient create(Ingredient element) {
        return null;
    }
}
