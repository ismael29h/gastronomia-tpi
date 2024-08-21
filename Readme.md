# Sistema de Gestión de Eventos de Cocina y Gastronomía

### Consideraciones:

+ Mi solución consta de cuatro entidades principales ('Chef', 'Participante', 'Evento' y 'Reseña').
+ Para mantener la cohesión en el código, la lógica se implementa en tres clases diferentes ('ChefServiceImpl', 'ParticipanteServiceImpl' y 'EventoServiceImpl').
+ Una clase adicional se encarga del menú y conecta con la clase 'App', que es el punto de entrada al programa, ('MenuServiceImpl').
+ Las clases de implementación (incluido el menú) son accesibles a través de una interfaz específica para cada una.
+ La solución utiliza clases del tipo 'Enum' como soporte para algunas elecciones, considerando estas elecciones como preestablecidas y acordes con las necesidades del evento.
