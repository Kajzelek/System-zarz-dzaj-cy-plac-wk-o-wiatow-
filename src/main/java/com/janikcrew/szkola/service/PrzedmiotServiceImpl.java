package com.janikcrew.szkola.service;

import com.janikcrew.szkola.dao.KlasaDAO;
import com.janikcrew.szkola.dao.OsobaDAO;
import com.janikcrew.szkola.dao.PrzedmiotDAO;
import com.janikcrew.szkola.dao.PrzedmiotDAOImpl;
import com.janikcrew.szkola.entity.Klasa;
import com.janikcrew.szkola.entity.Nauczyciel;
import com.janikcrew.szkola.entity.Przedmiot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PrzedmiotServiceImpl implements PrzedmiotService {
    private PrzedmiotDAO przedmiotDAO;
    private OsobaDAO osobaDAO;
    private KlasaDAO klasaDAO;

    @Autowired
    public PrzedmiotServiceImpl(PrzedmiotDAO przedmiotDAO, OsobaDAO osobaDAO, KlasaDAO klasaDAO) {
        this.przedmiotDAO = przedmiotDAO;
        this.osobaDAO = osobaDAO;
        this.klasaDAO = klasaDAO;
    }

    @Override
    public void dodajPrzedmiot(Przedmiot przedmiot, Nauczyciel prowadzacy, Klasa klasa) {
        // jezeli prowadzący jest wychowawcą klasy to nie da się powiązać klasy do przedmiotu
        /*
        if (klasa.getWychowawca() == prowadzacy) {
            przedmiotDAO.save(przedmiot);
            przedmiot.setProwadzacy(prowadzacy);
            przedmiot.setKlasa(klasa);
            przedmiotDAO.update(przedmiot);
        }
        else {
            przedmiotDAO.save(przedmiot);
            przedmiot.setProwadzacy(prowadzacy);
            przedmiot.setKlasa(klasa);
            przedmiotDAO.update(przedmiot);
        }
        */
        przedmiotDAO.save(przedmiot);
        przedmiot.setProwadzacy(prowadzacy);
        przedmiot.setKlasa(klasa);
        przedmiotDAO.update(przedmiot);

    }

    @Override
    public void deletePrzedmiotById(int id) {
        Przedmiot przedmiot = przedmiotDAO.findPrzedmiotById(id);
        przedmiot.setProwadzacy(null);
        przedmiot.setKlasa(null);
        przedmiotDAO.update(przedmiot);
        przedmiotDAO.deletePrzedmiotById(id);
    }
}
