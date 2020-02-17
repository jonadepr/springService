package com.jnavarro.springservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    @GetMapping("/time") // escucho al GET en /time
    @ResponseBody // haré un body html para devolver bien
    public String holaMundo() {
        return "Hola";
    }

}