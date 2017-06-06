package aninfo.proyecto;

import aninfo.Ticket;
import aninfo.proyecto.exceptions.*;
import aninfo.proyecto.fase.Fase;
import aninfo.tarea.Tarea;
import aninfo.tarea.exception.TareaException;
import util.Lapso;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * Created by christian on 5/26/17.
 */
public class Proyecto {

    private Lapso lapso;
    private Double presupuesto;
    private Equipo equipo;
    private List<Tarea> tareas;

    public Proyecto(Lapso lapso, Double presupuesto) {
        this.lapso = lapso;
        this.presupuesto = presupuesto;
        this.tareas = new LinkedList<>();
    }

    public Integer cantidadDeTareasAsignadas() {
        return equipo.getDesarrolladores().stream()
                .mapToInt(Desarrollador::cantidadDeTareasAsignadas)
                .sum();
    }

    public Integer cantidadDeTareas(){
        return tareas.size();
    }

    public void agregarTarea(Tarea unaTarea) {
        this.tareas.add(unaTarea);
    }

    public void asignarTarea(String idDeTarea, String nombreDelDesarrollador) throws ProyectoException {
       if(equipo == null) throw new ProyectoSinEquipoException();

       Tarea tarea = buscarTarea(idDeTarea);
       Desarrollador dev = buscarDesarrollador(nombreDelDesarrollador);
       if(dev.hasTarea(tarea)) throw new TareaYaAsignadaException();
       if(!dev.tieneMasDe4Tareas()){
           dev.asignar(tarea);
       }else{
           throw new DesarrolladorConMasDeCuatroTareasException();
       }
    }

    public Tarea asignarMotivoATarea(String idDeTarea,String motivo) throws ProyectoException {
        Tarea tarea = buscarTarea(idDeTarea);
        tarea.setMotivo(motivo);

        return tarea;
    }

    public Tarea asignarFaseATarea(String idDeTarea,Fase fase) throws ProyectoException,TareaException {
        Tarea tarea = buscarTarea(idDeTarea);
        tarea.setFase(fase);

        return tarea;
    }

    public Tarea asignarPrioridadATarea(String idDeTarea,int prioridad) throws ProyectoException,TareaException {
        Tarea tarea = buscarTarea(idDeTarea);
        tarea.setPrioridad(prioridad);

        return tarea;
    }

    public Tarea asignarHorasATarea(String idDeTarea,Integer horas) throws ProyectoException, TareaException {
        Tarea tarea = buscarTarea(idDeTarea);
        tarea.setHoras(horas);

        return tarea;
    }

    public Ticket vincularTicketATarea(String idDeTarea, Ticket unTicket) throws ProyectoException{
        Tarea tarea = buscarTarea(idDeTarea);
        tarea.addTicket(unTicket);
        unTicket.setTarea(tarea);

        return unTicket;
    }


    public Boolean tieneDesarrolladoresDisponibles(){

        return equipo.desarrolladoresConCuatroOMenosTareas().size() != 0;
    }

    public Boolean tieneDesarrolladorMasDeCuatroTareas(String nombreDelDesarrollador) throws ProyectoSinEquipoException {
        if(equipo == null) throw new ProyectoSinEquipoException();

        return equipo.desarrolladoresConCuatroOMenosTareas().stream()
                .anyMatch(d -> d.getNombre().equals(nombreDelDesarrollador));
    }

    public void asignar(Equipo equipo) {
        this.equipo = equipo;
    }

    private Desarrollador buscarDesarrollador(String nombreDelDesarrollador) throws ProyectoException {
        Optional<Desarrollador> optDev = equipo.getDesarrolladores().stream()
                .filter(d -> d.getNombre().equals(nombreDelDesarrollador)).findFirst();

        if(optDev.isPresent()) {
            return optDev.get();
        }else {
            throw new DesarrolladorInexistenteException();
        }
    }

    private Tarea buscarTarea(String idDeTarea) throws ProyectoException {
        Optional<Tarea> optTarea =  this.tareas.stream().filter(t -> t.getId().equals(idDeTarea)).findFirst();

        if(optTarea.isPresent()){
           return optTarea.get();
        }else{
            throw new TareaInexistenteException();
        }
    }
}
