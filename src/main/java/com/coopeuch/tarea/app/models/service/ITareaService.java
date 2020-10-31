package com.coopeuch.tarea.app.models.service;

import java.util.List;

import com.coopeuch.tarea.app.models.bean.Respuesta;
import com.coopeuch.tarea.app.models.entity.Tarea;

public interface ITareaService {

	public List<Tarea> findAll();
	
	public Respuesta  save(Tarea tarea);
	
	public Tarea findOne(Long id);
	
	public Respuesta delete(Long id);
}
