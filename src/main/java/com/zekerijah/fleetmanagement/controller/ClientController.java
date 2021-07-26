package com.zekerijah.fleetmanagement.controller;

import com.zekerijah.fleetmanagement.model.Client;
import com.zekerijah.fleetmanagement.model.Country;
import com.zekerijah.fleetmanagement.model.State;
import com.zekerijah.fleetmanagement.service.ClientService;
import com.zekerijah.fleetmanagement.service.CountryService;
import com.zekerijah.fleetmanagement.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private CountryService countryService;

    @Autowired
    private StateService stateService;

    @GetMapping("/clients")
    public String getClients(Model model){
        List<Client> clients = clientService.getAllClients();
        model.addAttribute("clients", clients);

        List<Country> countries = countryService.getListCountry();
        model.addAttribute("countries", countries);

        List<State> states = stateService.getListState();
        model.addAttribute("states", states);

        return "client";
    }

    @PostMapping("/clients/addnew")
    public String saveClient(Client client){
        clientService.save(client);
        return "redirect:/clients";
    }

    @RequestMapping("/clients/findById")
    @ResponseBody
    public Optional<Client> findById(int id){
        return clientService.getById(id);
    }

    @RequestMapping(value = "/clients/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Client client){
        clientService.save(client);
        return "redirect:/clients";
    }

    @RequestMapping(value = "/clients/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(int id){
        clientService.delete(id);
        return "redirect:/clients";
    }
}
