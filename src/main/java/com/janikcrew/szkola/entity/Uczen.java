package com.janikcrew.szkola.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@DiscriminatorValue("UCZEN")
public class Uczen extends Osoba {

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinColumn(name="nazwa_klasy")
    private Klasa klasa;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="id_rodzica")
    private Rodzic rodzic;

    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ucznia")
    private List<Uwaga> uwagiWystawione;

    public Uczen() {

    }
    public Uczen(String pesel, String imie, String nazwisko, String email, LocalDate dataUrodzenia) {
        super(pesel, imie, nazwisko, email, dataUrodzenia);
    }
    public Uczen(String pesel, String imie, String nazwisko, String email, LocalDate dataUrodzenia, Klasa klasa) {
        super(pesel, imie, nazwisko, email, dataUrodzenia);
        this.klasa = klasa;
    }

    public Uczen(String pesel, String imie, String nazwisko, String email, LocalDate dataUrodzenia, Klasa klasa, Rodzic rodzic) {
        super(pesel, imie, nazwisko, email, dataUrodzenia);
        this.klasa = klasa;
        this.rodzic = rodzic;
    }

    public Klasa getKlasa() {
        return klasa;
    }

    public void setKlasa(Klasa klasa) {
        this.klasa = klasa;
    }

    public Rodzic getRodzic() {
        return rodzic;
    }

    public void setRodzic(Rodzic rodzic) {
        this.rodzic = rodzic;
    }

    public List<Uwaga> getUwagiWystawione() {
        return uwagiWystawione;
    }

    public void setUwagiWystawione(List<Uwaga> uwagiWystawione) {
        this.uwagiWystawione = uwagiWystawione;
    }

    @Override
    public String toString() {
        return "Uczen{" +
                "klasa='" + klasa + '\'' +
                ", rodzic=" + rodzic +
                '}';
    }
}
