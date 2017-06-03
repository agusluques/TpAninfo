package fiuba;

import aninfo.tarea.Tarea;
import cucumber.api.PendingException;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import org.junit.Assert.*;

import static org.junit.Assert.*;

/**
 * Created by christian on 6/2/17.
 */
public class DEIM15Steps {

    private Tarea tarea;

    @Dado("^se crea una tareaCuatro$")
    public void se_crea_una_tareaCuatro() throws Throwable {
        tarea = new Tarea("Tarea0",Tarea.PRIORIDAD_BAJA,10 );
    }

    @Cuando("^le asigno una cantidad de horas positivas$")
    public void le_asigno_una_cantidad_de_horas_positivas() throws Throwable {
        tarea.setHoras(20);
    }

    @Entonces("^la tarea queda asignada con esas horas$")
    public void la_tarea_queda_asignada_con_esas_horas() throws Throwable {
       assertEquals(new Integer(20),tarea.getHoras());
    }

    @Dado("^se crea una tareaCinco$")
    public void se_crea_una_tareaCinco() throws Throwable {
        tarea = new Tarea("Tarea0",Tarea.PRIORIDAD_BAJA,30 );
    }

    @Cuando("^le asigno una cantidad de horas negativa$")
    public void vinculo_le_asigno_una_cantidad_de_horas_negativa() throws Throwable {
       try {
           tarea.setHoras(-25);
       }catch(Exception ex){}
    }

    @Entonces("^la tarea no queda asignada con esas horas$")
    public void la_tarea_no_queda_asignada_con_esas_horas() throws Throwable {
        assertEquals(new Integer(30),tarea.getHoras());
    }

}
