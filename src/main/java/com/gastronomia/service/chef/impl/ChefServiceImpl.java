package com.gastronomia.service.chef.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.gastronomia.domain.Chef;
import com.gastronomia.domain.Evento;
import com.gastronomia.enumeration.EspecialidadEnum;
import com.gastronomia.service.chef.ChefService;

public class ChefServiceImpl implements ChefService {
    private List<Chef> chefs; // lista total de chefs
    private Scanner sc;

    public ChefServiceImpl(Scanner sc) {
        this.sc = sc;
        this.chefs = new ArrayList<Chef>();
    }

    @Override
    public void asignarChef(Evento evento) {
        // TODO Auto-generated method stub

    }

    @Override
    public Chef buscarChef() {
        System.out.print("Ingrese el DNI del chef: ");
        int dni = sc.nextInt();
        sc.nextLine();

        for (Chef chef : chefs) {
            if (chef.getDni() == dni) {
                return chef;
            }
        }
        return null;
    }

    @Override
    public void nuevoChef() {
        System.out.println("----------------------------------------------------------");
        System.out.println("<<<NUEVO CHEF>>>\n");

        System.out.println("Ingrese el DNI del chef: ");
        int dni = sc.nextInt();
        sc.nextLine();

        System.out.println("Ingrese el nombre y apellido del chef: ");
        String nombre = sc.nextLine();
        sc.nextLine();

        System.out.println("Ingrese la especialidad del chef: ");
        EspecialidadEnum especialidad = elegirEspecialidad();

        chefs.add(new Chef(dni, nombre, especialidad));

        System.out.println("\n<<<CHEF CREADO CON EXITO>>>");

    }

    private EspecialidadEnum elegirEspecialidad() {
        // para iterar sobre Enum
        int opc;
        System.out.println("<Elije una especialidad>");
        System.out.println("1. Pastelería");
        System.out.println("2. Cocina Internacional");
        System.out.print("> ");

        opc = sc.nextInt();
        sc.nextLine();

        return (switch (opc) {
            case 1 -> EspecialidadEnum.PASTELERIA;
            case 2 -> EspecialidadEnum.COCINA_INTERNACIONAL;
            default -> null;
        });
    }

}
