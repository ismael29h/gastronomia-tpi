package com.gastronomia.service.evento.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.gastronomia.domain.Evento;
import com.gastronomia.service.evento.EventoService;

public class EventoServiceImpl implements EventoService {
    private List<Evento> eventos;
    private Scanner sc;

    public EventoServiceImpl(Scanner sc) {
        this.sc = sc;
    }

    @Override
    public Evento buscarEvento() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void crearEvento() {
        // TODO Auto-generated method stub

    }

    @Override
    public void exportEventosLlenos(LocalDate fecha) {
        // TODO Auto-generated method stub

    }

    @Override
    public void listarEventos(LocalDate fecha) {
        // TODO Auto-generated method stub

    }

}
