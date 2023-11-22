package com.janikcrew.szkola.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@DiscriminatorValue("NAUCZYCIEL")
public class Nauczyciel extends Osoba {
    //private Klasa klasaPodOpieką

    @OneToMany(mappedBy = "prowadzacy", cascade = {CascadeType.PERSIST, CascadeType.REFRESH,
            CascadeType.DETACH, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<Przedmiot> listaPrzedmiotow;
}
