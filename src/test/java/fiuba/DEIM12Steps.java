package fiuba;

import aninfo.proyecto.Desarrollador;
import aninfo.proyecto.Equipo;
import aninfo.proyecto.Proyecto;
import aninfo.proyecto.exceptions.DesarrolladorInexistenteException;
import aninfo.proyecto.exceptions.ProyectoException;
import aninfo.proyecto.exceptions.TareaInexistenteException;
import aninfo.tarea.Tarea;
import aninfo.tarea.exception.TareaException;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import org.junit.Assert;
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
        Desarrollador martin = new Desarrollador("Martin");
        List<Desarrollador> desarrolladores = new ArrayList<>();
        desarrolladores.add(juan);
        desarrolladores.add(pedro);
        desarrolladores.add(martin);
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
    @Dado("^que Martin un desarrollador del proyecto$")
    public void que_Martin_un_desarrollador_del_proyecto() throws Throwable {
        Boolean estaMartinEnElProyecto = proyecto.estaDesarrolladorEnElProyecto("Martin");
        Assert.assertTrue(estaMartinEnElProyecto);
    }

    @Cuando("^le asigno una tarea que no es del proyecto a Martin$")
    public void le_asigno_una_tarea_que_no_es_del_proyecto_a_Martin() throws Throwable {
        Boolean asignada;
        try {
            proyecto.asignarTarea("TareaX", "Martin");
            asignada = true;
        }catch(TareaInexistenteException tex){
           asignada = false;
        }
        Assert.assertFalse(asignada);
    }

    @Dado("^que Jose un desarrollador, que no es del proyecto$")
    public void que_Jose_un_desarrollador_que_no_es_del_proyecto() throws Throwable {
        Boolean estaJoseEnElProyecto = proyecto.estaDesarrolladorEnElProyecto("Jose");
        Assert.assertFalse(estaJoseEnElProyecto);
    }

    @Cuando("^le asigno una tarea del proyecto a Jose$")
    public void le_asigno_una_tarea_del_proyecto_a_Jose() throws Throwable {
        Boolean asignada;
        try {
            proyecto.asignarTarea("Tarea0", "Jose");
            asignada = true;
        }catch(DesarrolladorInexistenteException dex){
            asignada = false;
        }
        Assert.assertFalse(asignada);
    }


}
