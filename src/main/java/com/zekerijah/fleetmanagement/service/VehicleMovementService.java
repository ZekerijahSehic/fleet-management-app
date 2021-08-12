package com.zekerijah.fleetmanagement.service;

import com.zekerijah.fleetmanagement.model.VehicleMovement;
import com.zekerijah.fleetmanagement.repository.VehicleMovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleMovementService {

    @Autowired
    private VehicleMovementRepository vehicleMovementRepository;

    public List<VehicleMovement> getAllVehicleMovements(){
        return vehicleMovementRepository.findAll();
    }

    public void save(VehicleMovement vehicleMovement){
        vehicleMovementRepository.save(vehicleMovement);
    }

    public Optional<VehicleMovement> getVehicleMovementById(int id){
        return vehicleMovementRepository.findById(id);
    }

    public void delete(int id){
        vehicleMovementRepository.deleteById(id);
    }
}
