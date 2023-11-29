package com.janikcrew.szkola.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "uwaga")
public class Uwaga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_nauczyciela")
    private Nauczyciel wystawiajacy;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_ucznia")
    private Uczen otrzymujacy;

    @Column(name = "rodzaj")
    private String rodzaj;

    @Column(name = "tytul")
    private String tytul;

    @Column(name = "treść")
    private String tresc;

    @Column(name = "data")
    private LocalDate dataWystawienia;

    @Column(name = "czas")
    private LocalTime czasWystawienia;

    public Uwaga() {
        dataWystawienia = LocalDate.now();
        czasWystawienia = LocalTime.now();
    }

    public Uwaga(String rodzaj, String tytul, String tresc) {
        this.rodzaj = rodzaj;
        this.tytul = tytul;
        this.tresc = tresc;
        dataWystawienia = LocalDate.now();
        czasWystawienia = LocalTime.now();
    }

    public Uwaga(Nauczyciel wystawiajacy, Uczen otrzymujacy, String rodzaj, String tytul, String tresc) {
        this.wystawiajacy = wystawiajacy;
        this.otrzymujacy = otrzymujacy;
        this.rodzaj = rodzaj;
        this.tytul = tytul;
        this.tresc = tresc;
        dataWystawienia = LocalDate.now();
        czasWystawienia = LocalTime.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Nauczyciel getWystawiajacy() {
        return wystawiajacy;
    }

    public void setWystawiajacy(Nauczyciel wystawiajacy) {
        this.wystawiajacy = wystawiajacy;
    }

    public Uczen getOtrzymujacy() {
        return otrzymujacy;
    }

    public void setOtrzymujacy(Uczen otrzymujacy) {
        this.otrzymujacy = otrzymujacy;
    }

    public String getRodzaj() {
        return rodzaj;
    }

    public void setRodzaj(String rodzaj) {
        this.rodzaj = rodzaj;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public String getTresc() {
        return tresc;
    }

    public void setTresc(String tresc) {
        this.tresc = tresc;
    }

    public LocalDate getDataWystawienia() {
        return dataWystawienia;
    }

    public void setDataWystawienia(LocalDate dataWystawienia) {
        this.dataWystawienia = dataWystawienia;
    }

    public LocalTime getCzasWystawienia() {
        return czasWystawienia;
    }

    public void setCzasWystawienia(LocalTime czasWystawienia) {
        this.czasWystawienia = czasWystawienia;
    }

    @Override
    public String toString() {
        return "Uwaga{" +
                "id=" + id +
                ", wystawiajacy=" + wystawiajacy +
                ", otrzymujacy=" + otrzymujacy +
                ", rodzaj='" + rodzaj + '\'' +
                ", tytul='" + tytul + '\'' +
                ", tresc='" + tresc + '\'' +
                ", dataWystawienia=" + dataWystawienia +
                ", czasWystawienia=" + czasWystawienia +
                '}';
    }
}
