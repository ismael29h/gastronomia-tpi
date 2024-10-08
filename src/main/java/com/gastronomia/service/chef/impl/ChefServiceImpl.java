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

    // constructor
    public ChefServiceImpl(Scanner sc) {
        this.sc = sc;
        this.chefs = new ArrayList<Chef>();
    }

    @Override
    /** Asigna un chef a un evento */
    public void asignarChef(Evento evento) {
        if (evento == null) {
            System.out.println("\n<<<NO EXISTE EL EVENTO>>>\n");
            return;
        }

        Chef chef = buscarChef();

        if (chef == null) {
            System.out.println("\n<<<NO SE ENCUENTRA EL CHEF>>>\n");
            return;
        }

        if (evento.getChefACargo() != null) {
            System.out.println("\n<<El chef a cargo será reemplazado por el actual>>\n");
        }

        evento.setChefACargo(chef);
        chef.getEventosACargo().add(evento);
        System.out.println("\n<<<CHEF ASIGNADO AL EVENTO CON EXITO>>>\n");

    }

    @Override
    /** Agrega un nuevo chef */
    public void nuevoChef() {
        System.out.println("----------------------------------------------------------");
        System.out.println("<<<NUEVO CHEF>>>\n");

        System.out.print("Ingrese el DNI del chef: ");
        int dni = sc.nextInt();
        sc.nextLine();

        // Comprobar si existe
        if (existeChef(dni)) {
            System.out.println("\n<<<CHEF YA EXISTE>>>\n");
        }

        System.out.print("Ingrese el nombre y apellido del chef: ");
        String nombre = sc.nextLine();

        EspecialidadEnum especialidad = EspecialidadEnum.elegirEspecialidad(sc); // puede ser null

        chefs.add(new Chef(dni, nombre, especialidad));

        System.out.println("\n<<<CHEF CREADO CON EXITO>>>");

    }

    /** Comprueba la existencia de un chef */
    private boolean existeChef(int dni) {
        for (Chef chef : chefs) {
            if (chef.getDni() == dni)
                return true;
        }
        return false;
    }

    /** Busca y devuelve un chef del total */
    private Chef buscarChef() {
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

}
