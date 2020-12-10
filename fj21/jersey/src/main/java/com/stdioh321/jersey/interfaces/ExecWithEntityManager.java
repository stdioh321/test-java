package com.stdioh321.jersey.interfaces;

import javax.persistence.EntityManager;

public interface ExecWithEntityManager {
	public void exec(EntityManager em);
}

