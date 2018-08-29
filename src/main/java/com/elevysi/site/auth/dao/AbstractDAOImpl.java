package com.elevysi.site.auth.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.elevysi.site.commons.dto.ProfileDTO;

@Repository
@Transactional
public abstract class AbstractDAOImpl<E, K> implements AbstractDAO<E, K> {
	
	@PersistenceContext
	private EntityManager em;
	
	private Class<E> type;
	
//	public AbstractDAO(Class<T> type){
//		this.type = type;
//	}
	
	public AbstractDAOImpl(){
//		type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		
		Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class) pt.getActualTypeArguments()[0];
	}
	
	public E findByID(K key){
		return em.find(type, key);
	}
	
	
	public E save(E entity){
		em.persist(entity);
		em.flush();
		return entity;
	}
	
	public E saveEdited(E entity){
		em.merge(entity);
		em.flush();
		return entity;
	}
	
	public void delete(K key){
		E entity = em.find(type, key);
		if(entity != null) {
			em.merge(entity);
			em.remove(entity);
		}
	}
	
	public void remove(E entity){
		if(entity != null) {
			em.merge(entity);
			em.remove(entity);
		}
	}
	
	//https://www.petrikainulainen.net/programming/spring-framework/spring-data-jpa-tutorial-part-seven-pagination/
	public Pageable createRequestPage(int pageNo, int size, String sortDirection, String sortField){
		return new PageRequest(pageNo, size, sortDirection.equalsIgnoreCase("asc")? Sort.Direction.ASC: Sort.Direction.DESC, sortField);
	}
	
	
//	public ProfileDTO getProfile(long profileID) {
//		ProfileDTO profileDTO = socialFeignClient.getProfileByID(profileID);
//		return profileDTO;
//	}
	
	public List<E> findAll(){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<E> criteria = cb.createQuery(type);
		Root<E> root = criteria.from(type);
		criteria.select(root);
		TypedQuery<E> query = em.createQuery(criteria);
		return query.getResultList();
	}
	
	public long getCount(){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		cq.select(cb.count(cq.from(type)));
		return em.createQuery(cq).getSingleResult();
	}
	
	
}
