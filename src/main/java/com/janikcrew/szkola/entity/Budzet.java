package com.janikcrew.szkola.entity;

import jakarta.persistence.*;

@Entity
@Table(name="budżet")
public class Budzet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="budżet")
    private double budzet;

    public Budzet() {
        this.budzet = 0.0;
    }

    public Budzet(double budzet) {
        this.budzet = budzet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBudzet() {
        return budzet;
    }

    public void setBudzet(double budzet) {
        this.budzet = budzet;
    }

    @Override
    public String toString() {
        return "Budzet{" +
                "id=" + id +
                ", budzet=" + budzet +
                '}';
    }
}
