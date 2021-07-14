package com.zekerijah.fleetmanagement.service;

import com.zekerijah.fleetmanagement.model.VehicleMake;
import com.zekerijah.fleetmanagement.repository.VehicleMakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class VehicleMakeService {

    @Autowired
    private VehicleMakeRepository vehicleMakeRepository;

    public List<VehicleMake> getAllVehicleMake(){
        return vehicleMakeRepository.findAll();
    }

    public VehicleMake save(VehicleMake vehicleMake){
        return vehicleMakeRepository.save(vehicleMake);
    }

    public Optional<VehicleMake> findById(int id){
        return vehicleMakeRepository.findById(id);
    }

    public void delete(int id){
        vehicleMakeRepository.deleteById(id);
    }
}
