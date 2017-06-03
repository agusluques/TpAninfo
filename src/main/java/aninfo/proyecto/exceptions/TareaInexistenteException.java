package aninfo.proyecto.exceptions;

/**
 * Created by christian on 6/2/17.
 */
public class TareaInexistenteException extends ProyectoException{

    @Override
    public String getMessage() {
        return "La tarea no existe en este proyecto";
    }
}
