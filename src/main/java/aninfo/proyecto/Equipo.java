package aninfo.proyecto;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by christian on 5/27/17.
 */
public class Equipo {

    private List<Desarrollador> desarrolladores;

    public Equipo(List<Desarrollador> desarrolladores) {
        this.desarrolladores = desarrolladores;
    }

    public Boolean isEmpty(){
        return desarrolladores.isEmpty();
    }

    public List<Desarrollador> desarrolladoresConCuatroOMenosTareas(){
        return desarrolladores.stream()
                        .filter(d -> d.cantidadDeTareasAsignadas() <= 4)
                        .collect(Collectors.toList());
    }

    public List<Desarrollador> getDesarrolladores() {
        return desarrolladores;
    }
}
