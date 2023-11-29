package com.janikcrew.szkola.service;

import com.janikcrew.szkola.dao.OsobaDAO;
import com.janikcrew.szkola.dao.WiadomoscDAO;
import com.janikcrew.szkola.entity.Osoba;
import com.janikcrew.szkola.entity.Wiadomosc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WiadomoscServiceImpl implements WiadomoscService {
    private OsobaDAO osobaDAO;
    private WiadomoscDAO wiadomoscDAO;

    @Autowired
    public WiadomoscServiceImpl(OsobaDAO osobaDAO, WiadomoscDAO wiadomoscDAO) {
        this.osobaDAO = osobaDAO;
        this. wiadomoscDAO = wiadomoscDAO;
    }

    @Override
    public List<Wiadomosc> wiadomosciOdebrane(Osoba osoba) {
        return wiadomoscDAO.findWiadomosciOdebraneById(osoba.getId());
    }

    @Override
    public List<Wiadomosc> wiadomosciWyslane(Osoba osoba) {
        return wiadomoscDAO.findWiadomosciWyslaneById(osoba.getId());
    }

    @Override
    public void utworzWiadomosc(Wiadomosc wiadomosc, Osoba nadawca, Osoba odbiorca) {
        wiadomoscDAO.save(wiadomosc);
        wiadomosc.setNadawca(nadawca);
        wiadomosc.setOdbiorca(odbiorca);
        wiadomoscDAO.update(wiadomosc);
    }

    @Override
    public void utworzWiadomosc(Wiadomosc wiadomosc) {
        wiadomoscDAO.save(wiadomosc);
    }

    @Override
    public void usunWiadomosc(Wiadomosc wiadomosc) {

    }
}
