package com.test.demos.myfirstcucumbertest.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DateService {

    public String getDayOfTheWeek(Integer month, Integer day, Integer year){

        LocalDate localDate = LocalDate.of(year,month,day);
        return localDate.getDayOfWeek().name();


    }
}
