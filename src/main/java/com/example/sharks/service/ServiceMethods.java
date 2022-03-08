package com.example.sharks.service;

import java.util.List;

public interface ServiceMethods<T> {
	
	T create(T shark);
	
	List<T> readAll();
	
	T readyById(long id);
	
	T update(long id, T shark);

	boolean delete(long id);
}
