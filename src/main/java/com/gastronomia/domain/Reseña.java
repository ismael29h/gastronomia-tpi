package com.gastronomia.domain;

import java.util.UUID;

import com.gastronomia.enumeration.Calificacion;

public class Reseña {
    private UUID id;
    private Evento evento;
    private Participante participante;
    private Calificacion calificacion;
    private String comentario;

    // constructores
    public Reseña(Evento evento, Participante participante, Calificacion calificacion, String comentario) {
        this.id = UUID.randomUUID();
        this.evento = evento;
        this.participante = participante;
        this.calificacion = calificacion;
        this.comentario = comentario;
    }

    // getters&setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public Calificacion getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Calificacion calificacion) {
        this.calificacion = calificacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

}
