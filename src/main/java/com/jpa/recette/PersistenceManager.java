package com.jpa.recette;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public final class PersistenceManager {

    private static EntityManagerFactory S_INSTANCE;

    private static EntityManager DAO_LAYER;

    private final static String persistenceUnitName = "myPU";

    //CREATION DE NOTRE CONSTRUCTEUR EN PRIVATE
    private PersistenceManager() {
    }


    //CONNEXION A LA BASE DE DONNEES
    public static EntityManager getEntityManager() {
        if(S_INSTANCE == null || !S_INSTANCE.isOpen()) {
            S_INSTANCE = Persistence.createEntityManagerFactory(persistenceUnitName);
            DAO_LAYER = S_INSTANCE.createEntityManager();
        }
        return DAO_LAYER;
    }


    //DECONNEXION DE LA BASE DE DONNEES
    public static void closeConnection() {
        try {
            S_INSTANCE.close();
        } catch (Exception e) {
            System.err.println("Fermeture de la connexion impossible");
        }
    }


}
