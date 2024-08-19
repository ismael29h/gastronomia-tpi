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
        elegirIntereses(intereses);

        participantes.add(new Participante(dni, nombre, intereses));

        System.out.println("\n<<<PARTICIPANTE CREADO CON EXITO>>>");

    }

    /** Elige los intereses culinarios del participante */
    private void elegirIntereses(List<ComidaEnum> intereses) {

        System.out.println("\n<Selecciones los intereses culinarios del participante>\n");

        if (!intereses.contains(ComidaEnum.ITALIANA)) {
            System.out.println("1. Comida: " + ComidaEnum.ITALIANA);
        } else {
            System.out.println("1. Comida: " + ComidaEnum.ITALIANA + " <<AGREGADO A LA LISTA>>");
        }

        if (!intereses.contains(ComidaEnum.MEXICANA)) {
            System.out.println("2. Comida: " + ComidaEnum.MEXICANA);
        } else {
            System.out.println("2. Comida: " + ComidaEnum.MEXICANA + " <<AGREGADO A LA LISTA>>");
        }

        if (!intereses.contains(ComidaEnum.VEGANA)) {
            System.out.println("3. Comida: " + ComidaEnum.VEGANA);
        } else {
            System.out.println("3. Comida: " + ComidaEnum.VEGANA + " <<AGREGADO A LA LISTA>>");
        }

        System.out.println("4. <Salir del menú de intereses culinarios>");
        System.out.print("> ");

        int opc = sc.nextInt();
        sc.nextLine();

        if (opc == 4) {
            System.out.println("\n<Saliendo del menú de intereses culinarios>\n");
            return;
        }

        ComidaEnum comida = (switch (opc) {
            case 1 -> ComidaEnum.ITALIANA;
            case 2 -> ComidaEnum.MEXICANA;
            case 3 -> ComidaEnum.VEGANA;
            default -> null;
        });

        if (comida == null) {
            System.out.println("\n<Opción incorrecta>\n");
            elegirIntereses(intereses);
            return;
        }

        if (intereses.contains(comida)) {
            System.out.println("\n<El interés culinario ya se ha seleccionado>\n");
            elegirIntereses(intereses);
            return;
        }

        intereses.add(comida);
        System.out.println("\n<Interes culinario agregado>\n");
        elegirIntereses(intereses);
        return;

    }

}
