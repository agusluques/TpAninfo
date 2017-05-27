package fiuba;

import aninfo.Desarrollador;
import aninfo.Equipo;
import aninfo.Proyecto;
import aninfo.Tarea;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import util.Lapso;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by christian on 5/27/17.
 */
public class TareasSteps {

    private Proyecto proyecto;

    @Before
    public void initialize(){
        proyecto = new Proyecto(new Lapso(10),1000.0);
        Desarrollador juan = new Desarrollador("Juan");
        Desarrollador pedro = new Desarrollador("Pedro");
        List<Desarrollador> desarrolladores = new ArrayList<>();
        desarrolladores.add(juan);
        desarrolladores.add(pedro);
        Equipo equipo = new Equipo(desarrolladores);
        proyecto.asignar(equipo);
    }

//======================================================================================================================
    @Dado("^que el proyecto no tiene tareas$")
    public void que_el_proyecto_no_tiene_tareas() throws Throwable {
        assertEquals(new Integer(0),proyecto.cantidadDeTareas());
    }

    @Cuando("^creo una nueva tarea y la agrego al mismo$")
    public void creo_una_nueva_tarea_y_la_agrego_al_mismo(){
        Tarea unaTarea = new Tarea("Cambiar el tamaño del text a 12px", Tarea.PRIORIDAD_BAJA);
        proyecto.asignar(unaTarea,"Juan");
    }

    @Entonces("^la cantidad de tareas del proyecto es (\\d+)$")
    public void la_cantidad_de_tareas_del_proyecto_es(int arg1) throws Throwable {
        assertEquals(new Integer(arg1),proyecto.cantidadDeTareas());
    }
//======================================================================================================================
//======================================================================================================================

    private Boolean tareaAsignada = false;

    @Dado("^que Juan un desarrollador con cuatro o menos tareas$")
    public void que_un_desarrollador_con_o_menos_tareas() throws Throwable {

        Boolean juanIsDisponible = proyecto.isDesarrolladorDisponibles("Juan");
        assertTrue(juanIsDisponible);
    }

    @Cuando("^le asigno una tarea a Juan$")
    public void le_asigno_una_tarea_a() throws Throwable {
        Tarea unaTarea = new Tarea("Cambiar el texto del boton a 'Accept'", Tarea.PRIORIDAD_BAJA);
        tareaAsignada  = proyecto.asignar(unaTarea,"Juan");
    }

    @Entonces("^la tareas es asignada$")
    public void la_tareas_es_asignada() throws Throwable {
        assertTrue(tareaAsignada);
    }
//======================================================================================================================
//======================================================================================================================

    private Boolean tareaAsignada2 = true;

    @Dado("^que Pedro un desarrollador con mas de (\\d+) tareas$")
    public void que_un_desarrollador_con_tareas(int arg1) throws Throwable {

        for(int i = 0; i < arg1;i++){
           Tarea unaTarea = new Tarea("Cambiar el texto del boton a 'Accept'", Tarea.PRIORIDAD_BAJA);
           proyecto.asignar(unaTarea,"Pedro");
        }

        Boolean pedroIsDisponible = proyecto.isDesarrolladorDisponibles("Pedro");
        assertFalse(pedroIsDisponible);
    }

    @Cuando("^le asigno una tarea a Pedro$")
    public void le_asigno_una_tarea_b() throws Throwable {
        Tarea unaTarea = new Tarea("Cambiar el texto del boton a 'Accept'", Tarea.PRIORIDAD_BAJA);
        tareaAsignada2  = proyecto.asignar(unaTarea,"Pedro");
    }

    @Entonces("^la tareas no es asignada$")
    public void la_tareas_no_es_asignada() throws Throwable {
        assertFalse(tareaAsignada2);
    }
//======================================================================================================================
}
