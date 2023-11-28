package com.janikcrew.szkola.dao;

import com.janikcrew.szkola.entity.Klasa;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class KlasaDAOImpl implements KlasaDAO {

    private EntityManager entityManager;

    @Autowired
    public KlasaDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Klasa findKlasaByNazwa(String nazwa) {
        return entityManager.find(Klasa.class, nazwa);
    }
    @Override
    @Transactional
    public void save(Klasa klasa) {
        entityManager.persist(klasa);
    }

    @Override
    @Transactional
    public void update(Klasa klasa) {
        entityManager.merge(klasa);
    }

    @Override
    @Transactional
    public void deleteKlasaByName(String nazwa) {
        Klasa klasa = entityManager.find(Klasa.class, nazwa);
        entityManager.remove(klasa);
    }

}
