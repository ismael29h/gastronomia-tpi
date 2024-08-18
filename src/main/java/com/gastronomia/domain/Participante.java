package com.gastronomia.domain;

import java.util.List;

import com.gastronomia.enumeration.Comida;

public class Participante {
    private int dni;
    private String nombre;
    private List<Comida> intereses;
    private List<Evento> eventosHistorial; // historial de eventos que ha participado

    // constructores
    public Participante(int dni, String nombre, List<Comida> intereses) {
        this.dni = dni;
        this.nombre = nombre;
        this.intereses = intereses;
    }

    // getters&setters
    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Comida> getIntereses() {
        return intereses;
    }

    public void setIntereses(List<Comida> intereses) {
        this.intereses = intereses;
    }

    public List<Evento> getEventosHistorial() {
        return eventosHistorial;
    }

    public void setEventosHistorial(List<Evento> eventosHistorial) {
        this.eventosHistorial = eventosHistorial;
    }
}
