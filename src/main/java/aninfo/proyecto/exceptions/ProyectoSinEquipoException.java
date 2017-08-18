package aninfo.proyecto.exceptions;

/**
 * Created by christian on 6/2/17.
 */
public class ProyectoSinEquipoException extends ProyectoException{
    @Override
    public String getMessage() {
        return "El proyecto no tiene un equipo asignado";
    }
}
