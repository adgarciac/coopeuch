package com.coopeuch.tarea.app.models.bean;

public class Respuesta {

	private int codigo;
	private String descripcion;
	
	public Respuesta() {
		super();
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Respuesta [codigo=" + codigo + ", descripcion=" + descripcion + "]";
	}
	
}
