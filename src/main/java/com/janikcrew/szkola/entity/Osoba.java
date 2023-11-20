package com.janikcrew.szkola.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;



@Entity(name="osoba")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="osoba_type", discriminatorType = DiscriminatorType.INTEGER)
public abstract class Osoba {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_budzetu")
    private Budzet budzet;

    @Column(name="pesel")
    private String pesel;

    @Column(name="imie")
    private String imie;

    @Column(name="nazwisko")
    private String nazwisko;

    @Column(name="email")
    private String email;

    @Column(name="data_uro")
    private LocalDate dataUrodzenia;

    @Column(name="rola")
    private String rola;

    public Osoba() {

    }

    public Osoba(String pesel, String imie, String nazwisko, String email, LocalDate dataUrodzenia) {
        this.pesel = pesel;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.email = email;
        this.dataUrodzenia = dataUrodzenia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Budzet getBudzet() {
        return budzet;
    }

    public void setBudzet(Budzet budzet) {
        this.budzet = budzet;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataUrodzenia() {
        return dataUrodzenia;
    }

    public void setDataUrodzenia(LocalDate dataUrodzenia) {
        this.dataUrodzenia = dataUrodzenia;
    }

    public String getRola() {
        return rola;
    }

    public void setRola(String rola) {
        this.rola = rola;
    }

    @Override
    public String toString() {
        return "Osoba{" +
                "id=" + id +
                ", budzetu=" + budzet +
                ", pesel=" + pesel +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", email='" + email + '\'' +
                ", dataUrodzenia=" + dataUrodzenia +
                ", rola='" + rola + '\'' +
                '}';
    }
}
