package com.janikcrew.szkola.dao;

import com.janikcrew.szkola.entity.Osoba;

public interface OsobaDAO {
    void save(Osoba osoba);
    Osoba findOsobaById(int id);
}
