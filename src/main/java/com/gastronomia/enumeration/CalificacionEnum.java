package com.gastronomia.enumeration;

import java.util.Scanner;

public enum CalificacionEnum {
    UNA_ESTRELLA,
    DOS_ESTRELLAS,
    TRES_ESTRELLAS,
    CUATRO_ESTRELLAS,
    CINCO_ESTRELLAS;

    public static CalificacionEnum elegirCalificacion(Scanner sc) {
        int opc;
        System.out.println("<Elije una calificación>");
        System.out.println("1. Una estrella *");
        System.out.println("2. Dos estrellas **");
        System.out.println("3. Tres estrellas ***");
        System.out.println("4. Cuatro estrellas ****");
        System.out.println("5. Cinco estrellas *****");
        System.out.print("> ");

        opc = sc.nextInt();
        sc.nextLine();

        return (switch (opc) {
            case 1 -> CalificacionEnum.UNA_ESTRELLA;
            case 2 -> CalificacionEnum.DOS_ESTRELLAS;
            case 3 -> CalificacionEnum.TRES_ESTRELLAS;
            case 4 -> CalificacionEnum.CUATRO_ESTRELLAS;
            case 5 -> CalificacionEnum.CINCO_ESTRELLAS;
            default -> null;
        });
    }
}
