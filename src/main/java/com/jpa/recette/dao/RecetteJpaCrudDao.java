package com.jpa.recette.dao;

import com.jpa.recette.PersistenceManager;
import com.jpa.recette.entity.Recette;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RecetteJpaCrudDao implements CrudDao<Recette> {

    //va permettre de nous connecter à la BDD
    private EntityManagerFactory emf = PersistenceManager.getEntityManager().getEntityManagerFactory();

    @Override
    public List<Recette> findAll() {
        List<Recette> recetteList = new ArrayList<>();
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            TypedQuery<Recette> query = em.createQuery("SELECT r FROM Recette r", Recette.class);
            recetteList = query.getResultList();
            et.commit();
        }catch (Exception e) {
            e.printStackTrace();
            if (et.isActive()) {
                et.rollback();
            }
        }finally {
                em.close();
            }
        return recetteList;
    }

    @Override
    public Optional<Recette> findById(Long id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            Recette recette = em.createQuery("SELECT r FROM Recette r WHERE r.id = :idParam", Recette.class)
                    .setParameter("idParam", id)
                    .getSingleResult();
            et.commit();
            return Optional.of(recette);
        }catch (Exception e){
            if (et.isActive()){
                et.rollback();
            }
        }finally {
            em.close();
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try{
            et.begin();
            Recette recette = em.find(Recette.class, id);
            em.remove(recette);
            et.commit();
        }catch(Exception e){
            if(et.isActive()){
                et.rollback();
            }
        }finally {
            em.close();
        }
        return true;
    }

    @Override
    public Recette update(Recette element) {
        Recette recetteUpdated = null;
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try{
            et.begin();
            recetteUpdated = em.merge(element);
            et.commit();
        }catch(Exception e){
            if(et.isActive()){
                et.rollback();
            }
        }finally {
            em.close();
        }
        return recetteUpdated;
    }

    @Override
    public Recette create(Recette element) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try{
            et.begin();
            em.persist(element);
            et.commit();
        }catch (Exception e){
            if(et.isActive()){
                et.rollback();
            }
        }finally {
            em.close();
        }




        return null;
    }
}
