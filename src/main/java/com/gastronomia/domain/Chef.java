package com.gastronomia.domain;

import java.util.List;

import com.gastronomia.enumeration.Especialidad;

public class Chef {
    private int dni;
    private String nombre;
    private Especialidad especialidad;
    private List<Evento> eventosACargo; // eventos que está a cargo un chef

    // constructores
    public Chef(int dni, String nombre, Especialidad especialidad) {
        this.dni = dni;
        this.nombre = nombre;
        this.especialidad = especialidad;
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

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public List<Evento> getEventosACargo() {
        return eventosACargo;
    }

    public void setEventosACargo(List<Evento> eventosACargo) {
        this.eventosACargo = eventosACargo;
    }
}
