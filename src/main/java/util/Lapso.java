package util;

import java.util.Date;

/**
 * Created by christian on 5/26/17.
 */
public class Lapso {

    private Integer horasAsignadas;
    private Integer horasTrabajadas = 0;

    public Lapso(Integer horas) {
        horasAsignadas = horas;
    }

    public void consumir(Integer horas){
        horasTrabajadas += horas;
        horasAsignadas -= horas;
    }

    public Integer horasRestantes(){
        return horasAsignadas;
    }

    private Integer horasTrabajadas(){
        return horasTrabajadas;
    }
}
