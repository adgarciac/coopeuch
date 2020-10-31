package com.coopeuch.tarea.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coopeuch.tarea.app.models.bean.Respuesta;
import com.coopeuch.tarea.app.models.dao.ITareaDao;
import com.coopeuch.tarea.app.models.entity.Tarea;

@Service
public class TareaServiceImpl implements ITareaService {

	@Autowired
	private ITareaDao tareaDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Tarea> findAll(){
		return (List<Tarea>) tareaDao.findAll();
	}
 
	@Override
	@Transactional
	public Respuesta save(Tarea tarea) {
		Respuesta respuesta = new Respuesta();
		

		if(tarea.getDescripcion() == null) {
			respuesta.setCodigo(-2);
			respuesta.setDescripcion("campo Descripcion Nulo");
			return respuesta;
		}
		
		if(tarea.getFecha_creacion() == null) {
			respuesta.setCodigo(-3);
			respuesta.setDescripcion("Campo Fecha Nulo");
			return respuesta;
		}
				
		try {
			respuesta.setCodigo(1);
			respuesta.setDescripcion("Se ha guardado Existosamente el Dato");
			tareaDao.save(tarea);
		}catch (Exception e) {
			respuesta.setCodigo(-2);
			respuesta.setDescripcion("Problemas al grabar el Dato "+e.getMessage());
		}
		return respuesta;
	}
	
	@Override
	@Transactional(readOnly=true)
	public Tarea findOne(Long id) {
		return tareaDao.findOne(id);
	}
	
	
	@Override
	@Transactional
	public Respuesta delete(Long id) {
		Respuesta respuesta = new Respuesta();

		if(id == null) {
			respuesta.setCodigo(-1);
			respuesta.setDescripcion("Id Nulo");
			return respuesta;
		}
		
		try {
			respuesta.setCodigo(1);
			respuesta.setDescripcion("Se ha Eliminado Existosamente el Dato");
			tareaDao.delete(id);
		}catch (Exception e) {
			respuesta.setCodigo(-2);
			respuesta.setDescripcion("Problemas al grabar el Dato "+e.getMessage());
		}
		return respuesta;
	}
}
