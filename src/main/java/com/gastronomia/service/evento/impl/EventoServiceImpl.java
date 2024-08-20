package com.gastronomia.service.evento.impl;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import com.gastronomia.domain.Evento;
import com.gastronomia.service.evento.EventoService;
import com.gastronomia.service.fecha.FechaService;
import com.opencsv.CSVWriter;

public class EventoServiceImpl implements EventoService {
    private List<Evento> eventos;
    private Scanner sc;
    private final String RUTA_RECURSOS = "\\src\\main\\java\\com\\gastronomia\\resource\\";
    CSVWriter csvWriter = null;

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
        boolean noHayEventosLlenos = true;

        String rutaArchivo = System.getProperty("user.dir") + RUTA_RECURSOS + "EventosLlenos ("
                + FechaService.mostrarFecha(fecha) + ").csv";

        try {
            csvWriter = new CSVWriter(new FileWriter(rutaArchivo));

            String[] encabezado = { "ID", "NOMBRE", "DESCRIPCION", "UBICACION", "CHEF A CARGO", "FECHA Y HORA",
                    "CAPACIDAD" };

            csvWriter.writeNext(encabezado);

            for (Evento evento : eventos) {
                if (eventoEstaLleno(evento)) {
                    String[] datosDelEvento = {
                            evento.getId().toString(),
                            evento.getNombre(),
                            evento.getDescripcion(),
                            evento.getUbicacion(),
                            evento.getChefACargo() != null ? evento.getChefACargo().getNombre() : "(Sin chef)",
                            FechaService.mostrarFechaYHora(evento.getFechaYHora()),
                            "" + evento.getCapacidad()
                    };
                    csvWriter.writeNext(datosDelEvento);
                    noHayEventosLlenos = false; // al menos uno
                }
            }
            if (noHayEventosLlenos) {
                System.out.println("\n<<<NO HAY EVENTOS QUE ESTÉN LLENOS>>>");
            } else {
                System.out.println("\n<<<SE HA GUARDADO EL ARCHIVO>>>\n");
            }

        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

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

    private boolean eventoEstaLleno(Evento evento) {
        return evento.getNumParticipantes() >= evento.getCapacidad();
    }

    public void cerrarWriter() {
        if (csvWriter != null) {
            try {
                csvWriter.close();
            } catch (IOException e) {
                System.out.println("ERROR: " + e.getMessage());
            }
        }
    }
}
