package com.mycompany.myproject.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user")
@RequestMapping("/management")
public class ManagerController {

    @GetMapping(value = "/managerLink")
    public String goManagerPage(
    ) {


        return "managerPage";
    }


    @GetMapping(value = "/addTrainLink")
    public String addTrain(
    ) {


        return "mAddTrainPage";
    }

    @GetMapping(value = "/addStationLink")
    public String addStation(
    ) {


        return "mAddStationPage";
    }

    @GetMapping(value = "/getReservesLink")
    public String getReserves(
    ) {


        return "mGetReservePage";
    }

    @GetMapping(value = "/getTrainsLink")
    public String getTrains(
    ) {


        return "mGetTrainsPage";
    }

}
