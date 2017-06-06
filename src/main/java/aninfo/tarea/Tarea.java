package aninfo.tarea;

import aninfo.Ticket;
import aninfo.proyecto.fase.Fase;
import aninfo.tarea.exception.EstimacionNegativaException;
import aninfo.tarea.exception.PrioridadInvalidaException;
import aninfo.tarea.exception.TicketInexistenteException;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * Created by christian on 5/27/17.
 */
public class Tarea {

    public static final int PRIORIDAD_BAJA = 0;
    public static final int PRIORIDAD_MEDIA = 1;
    public static final int PRIORIDAD_ALTA = 2;

    private List<Ticket> tickets;

    private String id;
    private String motivo;
    private Integer prioridad;
    private Integer horas;

    private Fase fase;

    public Tarea(String id, Integer prioridad, Integer horas) {
        this.id = id;
        this.horas = horas;
        this.tickets = new LinkedList<>();
        if(prioridad > 2 || prioridad < 0) prioridad = PRIORIDAD_ALTA;
        else this.prioridad = prioridad;
    }

    public String getId() {
        return id;
    }

    public String getMotivo() {
        return motivo;
    }

    public Integer getPrioridad() {
        return prioridad;
    }


    public void setPrioridad(Integer prioridad) throws  PrioridadInvalidaException{
        if(prioridad > 2 || prioridad < 0) throw new PrioridadInvalidaException();
        else this.prioridad = prioridad;
    }

    public void setHoras(Integer horas) throws EstimacionNegativaException{
       if(horas < 0){
           throw new EstimacionNegativaException();
       }
        this.horas = horas;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Integer getHoras() {
        return horas;
    }

    public void addTicket(Ticket t){
        this.tickets.add(t);
    }

    public Ticket buscarTicket(String id) throws TicketInexistenteException{
        Optional<Ticket> optTicket = tickets.stream().filter(t -> t.getId().equals(id)).findFirst();

        if(optTicket.isPresent()){
            return optTicket.get();
        }else{
            throw new TicketInexistenteException();
        }
    }

    public void setFase(Fase fase) {
        this.fase = fase;
    }

    public Fase getFase() {
        return fase;
    }
}
