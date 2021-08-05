package com.zekerijah.fleetmanagement.service;

import com.zekerijah.fleetmanagement.model.Contact;
import com.zekerijah.fleetmanagement.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    public void save(Contact contact) {
        contactRepository.save(contact);
    }

    public Optional<Contact> getById(int id){
        return contactRepository.findById(id);
    }

    public void delete(int id) {
        contactRepository.deleteById(id);
    }
}
