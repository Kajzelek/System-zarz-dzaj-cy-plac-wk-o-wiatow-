package com.janikcrew.szkola.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@DiscriminatorValue("NAUCZYCIEL")
public class Nauczyciel extends Osoba {

    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,
                                                    CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name="nazwa_klasy_pod_opieka")
    private Klasa klasaPodOpieka;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH,
            CascadeType.DETACH, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinColumn(name="id_nauczyciela")
    private List<Przedmiot> listaPrzedmiotow;

    public Nauczyciel() {

    }
    public Nauczyciel(String pesel, String imie, String nazwisko, String email, LocalDate dataUrodzenia, Klasa klasaPodOpieką, List<Przedmiot> listaPrzedmiotow) {
        super(pesel, imie, nazwisko, email, dataUrodzenia);
        this.klasaPodOpieka = klasaPodOpieką;
        this.listaPrzedmiotow = listaPrzedmiotow;
    }

    public Nauczyciel(String pesel, String imie, String nazwisko, String email, LocalDate dataUrodzenia, List<Przedmiot> listaPrzedmiotow) {
        super(pesel, imie, nazwisko, email, dataUrodzenia);
        this.listaPrzedmiotow = listaPrzedmiotow;
    }
    public Nauczyciel(String pesel, String imie, String nazwisko, String email, LocalDate dataUrodzenia) {
        super(pesel, imie, nazwisko, email, dataUrodzenia);
    }
    public void addPrzedmiot(Przedmiot przedmiot) {
        listaPrzedmiotow.add(przedmiot);
    }
    public Klasa getKlasaPodOpieka() {
        return klasaPodOpieka;
    }

    public void setKlasaPodOpieka(Klasa klasaPodOpieką) {
        this.klasaPodOpieka = klasaPodOpieką;
    }

    public List<Przedmiot> getListaPrzedmiotow() {
        return listaPrzedmiotow;
    }

    public void setListaPrzedmiotow(List<Przedmiot> listaPrzedmiotow) {
        this.listaPrzedmiotow = listaPrzedmiotow;
    }

   /* @Override
    public String toString() {
        return "Nauczyciel{" +
                "klasaPodOpieką=" + klasaPodOpieka +
                ", listaPrzedmiotow=" + listaPrzedmiotow +
                '}';
    }

    */
}
