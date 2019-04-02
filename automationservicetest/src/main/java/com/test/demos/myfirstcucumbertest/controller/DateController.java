package com.test.demos.myfirstcucumbertest.controller;

import com.test.demos.myfirstcucumbertest.service.DateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DateController {

    @Autowired
    DateService service;

    @GetMapping(value = {"/dayOfTheWeek/{month}/{day}/{year}"})
    public String getDayofWeek(@PathVariable("month") int month, @PathVariable("day") int day,
                               @PathVariable("year") int year){

        return service.getDayOfTheWeek(month,day,year);
    }
}
