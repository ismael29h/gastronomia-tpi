package com.gastronomia.service.participante.impl;

import java.util.List;
import java.util.Scanner;

import com.gastronomia.domain.Evento;
import com.gastronomia.domain.Participante;
import com.gastronomia.domain.Reseña;
import com.gastronomia.service.participante.ParticipanteService;

public class ParticipanteServiceImpl implements ParticipanteService {
    private List<Participante> participantes;
    private List<Reseña> reseñas;
    private Scanner sc;

    public ParticipanteServiceImpl(Scanner sc) {
        this.sc = sc;
    }

    @Override
    public Reseña crearReseña(Evento evento, Participante participante) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Participante buscarParticipante() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void inscribirParticipante(Evento evento) {
        // TODO Auto-generated method stub

    }

    @Override
    public void nuevoParticipante() {
        // TODO Auto-generated method stub

    }
}
