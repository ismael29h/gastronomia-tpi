package com.gastronomia.service.evento;

import java.time.LocalDate;

import com.gastronomia.domain.Evento;
import com.gastronomia.service.chef.ChefService;

public interface EventoService {
    public void crearEvento(ChefService chefService);

    public Evento buscarEvento();

    public void listarEventos(LocalDate fecha);

    public void exportEventosLlenos(LocalDate fecha);

}
