package com.gastronomia.domain;

import java.util.UUID;

import com.gastronomia.enumeration.CalificacionEnum;

public class Reseña {
    private UUID id;
    private Evento evento;
    private Participante participante;
    private CalificacionEnum calificacion;
    private String comentario;

    // constructores
    public Reseña(Evento evento, Participante participante, CalificacionEnum calificacion, String comentario) {
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

    public CalificacionEnum getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(CalificacionEnum calificacion) {
        this.calificacion = calificacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Reseña) {
            Reseña otraReseña = (Reseña) obj;
            return id != null && id.equals(otraReseña.getId());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
