package fiuba;

import aninfo.Proyecto;
import aninfo.Tarea;
import cucumber.api.PendingException;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import util.Lapso;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by christian on 5/27/17.
 */
public class TareasSteps {

    private Proyecto proyecto;

//======================================================================================================================
    @Dado("^que el proyecto no tiene tareas$")
    public void que_el_proyecto_no_tiene_tareas() throws Throwable {
        proyecto = new Proyecto(new Lapso(10),1000.0);
        assertEquals(new Integer(0),proyecto.cantidadDeTareas());
    }

    @Cuando("^creo una nueva tarea y la agrego al mismo$")
    public void creo_una_nueva_tarea_y_la_agrego_al_mismo() throws Throwable {
        Tarea unaTarea = new Tarea("Cambiar el tamaño del text a 12px", Tarea.PRIORIDAD_BAJA);
        proyecto.agregar(unaTarea);
    }

    @Entonces("^la cantidad de tareas del proyecto es \"(.*?)\"$")
    public void la_cantidad_de_tareas_del_proyecto_es(String arg1) throws Throwable {
        assertEquals(new Integer(1),proyecto.cantidadDeTareas());
    }
//======================================================================================================================
//======================================================================================================================
    @Dado("^que Juan un desarrollador con (\\d+) o menos tareas$")
    public void que_un_desarrollador_con_o_menos_tareas(int arg1) throws Throwable {
        //Desarrollador
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Cuando("^le asigno una tarea a Juan$")
    public void le_asigno_una_tarea_a() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Entonces("^la tareas es asignada$")
    public void la_tareas_es_asignada() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
//======================================================================================================================
//======================================================================================================================
    @Dado("^que Pedro un desarrollador con (\\d+) tareas$")
    public void que_un_desarrollador_con_tareas(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Cuando("^le asigno una tarea a Pedro$")
    public void le_asigno_una_tarea_b() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Entonces("^la tareas no es asignada$")
    public void la_tareas_no_es_asignada() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
//======================================================================================================================
}
