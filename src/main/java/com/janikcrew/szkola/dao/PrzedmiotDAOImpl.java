package com.janikcrew.szkola.dao;

import com.janikcrew.szkola.entity.Nauczyciel;
import com.janikcrew.szkola.entity.Przedmiot;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class PrzedmiotDAOImpl implements PrzedmiotDAO {

    private EntityManager entityManager;

    @Autowired
    public PrzedmiotDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    public List<Przedmiot> findPrzedmiotyByNauczycielId(int id) {
        TypedQuery<Przedmiot> query = entityManager.createQuery("from Przedmiot where prowadzacy.id = :data", Przedmiot.class);
        query.setParameter("data", id);
        return query.getResultList();
    }

    @Override
    public Przedmiot findPrzedmiotById(int id) {
        return entityManager.find(Przedmiot.class, id);
    }

    @Override
    @Transactional
    public void deletePrzedmiotById(int id) {
        Przedmiot przedmiot = entityManager.find(Przedmiot.class, id);
        entityManager.remove(przedmiot);
    }

    @Override
    @Transactional
    public void save(Przedmiot przedmiot) {
        entityManager.persist(przedmiot);
    }

    @Override
    @Transactional
    public void update(Przedmiot przedmiot) {
        entityManager.merge(przedmiot);
    }
}
