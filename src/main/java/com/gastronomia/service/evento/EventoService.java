package com.gastronomia.service.evento;

import java.time.LocalDate;

public interface EventoService {
    public void crearEvento();

    public void listarEventos(LocalDate fecha);

    public void exportEventosLlenos(LocalDate fecha);

}
