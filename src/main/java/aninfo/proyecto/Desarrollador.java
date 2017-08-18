package aninfo.proyecto;

import aninfo.tarea.Tarea;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by christian on 5/27/17.
 */
public class Desarrollador {

    private List<Tarea> tareas;
    private String nombre;

    public Desarrollador(String nombre) {
        this.nombre = nombre;
        this.tareas = new ArrayList<>();
    }

    public void asignar(Tarea unaTarea){
        this.tareas.add(unaTarea);
    }

    public Integer cantidadDeTareasAsignadas(){
        return tareas.size();
    }

    public String getNombre() {
        return nombre;
    }

    public boolean tieneMasDe4Tareas() {
       return (tareas.size() > 4);
    }

    public boolean hasTarea(Tarea tarea) {
        return tareas.stream().anyMatch(t -> t.getId().equals(tarea.getId()));
    }

}
