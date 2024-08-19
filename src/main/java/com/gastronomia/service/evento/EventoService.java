package com.gastronomia.service.evento;

import java.time.LocalDate;

import com.gastronomia.domain.Evento;

public interface EventoService {
    public void crearEvento();

    public Evento buscarEvento();

    public void listarEventos(LocalDate fecha);

    public void exportEventosLlenos(LocalDate fecha);

}
