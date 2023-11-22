package com.janikcrew.szkola.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@DiscriminatorValue("UCZEN")
public class Uczen extends Osoba {

    @Column(name="nazwa_klasy")
    private String nazwaKlasy;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_rodzica")
    private Rodzic rodzic;

    public Uczen() {

    }

    public Uczen(String pesel, String imie, String nazwisko, String email, LocalDate dataUrodzenia, String nazwaKlasy, Rodzic rodzic) {
        super(pesel, imie, nazwisko, email, dataUrodzenia);
        this.nazwaKlasy = nazwaKlasy;
        this.rodzic = rodzic;
    }

    public String getNazwaKlasy() {
        return nazwaKlasy;
    }

    public void setNazwaKlasy(String nazwaKlasy) {
        this.nazwaKlasy = nazwaKlasy;
    }

    public Rodzic getRodzic() {
        return rodzic;
    }

    public void setRodzica(Rodzic rodzic) {
        this.rodzic = rodzic;
    }

    @Override
    public String toString() {
        return "Uczen{" +
                "nazwaKlasy='" + nazwaKlasy + '\'' +
                ", rodzic=" + rodzic +
                '}';
    }
}
