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

    private Calendar c = new GregorianCalendar();

    @Override
    public String hola() {
        return saludo + miNombre + " " + c.getTime().toString();
    }

    public HelloServiceImpl() {
        
        saludo = "Hola holita "+c.getTime().toString()+" ";
    }
}