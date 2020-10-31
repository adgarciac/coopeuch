package com.coopeuch.tarea.app.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity; 	
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.coopeuch.tarea.app.models.bean.Respuesta;
import com.coopeuch.tarea.app.models.entity.Tarea;
import com.coopeuch.tarea.app.models.service.ITareaService;

@RestController
@RequestMapping("/coopeuch")
public class TareaController {

	@Autowired
	private ITareaService tareaService;
	/*
	@GetMapping({"/form"})
	public String formTarea(Model model) {
		
		model.addAttribute("titulo", "Registros de Tareas");
		model.addAttribute("tareas", new Tarea());
		return "form";
		
	}
	   
	@GetMapping("/listar")
	public String listarTareas(Model model) {
		
		model.addAttribute("titulo", "");
		model.addAttribute("subtitulo", "Lista de Tareas de Coopeuch");
		model.addAttribute("tareas", tareaService.findAll());		
		return "listar";
		
	}
	
	@GetMapping(value="/editar/{id}")
	public String editarTareas(@PathVariable(value="id") Long id, Model model, RedirectAttributes  flash) {
		
		Tarea tarea = null;
		
		if(id > 0) {
			tarea = tareaService.findOne(id);
			if(tarea == null) {
				flash.addFlashAttribute("error", "El ID de la Tarea no existe en la BBDD!");
				return "redirect:/listar";
			}
		} else {
			flash.addFlashAttribute("error", "El ID de la Tarea no puede ser cero!");
			return "redirect:/listar";
		}
		model.addAttribute("tareas", tarea);
		model.addAttribute("titulo", "Editar Tarea");
		return "form"; 
	}
	
	@PostMapping(value = "/guardar")
	public String guardarTareas(@Valid Tarea tarea,
		      	          BindingResult result,
		      	          Model model,RedirectAttributes flash, SessionStatus status) {

		if(result.hasErrors()) {
			Map<String, String> errores = new HashMap<>();
			result.getFieldErrors().forEach(err ->{
				errores.put(err.getField(), "El campo ".concat(err.getField()).concat(" ").concat(err.getDefaultMessage()));
			});
			model.addAttribute("error", errores);
			model.addAttribute("tareas", tarea);
			model.addAttribute("titulo", "Registros de Tareas");
			return "form";
		}   
		
		
	    model.addAttribute("titulo", "Formulario de Tarea");  
		String mensajeFlash = (tarea.getId() != null) ? "Tarea editada con éxito!" : "Tarea creada con éxito!";
		
		tareaService.save(tarea);
		status.setComplete();
		flash.addFlashAttribute("success", mensajeFlash);
		return "redirect:listar";
	}
	
	@GetMapping(value="/eliminar/{id}")
	public String eliminarTareas(@PathVariable(value="id") Long id, RedirectAttributes flash) {
		

		tareaService.delete(id);
		flash.addFlashAttribute("success", "Tarea eliminada con éxito!");
		return "redirect:/coopeuch/listar";
	
	}
	
	*/
	
	
	@GetMapping(value = "/listarRest", produces = MediaType.APPLICATION_JSON_VALUE)
	public  List<Tarea> listarTareasRest(Model model) {
		return tareaService.findAll();
		
	}
	
	@PostMapping(value = "/guardarRest")
	public ResponseEntity<Respuesta> guardarTareasRest(@RequestBody Tarea tarea) {
		return new ResponseEntity<Respuesta>(tareaService.save(tarea), HttpStatus.ACCEPTED);
	}
	
	
	@DeleteMapping(value="/eliminarRest/{id}")
	public ResponseEntity<Respuesta> eliminarTareasRest(@PathVariable(value="id") Long id) {
		return new ResponseEntity<Respuesta>(tareaService.delete(id),HttpStatus.ACCEPTED);
	
	}
	
	@PutMapping(value = "/editarRest")
	public ResponseEntity<Respuesta> editarRest(@RequestBody Tarea tarea) {
		return new ResponseEntity<Respuesta>(tareaService.save(tarea), HttpStatus.ACCEPTED);
		
	}
	
	
	
	
}
