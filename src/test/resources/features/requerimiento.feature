# language: es
Característica: Gestion de recursos

  Escenario: Proyecto sin tareas
    Dado que el proyecto no tiene tareas
    Cuando creo una nueva tarea y la agrego al mismo
    Entonces la cantidad de tareas del proyecto es 1

  Escenario: Asignar una tarea del proyecto a un desarrollador con 4 o menos tareas
    Dado que Juan un desarrollador con cuatro o menos tareas
    Cuando le asigno una tarea a Juan
    Entonces la tareas es asignada

  Escenario: Asignar una tarea del proyecto a un desarrollador con 5 tareas
    Dado que Pedro un desarrollador con mas de 5 tareas
    Cuando le asigno una tarea a Pedro
    Entonces la tareas no es asignada