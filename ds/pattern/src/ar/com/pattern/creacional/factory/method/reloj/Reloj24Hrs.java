package ar.com.pattern.creacional.factory.method.reloj;

import java.util.Date;

//La que nos da la hora en formato de 24 horas:
public class Reloj24Hrs extends Reloj {
 
    public String dameLaHora() {
        Date d = new Date();
        int hora = d.getHours();
        int minutos = d.getMinutes();
        int segundos = d.getSeconds();
        String tr;
        tr = "Son las " + hora + ":" + minutos + ":" + segundos + " ";
        return tr;
    }
}