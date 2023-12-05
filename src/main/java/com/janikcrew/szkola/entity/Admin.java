package com.janikcrew.szkola.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.*;
import java.util.Date;

@Entity
@DiscriminatorValue("ADMIN")
public class Admin extends Osoba {
    public Admin() {
    }

    public Admin(String pesel, String imie, String nazwisko, String email, LocalDate dataUrodzenia) {
        super(pesel, imie, nazwisko, email, dataUrodzenia);
    }
}
