package com.gastronomia.service.participante;

import com.gastronomia.domain.Evento;
import com.gastronomia.domain.Participante;

public interface ParticipanteService {
    public void nuevoParticipante();

    public void inscribirParticipante(Evento evento);

    public void crearReseña(Evento evento);

    public Participante buscarParticipante();
}
