package com.zekerijah.fleetmanagement.service;

import com.zekerijah.fleetmanagement.model.VehicleType;
import com.zekerijah.fleetmanagement.repository.VehicleTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class VehicleTypeService {

    @Autowired
    private VehicleTypeRepository vehicleTypeRepository;

    public List<VehicleType> getAllVehicleType(){
        return vehicleTypeRepository.findAll();
    }

    public VehicleType save(VehicleType vehicleType){
        return vehicleTypeRepository.save(vehicleType);
    }

    public Optional<VehicleType> findById(int id){
        return vehicleTypeRepository.findById(id);
    }

    public void delete(int id){
        vehicleTypeRepository.deleteById(id);
    }
}
