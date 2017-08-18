package aninfo.proyecto.exceptions;

/**
 * Created by christian on 6/2/17.
 */
public class TareaYaAsignadaException extends ProyectoException {

    @Override
    public String getMessage() {
        return "El desarrollador ya tiene asignada esa tarea";
    }
}
