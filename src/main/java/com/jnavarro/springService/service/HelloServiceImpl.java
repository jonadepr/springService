package com.jnavarro.springservice.service;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * HelloServiceImpl
 */

@Service
public class HelloServiceImpl implements HelloService{

    @Value(value = "${mi.nombre}")
    private String miNombre;

    private String saludo;

    @Override
    public String hola() {
        Calendar c2 = new GregorianCalendar();
        return saludo + miNombre + " " + c2.getTime().toString(); // El servicio está activo y crea c2 al tiempo que actualiza la página
    }

    public HelloServiceImpl() {
        Calendar c = new GregorianCalendar();
        saludo = "Hola holita "+c.getTime().toString()+" "; //c se coge en tiempo de compilación y no de ejecución
    }
}