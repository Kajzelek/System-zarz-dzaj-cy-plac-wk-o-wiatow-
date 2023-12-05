package com.janikcrew.szkola.service;

import com.janikcrew.szkola.dao.GodzinaLekcyjnaDAO;
import com.janikcrew.szkola.dao.KalendarzDAO;
import com.janikcrew.szkola.dao.OsobaDAO;
import com.janikcrew.szkola.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

@Service
public class GodzinaLekcyjnaServiceImpl implements GodzinaLekcyjnaService {

    private final GodzinaLekcyjnaDAO godzinaLekcyjnaDAO;

    private final KalendarzDAO kalendarzDAO;

    private final OsobaDAO osobaDAO;

    @Autowired
    public GodzinaLekcyjnaServiceImpl(GodzinaLekcyjnaDAO godzinaLekcyjnaDAO, KalendarzDAO kalendarzDAO, OsobaDAO osobaDAO) {
        this.godzinaLekcyjnaDAO = godzinaLekcyjnaDAO;
        this.kalendarzDAO = kalendarzDAO;
        this.osobaDAO = osobaDAO;
    }

    @Override
    public void dodajGodzinaLekcyjnaDoPlanuLekcji(Przedmiot przedmiot, Klasa klasa, String dzien, String godzRozpoczecia, String dateRozpoczecia) {

        Nauczyciel nauczyciel = przedmiot.getProwadzacy();
        DateTimeFormatter formatterGodz = DateTimeFormatter.ofPattern("HH:mm:ss");
        DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalTime godzinaRozpoczecia = LocalTime.parse(godzRozpoczecia, formatterGodz);
        LocalTime godzinaZakonczenia = godzinaRozpoczecia.plusMinutes(45);
        LocalDate dataRozpoczecia = LocalDate.parse(dateRozpoczecia, formatterData);

        ArrayList<Dzien> listaDat = (ArrayList<Dzien>) kalendarzDAO.getKalendarzByDzien(dzien);

        while (dataRozpoczecia.isAfter(listaDat.get(0).getData())) {
            listaDat.remove(0);
        }

        for (Dzien dzienKalendarzowy : listaDat) {

            System.out.println(dzienKalendarzowy.getData() + ", " + dzienKalendarzowy.getNazwaDnia());
            GodzinaLekcyjna godzinaLekcyjna = new GodzinaLekcyjna();
            godzinaLekcyjnaDAO.save(godzinaLekcyjna);
            godzinaLekcyjna.setDzien(dzienKalendarzowy);
            godzinaLekcyjna.setGodzRozpoczecia(godzinaRozpoczecia);
            godzinaLekcyjna.setGodzZakonczenia(godzinaZakonczenia);
            godzinaLekcyjna.setKlasa(klasa);
            godzinaLekcyjna.setProwadzacy(nauczyciel);
            godzinaLekcyjna.setPrzedmiot(przedmiot);
            godzinaLekcyjnaDAO.update(godzinaLekcyjna);

        }

    }

    @Override
    public void dodajZdarzenieDoGodzinyLekcyjnej(int idGodzinyLekcyjnej, String zdarzenie) {

        GodzinaLekcyjna godzinaLekcyjna = godzinaLekcyjnaDAO.getGodzinaLekcyjnaById(idGodzinyLekcyjnej);
        godzinaLekcyjna.setZdarzenie(zdarzenie);
        godzinaLekcyjnaDAO.update(godzinaLekcyjna);
    }

    @Override
    public void dodajZastepstwoDoGodzinyLekcyjnej(int idGodzinyLekcyjnej, int idNauczycielaZastepujacego) {

        GodzinaLekcyjna godzinaLekcyjna = godzinaLekcyjnaDAO.getGodzinaLekcyjnaById(idGodzinyLekcyjnej);
        Nauczyciel nauczyciel = (Nauczyciel) osobaDAO.findOsobaById(idNauczycielaZastepujacego);
        godzinaLekcyjna.setNauczycielZastepujacy(nauczyciel);
        godzinaLekcyjnaDAO.update(godzinaLekcyjna);
    }
}
