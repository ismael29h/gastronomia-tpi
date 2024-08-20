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
            System.out.println("4. <Salir de la aplicación>");

            // pruebas
            System.out.println("9.......");

            System.out.print("> ");

            opc = sc.nextInt();
            sc.nextLine();

            switch (opc) {
                case 1:
                    gestionChef();
                    break;
                case 2:
                    gestionParticipante();
                    break;
                case 3:
                    gestionEvento();
                    break;
                case 4:
                    System.out.println("\n<<<APLICACION FINALIZADA>>>");
                    break;
                case 9:
                    // PRUEBAS
                    participanteService.nuevoParticipante();
                    break;
                default:
                    System.out.println("\n<<<OPCION INCORRECTA>>>");
                    break;
            }

        } while (opc != 4);

    }

    /** GESTIONAR EVENTOS */
    private void gestionEvento() {
        int opc;
        do {
            System.out.println("----------------------------------------------------------");
            System.out.println("<<<MENU DE GESTION DE EVENTOS>>>\n");
            System.out.println("1. Crear evento");
            System.out.println("2. <Volver hacia atrás>");
            System.out.print("> ");

            opc = sc.nextInt();
            sc.nextLine();

            switch (opc) {
                case 1:
                    eventoService.crearEvento();
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

    /** GESTIONAR CHEFS */
    private void gestionChef() {
        int opc;
        do {
            System.out.println("----------------------------------------------------------");
            System.out.println("<<<MENU DE GESTION DE CHEF>>>\n");
            System.out.println("1. Nuevo chef en la organización");
            System.out.println("2. Asignar un chef a un evento");
            System.out.println("3. <Volver hacia atrás>");
            System.out.print("> ");

            opc = sc.nextInt();
            sc.nextLine();

            switch (opc) {
                case 1:
                    chefService.nuevoChef();
                    break;
                case 2:
                    chefService.asignarChef(eventoService.buscarEvento());
                    break;
                case 3:
                    System.out.println("\n<<<SALIENDO DE GESTION DE CHEF>>>");
                    break;
                default:
                    System.out.println("\n<<<OPCION INCORRECTA>>>");
                    break;
            }
        } while (opc != 3);
    }

    /** GESTIONAR PARTICIPANTES */
    private void gestionParticipante() {
        int opc;
        do {
            System.out.println("----------------------------------------------------------");
            System.out.println("<<<MENU DE GESTION DE PARTICIPANTES>>>\n");
            System.out.println("1. Nuevo participante en la organización");
            System.out.println("2. Asignar un participante a un evento");
            System.out.println("3. <Volver hacia atrás>");
            System.out.print("> ");

            opc = sc.nextInt();
            sc.nextLine();

            switch (opc) {
                case 1:
                    participanteService.nuevoParticipante();
                    break;
                case 2:
                    participanteService.inscribirParticipante(eventoService.buscarEvento());
                    break;
                case 3:
                    System.out.println("\n<<<SALIENDO DE GESTION DE PARTICIPANTES>>>");
                    break;
                default:
                    System.out.println("\n<<<OPCION INCORRECTA>>>");
                    break;
            }
        } while (opc != 3);
    }

}
