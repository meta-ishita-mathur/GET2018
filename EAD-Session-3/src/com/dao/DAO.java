package com.dao;

import java.util.List;

public interface DAO<T>{
	public List<T> getAll();
	public List<T> get(T t);
	public boolean add(T t);
}
