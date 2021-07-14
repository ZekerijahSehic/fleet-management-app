package com.zekerijah.fleetmanagement.service;

import com.zekerijah.fleetmanagement.model.EmployeeType;
import com.zekerijah.fleetmanagement.repository.EmployeeTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeTypeService {

    @Autowired
    private EmployeeTypeRepository employeeTypeRepository;

    public List<EmployeeType> getAllEmployeType(){
        return employeeTypeRepository.findAll();
    }

    public EmployeeType save(EmployeeType employeeType){
        return employeeTypeRepository.save(employeeType);
    }

    public Optional<EmployeeType> findById(Integer id){
        return employeeTypeRepository.findById(id);
    }

    public void delete(int id){
        employeeTypeRepository.deleteById(id);
    }
}
