package com.gastronomia.enumeration;

import java.util.List;
import java.util.Scanner;

public enum ComidaEnum {
    ITALIANA,
    MEXICANA,
    VEGANA;

    /** Elige los intereses culinarios del participante */
    public static void elegirIntereses(List<ComidaEnum> intereses, Scanner sc) {

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
            ComidaEnum.elegirIntereses(intereses, sc);
            return;
        }

        if (intereses.contains(comida)) {
            System.out.println("\n<El interés culinario ya se ha seleccionado>\n");
            ComidaEnum.elegirIntereses(intereses, sc);
            return;
        }

        intereses.add(comida);
        System.out.println("\n<Interes culinario agregado>\n");
        ComidaEnum.elegirIntereses(intereses, sc);
        return;

    }
}
