package com.janikcrew.szkola.service;

import com.janikcrew.szkola.entity.*;

public interface OsobaService {
    Osoba findOsobaById(int id);
    Nauczyciel findNauczycielByIdZPrzedmiotami(int id);
    void update(Osoba osoba);
    void dodajRodzicaUcznia(Rodzic rodzic, Uczen uczen);
    void dodajNauczyciela(Nauczyciel nauczyciel);
    void dodajUzytkownika(Osoba osoba, Budzet budzet);
    void dodajBudzetDoOsoby(Osoba osoba, Budzet budzet);
}
