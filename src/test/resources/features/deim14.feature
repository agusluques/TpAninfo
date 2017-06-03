# language: es
Característica:
  Como Lider de Proyecto
  Quiero asignar una prioridad a la tarea
  Para priorizar unas tareas respecto de otras.


  Escenario: Crear una tarea y priorizarla con prioridad ALTA
    Dado que se crea una tareaDos
    Cuando la priorizo con prioridad ALTA
    Entonces la tarea queda priorizada con prioridad ALTA


  Escenario: Crear una tarea y priorizarla con una prioridad INVALIDA
    Dado que se crea una tareaTres
    Cuando la priorizo con prioridad INVALIDA
    Entonces la tarea no queda priorizada con esa prioridad INVALIDA