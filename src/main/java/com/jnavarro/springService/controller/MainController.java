package com.jnavarro.springservice.controller;

import com.jnavarro.springservice.service.HelloService;
import com.jnavarro.springservice.service.TimeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


// El controlador no hará demasiado, en este caso la calculadora debería estar en un servicio, que es la 
// lógica de negocio, controlador recupera el /time y hace lo necesario
// El servicio es una interfaz, en un momento dado podré tener servicesImplement1, servicesImplement2, 
// servicesImplement3 y desde el application.properties se puede decir qué implementación usar.
// servicios para interacción con el ERP.
@Controller
public class MainController {

    // Coger el servicio creado por spring
    @Autowired
    private HelloService helloService;

    @Autowired 
    private TimeService timeService;

    @GetMapping("/time") // escucho al GET en /time
    @ResponseBody // haré un body html para devolver la página completa
    public String hello() { // método para devolver un string para responsebody
        return helloService.hola();
    }

    @GetMapping("/timesingle") // escucho al GET en /timesingle
    @ResponseBody // haré un body html para devolverlo bien
    public String timesingle() { // método para devolver un string para responsebody
        return timeService.time();
    }

}