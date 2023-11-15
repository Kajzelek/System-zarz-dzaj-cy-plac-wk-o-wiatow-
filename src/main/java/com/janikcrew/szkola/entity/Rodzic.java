package com.janikcrew.szkola.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="osoba")
public class Rodzic extends Osoba {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_dziecka")
    private Uczen dziecko;

    public Rodzic(Uczen dziecko) {
        this.dziecko = dziecko;
    }

    public Rodzic(String pesel, String imie, String nazwisko, String email, LocalDate dataUrodzenia, Uczen dziecko) {
        super(pesel, imie, nazwisko, email, dataUrodzenia);
        this.dziecko = dziecko;
    }


}
