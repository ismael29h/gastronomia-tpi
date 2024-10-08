package com.gastronomia.service.fecha;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

public class FechaService {
    /** Comprueba que una fecha no haya pasado (sin contar minutos) */
    public static boolean comprobarFecha(LocalDateTime fechaYHora) {
        LocalDateTime fActual = LocalDateTime.now();

        if (fActual.toLocalDate().isBefore(fechaYHora.toLocalDate())) {
            return true;
        } else if (fActual.toLocalDate().isEqual(fechaYHora.toLocalDate())
                && fActual.getHour() <= fechaYHora.getHour()) {
            return true;
        }

        return false;
    }

    /** Devuelve un String con la fecha especificada */
    public static String mostrarFecha(LocalDate fechaYHora) {
        StringBuilder sb = new StringBuilder();

        return sb.append(fechaYHora.getDayOfMonth() + "-")
                .append(fechaYHora.getMonthValue() + "-")
                .append(fechaYHora.getYear()).toString();
    }

    /** Devuelve un String con la fecha y hora especificada */
    public static String mostrarFechaYHora(LocalDateTime fechaYHora) {
        StringBuilder sb = new StringBuilder();

        return sb.append(fechaYHora.getDayOfMonth() + "-")
                .append(fechaYHora.getMonthValue() + "-")
                .append(fechaYHora.getYear() + " ")
                .append(fechaYHora.getHour() + ":")
                .append(fechaYHora.getMinute()).toString();
    }

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
