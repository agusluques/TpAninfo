package fiuba;

import aninfo.proyecto.Proyecto;
import aninfo.proyecto.fase.FaseDesarrollo;
import aninfo.proyecto.fase.Fase;
import aninfo.proyecto.fase.FaseProduccion;
import aninfo.proyecto.fase.FaseTesting;
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
public class DEIM17Steps {

    private Proyecto proyecto;
    private Fase fase;
    private Tarea tarea;

    @Before
    public void initialize(){
        proyecto = new Proyecto(new Lapso(10),1000.0);
    }
//======================================================================================================================
//======================================================================================================================
    @Dado("^una fase de testing$")
    public void una_fase_de_testing() throws Throwable {
        fase = new FaseTesting();
    }

    @Dado("^una fase de produccion$")
    public void una_fase_de_produccion() throws Throwable {
        fase = new FaseProduccion();
    }

    @Dado("^una tarea para vincular una fase$")
    public void una_tarea_para_vincular_una_fase() throws Throwable {
        Tarea tarea = new Tarea("Tarea0",Tarea.PRIORIDAD_ALTA,10);
        proyecto.agregarTarea(tarea);
    }

    @Dado("^una fase de desarrollo$")
    public void una_fase_de_desarrollo() throws Throwable {
        fase = new FaseDesarrollo();
    }

    @Cuando ("^vinculo la fase con la tarea$")
    public void vinculo_la_fase_con_la_tarea(){
        try {
            tarea = proyecto.asignarFaseATarea("Tarea0", fase);
        }catch(Exception ignored){}
    }
//======================================================================================================================
//======================================================================================================================
    @Entonces("^la tarea queda viculada con la fase de desarrollo$")
    public void la_tarea_queda_viculada_con_la_fase_de_desarrollo() throws Throwable {
        Assert.assertTrue(tarea.getFase() instanceof FaseDesarrollo);
    }
//======================================================================================================================
//======================================================================================================================
    @Entonces("^la tarea queda viculada con la fase de produccion$")
    public void la_tarea_queda_viculada_con_la_fase_de_produccion() throws Throwable {
        Assert.assertTrue(tarea.getFase() instanceof FaseProduccion);
    }
//======================================================================================================================
//======================================================================================================================
    @Entonces("^la tarea queda viculada con la fase de testing$")
    public void la_tarea_queda_viculada_con_la_fase_de_testing() throws Throwable {
        Assert.assertTrue(tarea.getFase() instanceof FaseTesting);
    }
//======================================================================================================================
//======================================================================================================================
}
