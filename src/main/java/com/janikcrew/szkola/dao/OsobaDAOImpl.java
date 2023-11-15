package com.janikcrew.szkola.dao;

import com.janikcrew.szkola.entity.Osoba;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class OsobaDAOImpl implements OsobaDAO {

    private EntityManager entityManager;

    @Autowired
    public OsobaDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    @Transactional
    public void save(Osoba osoba) {
        entityManager.persist(osoba);
    }

    @Override
    public Osoba findOsobaById(int id) {
        return entityManager.find(Osoba.class, id);
    }
}
