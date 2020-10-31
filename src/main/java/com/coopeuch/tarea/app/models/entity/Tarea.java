package com.coopeuch.tarea.app.models.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="Tarea")
public class Tarea {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@NotEmpty
	@Column(name = "DESCRIPCION", nullable = false, length = 500)
	private String descripcion;
	
	@NotEmpty
	@Column(name = "FECHA_CREACION")
	private String fecha_creacion;
	
	@Column(name="VIGENCIA")
	private int vigencia;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(String fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public int getVigencia() {
		return vigencia;
	}

	public void setVigencia(int vigencia) {
		this.vigencia = vigencia;
	}

	public Tarea() {

		// TODO Auto-generated constructor stub
	}

	public Tarea(Long id, String descripcion, String fecha_creacion, int vigencia) {
		this.id = id;
		this.descripcion = descripcion;
		this.fecha_creacion = fecha_creacion;
		this.vigencia = vigencia;
	}


	
	
	
}
