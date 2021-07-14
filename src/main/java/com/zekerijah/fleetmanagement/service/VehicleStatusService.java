package com.zekerijah.fleetmanagement.service;

import com.zekerijah.fleetmanagement.model.VehicleStatus;
import com.zekerijah.fleetmanagement.repository.VehicleStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class VehicleStatusService {

    @Autowired
    private VehicleStatusRepository vehicleStatusRepository;

    public List<VehicleStatus> getAllVehicleStatus(){
        return vehicleStatusRepository.findAll();
    }

    public VehicleStatus save (VehicleStatus vehicleStatus){
        return vehicleStatusRepository.save(vehicleStatus);
    }

    public Optional<VehicleStatus> getById(int id){
        return vehicleStatusRepository.findById(id);
    }

    public void delete(int id){
        vehicleStatusRepository.deleteById(id);
    }
}
