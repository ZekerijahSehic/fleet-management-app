package com.zekerijah.fleetmanagement.service;

import com.zekerijah.fleetmanagement.model.Supplier;
import com.zekerijah.fleetmanagement.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public List<Supplier> getAllSuppliers(){
        return supplierRepository.findAll();
    }

    public void save(Supplier supplier){
        supplierRepository.save(supplier);
    }

    public Optional<Supplier> getById(Integer id){
        return supplierRepository.findById(id);
    }

    public void delete(Integer id){
        supplierRepository.deleteById(id);
    }

}
