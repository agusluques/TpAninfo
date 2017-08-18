# language: es
Característica:
  Como Lider de Proyecto
  Quiero crear una tarea dentro de un proyecto
  Para dividir el trabajo.

  Escenario: Proyecto sin tareas
    Dado que el proyecto no tiene tareas
    Cuando creo una nueva tarea y la agrego al mismo
    Entonces la cantidad de tareas del proyecto es 1


  Escenario: Proyecto con tareas existentes
    Dado que el proyecto tiene 7 tareas
    Cuando creo una nueva tarea y la agrego al mismo
    Entonces la cantidad de tareas del proyecto es 8