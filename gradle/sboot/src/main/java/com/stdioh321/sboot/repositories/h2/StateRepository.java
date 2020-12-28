package com.stdioh321.sboot.repositories.h2;


import com.stdioh321.sboot.entities.h2.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository  extends JpaRepository<State, String> {
}
