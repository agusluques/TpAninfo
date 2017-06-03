package fiuba;

import aninfo.tarea.Tarea;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * Created by christian on 6/2/17.
 */
public class DEIM14Steps {

    private Tarea tarea;
    private Integer prioridad = Tarea.PRIORIDAD_ALTA;
    private final static int PRIORIDAD_INVALIDA = 5;
    private Boolean assertion;

//======================================================================================================================
//======================================================================================================================
    @Dado("^que se crea una tareaDos$")
    public void que_se_crea_una_tareaDos() throws Throwable {
        tarea = new Tarea("Tarea0",Tarea.PRIORIDAD_BAJA,10 );
    }

    @Cuando("^la priorizo con prioridad ALTA$")
    public void la_priorizo_con_prioridad_ALTA() throws Throwable {
        tarea.setPrioridad(prioridad);
    }

    @Entonces("^la tarea queda priorizada con prioridad ALTA$")
    public void la_tarea_queda_priorizada_con_prioridad_ALTA() throws Throwable {
       assertEquals(tarea.getPrioridad(),prioridad);
    }
//======================================================================================================================
//======================================================================================================================
    @Dado("^que se crea una tareaTres$")
    public void que_se_crea_una_tareaTres() throws Throwable {
        tarea = new Tarea("Tarea0",Tarea.PRIORIDAD_BAJA,10 );
    }

    @Cuando("^la priorizo con prioridad INVALIDA$")
    public void la_priorizo_con_prioridad_INEXISTENTE() throws Throwable {
        try {
            tarea.setPrioridad(PRIORIDAD_INVALIDA);
        }catch(Exception ignored){}
    }

    @Cuando("^la tarea no queda priorizada con esa prioridad INVALIDA$")
    public void la_tarea_no_queda_priorizada_con_esa_prioridad_INEXISTENTE() throws Throwable {
        Integer p = Tarea.PRIORIDAD_BAJA;
        assertEquals(tarea.getPrioridad(),p);
    }
//======================================================================================================================
//======================================================================================================================
}
