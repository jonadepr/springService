package com.jnavarro.springservice.service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

/**
 * TimeServiceImpl
 */

@Service
@RequestScope // Existirá uno por llamada (request), cambiamos el ámbito de aplicación, en general serán sin esto (Singleton)
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
        Date birthDate = new Date(ayear, amonth, aday);
        //create calendar object for birth day
        Calendar birthDay = Calendar.getInstance();
        birthDay.setTimeInMillis(birthDate.getTime());

        //create calendar object for current day
        long currentTime = System.currentTimeMillis();
        Calendar now = Calendar.getInstance();
        now.setTimeInMillis(currentTime);

        //Get difference between years
        int years = now.get(Calendar.YEAR) - birthDay.get(Calendar.YEAR);
        int currMonth = now.get(Calendar.MONTH) + 1;
        int birthMonth = birthDay.get(Calendar.MONTH) + 1;

        //Get difference between months
        int months = currMonth - birthMonth;

        //if month difference is in negative then reduce years by one 
        //and calculate the number of months.
        if (months < 0)
        {
        years--;
        months = 12 - birthMonth + currMonth;
        if (now.get(Calendar.DATE) < birthDay.get(Calendar.DATE))
            months--;
        } else if (months == 0 && now.get(Calendar.DATE) < birthDay.get(Calendar.DATE))
        {
        years--;
        months = 11;
        }
        int days;
        //Calculate the days
        if (now.get(Calendar.DATE) > birthDay.get(Calendar.DATE))
        days = now.get(Calendar.DATE) - birthDay.get(Calendar.DATE);
        else if (now.get(Calendar.DATE) < birthDay.get(Calendar.DATE))
        {
        int today = now.get(Calendar.DAY_OF_MONTH);
        now.add(Calendar.MONTH, -1);
        days = now.getActualMaximum(Calendar.DAY_OF_MONTH) - birthDay.get(Calendar.DAY_OF_MONTH) + today;
        } 
        else
        {
        days = 0;
        if (months == 12)
        {
            years++;
            months = 0;
        }
        }
        //Create new Age object 
        return "Tienes, dias: "+days+" meses: "+months+" anyos: "+ years;
            
    }
}