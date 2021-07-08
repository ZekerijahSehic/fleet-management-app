package com.zekerijah.fleetmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StateController {

    @GetMapping("/states")
    public String getClients(){
        return "state";
    }
}
