package com.coopeuch.tarea.app.models.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ControladorGeneralDeExcepciones {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public ControladorGeneralDeExcepciones() {
        super();
    }
    //IllegalArgumentException
    

    @ExceptionHandler(value = Throwable.class)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Respuesta procesarErrorNoControlado(Exception ex) {
    	Respuesta r = new Respuesta();
    	r.setCodigo(999);
    	r.setDescripcion("Error: "+ex.getMessage());
        return r;
    }
}
