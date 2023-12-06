package com.janikcrew.szkola.service;

import com.janikcrew.szkola.dao.DyzurDAO;
import com.janikcrew.szkola.dao.OsobaDAO;
import com.janikcrew.szkola.entity.Dyzur;
import com.janikcrew.szkola.entity.Miejsce;
import com.janikcrew.szkola.entity.Nauczyciel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DyzurServiceImpl implements DyzurService {

    private final DyzurDAO dyzurDAO;

    private final OsobaDAO osobaDAO;

    @Autowired
    public DyzurServiceImpl(DyzurDAO dyzurDAO, OsobaDAO osobaDAO) {
        this.dyzurDAO = dyzurDAO;
        this.osobaDAO = osobaDAO;
    }
    @Override
    public Dyzur getDyzurById(int id) {
        return dyzurDAO.getDyzurById(id);
    }

    @Override
    public void dodajDyzurDoPlanuDyzurow(Nauczyciel nauczyciel, Miejsce miejsce, String nazwaDnia, String godzinaRozpoczecia, String dataRozpoczecia) {

    }

    @Override
    public void dodajZastepstwoDoDyzuru(int idDyzuru, int idNauczycielaZastepujacego) {
        Dyzur dyzur = dyzurDAO.getDyzurById(idDyzuru);
        Nauczyciel nauczycielZastepujacy = (Nauczyciel) osobaDAO.findOsobaById(idNauczycielaZastepujacego);
        dyzur.setNauczycielZastepujacy(nauczycielZastepujacy);
        dyzurDAO.update(dyzur);
    }
}
