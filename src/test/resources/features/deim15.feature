# language: es
Característica:
  Como Lider de Proyecto
  Quiero asignar una cantidad de horas estimadas a una determinada tarea
  Para planificar el trabajo.

  Escenario: Asignar una cantidad de horas positiva a una tarea
    Dado se crea una tareaCuatro
    Cuando le asigno una cantidad de horas positivas
    Entonces la tarea queda asignada con esas horas


  Escenario: Asignar una cantidad de horas negativa a una tarea
    Dado se crea una tareaCinco
    Cuando le asigno una cantidad de horas negativa
    Entonces la tarea no queda asignada con esas horas