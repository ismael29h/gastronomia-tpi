package com.gastronomia.service.menu.impl;

import java.time.LocalDateTime;
import java.util.Scanner;

import com.gastronomia.service.chef.ChefService;
import com.gastronomia.service.evento.EventoService;
import com.gastronomia.service.fecha.FechaService;
import com.gastronomia.service.menu.MenuService;
import com.gastronomia.service.participante.ParticipanteService;

public class MenuServiceImpl implements MenuService {
    private EventoService eventoService;
    private ChefService chefService;
    private ParticipanteService participanteService;
    private Scanner sc;

    // Constructor
    public MenuServiceImpl(EventoService eventoService, ChefService chefService,
            ParticipanteService participanteService, Scanner sc) {
        this.eventoService = eventoService;
        this.chefService = chefService;
        this.participanteService = participanteService;
        this.sc = sc;
    }

    // Métodos
    @Override
    /** Menú principal de la aplicación */
    public void mostrarMenu() {
        int opc;
        System.out.println("----------------------------------------------------------");
        System.out.println("<<<APLICACION INICIADA>>>\n");
        System.out.println(FechaService.mostrarFechaYHora(LocalDateTime.now()));

        do {
            System.out.println("----------------------------------------------------------");
            System.out.println("<<<MENU PRINCIPAL>>>\n");
            System.out.println("1. Gestion de chefs");
            System.out.println("2. Gestión de participantes");
            System.out.println("3. Gestion de eventos");
            System.out.println("4. <Salir de la aplicación>");
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
                default:
                    System.out.println("\n<<<OPCION INCORRECTA>>>");
                    break;
            }

        } while (opc != 4);

    }

    /** Menú para gestionar eventos */
    private void gestionEvento() {
        int opc;
        do {
            System.out.println("----------------------------------------------------------");
            System.out.println("<<<MENU DE GESTION DE EVENTOS>>>\n");
            System.out.println("1. Crear evento");
            System.out.println("2. Listar eventos de una día");
            System.out.println("3. Exportar eventos que estén repletos");
            System.out.println("4. <Volver hacia atrás>");
            System.out.print("> ");

            opc = sc.nextInt();
            sc.nextLine();

            switch (opc) {
                case 1:
                    eventoService.crearEvento();
                    break;
                case 2:
                    eventoService.listarEventos(FechaService.solicitarFecha(sc));
                    break;
                case 3:
                    eventoService.exportEventosLlenos(FechaService.solicitarFecha(sc));
                    break;
                case 4:
                    System.out.println("\n<<<SALIENDO DE GESTION DE EVENTOS>>>");
                    break;
                default:
                    System.out.println("\n<<<OPCION INCORRECTA>>>");
                    break;
            }
        } while (opc != 4);
    }

    /** Menú para gestionar chefs */
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

    /** Menú para gestionar participantes */
    private void gestionParticipante() {
        int opc;
        do {
            System.out.println("----------------------------------------------------------");
            System.out.println("<<<MENU DE GESTION DE PARTICIPANTES>>>\n");
            System.out.println("1. Nuevo participante en la organización");
            System.out.println("2. Asignar un participante a un evento");
            System.out.println("3. Un participante deja una reseña");
            System.out.println("4. <Volver hacia atrás>");
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
                    participanteService.crearReseña(eventoService.buscarEvento());
                    break;
                case 4:
                    System.out.println("\n<<<SALIENDO DE GESTION DE PARTICIPANTES>>>");
                    break;
                default:
                    System.out.println("\n<<<OPCION INCORRECTA>>>");
                    break;
            }
        } while (opc != 4);
    }

}
