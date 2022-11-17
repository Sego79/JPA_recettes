package com.jpa.recette;

import com.jpa.recette.dao.CrudDao;
import com.jpa.recette.dao.RecetteJpaCrudDao;
import com.jpa.recette.entity.Ingredient;
import com.jpa.recette.entity.Recette;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        boolean recetteBoolean;
        CrudDao<Recette> recetteCrudDao = new RecetteJpaCrudDao();


        //CREATE
        String nameRecette = Util.askDataString("Quel est le nom de votre recette ?");
        Recette recette = new Recette(nameRecette);
        recetteCrudDao.create(recette);


//        recette.setIngredientList(Arrays.asList(new Ingredient("Patate")));
//        Recette createRecette =  recetteCrudDao.create(recette);

//         recetteBoolean = recetteCrudDao.delete(Long.valueOf(4));



    }
}
