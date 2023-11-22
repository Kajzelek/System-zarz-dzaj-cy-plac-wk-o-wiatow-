package com.janikcrew.szkola.service;

import com.janikcrew.szkola.entity.Budzet;
import com.janikcrew.szkola.entity.Transakcja;

public interface BudzetService {
void dodajTransakcjeDoBudzetu(Budzet budzet, Transakcja transakcja) throws Exception;
Budzet findBudzetById(int id);
}
