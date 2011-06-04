package ar.com.pattern.creacional.factory.abstrac;

import java.util.Date;

//La clase que se da la hora en formato AM/PM:
class RelojAmPm extends Reloj {

	public String dameLaHora() {
        Date d = new Date();
        int hora = d.getHours();
        int minutos = d.getMinutes();
        int segundos = d.getSeconds();
        String tr;
        if (hora == 12){
            tr="Son las "+hora+":"+minutos+":"+segundos+" AM";
        } else {
            tr="Son las "+(hora-12)+":"+minutos+":"+segundos+" PM";
        }
        return tr;
    }
}