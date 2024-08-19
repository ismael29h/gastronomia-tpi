package com.gastronomia.service.participante.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.gastronomia.domain.Evento;
import com.gastronomia.domain.Participante;
import com.gastronomia.domain.Reseña;
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
    public Reseña crearReseña(Evento evento, Participante participante) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void inscribirParticipante(Evento evento) {
        // TODO Auto-generated method stub

    }

    @Override
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

    private boolean existeParticipante(int dni) {
        for (Participante participante : participantes) {
            if (participante.getDni() == dni) {
                return true;
            }
        }
        return false;
    }

    /** Busca y devuelve un participante del total */
    private Participante buscarParticipante() {
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
}
