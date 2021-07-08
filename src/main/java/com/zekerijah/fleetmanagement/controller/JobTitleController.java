package com.zekerijah.fleetmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JobTitleController {

    @GetMapping("/job-titles")
    public String getJobs(){
        return "job-title";
    }
}
