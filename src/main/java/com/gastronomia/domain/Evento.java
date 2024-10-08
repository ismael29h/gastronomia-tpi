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
    private int numParticipantes;

    // constructores
    public Evento(String nombre, String descripcion, LocalDateTime fechaYHora, String ubicacion, int capacidad) {
        this.id = UUID.randomUUID();
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaYHora = fechaYHora;
        this.ubicacion = ubicacion;
        this.capacidad = capacidad;
        this.chefACargo = null;
        this.numParticipantes = 0;
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

    public int getNumParticipantes() {
        return numParticipantes;
    }

    public void setNumParticipantes(int numParticipantes) {
        this.numParticipantes = numParticipantes;
    }

    /** Incrementa el número de participantes en 1 */
    public void incNumParticipantes() {
        this.numParticipantes += 1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        String chefString;
        if (chefACargo == null) {
            chefString = "-> (Ningún chef a cargo)\n";
        } else {
            chefString = "-> A cargo del evento: " + chefACargo.getNombre()
                    + " (DNI: " + chefACargo.getDni() + ")\n";
        }

        return sb.append("----------------------------------------------------------\n")
                .append("-> Nombre del evento: " + nombre + "\n")
                .append("-> ID: " + id + "\n")
                .append(chefString)
                .append("-> Descripción: " + descripcion + "\n")
                .append("-> Lugar: " + ubicacion + "\n")
                .append("-> Capacidad máxima: " + capacidad + "\n")
                .append("-> Fecha: "
                        + fechaYHora.getDayOfMonth() + "/"
                        + fechaYHora.getMonthValue() + "/"
                        + fechaYHora.getYear() + "\n")
                .append("-> Hora: "
                        + fechaYHora.getHour() + ":"
                        + fechaYHora.getMinute() + "\n")
                .toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Evento) {
            Evento otroEvento = (Evento) obj;
            return id != null && id.equals(otroEvento.getId());
        }

        return false;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0; // se usa el hashcode del obj UUIDs
    }
}
