package com.gastronomia.service.participante;

import com.gastronomia.domain.Evento;
import com.gastronomia.domain.Participante;
import com.gastronomia.domain.Reseña;

public interface ParticipanteService {
    public void nuevoParticipante();

    public Participante buscarParticipante();

    public void inscribirParticipante(Evento evento);

    public Reseña crearReseña(Evento evento, Participante participante);
}
