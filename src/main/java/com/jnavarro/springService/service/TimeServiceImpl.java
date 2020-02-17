package com.jnavarro.springservice.service;

import java.util.Calendar;
import java.util.GregorianCalendar;
import org.springframework.stereotype.Service;

/**
 * HelloServiceImpl
 */

@Service
public class TimeServiceImpl implements TimeService {

    private String timeinicial;

    @Override
    public String time() {
        Calendar c2 = new GregorianCalendar();
        return timeinicial + " Ejecutado a: " + c2.getTime().toString(); // El servicio está activo y crea c2 al tiempo que
                                                                  // actualiza la página
    }

    public TimeServiceImpl() {
        Calendar c = new GregorianCalendar();
        timeinicial = "Compilado a: "+c.getTime().toString()+". "; //c se coge en tiempo de compilación y no de ejecución
    }
}