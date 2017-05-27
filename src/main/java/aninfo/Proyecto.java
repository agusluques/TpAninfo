package aninfo;

import util.Lapso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by christian on 5/26/17.
 */
public class Proyecto {

    private Lapso lapso;
    private Double presupuesto;
    private List<Tarea> listaDeTareas;
    //private Equipo equipo;


    public Proyecto(Lapso lapso, Double presupuesto) {
        this.lapso = lapso;
        this.presupuesto = presupuesto;
        listaDeTareas = new ArrayList<>();
    }

    public Integer cantidadDeTareas() {
        return this.listaDeTareas.size();
    }

    public void agregar(Tarea unTarea) {
        listaDeTareas.add(unTarea);
    }
}
