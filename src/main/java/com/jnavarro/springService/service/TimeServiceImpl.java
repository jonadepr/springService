package com.jnavarro.springservice.service;

import java.util.Calendar;
import java.util.GregorianCalendar;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

/**
 * HelloServiceImpl
 */

@Service
@RequestScope // Existirá uno por llamada (request), cambiamos el ámbito de aplicación, sin esto es más rápido
public class TimeServiceImpl implements TimeService {

    private Calendar c;

    @Override
    public String time() { // Singleton se crea al lebantar el sistema
        Calendar c2 = new GregorianCalendar(); // Creo una nueva fecha y la imprimo abajo con c2.getTime...
        return "Compilado a: "+c.getTime().toString()+". " + " Ejecutado a: " + c2.getTime().toString(); // El servicio está activo y crea c2 al tiempo que
                                                                  // actualiza la página, por cada petición uno nuevo
    } 

    public TimeServiceImpl() {
        c = new GregorianCalendar(); //c se coge en tiempo de compilación y no de ejecución, 
        // lo crea y lo deja CREADO el singleton
    }
}