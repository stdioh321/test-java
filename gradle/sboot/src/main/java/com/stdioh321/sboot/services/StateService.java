package com.stdioh321.sboot.services;

import com.stdioh321.sboot.entities.h2.State;
import com.stdioh321.sboot.repositories.h2.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class StateService implements GenericService<State> {

    @Autowired
    private StateRepository stateRepository;


    public State getById(String id){
        return stateRepository.findById(id).orElse(null);
    }

    @Override
    public List<State> getAll() {
        return stateRepository.findAll();
    }

    @Override
    public State add(State entity) {
        return stateRepository.saveAndFlush(entity);
    }

    public State delete(String id){
        return null;
    }

    public State put(String id, State state){
        var optState = stateRepository.findById(id);
        if(optState.isEmpty()) throw new EntityNotFoundException();
        state.setId(optState.get().getId());
        var currentState = optState.get();

        currentState.updateOnlyNotNull(state,null);
        return stateRepository.saveAndFlush(currentState);
    }
}
