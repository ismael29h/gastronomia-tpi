package com.gastronomia.service.menu.impl;

import java.util.Scanner;

import com.gastronomia.service.chef.ChefService;
import com.gastronomia.service.evento.EventoService;
import com.gastronomia.service.menu.MenuService;
import com.gastronomia.service.participante.ParticipanteService;

public class MenuServiceImpl implements MenuService {
    private EventoService eventoService;
    private ChefService chefService;
    private ParticipanteService participanteService;
    private Scanner sc;

    public MenuServiceImpl(EventoService eventoService, ChefService chefService,
            ParticipanteService participanteService, Scanner sc) {
        this.eventoService = eventoService;
        this.chefService = chefService;
        this.participanteService = participanteService;
        this.sc = sc;
    }

    @Override
    public void mostrarMenu() {
        int opc;
        System.out.println("----------------------------------------------------------");
        System.out.println("<<<APLICACION INICIADA>>>");

        do {
            System.out.println("----------------------------------------------------------");
            System.out.println("<<<MENU PRINCIPAL>>>\n");
            System.out.println("1. Gestion de chefs");
            System.out.println("2. Gestión de participantes");
            System.out.println("3. Gestion de eventos");
            System.out.println("4. Salir de la aplicación");
            System.out.print("> ");

            opc = sc.nextInt();
            sc.nextLine();

            switch (opc) {
                case 1:
                    // gestion de chefs
                    break;
                case 2:
                    // gestion de participantes
                    break;
                case 3:
                    gestionEvento();
                    break;
                case 4:
                    System.out.println("\n<<<APLICACION FINALIZADA>>>");
                    break;
                default:
                    System.out.println("\n<<<OPCION INCORRECTA>>>");
                    break;
            }

        } while (opc != 4);

    }

    private void gestionEvento() {
        int opc;
        do {
            System.out.println("----------------------------------------------------------");
            System.out.println("<<<MENU DE GESTION DE EVENTOS>>>\n");
            System.out.println("1. Crear evento");
            System.out.println("2. Volver hacia atrás");

            opc = sc.nextInt();
            sc.nextLine();

            switch (opc) {
                case 1:
                    eventoService.crearEvento(chefService);
                    break;
                case 2:
                    System.out.println("\n<<<SALIENDO DE GESTION DE EVENTOS>>>");
                    break;
                default:
                    System.out.println("\n<<<OPCION INCORRECTA>>>");
                    break;
            }
        } while (opc != 2);
    }
}
