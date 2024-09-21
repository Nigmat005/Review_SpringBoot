package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/car")
public class CarController {
    @GetMapping("/carInfo") //localhost8080:/car/carInfo?make=Audi&carModel=Q7&Year=2022
    public String getCarInfo(@RequestParam String make,
                             @RequestParam String carModel,
                             @RequestParam int year,
                             @RequestParam int drivenYear,
                             Model model){
       // @RequestParam will help you bring data in http request back to method
        // Now we use data brought back from http request to render car.html

        model.addAttribute("carMake", make);
        model.addAttribute("carModel", carModel);
        model.addAttribute("year", year);
        model.addAttribute("drivenYear", drivenYear);

        System.out.printf("car make is %2$s, car model is %s, car made year is %3$d and has been driven for %4$d year(s) ",carModel,make,year,drivenYear);
        return "/car/car";
    }
}
