package com.gastronomia.service.fecha;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

public class FechaService {
    /** Verifica que sean la misma fecha aunque con diferente horario */
    public static boolean esMismaFecha(LocalDate fecha, LocalDateTime fechaYHora) {
        if (fecha.getDayOfMonth() == fechaYHora.getDayOfMonth()
                && fecha.getMonthValue() == fechaYHora.getMonthValue()
                && fecha.getYear() == fechaYHora.getYear()) {
            return true;
        }

        return false;
    }

    /** Crea un obj LocalDate luego de solicitar dia,mes y año */
    public static LocalDate solicitarFecha(Scanner sc) {
        System.out.print("Ingrese el año: ");
        int año = sc.nextInt();
        sc.nextLine();

        System.out.print("Ingrese el mes: ");
        int mes = sc.nextInt();
        sc.nextLine();

        System.out.print("Ingrese el día: ");
        int dia = sc.nextInt();
        sc.nextLine();

        return LocalDate.of(año, mes, dia);
    };

    /** Crea un obj LocalDateTime luego de solicitar lo necesario */
    public static LocalDateTime solicitarFechaYHora(Scanner sc) {
        LocalDate fecha = solicitarFecha(sc);

        System.out.print("Ingrese la hora: ");
        int hora = sc.nextInt();
        sc.nextLine();

        System.out.print("Ingrese los minutos: ");
        int minutos = sc.nextInt();
        sc.nextLine();

        LocalTime horario = LocalTime.of(hora, minutos);
        return LocalDateTime.of(fecha, horario);
    };
}
