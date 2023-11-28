package com.janikcrew.szkola.service;

import com.janikcrew.szkola.entity.Klasa;
import com.janikcrew.szkola.entity.Nauczyciel;
import com.janikcrew.szkola.entity.Przedmiot;

public interface PrzedmiotService {
    void dodajPrzedmiot(Przedmiot przedmiot, Nauczyciel prowadzacy, Klasa klasa);
    void deletePrzedmiotById(int id);
}
