package com.janikcrew.szkola.dao;

import com.janikcrew.szkola.entity.Klasa;
import com.janikcrew.szkola.entity.Nauczyciel;
import com.janikcrew.szkola.entity.Przedmiot;

import java.util.List;

public interface KlasaDAO {
    Klasa findKlasaByNazwa(String nazwa);
    void save(Klasa klasa);
    void update(Klasa klasa);
    void deleteKlasaByName(String nazwa);
}
