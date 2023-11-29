package com.janikcrew.szkola.service;

import com.janikcrew.szkola.entity.Osoba;
import com.janikcrew.szkola.entity.Wiadomosc;

import java.util.List;

public interface WiadomoscService {
    List<Wiadomosc> wiadomosciOdebrane(Osoba osoba);
    List<Wiadomosc> wiadomosciWyslane(Osoba osoba);
    void utworzWiadomosc(Wiadomosc wiadomosc, Osoba nadawca, Osoba odbiorca);
    void utworzWiadomosc(Wiadomosc wiadomosc);
    void usunWiadomosc(Wiadomosc wiadomosc);
}
