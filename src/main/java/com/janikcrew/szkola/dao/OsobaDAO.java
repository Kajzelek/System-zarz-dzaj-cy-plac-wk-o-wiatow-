package com.janikcrew.szkola.dao;

import com.janikcrew.szkola.entity.Budzet;
import com.janikcrew.szkola.entity.Osoba;

public interface OsobaDAO {
    void save(Osoba osoba);
    void save(Budzet budzet);
    Osoba findOsobaById(int id);

}
