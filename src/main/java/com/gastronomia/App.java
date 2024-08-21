package com.gastronomia;

import java.util.Scanner;

import com.gastronomia.service.chef.ChefService;
import com.gastronomia.service.chef.impl.ChefServiceImpl;
import com.gastronomia.service.evento.EventoService;
import com.gastronomia.service.evento.impl.EventoServiceImpl;
import com.gastronomia.service.menu.MenuService;
import com.gastronomia.service.menu.impl.MenuServiceImpl;
import com.gastronomia.service.participante.ParticipanteService;
import com.gastronomia.service.participante.impl.ParticipanteServiceImpl;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ChefService chefService = new ChefServiceImpl(sc);
        EventoService eventoService = new EventoServiceImpl(sc);
        ParticipanteService participanteService = new ParticipanteServiceImpl(sc);

        MenuService menuService = new MenuServiceImpl(eventoService, chefService, participanteService, sc);

        menuService.mostrarMenu();

        sc.close();
    }

}
