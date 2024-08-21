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

    // Constructor
    public EventoServiceImpl(Scanner sc) {
        this.sc = sc;
        this.eventos = new ArrayList<Evento>();
    }

    // Métodos
    @Override
    /** Crear evento nuevo */
    public void crearEvento() {
        System.out.println("----------------------------------------------------------");
        System.out.println("<<<CREACION DE EVENTO>>>\n");

        System.out.print("Escriba el nombre para el evento: ");
        String nombre = sc.nextLine();

        System.out.print("Escriba una descripcion: ");
        String descripcion = sc.nextLine();

        LocalDateTime fechaYHora = FechaService.solicitarFechaYHora(sc);

        if (!FechaService.comprobarFecha(fechaYHora)) {
            System.out.println("\n<<LA FECHA y HORA HA PASADO>>\n");
            return;
        }

        System.out.print("Escriba la ubicación del evento: ");
        String ubicacion = sc.nextLine();

        System.out.print("Escriba la capacidad máxima del evento: ");
        int capacidad = sc.nextInt();
        sc.nextLine();

        if (capacidad < 1) {
            capacidad = 1; // min por defecto
        }

        Evento evento = new Evento(nombre, descripcion, fechaYHora, ubicacion, capacidad);

        // guardar el evento (el chef se elige en la gestión de chefs)
        eventos.add(evento);

        System.out.println("\n<<<EVENTO CREADO CON EXITO>>>");
        System.out.println("\nID: " + evento.getId().toString());
    }

    @Override
    /** Exporta los eventos que están llenos en un archivo .csv */
    public void exportEventosLlenos(LocalDate fecha) {
        final String RUTA_RECURSOS = "\\src\\main\\java\\com\\gastronomia\\resource\\";
        CSVWriter csvWriter = null;

        // comprobaciones
        boolean noHayEventosLlenos = true;

        for (Evento evento : eventos) {
            if (FechaService.esMismaFecha(fecha, evento.getFechaYHora()) && eventoEstaLleno(evento)) {
                noHayEventosLlenos = false;// hay uno
                break;
            }
        }

        if (noHayEventosLlenos) {
            System.out.println("\n<<<NO HAY EVENTOS QUE ESTÉN LLENOS>>>");
            return;
        }

        // se procede...
        String rutaArchivo = System.getProperty("user.dir") + RUTA_RECURSOS
                + "EventosLlenos (" + FechaService.mostrarFecha(fecha) + ").csv";

        try {
            csvWriter = new CSVWriter(new FileWriter(rutaArchivo));

            String[] encabezado = { "ID", "NOMBRE", "DESCRIPCION", "UBICACION", "CHEF A CARGO", "FECHA Y HORA",
                    "CAPACIDAD" };

            csvWriter.writeNext(encabezado);

            for (Evento evento : eventos) {
                if (FechaService.esMismaFecha(fecha, evento.getFechaYHora()) && eventoEstaLleno(evento)) {
                    String[] datosDelEvento = {
                            evento.getId().toString(),
                            evento.getNombre(),
                            evento.getDescripcion(),
                            evento.getUbicacion(),
                            evento.getChefACargo() != null ? evento.getChefACargo().getNombre() : "(Sin chef)",
                            FechaService.mostrarFechaYHora(evento.getFechaYHora()),
                            "" + evento.getCapacidad() // cast a string
                    };
                    csvWriter.writeNext(datosDelEvento);

                }
            }
            System.out.println("\n<<<SE HA GUARDADO EL ARCHIVO>>>\n");

        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        } finally {
            try {
                csvWriter.close();
            } catch (IOException e) {
                System.out.println("No se pudo guardar el archivo: " + e.getMessage());
            }
        }

    }

    @Override
    /** Da una lista de evento en una fecha determinada */
    public void listarEventos(LocalDate fecha) {
        // comprobar
        boolean noHayEventos = true;
        for (Evento evento : eventos) {
            if (FechaService.esMismaFecha(fecha, evento.getFechaYHora())) {
                noHayEventos = false;// hay uno
                break;
            }
        }

        if (noHayEventos) {
            System.out.println("\n<<<NO HAY EVENTOS EN LA FECHA INDICADA>>>\n");
            return;
        }

        // se procede
        System.out.println("\n<<MOSTRANDO EVENTOS>>\n");
        for (Evento evento : eventos) {
            if (FechaService.esMismaFecha(fecha, evento.getFechaYHora())) {
                System.out.println(evento.toString());
            }
        }
    }

    @Override
    /** Busca y devuelve un evento a partir de su ID */
    public Evento buscarEvento() {
        UUID id;

        System.out.print("Ingrese el ID del evento: ");

        try {
            id = UUID.fromString(sc.nextLine());
        } catch (IllegalArgumentException e) {
            // debe poder convertirse en UUID
            System.out.println("\nFormato incorrecto: " + e.getMessage());
            return null;
        }

        for (Evento evento : eventos) {
            if (evento.getId().equals(id)) {
                return evento;
            }
        }
        return null;
    }

    /** Señala si un evento está a su máxima capacidad */
    private boolean eventoEstaLleno(Evento evento) {
        // aunque no se espera que haya más participantes del permitido
        return evento.getNumParticipantes() >= evento.getCapacidad();
    }
}
