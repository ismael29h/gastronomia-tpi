package com.gastronomia.service.evento.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import com.gastronomia.domain.Evento;
import com.gastronomia.service.evento.EventoService;
import com.gastronomia.service.fecha.FechaService;

public class EventoServiceImpl implements EventoService {
    private List<Evento> eventos;
    private Scanner sc;

    public EventoServiceImpl(Scanner sc) {
        this.sc = sc;
        this.eventos = new ArrayList<Evento>();
    }

    @Override
    public void crearEvento() {
        System.out.println("----------------------------------------------------------");
        System.out.println("<<<CREACION DE EVENTO>>>\n");

        System.out.print("Escriba el nombre para el evento: ");
        String nombre = sc.nextLine();
        sc.nextLine();

        System.out.print("Escriba una descripcion: ");
        String descripcion = sc.nextLine();
        sc.nextLine();

        LocalDateTime fechaYHora = FechaService.solicitarFechaYHora(sc);

        System.out.print("Escriba la ubicación del evento: ");
        String ubicacion = sc.nextLine();
        sc.nextLine();

        System.out.print("Escriba la capacidad máxima del evento: ");
        int capacidad = sc.nextInt();
        sc.nextLine();

        Evento evento = new Evento(nombre, descripcion, fechaYHora, ubicacion, capacidad);

        // guardar el evento (el chef se elige en la gestión de chefs)
        eventos.add(evento);

        System.out.println("\n<<<EVENTO CREADO CON EXITO>>>");
        System.out.println("\nID: " + evento.getId().toString());
    }

    @Override

    public void exportEventosLlenos(LocalDate fecha) {

    }

    /** Da una lista de evento en una fecha determinada */
    @Override
    public void listarEventos(LocalDate fecha) {
        boolean noHayEventos = true;

        System.out.println("Buscando eventos...\n");
        for (Evento evento : eventos) {
            if (FechaService.esMismaFecha(fecha, evento.getFechaYHora())) {
                System.out.println(evento.toString());
                noHayEventos = false;
            }
        }

        if (noHayEventos) {
            System.out.println("\n<<<NO HAY EVENTOS EN LA FECHA INDICADA>>>\n");
        }
    }

    private boolean existeEvento(UUID id) {
        for (Evento evento : eventos) {
            if (evento.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    @Override
    /** Busca y devuelve un evento a partir de su ID */
    public Evento buscarEvento() {
        System.out.print("Ingrese el ID del evento: ");
        UUID id = UUID.fromString(sc.nextLine());

        for (Evento evento : eventos) {
            if (evento.getId().equals(id)) {
                return evento;
            }
        }

        return null;
    }
}
