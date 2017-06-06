package fiuba;

import aninfo.Ticket;
import aninfo.proyecto.Proyecto;
import aninfo.tarea.Tarea;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import util.Lapso;

import java.util.Optional;

import static org.junit.Assert.*;

/**
 * Created by christian on 6/2/17.
 */
public class DEIM16Steps {

    private Proyecto proyecto;
    private Ticket ticket;
    private Tarea tarea;

    @Before
    public void initialize(){
        proyecto = new Proyecto(new Lapso(10),1000.0);
    }

    @Dado("^una tarea$")
    public void una_tarea() throws Throwable {
        tarea = new Tarea("Tarea0",Tarea.PRIORIDAD_ALTA,10);
        proyecto.agregarTarea(tarea);
    }

    @Dado("^un ticket$")
    public void un_ticket() throws Throwable {
        ticket = new Ticket("Ticket0","Ticket descripcion");
    }

    @Cuando("^vinculo el ticket con la tarea$")
    public void vinculo_el_ticket_con_la_tarea() throws Throwable {
        ticket = proyecto.vincularTicketATarea("Tarea0",ticket);
    }

    @Entonces("^quedan viculados entre si$")
    public void quedan_viculados_entre_si() throws Throwable {
        Ticket ticketDeTarea = tarea.buscarTicket("Ticket0");
        Tarea tareaDeTicket = ticket.getTarea();

        assertEquals(tareaDeTicket.getId(),tarea.getId());
        assertEquals(ticketDeTarea.getId(),ticket.getId());
    }
}
