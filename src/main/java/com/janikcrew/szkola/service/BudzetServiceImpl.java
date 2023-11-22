package com.janikcrew.szkola.service;

import com.janikcrew.szkola.dao.BudzetDAO;
import com.janikcrew.szkola.dao.BudzetDAOImpl;
import com.janikcrew.szkola.entity.Budzet;
import com.janikcrew.szkola.entity.Transakcja;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BudzetServiceImpl implements BudzetService {
    private BudzetDAO budzetDAO;

    @Autowired
    public BudzetServiceImpl(BudzetDAO budzetDAO) {
        this.budzetDAO = budzetDAO;
    }

    @Override
    public void dodajTransakcjeDoBudzetu(Budzet budzet, Transakcja transakcja) throws Exception {
        int id = budzet.getId();
        List<Transakcja> listaTransakcji = budzetDAO.findTransactionsByBudzetId(id);
        budzet.setListaTransakcji(listaTransakcji);
        budzet.dodajTransakcje(transakcja);
        transakcja.setBudzet(budzet);
        budzetDAO.update(budzet);
    }

    @Override
    public Budzet findBudzetById(int id) {
        return budzetDAO.findBudzetById(id);
    }
}
