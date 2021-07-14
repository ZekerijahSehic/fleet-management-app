package com.zekerijah.fleetmanagement.controller;

import com.zekerijah.fleetmanagement.model.Country;
import com.zekerijah.fleetmanagement.model.State;
import com.zekerijah.fleetmanagement.model.JobTitle;
import com.zekerijah.fleetmanagement.service.CountryService;
import com.zekerijah.fleetmanagement.service.StateService;
import com.zekerijah.fleetmanagement.service.JobTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class JobTitleController {

    @Autowired
    private JobTitleService jobTitleService;

    @GetMapping("/job-title")
    public String getLoacations(Model model){
        List<JobTitle> jobTitleList = jobTitleService.getAllJobTitle();
        model.addAttribute("jobTitleList", jobTitleList);
        return "job-title";
    }

    @PostMapping("/job-title/addnew")
    public String addNew(JobTitle jobTitle){
        jobTitleService.save(jobTitle);
        return "redirect:/job-title";
    }

    @RequestMapping("/job-title/findById")
    @ResponseBody
    public Optional<JobTitle> findJobTitleById(Integer id){
        return jobTitleService.findById(id);
    }

    @RequestMapping(value = "/job-title/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateJobTitle(JobTitle jobTitle){
        jobTitleService.save(jobTitle);
        return "redirect:/job-title";
    }

    @RequestMapping(value = "/job-title/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteJobTitle(Integer id){
        jobTitleService.delte(id);
        return "redirect:/job-title";
    }
}

