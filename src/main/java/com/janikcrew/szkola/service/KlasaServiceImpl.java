package com.janikcrew.szkola.service;

import com.janikcrew.szkola.dao.KlasaDAO;
import com.janikcrew.szkola.dao.OsobaDAO;
import com.janikcrew.szkola.entity.Klasa;
import com.janikcrew.szkola.entity.Nauczyciel;
import com.janikcrew.szkola.entity.Uczen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KlasaServiceImpl implements KlasaService {

    private KlasaDAO klasaDAO;
    private OsobaDAO osobaDAO;

    @Autowired
    public KlasaServiceImpl(KlasaDAO klasaDAO, OsobaDAO osobaDAO) {
        this.klasaDAO = klasaDAO;
        this.osobaDAO = osobaDAO;
    }
    @Override
    public void dodajKlase(Klasa klasa, Nauczyciel nauczyciel) {
        klasaDAO.save(klasa);
        nauczyciel.setKlasaPodOpieka(klasa);
        klasa.setWychowawca(nauczyciel);
        klasaDAO.update(klasa);
        osobaDAO.update(nauczyciel);
    }

    @Override
    public void dodajUcznia(Klasa klasa, Uczen ... listaUczniow) {
        for (Uczen uczen : listaUczniow) {
            klasa.dodajUcznia(uczen);
            uczen.setKlasa(klasa);
            osobaDAO.update(uczen);
            klasaDAO.update(klasa);
        }

    }

    @Override
    public Klasa findKlasaByName(String name) {
        return klasaDAO.findKlasaByNazwa(name);
    }

    @Override
    public void delete(Klasa klasa) {
        Nauczyciel nauczyciel = klasa.getWychowawca();
        nauczyciel.setKlasaPodOpieka(null);
        klasa.setWychowawca(null);
        String nazwa = klasa.getNazwa();
        klasaDAO.update(klasa);
        osobaDAO.update(nauczyciel);
        klasaDAO.deleteKlasaByName(nazwa);
    }
}
