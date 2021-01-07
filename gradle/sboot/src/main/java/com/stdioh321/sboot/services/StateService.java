package com.stdioh321.sboot.services;

import com.stdioh321.sboot.entities.h2.State;
import com.stdioh321.sboot.repositories.h2.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateService implements GenericService<State> {

    @Autowired
    private StateRepository stateRepository;

    @Override
    public List<State> getAll() {

        return stateRepository.findAll();
    }

    @Override
    public State add(State entity) {
        return stateRepository.saveAndFlush(entity);
    }
}
