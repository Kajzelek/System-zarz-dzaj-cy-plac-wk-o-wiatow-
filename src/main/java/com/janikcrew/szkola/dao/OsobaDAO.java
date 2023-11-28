package com.janikcrew.szkola.dao;

import com.janikcrew.szkola.entity.Budzet;
import com.janikcrew.szkola.entity.Osoba;

public interface OsobaDAO {
    void save(Osoba osoba);
    void update(Osoba osoba);
    Osoba findOsobaById(int id);
    void deleteOsobaById(int id);

}
