package com.coopeuch.tarea.app.model;

import java.util.ArrayList;
import java.util.List;

import com.coopeuch.tarea.app.models.entity.Tarea;

public class Datos {

	public static List<Tarea> LISTA_TAREAS() {
		List<Tarea> tareas = new ArrayList<>();
		tareas.add(TAREA(1L));
        return tareas;
    }
	
	public static Tarea TAREA(Long id) {
		Tarea tarea = new Tarea();
		tarea.setId(id);
		tarea.setDescripcion(null);
		tarea.setFecha_creacion("30-10-2020");
		tarea.setVigencia(1);
		return tarea;
	}
	
	public static Tarea TAREA2(Long id) {
		Tarea tarea = new Tarea();
		tarea.setId(id);
		tarea.setDescripcion("Prueba");
		tarea.setFecha_creacion("30-10-2020");
		tarea.setVigencia(1);
		return tarea;
	}
	
}
