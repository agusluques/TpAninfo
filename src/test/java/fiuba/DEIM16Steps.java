package fiuba;

import aninfo.Ticket;
import aninfo.tarea.Tarea;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;

import java.util.Optional;

import static org.junit.Assert.*;

/**
 * Created by christian on 6/2/17.
 */
public class DEIM16Steps {

    private Ticket ticket;
    private Tarea tarea;

    @Dado("^una tarea$")
    public void una_tarea() throws Throwable {
        tarea = new Tarea("Tarea0",Tarea.PRIORIDAD_ALTA,10);
    }

    @Dado("^un ticket$")
    public void un_ticket() throws Throwable {
        ticket = new Ticket("Ticket0","Ticket descripcion");
    }

    @Cuando("^vinculo el ticket con la tarea$")
    public void vinculo_el_ticket_con_la_tarea() throws Throwable {
        ticket.setTarea(tarea);
        tarea.addTicket(ticket);
    }

    @Entonces("^quedan viculados entre si$")
    public void quedan_viculados_entre_si() throws Throwable {
        Optional<Ticket> optTicketDeTarea = tarea.buscarTicket("Ticket0");
        if(optTicketDeTarea.isPresent()){
            Ticket ticketDeTarea = optTicketDeTarea.get();
            Tarea tareaDeTicket = ticket.getTarea();

            assertEquals(tareaDeTicket.getId(),tarea.getId());
            assertEquals(ticketDeTarea.getId(),ticket.getId());
        }else{
           throw new Throwable();
        }
    }
}
