# language: es
Característica:
  Como Lider de Proyecto
  Quiero vincular una tarea a la fase que corresponde
  Para controlar las acciones llevadas a cabo en cada fase.

  Escenario: Vincular una con una fase de desarrollo
    Dado una tarea para vincular una fase
    Y una fase de desarrollo
    Cuando vinculo la fase con la tarea
    Entonces la tarea queda viculada con la fase de desarrollo


  Escenario: Vincular una con una fase de testing
    Dado una tarea para vincular una fase
    Y una fase de testing
    Cuando vinculo la fase con la tarea
    Entonces la tarea queda viculada con la fase de testing


  Escenario: Vincular una con una fase de produccion
    Dado una tarea para vincular una fase
    Y una fase de produccion
    Cuando vinculo la fase con la tarea
    Entonces la tarea queda viculada con la fase de produccion