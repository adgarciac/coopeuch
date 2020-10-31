package com.coopeuch.tarea.app.models.dao;

import java.util.List;

import com.coopeuch.tarea.app.models.entity.Tarea;

public interface ITareaDao  {

	public List<Tarea> findAll();
	
	public void save(Tarea tarea);
	
	public Tarea findOne(Long id);
	
	public void delete(Long id);
}
