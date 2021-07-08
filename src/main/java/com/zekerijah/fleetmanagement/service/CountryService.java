package com.zekerijah.fleetmanagement.service;

import com.zekerijah.fleetmanagement.model.Country;
import com.zekerijah.fleetmanagement.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public List<Country> getListCountry() {
        return countryRepository.findAll();
    }

    public Country saveCountry(Country country){
        return countryRepository.save(country);
    }
}
