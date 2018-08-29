package com.elevysi.site.auth.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elevysi.site.auth.dao.AbstractDAO;


@Service
public abstract class AbstractServiceImpl<E, K> extends BasicService implements AbstractService<E, K>{
	
	@Autowired
	private AbstractDAO<E, K> abstractDAO;
	
	public E findByID(K key){
		return abstractDAO.findByID(key);
	}
	public E save(E entity){
		return abstractDAO.save(entity);
	}
	public E saveEdited(E entity){
		return abstractDAO.saveEdited(entity);
	}
	public long getCount(){
		return abstractDAO.getCount();
	}
	public void delete(K key){
		abstractDAO.delete(key);
	}
	public void remove(E entity){
		abstractDAO.remove(entity);
	}
	public List<E> findAll(){
		return abstractDAO.findAll();
	}

}
