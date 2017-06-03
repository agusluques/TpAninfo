package aninfo.proyecto;

import aninfo.proyecto.exceptions.*;
import aninfo.tarea.Tarea;
import util.Lapso;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * Created by christian on 5/26/17.
 */
public class Proyecto {

    private Lapso lapso;
    private Double presupuesto;
    private Equipo equipo;
    private List<Tarea> tareas;


    public Proyecto(Lapso lapso, Double presupuesto) {
        this.lapso = lapso;
        this.presupuesto = presupuesto;
        this.tareas = new LinkedList<>();
    }

    public Integer cantidadDeTareasAsignadas() {
        return equipo.getDesarrolladores().stream()
                .mapToInt(Desarrollador::cantidadDeTareasAsignadas)
                .sum();
    }

    public Integer cantidadDeTareas(){
        return tareas.size();
    }

    public void agregarTarea(Tarea unaTarea) {
        this.tareas.add(unaTarea);
    }

    public void asignarTarea(String idDeTarea, String nombreDelDesarrollador) throws ProyectoException {
       if(equipo == null) throw new ProyectoSinEquipoException();
       Optional<Tarea> optTarea =  this.tareas.stream().filter(t -> t.getId().equals(idDeTarea)).findFirst();
       if(optTarea.isPresent()){
           Optional<Desarrollador> optDev = equipo.getDesarrolladores().stream()
                   .filter(d -> d.getNombre().equals(nombreDelDesarrollador)).findFirst();
           if(optDev.isPresent()){
               Desarrollador dev = optDev.get();
               if(dev.hasTarea(optTarea.get())) throw new TareaYaAsignadaException();
               if(!dev.tieneMasDe4Tareas()){
                   dev.asignar(optTarea.get());
               }else{
                   throw new DesarrolladorConMasDeCuatroTareasException();
               }
           }else{
               throw new DesarrolladorInexistenteException();
           }
       }else{
           throw new TareaInexistenteException();
       }
    }

    public Boolean areDesarrolladoresDisponibles(){
        return equipo.desarrolladoresConCuatroOMenosTareas().size() != 0;
    }

    public Boolean tieneDesarrolladorMasDeCuatroTareas(String nombreDelDesarrollador) throws ProyectoSinEquipoException {
        if(equipo == null) throw new ProyectoSinEquipoException();
        return equipo.desarrolladoresConCuatroOMenosTareas().stream()
                .anyMatch(d -> d.getNombre().equals(nombreDelDesarrollador));
    }

    public void asignar(Equipo equipo) {
        this.equipo = equipo;
    }
}
