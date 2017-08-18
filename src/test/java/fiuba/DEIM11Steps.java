package fiuba;

import aninfo.proyecto.Proyecto;
import aninfo.tarea.Tarea;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import util.Lapso;

import static org.junit.Assert.assertEquals;

/**
 * Created by christian on 6/2/17.
 */
public class DEIM11Steps {

    private Proyecto proyecto;

    @Before
    public void initialize(){
        proyecto = new Proyecto(new Lapso(10),1000.0);
    }

//======================================================================================================================
//======================================================================================================================
    @Dado("^que el proyecto no tiene tareas$")
    public void que_el_proyecto_no_tiene_tareas() throws Throwable {
        assertEquals(new Integer(0),proyecto.cantidadDeTareas());
    }

    @Dado("^que el proyecto tiene (\\d+) tareas$")
    public void que_el_proyecto_no_tiene_tareas(int numDeTareas) throws Throwable {
        for(int i = 0; i < numDeTareas; i++){
            proyecto.agregarTarea(new Tarea("Tarea" + i,Tarea.PRIORIDAD_MEDIA,10 ));
        }
        assertEquals(new Integer(numDeTareas),proyecto.cantidadDeTareas());
    }

    @Cuando("^creo una nueva tarea y la agrego al mismo$")
    public void creo_una_nueva_tarea_y_la_agrego_al_mismo(){
        Tarea unaTarea = new Tarea("Tarea2", Tarea.PRIORIDAD_BAJA,10 );
        proyecto.agregarTarea(unaTarea);
    }

    @Entonces("^la cantidad de tareas del proyecto es (\\d+)$")
    public void la_cantidad_de_tareas_del_proyecto_es(int arg1) throws Throwable {
        assertEquals(new Integer(arg1),proyecto.cantidadDeTareas());
    }
//======================================================================================================================
//======================================================================================================================
}
