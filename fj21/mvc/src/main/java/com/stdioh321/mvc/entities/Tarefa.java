package com.stdioh321.mvc.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

public class Tarefa {
	private String id;

	public Tarefa() {
		this.setId("Random");
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Tarefa [id=" + id + "]";
	}

}
