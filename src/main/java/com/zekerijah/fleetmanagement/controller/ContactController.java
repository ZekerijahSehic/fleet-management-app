package com.zekerijah.fleetmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactController {

    @GetMapping("/contacts")
    public String getClients(){
        return "contact";
    }
}
