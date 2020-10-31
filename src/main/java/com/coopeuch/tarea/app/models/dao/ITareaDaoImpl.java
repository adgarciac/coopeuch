package com.coopeuch.tarea.app.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coopeuch.tarea.app.models.entity.Tarea;

@Repository
public class ITareaDaoImpl implements ITareaDao{

	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override	
	public List<Tarea> findAll() {
		// TODO Auto-generated method stub
		return em.createQuery("from Tarea").getResultList();
	}

	@Override
	@Transactional
	public void save(Tarea tarea) {
		if (tarea.getId() != null && tarea.getId() > 0) {
			em.merge(tarea);
		} else {
			em.persist(tarea);
		}
		
	}

	@Override
	@Transactional(readOnly = true)
	public Tarea findOne(Long id) {
		// TODO Auto-generated method stub
		return em.find(Tarea.class, id);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		em.remove(findOne(id));
	}

}
