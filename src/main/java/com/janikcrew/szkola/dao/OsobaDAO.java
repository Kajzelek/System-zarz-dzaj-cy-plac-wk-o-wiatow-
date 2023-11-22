package com.janikcrew.szkola.dao;

import com.janikcrew.szkola.entity.Budzet;
import com.janikcrew.szkola.entity.Osoba;

public interface OsobaDAO {
    void save(Osoba osoba);

    void deleteBudzetById(int id);
    Osoba findOsobaById(int id);

}
