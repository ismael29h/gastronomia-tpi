package com.gastronomia.service.chef;

import com.gastronomia.domain.Chef;
import com.gastronomia.domain.Evento;

public interface ChefService {
    public void nuevoChef();

    public Chef buscarChef();

    public void asignarChef(Evento evento);
}
