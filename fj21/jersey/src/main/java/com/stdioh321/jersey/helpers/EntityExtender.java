package com.stdioh321.jersey.helpers;

import java.lang.reflect.Field;
import java.util.Objects;

import com.stdioh321.jersey.entities.User;

public interface EntityExtender<T extends EntityExtender>  {
	
	default public void update(T ee) {
		if(!getClass().equals(ee.getClass())) {
			return;
		}
		try {
			for (Field f : getClass().getDeclaredFields()) {
				f.setAccessible(true);
				boolean isNull = Objects.isNull(f.get(ee));
				if (!isNull) {
					f.set(this, f.get(ee));
//					System.out.println(f.get(ee));
				}
			}
		} catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}
	}
	
}
