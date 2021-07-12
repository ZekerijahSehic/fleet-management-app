package com.zekerijah.fleetmanagement.service;

import com.zekerijah.fleetmanagement.model.State;
import com.zekerijah.fleetmanagement.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StateService {

    @Autowired
    private StateRepository stateRepository;

    public List<State> getListState() {
        return stateRepository.findAll();
    }

    public State saveState(State state){
        return stateRepository.save(state);
    }

    public Optional<State> findById(int id) {
        return stateRepository.findById(id);
    }

    public void delete(Integer id) {
        stateRepository.deleteById(id);
    }
}
