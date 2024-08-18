package com.gastronomia.service.fecha;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

public class FechaService {
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
