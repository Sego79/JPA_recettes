package com.jpa.recette.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "recette")
public class Recette {

    @Id
    @Column(name = "id_recette")
    private long id;
    @Column(length = 1000)
    private String nameRecette;
    @ManyToMany(cascade = {CascadeType.PERSIST})
    @JoinTable(
            name = "recette_ingredient",
            joinColumns = @JoinColumn(name = "recette_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id")
    )
    private List<Ingredient> ingredientList = new ArrayList<>();

    //CONSTRUCTEUR
    public Recette() {
    }

    //GETTER AND SETTER
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameRecette() {
        return nameRecette;
    }

    public void setNameRecette(String nameRecette) {
        this.nameRecette = nameRecette;
    }

    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }
}
