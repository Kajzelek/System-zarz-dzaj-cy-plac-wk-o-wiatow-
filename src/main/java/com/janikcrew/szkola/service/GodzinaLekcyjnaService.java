package com.janikcrew.szkola.service;

import com.janikcrew.szkola.entity.GodzinaLekcyjna;
import com.janikcrew.szkola.entity.Nauczyciel;
import com.janikcrew.szkola.entity.Przedmiot;
import com.janikcrew.szkola.entity.Klasa;

import java.time.LocalDate;
import java.time.LocalTime;

public interface GodzinaLekcyjnaService {
    void dodajGodzinaLekcyjnaDoPlanuLekcji(Przedmiot przedmiot, Klasa klasa, String dzien, String godzinaRozpoczecia, String dataRozpoczecia);
    void dodajZdarzenieDoGodzinyLekcyjnej(int idGodzinyLekcyjnej, String zdarzenie);
    void dodajZastepstwoDoGodzinyLekcyjnej(int idGodzinyLekcyjnej, int idNauczycielaZastepujacego);
}
