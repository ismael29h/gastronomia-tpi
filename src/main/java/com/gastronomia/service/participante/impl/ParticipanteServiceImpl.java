package com.gastronomia.service.participante.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.gastronomia.domain.Evento;
import com.gastronomia.domain.Participante;
import com.gastronomia.domain.Reseña;
import com.gastronomia.enumeration.CalificacionEnum;
import com.gastronomia.enumeration.ComidaEnum;
import com.gastronomia.service.participante.ParticipanteService;

public class ParticipanteServiceImpl implements ParticipanteService {
    private List<Participante> participantes;
    private List<Reseña> reseñas;
    private Scanner sc;

    public ParticipanteServiceImpl(Scanner sc) {
        this.sc = sc;
        this.participantes = new ArrayList<Participante>();
        this.reseñas = new ArrayList<Reseña>();
    }

    @Override
    public void crearReseña(Evento evento) {
        if (evento == null) {
            System.out.println("\n<<<NO EXISTE EL EVENTO>>>\n");
            return;
        }

        Participante participante = buscarParticipante();

        if (participante == null) {
            System.out.println("\n<<<NO EXISTE EL PARTICIPANTE>>>\n");
            return;
        }

        if (!existeParticipanteEnEvento(participante, evento)) {
            System.out.println("\n<<<PARTICIPANTE NO HA ASISTIDO AL EVENTO>>>\n");
            return;
        }

        if (yaExisteReseña(evento, participante)) {
            System.out.println("\n<<<YA EXISTE UNA RESEÑA CON ESE PARTICIPANTE Y EVENTO>>>\n");
            return;
        }

        CalificacionEnum calificacion = CalificacionEnum.elegircalificacion(sc);

        if (calificacion == null) {
            calificacion = CalificacionEnum.TRES_ESTRELLAS;// valor por defecto
        }

        System.out.print("<Escriba un comentario a continuación>\n> ");

        String comentario = sc.nextLine();
        sc.nextLine();

        Reseña reseña = new Reseña(evento, participante, calificacion, comentario);

        reseñas.add(reseña);

        System.out.println("\n<<<RESEÑA CREADA CON EXITO>>>\n");
    }

    @Override
    public void inscribirParticipante(Evento evento) {
        if (evento == null) {
            System.out.println("\n<<<NO EXISTE EL EVENTO>>>\n");
            return;
        }
        // comprobar si el evento sobrepasó sus límites
        if (evento.getNumParticipantes() >= evento.getCapacidad()) {
            System.out.println("\n<<<EVENTO LLENO>>>\n");
            return;
        }

        Participante participante = buscarParticipante();
        if (participante == null) {
            System.out.println("\n<<<NO SE ENCUENTRA EL PARTICIPANTE>>>\n");
            return;
        }

        if (existeParticipanteEnEvento(participante, evento)) {
            System.out.println("\n<<<PARTICIPANTE YA EXISTEN EN EL EVENTO>>>\n");
            return;
        }

        // registrar participant (el evento no lleva listas de sus participantes)
        participante.getEventosHistorial().add(evento);
        evento.incNumParticipantes();

        System.out.println("\n<<<EL PARTICIPANTE RECIBE SU INVITACIÓN AL EVENTO>>>\n");

    }

    @Override
    /** Crea un nuevo participante en la organización */
    public void nuevoParticipante() {
        System.out.println("----------------------------------------------------------");
        System.out.println("<<<NUEVO PARTICIPANTE>>>\n");

        System.out.println("Ingrese el DNI del participante: ");
        int dni = sc.nextInt();
        sc.nextLine();

        System.out.println("Ingrese el nombre y apellido del participante: ");
        String nombre = sc.nextLine();
        sc.nextLine();

        List<ComidaEnum> intereses = new ArrayList<>();
        ComidaEnum.elegirIntereses(intereses, sc);

        participantes.add(new Participante(dni, nombre, intereses));

        System.out.println("\n<<<PARTICIPANTE CREADO CON EXITO>>>");

    }

    /** Comprueba si existe un participante según su dni */
    private boolean existeParticipante(int dni) {
        for (Participante participante : participantes) {
            if (participante.getDni() == dni) {
                return true;
            }
        }
        return false;
    }

    @Override
    /** Solicita, busca y devuelve un participante del total */
    public Participante buscarParticipante() {
        System.out.print("Ingrese el DNI del participante: ");
        int dni = sc.nextInt();
        sc.nextLine();

        for (Participante participante : participantes) {
            if (participante.getDni() == dni) {
                return participante;
            }
        }
        return null;
    }

    /** comprobar si el participante ya está en ese evento */
    private boolean existeParticipanteEnEvento(Participante participante, Evento evento) {

        for (Evento eventoEnHistorial : participante.getEventosHistorial()) {
            if (eventoEnHistorial.equals(evento)) {
                return true;
            }
        }

        return false;
    }

    /** Verifica si un participante hizo una reseña a un evento */
    private boolean yaExisteReseña(Evento evento, Participante participante) {

        for (Reseña reseña : reseñas) {
            if (reseña.getEvento().equals(evento) && reseña.getParticipante().equals(participante)) {
                return true;
            }
        }

        return false;
    }
}
