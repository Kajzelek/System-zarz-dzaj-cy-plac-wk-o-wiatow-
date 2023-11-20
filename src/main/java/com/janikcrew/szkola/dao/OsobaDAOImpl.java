package com.janikcrew.szkola.dao;

import com.janikcrew.szkola.entity.Budzet;
import com.janikcrew.szkola.entity.Osoba;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
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
    @Transactional
    public void save(Budzet budzet) {
        entityManager.persist(budzet);
    }

    @Override
    public Osoba findOsobaById(int id) {
        return entityManager.find(Osoba.class, id);
    }
}
