package aninfo.proyecto.exceptions;

/**
 * Created by christian on 6/2/17.
 */
public class DesarrolladorInexistenteException extends ProyectoException {

    @Override
    public String getMessage() {
        return "El desarrollador no existe en el equipo de este proyecto";
    }
}
