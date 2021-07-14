package com.zekerijah.fleetmanagement.service;

import com.zekerijah.fleetmanagement.model.VehicleModel;
import com.zekerijah.fleetmanagement.repository.VehicleModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class VehicleModelService {

    @Autowired
    private VehicleModelRepository vehicleModelRepository;

    public List<VehicleModel> getAllVehicleModel(){
        return vehicleModelRepository.findAll();
    }

    public VehicleModel save(VehicleModel vehicleModel){
        return vehicleModelRepository.save(vehicleModel);
    }

    public Optional<VehicleModel> findById(int id){
        return vehicleModelRepository.findById(id);
    }

    public void delete(int id){
        vehicleModelRepository.deleteById(id);
    }
}
