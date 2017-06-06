package fiuba;

import aninfo.proyecto.Proyecto;
import aninfo.tarea.Tarea;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import util.Lapso;

import static org.junit.Assert.*;

/**
 * Created by christian on 6/2/17.
 */
public class DEIM14Steps {

    private Tarea tarea;
    private final static int PRIORIDAD_INVALIDA = 5;
    private Proyecto proyecto;

    @Before
    public void initialize(){
        proyecto = new Proyecto(new Lapso(10),1000.0);
    }

//======================================================================================================================
//======================================================================================================================
    @Dado("^que se crea una tareaDos$")
    public void que_se_crea_una_tareaDos() throws Throwable {
        tarea = new Tarea("Tarea0",Tarea.PRIORIDAD_BAJA,10 );
        proyecto.agregarTarea(tarea);
    }

    @Cuando("^la priorizo con prioridad ALTA$")
    public void la_priorizo_con_prioridad_ALTA() throws Throwable {
       tarea = proyecto.asignarPrioridadATarea("Tarea0",Tarea.PRIORIDAD_ALTA);
    }

    @Entonces("^la tarea queda priorizada con prioridad ALTA$")
    public void la_tarea_queda_priorizada_con_prioridad_ALTA() throws Throwable {
        int prioridad = tarea.getPrioridad();
        assertEquals(prioridad,Tarea.PRIORIDAD_ALTA);
    }
//======================================================================================================================
//======================================================================================================================
    @Dado("^que se crea una tareaTres$")
    public void que_se_crea_una_tareaTres() throws Throwable {
        tarea = new Tarea("Tarea1",Tarea.PRIORIDAD_BAJA,10 );
        proyecto.agregarTarea(tarea);
    }

    @Cuando("^la priorizo con prioridad INVALIDA$")
    public void la_priorizo_con_prioridad_INEXISTENTE() throws Throwable {
        try {
            tarea = proyecto.asignarPrioridadATarea("Tarea1",PRIORIDAD_INVALIDA);
        }catch(Exception ignored){}
    }

    @Cuando("^la tarea no queda priorizada con esa prioridad INVALIDA$")
    public void la_tarea_no_queda_priorizada_con_esa_prioridad_INEXISTENTE() throws Throwable {
        Integer prioridad = Tarea.PRIORIDAD_BAJA;
        assertEquals(tarea.getPrioridad(),prioridad);
    }
//======================================================================================================================
//======================================================================================================================
}
