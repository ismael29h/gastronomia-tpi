package com.gastronomia.domain;

import java.time.LocalDateTime;
import java.util.UUID;

public class Evento {
    private UUID id;
    private String nombre;
    private String descripcion;
    private LocalDateTime fechaYHora;
    private String ubicacion;
    private int capacidad;
    private Chef chefACargo;

    // constructores
    public Evento(String nombre, String descripcion, LocalDateTime fechaYHora, String ubicacion, int capacidad) {
        this.id = UUID.randomUUID();
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaYHora = fechaYHora;
        this.ubicacion = ubicacion;
        this.capacidad = capacidad;
    }

    // getters&setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getFechaYHora() {
        return fechaYHora;
    }

    public void setFechaYHora(LocalDateTime fechaYHora) {
        this.fechaYHora = fechaYHora;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public Chef getChefACargo() {
        return chefACargo;
    }

    public void setChefACargo(Chef chefACargo) {
        this.chefACargo = chefACargo;
    }
}
