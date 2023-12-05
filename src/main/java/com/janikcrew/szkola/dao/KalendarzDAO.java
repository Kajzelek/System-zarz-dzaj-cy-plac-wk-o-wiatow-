package com.janikcrew.szkola.dao;

import com.janikcrew.szkola.entity.Dzien;

import java.util.List;

public interface KalendarzDAO {
    void save(Dzien dzien);
    List<Dzien> getKalendarzByDzien(String dzien);
}
