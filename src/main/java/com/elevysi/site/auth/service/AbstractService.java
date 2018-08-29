package com.elevysi.site.auth.service;

import java.util.List;

public interface AbstractService<E, K> {
	
	public E findByID(K key);
	public E save(E entity);
	public E saveEdited(E entity);
	public long getCount();
	public void delete(K key);
	public void remove(E entity);
	public List<E> findAll();
}
