package aninfo;

import aninfo.tarea.Tarea;

/**
 * Created by christian on 6/2/17.
 */
public class Ticket {

    public static final int PRIORIDAD_BAJA = 10;
    public static final int PRIORIDAD_MEDIA = 11;
    public static final int PRIORIDAD_ALTA = 12;

    private String id;
    private String descripcion;
    private int prioridad;

    private Tarea tarea;

    public Ticket(String id,String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
        this.setPrioridad(PRIORIDAD_MEDIA);
    }



    public String getDescripcion() {
        return descripcion;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public Tarea getTarea() {
        return tarea;
    }

    public void setTarea(Tarea tarea) {
        this.tarea = tarea;
    }

    public String getId() {
        return id;
    }
}
