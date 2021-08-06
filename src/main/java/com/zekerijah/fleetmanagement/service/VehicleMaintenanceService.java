package com.zekerijah.fleetmanagement.service;

import com.zekerijah.fleetmanagement.model.VehicleMaintenance;
import com.zekerijah.fleetmanagement.repository.VehicleMaintenanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleMaintenanceService {

    @Autowired
    private VehicleMaintenanceRepository vehicleMaintenanceRepository;

    public List<VehicleMaintenance> getAllVehicleMaintenances(){
        return vehicleMaintenanceRepository.findAll();
    }

    public void save(VehicleMaintenance vehicleMaintenance){
        vehicleMaintenanceRepository.save(vehicleMaintenance);
    }

    public Optional<VehicleMaintenance> getById(int id){
        return vehicleMaintenanceRepository.findById(id);
    }

    public void delete(int id){
        vehicleMaintenanceRepository.deleteById(id);
    }
}
