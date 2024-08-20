package com.gastronomia.domain;

import java.util.ArrayList;
import java.util.List;

import com.gastronomia.enumeration.ComidaEnum;

public class Participante {
    private int dni;
    private String nombre;
    private List<ComidaEnum> intereses;
    private List<Evento> eventosHistorial; // historial de eventos que ha participado o participa actualmente

    // constructores
    public Participante(int dni, String nombre, List<ComidaEnum> intereses) {
        this.dni = dni;
        this.nombre = nombre;
        this.intereses = intereses;
        this.eventosHistorial = new ArrayList<Evento>();
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

    public List<ComidaEnum> getIntereses() {
        return intereses;
    }

    public void setIntereses(List<ComidaEnum> intereses) {
        this.intereses = intereses;
    }

    public List<Evento> getEventosHistorial() {
        return eventosHistorial;
    }

    public void setEventosHistorial(List<Evento> eventosHistorial) {
        this.eventosHistorial = eventosHistorial;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Participante) {
            Participante otroParticipante = (Participante) obj;
            return dni == otroParticipante.getDni();
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(dni);
    }
}
