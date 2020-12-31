package com.stdioh321.sboot.repositories.mysql;


import com.stdioh321.sboot.entities.mysql.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository  extends JpaRepository<State, String> {
}
