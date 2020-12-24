package com.stdioh321.mvc.entities;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Contact {

	private String id;
	private String name;

	@NotNull
	@Size(max = 3)
	private String size;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", name=" + name + ", size=" + size + "]";
	}

}
