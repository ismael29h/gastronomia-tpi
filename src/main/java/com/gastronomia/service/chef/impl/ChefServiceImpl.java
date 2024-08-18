package com.gastronomia.service.chef.impl;

import java.util.List;
import java.util.Scanner;

import com.gastronomia.domain.Chef;
import com.gastronomia.domain.Evento;
import com.gastronomia.service.chef.ChefService;

public class ChefServiceImpl implements ChefService {
    private List<Chef> chefs; // lista total de chefs
    private Scanner sc;

    public ChefServiceImpl(Scanner sc) {
        this.sc = sc;
    }

    @Override
    public void asignarChef(Evento evento) {
        // TODO Auto-generated method stub

    }

    @Override
    public Chef buscarChef() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void nuevoChef() {
        // TODO Auto-generated method stub

    }

}
