package com.zekerijah.fleetmanagement.service;

import com.zekerijah.fleetmanagement.model.Client;
import com.zekerijah.fleetmanagement.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAllClients(){
        return clientRepository.findAll();
    }

    public Client save(Client client){
        return clientRepository.save(client);
    }

    public Optional<Client> getById(int id){
        return clientRepository.findById(id);
    }

    public void delete(int id){
        clientRepository.deleteById(id);
    }
}
