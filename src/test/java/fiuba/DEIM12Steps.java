package fiuba;

import aninfo.proyecto.Desarrollador;
import aninfo.proyecto.Equipo;
import aninfo.proyecto.Proyecto;
import aninfo.tarea.Tarea;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import util.Lapso;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by christian on 6/2/17.
 */
public class DEIM12Steps {

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

        for(int i = 0;i < 11;i++){
            Tarea unaTarea = new Tarea("Tarea" + i, Tarea.PRIORIDAD_BAJA,10 );
            proyecto.agregarTarea(unaTarea);
        }

        for(int i = 0; i < 3;i++){
            try {
                proyecto.asignarTarea("Tarea" + i, "Juan");
            }catch(Exception ignored){}
        }

        for(int i = 3; i < 8;i++){
            try {
                proyecto.asignarTarea("Tarea" + i,"Pedro");
            }catch(Exception ignored){}
        }
    }

//======================================================================================================================
//======================================================================================================================
    @Dado("^que Juan un desarrollador con cuatro o menos tareas$")
    public void que_un_desarrollador_con_o_menos_tareas() throws Throwable {
        Boolean juanIsDisponible = proyecto.tieneDesarrolladorMasDeCuatroTareas("Juan");
        assertTrue(juanIsDisponible);
    }

    @Cuando("^le asigno una tarea a Juan$")
    public void le_asigno_una_tarea_para_juan() throws Throwable {
        proyecto.asignarTarea("Tarea4","Juan");
    }

    @Entonces("^la tarea es asignada$")
    public void la_tarea_es_asignada() throws Throwable {
    }
//======================================================================================================================
//======================================================================================================================
    @Dado("^que Pedro un desarrollador con mas de (\\d+) tareas$")
    public void que_un_desarrollador_con_tareas(int arg1) throws Throwable {
        Boolean pedroIsDisponible = proyecto.tieneDesarrolladorMasDeCuatroTareas("Pedro");
        assertFalse(pedroIsDisponible);
    }


    @Cuando("^le asigno una tarea a Pedro$")
    public void le_asigno_una_tarea_para_pedro() throws Throwable {
        boolean asignada;
        try {
                proyecto.asignarTarea("Tarea8", "Pedro");
                asignada = true;
        }catch(Exception ex){asignada = false;}
        assertFalse(asignada);
    }

    @Entonces("^la tarea no es asignada$")
    public void la_tarea_no_es_asignada() throws Throwable {
    }
//======================================================================================================================
//======================================================================================================================
}
