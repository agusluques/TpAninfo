package aninfo;

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
}
