package aninfo;

import util.Lapso;

/**
 * Created by christian on 5/26/17.
 */
public class Proyecto {

    private Lapso lapso;
    private Double presupuesto;
    private Equipo equipo;


    public Proyecto(Lapso lapso, Double presupuesto) {
        this.lapso = lapso;
        this.presupuesto = presupuesto;
    }

    public Integer cantidadDeTareas() {
        return equipo.getDesarrolladores().stream()
                .mapToInt(Desarrollador::cantidadDeTareasAsignadas)
                .sum();
    }

    public Boolean asignar(Tarea unaTarea, String nombreDelDesarrollador){
        if(equipo == null){
            return false;
        }else if(equipo.isEmpty()){
            return false;
        }else{

            if(!isDesarrolladorDisponibles(nombreDelDesarrollador)) return false;

            for(Desarrollador d : equipo.getDesarrolladores()){
                if(d.getNombre().equals(nombreDelDesarrollador)){
                    d.asignar(unaTarea);
                }
            }
            return true;
        }
    }

    public Boolean desarrolladoresDisponibles(){
        return equipo.desarrolladoresConCuatroOMenosTareas().size() != 0;
    }

    public Boolean isDesarrolladorDisponibles(String nombreDelDesarrollador){
        return equipo.desarrolladoresConCuatroOMenosTareas().stream()
                .anyMatch(d -> d.getNombre().equals(nombreDelDesarrollador));
    }

    public void asignar(Equipo equipo) {
        this.equipo = equipo;
    }
}
