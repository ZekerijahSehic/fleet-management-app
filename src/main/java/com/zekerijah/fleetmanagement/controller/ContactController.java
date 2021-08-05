package com.zekerijah.fleetmanagement.controller;

import com.zekerijah.fleetmanagement.model.Contact;
import com.zekerijah.fleetmanagement.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping("/contacts")
    public String getContacts(Model model) {
        List<Contact> contactList = contactService.getAllContacts();
        model.addAttribute("contacts", contactList);
        return "contact";
    }

    @PostMapping("/contacts/addnew")
    public String saveContact(Contact contact){
        contactService.save(contact);
        return "redirect:/contacts";
    }

    @RequestMapping("/contacts/findById")
    @ResponseBody
    public Optional<Contact> findById(int id){
        return contactService.getById(id);
    }

    @RequestMapping(value = "/contacts/update", method = {RequestMethod.GET, RequestMethod.PUT})
    public String update(Contact contact){
        contactService.save(contact);
        return "redirect:/contacts";
    }

    @RequestMapping(value = "/contacts/delete", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String delete(int id){
        contactService.delete(id);
        return "redirect:/contacts";
    }
}
