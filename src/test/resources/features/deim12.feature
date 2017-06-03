# language: es
Característica:
  Como Lider de Proyecto
  Quiero asignar una tarea a una persona
  Para establecer un responsable por tarea.

  Escenario: Asignar una tarea del proyecto a un desarrollador con 4 o menos tareas
    Dado que Juan un desarrollador con cuatro o menos tareas
    Cuando le asigno una tarea a Juan
    Entonces la tarea es asignada

  Escenario: Asignar una tarea del proyecto a un desarrollador con 5 tareas
    Dado que Pedro un desarrollador con mas de 5 tareas
    Cuando le asigno una tarea a Pedro
    Entonces la tarea no es asignada