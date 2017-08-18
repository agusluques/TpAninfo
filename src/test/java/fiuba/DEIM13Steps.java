package fiuba;

import aninfo.proyecto.Proyecto;
import aninfo.tarea.Tarea;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import org.junit.Assert;
import util.Lapso;

/**
 * Created by christian on 6/2/17.
 */
public class DEIM13Steps {

    private Tarea tarea;
    private String unMotivo = "unMotivo";
    private Boolean assertion;
    private Proyecto proyecto;

    @Before
    public void initialize(){
        proyecto = new Proyecto(new Lapso(10),1000.0);
    }

//======================================================================================================================
//======================================================================================================================
    @Dado("^que se crea una tarea$")
    public void se_crea_una_tarea() throws Throwable {
        tarea = new Tarea("Tarea0",Tarea.PRIORIDAD_MEDIA,10 );
        proyecto.agregarTarea(tarea);
    }

    @Cuando("^le asigno un motivo$")
    public void le_asigno_un_motivo() throws Throwable {
        tarea = proyecto.asignarMotivoATarea("Tarea0", unMotivo);
    }

    @Cuando("^determino su motivo$")
    public void determino_su_motivo() throws Throwable {
        assertion = tarea.getMotivo().equals(unMotivo);
    }

    @Entonces("^la tarea tiene el motivo asignado$")
    public void la_tarea_tiene_el_motivo_asignado() throws Throwable {
        Assert.assertTrue(assertion);
    }
//======================================================================================================================
//======================================================================================================================
}
