package com.jnavarro.springservice.service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

/**
 * TimeServiceImpl
 */

@Service
@RequestScope // Existirá uno por llamada (request), cambiamos el ámbito de aplicación, en
              // general serán sin esto (Singleton)
public class TimeServiceImpl implements TimeService {

    private Calendar c;

    @Override
    public String time() { // Singleton se crea al arrancar el sistema
        Calendar c2 = new GregorianCalendar(); // Creo una nueva fecha y la imprimo abajo con c2.getTime...
        return "Compilado a: "+c.getTime().toString()+". " + " Ejecutado a: " + c2.getTime().toString(); // El servicio está activo y crea c2 al tiempo que
                                                                  // actualiza la página, por cada petición uno nuevo
    } 

    public TimeServiceImpl() {
        c = new GregorianCalendar(); //c se coge en tiempo de compilación y no de ejecución, 
        // lo crea y lo deja CREADO el singleton
    }

    @Override
    public String edad(Integer aday, Integer amonth, Integer ayear) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Le doy el formato habitual de la fecha dd/MM/aaaa
        String fechaNacString = aday+"/"+amonth+"/"+ayear; // Creo la fecha de nacimiento
        LocalDate fechaNac = LocalDate.parse(fechaNacString, formato); // Asigno la fecha de nacimiento a LocalDate fechaNac
        LocalDate ahora = LocalDate.now(); // Consigo la fecha actual
        Period periodo = Period.between(fechaNac, ahora); // Calculo el periodo entre las dos fechas y abajo recupero por año, mes y dias
        return "Tu edad es: "+periodo.getYears()+" anyos, "+periodo.getMonths()+" meses y "+periodo.getDays()+" dias"; 
    }
}