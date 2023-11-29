package com.janikcrew.szkola.service;

import com.janikcrew.szkola.dao.OsobaDAO;
import com.janikcrew.szkola.dao.UwagaDAO;
import com.janikcrew.szkola.entity.Nauczyciel;
import com.janikcrew.szkola.entity.Uczen;
import com.janikcrew.szkola.entity.Uwaga;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UwagaServiceImpl implements UwagaService {
    private UwagaDAO uwagaDAO;
    private OsobaDAO osobaDAO;

    @Autowired
    public UwagaServiceImpl(OsobaDAO osobaDAO, UwagaDAO uwagaDAO) {
        this.osobaDAO = osobaDAO;
        this.uwagaDAO = uwagaDAO;
    }

    @Override
    public List<Uwaga> uwagiWystawione(Nauczyciel nauczyciel) {
        return uwagaDAO.findUwagiWystawioneByIdNauczyciela(nauczyciel.getId());
    }

    @Override
    public List<Uwaga> uwagiOtrzymane(Uczen uczen) {
        return uwagaDAO.findUwagiWystawioneByIdUcznia(uczen.getId());
    }

    @Override
    public void utworzUwage(Uwaga uwaga, Nauczyciel wystawiajacy, Uczen otrzymujacy) {
        uwagaDAO.save(uwaga);
        uwaga.setWystawiajacy(wystawiajacy);
        uwaga.setOtrzymujacy(otrzymujacy);
        uwagaDAO.update(uwaga);
    }

    @Override
    public void utworzUwage(Uwaga uwaga) {
        uwagaDAO.save(uwaga);
    }

    @Override
    public void usunUwage(Uwaga uwaga) {
        uwagaDAO.deleteUwagaById(uwaga.getId());
    }
}
