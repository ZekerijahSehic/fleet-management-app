package com.zekerijah.fleetmanagement.service;

import com.zekerijah.fleetmanagement.model.VehicleHire;
import com.zekerijah.fleetmanagement.repository.VehicleHireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleHireService {

    @Autowired
    private VehicleHireRepository vehicleHireRepository;

    public List<VehicleHire> getAllVehicleHires(){
        return vehicleHireRepository.findAll();
    }

    public VehicleHire save(VehicleHire vehicleHire){
        return vehicleHireRepository.save(vehicleHire);
    }

    public Optional<VehicleHire> getVehicleHireById(int id){
        return vehicleHireRepository.findById(id);
    }

    public void delete(int id){
        vehicleHireRepository.deleteById(id);
    }


}
