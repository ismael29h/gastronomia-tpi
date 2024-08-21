package com.gastronomia.enumeration;

import java.util.Scanner;

public enum EspecialidadEnum {
    PASTELERIA,
    COCINA_INTERNACIONAL;

    /** Devuelve una especialidad */
    public static EspecialidadEnum elegirEspecialidad(Scanner sc) {
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
