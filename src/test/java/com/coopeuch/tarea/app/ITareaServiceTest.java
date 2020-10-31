package com.coopeuch.tarea.app;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.nullValue;
import static org.mockito.Mockito.when;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.coopeuch.tarea.app.model.Datos;
import com.coopeuch.tarea.app.models.bean.Respuesta;
import com.coopeuch.tarea.app.models.dao.ITareaDao;
import com.coopeuch.tarea.app.models.entity.Tarea;
import com.coopeuch.tarea.app.models.service.TareaServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class ITareaServiceTest {

	@InjectMocks
	private TareaServiceImpl service;

	@Mock
	private EntityManager entityManager;

	@Mock
	private ITareaDao tareaDao;

	@Before
	public void configure() {

	}

	@Test
	public void testListarRest() {

		when(tareaDao.findAll())
			.thenReturn(Datos.LISTA_TAREAS());

		List<Tarea> respuesta = service.findAll();

		assertThat(respuesta, is(not(nullValue())));

		assertThat(respuesta.size(), is(1));

	}

	@Test
	public void testGuardarFallaRest() {

		Respuesta respuesta = service.save(Datos.TAREA(1L));

		assertThat(respuesta, is(not(nullValue())));

		assertThat(respuesta.getCodigo(), is(-2));
	}
	
	@Test
	public void testGuardarRest() {

		Respuesta respuesta = service.save(Datos.TAREA2(null));

		assertThat(respuesta, is(not(nullValue())));

		assertThat(respuesta.getCodigo(), is(1));
	}
	
	@Test
	public void testEliminarFallaRest() {

		Respuesta respuesta = service.delete(null);

		assertThat(respuesta, is(not(nullValue())));

		assertThat(respuesta.getCodigo(), is(-1));
	}
	
	@Test
	public void testEliminarRest() {

		Respuesta respuesta = service.delete(1L);

		assertThat(respuesta, is(not(nullValue())));

		assertThat(respuesta.getCodigo(), is(1));
	}
	
}
