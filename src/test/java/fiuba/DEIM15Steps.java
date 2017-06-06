package fiuba;

import aninfo.proyecto.Proyecto;
import aninfo.tarea.Tarea;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import org.junit.Assert.*;
import util.Lapso;

import static org.junit.Assert.*;

/**
 * Created by christian on 6/2/17.
 */
public class DEIM15Steps {

    private Tarea tarea;
    private Proyecto proyecto;

    @Before
    public void initialize(){
        proyecto = new Proyecto(new Lapso(10),1000.0);
    }
//======================================================================================================================
//======================================================================================================================
    @Dado("^se crea una tareaCuatro$")
    public void se_crea_una_tareaCuatro() throws Throwable {
        tarea = new Tarea("Tarea0",Tarea.PRIORIDAD_BAJA,10 );
        proyecto.agregarTarea(tarea);
    }

    @Cuando("^le asigno una cantidad de horas positivas$")
    public void le_asigno_una_cantidad_de_horas_positivas() throws Throwable {
        tarea = proyecto.asignarHorasATarea("Tarea0",20);
    }

    @Entonces("^la tarea queda asignada con esas horas$")
    public void la_tarea_queda_asignada_con_esas_horas() throws Throwable {
       assertEquals(new Integer(20),tarea.getHoras());
    }
//======================================================================================================================
//======================================================================================================================
    @Dado("^se crea una tareaCinco$")
    public void se_crea_una_tareaCinco() throws Throwable {
        tarea = new Tarea("Tarea0",Tarea.PRIORIDAD_BAJA,30 );
        proyecto.agregarTarea(tarea);
    }

    @Cuando("^le asigno una cantidad de horas negativa$")
    public void vinculo_le_asigno_una_cantidad_de_horas_negativa() throws Throwable {
       try {
           tarea = proyecto.asignarHorasATarea("Tarea0",-25);
       }catch(Exception ignored){}
    }

    @Entonces("^la tarea no queda asignada con esas horas$")
    public void la_tarea_no_queda_asignada_con_esas_horas() throws Throwable {
        assertEquals(new Integer(30),tarea.getHoras());
    }
//======================================================================================================================
//======================================================================================================================
}
