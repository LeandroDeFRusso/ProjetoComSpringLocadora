package com.example.demo.model;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class Veiculo {

    private String renavam;
    private double diaria;
    public Veiculo() {
    }

    public Veiculo(String renavam, double diaria) {
        this.renavam = renavam;
        this.diaria = diaria;
    }

    public String getRenavam() {
        return renavam;
    }

    public double getDiaria() {
        return diaria;
    }

    public void setDiaria(double diaria) {
        this.diaria = diaria;
    }
}