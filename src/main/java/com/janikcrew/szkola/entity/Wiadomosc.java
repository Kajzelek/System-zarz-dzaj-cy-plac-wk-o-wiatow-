package com.janikcrew.szkola.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "wiadomość")
public class Wiadomosc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_nadawcy")
    private Osoba nadawca;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_odbiorcy")
    private Osoba odbiorca;

    @Column(name = "tytul")
    private String tytul;

    @Column(name = "tresc")
    private String tresc;

    @Column(name = "data_wyslania")
    private LocalDate dataWyslania;

    @Column(name = "czas_wyslania")
    private LocalTime czasWyslania;

    public Wiadomosc() {
        dataWyslania = LocalDate.now();
        czasWyslania = LocalTime.now();
    }

    public Wiadomosc(Osoba nadawca, Osoba odbiorca, String tytul, String tresc) {
        this.nadawca = nadawca;
        this.odbiorca = odbiorca;
        this.tytul = tytul;
        this.tresc = tresc;
        dataWyslania = LocalDate.now();
        czasWyslania = LocalTime.now();
    }

    public Wiadomosc(String tytul, String tresc) {
        this.tytul = tytul;
        this.tresc = tresc;
        dataWyslania = LocalDate.now();
        czasWyslania = LocalTime.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Osoba getNadawca() {
        return nadawca;
    }

    public void setNadawca(Osoba nadawca) {
        this.nadawca = nadawca;
    }

    public Osoba getOdbiorca() {
        return odbiorca;
    }

    public void setOdbiorca(Osoba odbiorca) {
        this.odbiorca = odbiorca;
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

    public LocalDate getDataWyslania() {
        return dataWyslania;
    }

    public void setDataWyslania(LocalDate dataWyslania) {
        this.dataWyslania = dataWyslania;
    }

    public LocalTime getCzasWyslania() {
        return czasWyslania;
    }

    public void setCzasWyslania(LocalTime czasWyslania) {
        this.czasWyslania = czasWyslania;
    }


    @Override
    public String toString() {
        return "Wiadomosc{" +
                "id=" + id +
                ", nadawca=" + nadawca +
                ", odbiorca=" + odbiorca +
                ", tytul='" + tytul + '\'' +
                ", tresc='" + tresc + '\'' +
                '}';
    }
}
