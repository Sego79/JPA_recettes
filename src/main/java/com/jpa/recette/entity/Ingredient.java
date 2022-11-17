package com.jpa.recette.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ingredient")
public class Ingredient {

    @Id
    @Column(name = "id_ingredient")
    private long id;

    @Column(length = 1000)
    private String nameIngredient;
    @ManyToMany()
    private List<Ingredient> recetteList = new ArrayList<>();

    //CONSTRUCTEUR
    public Ingredient() {
    }

    //GETTER AND SETTER
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameIngredient() {
        return nameIngredient;
    }

    public void setNameIngredient(String nameIngredient) {
        this.nameIngredient = nameIngredient;
    }

    public List<Ingredient> getRecetteList() {
        return recetteList;
    }

    public void setRecetteList(List<Ingredient> recetteList) {
        this.recetteList = recetteList;
    }

}
