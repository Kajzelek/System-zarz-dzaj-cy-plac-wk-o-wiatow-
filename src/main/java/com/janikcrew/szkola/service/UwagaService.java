package com.janikcrew.szkola.service;

import com.janikcrew.szkola.entity.*;

import java.util.List;

public interface UwagaService {
    List<Uwaga> uwagiWystawione(Nauczyciel nauczyciel);
    List<Uwaga> uwagiOtrzymane(Uczen uczen);
    void utworzUwage(Uwaga uwaga, Nauczyciel wystawiajacy, Uczen otrzymujacy);
    void utworzUwage(Uwaga uwaga);
    void usunUwage(Uwaga uwaga);
}
