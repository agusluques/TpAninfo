package aninfo;

/**
 * Created by christian on 5/27/17.
 */
public class Tarea {

    public static final int PRIORIDAD_BAJA = 0;
    public static final int PRIORIDAD_MEDIA = 1;
    public static final int PRIORIDAD_ALTA = 2;

    private String motivo;
    private Integer prioridad;

    public Tarea(String motivo, Integer prioridad) {
        this.motivo = motivo;
        this.prioridad = prioridad;
    }


}
