package ar.edu.unq.po2.tpfinal.sistemaTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import ar.edu.unq.po2.tpfinal.desafio.Desafio;
import ar.edu.unq.po2.tpfinal.proyecto.Proyecto;
import ar.edu.unq.po2.tpfinal.sistema.Sistema;
import ar.edu.unq.po2.tpfinal.usuario.Usuario;
import ar.edu.unq.po2.tpfinal.categoria.Categoria;

class SistemaTest {
	
	public Sistema sistema;
	public Categoria categoria1;
	public Categoria categoria2;
	public String nombreCategoria1;
	public String nombreCategoria2;
	public Usuario user;
	public Proyecto proyecto;
	
	
	@BeforeEach
	void setUp() throws Exception {
		sistema = new Sistema();
		categoria1 = mock(Categoria.class);
		categoria2 = mock(Categoria.class);
		user = mock(Usuario.class);
		proyecto = mock(Proyecto.class);
		nombreCategoria1 = "nombre1";
		nombreCategoria2 = "nombre2";
		when(categoria1.getNombre()).thenReturn(nombreCategoria1);
		when(categoria2.getNombre()).thenReturn(nombreCategoria2);
	}

	@Test
	void testSistemaPuedeAgregarUnaCategoria() {
		sistema.addCategoria(categoria1);
		assertTrue(sistema.getCategorias().contains(categoria1));
	}
	
	@Test
	void testSistemaPuedeAgregarUnDesafio() {
		Desafio desafio;
		desafio = mock(Desafio.class);
		sistema.addDesafio(desafio);
		assertTrue(sistema.getDesafios().contains(desafio));
	}
	
	@Test
	void testSistemaPuedeDecirQueIncluyeUnaCategoria() {
		sistema.addCategoria(categoria1);
		assertTrue(sistema.contieneLaCategoria(categoria1));
	}
	
	@Test
	void testSistemaPuedeDecirQueNoIncluyeUnaCategoria() {
		sistema.addCategoria(categoria1);
		assertFalse(sistema.contieneLaCategoria(categoria2));
	}
	
	@Test
	void testSistemaPuedeDecirQueIncluyeUnDesafio() {
		Desafio desafio;
		desafio = mock(Desafio.class);
		sistema.addDesafio(desafio);
		assertTrue(sistema.contieneElDesafio(desafio));
	}
	
	@Test
	void testSistemaPuedeDecirQueNoIncluyeUnDesafio() {
		Desafio desafio;
		desafio = mock(Desafio.class);
		assertFalse(sistema.contieneElDesafio(desafio));
	}
	
	@Test
	void testSistemaPuedeRemoverUnaCategoria() {
		sistema.addCategoria(categoria1);
		sistema.removeCategoria(categoria1);
		assertFalse(sistema.getCategorias().contains(categoria1));
		assertTrue(sistema.getCategorias().isEmpty());
	}
	
	@Test
	void testSistemaPuedeRemoverUnDesafio() {
		Desafio desafio;
		desafio = mock(Desafio.class);
		sistema.addDesafio(desafio);
		sistema.removeDesafio(desafio);
		assertFalse(sistema.getDesafios().contains(desafio));
		assertTrue(sistema.getDesafios().isEmpty());
	}
	
	@Test
	void testSistemaPuedeAñadirUnUsuario() {
		sistema.addUsuario(user);
		assertTrue(sistema.getUsuarios().contains(user));
	}
	
	@Test
	void testSistemaPuedeRemoverUnUsuario() {
		sistema.addUsuario(user);

		sistema.removeUsuario(user);
		assertFalse(sistema.getUsuarios().contains(user));
	}
	
	@Test
	void testSistemaPuedeDecirQueIncluyeAUnUsuario() {
		sistema.addUsuario(user);

		assertTrue(sistema.contieneElUsuario(user));
	}
	
	@Test
	void testSistemaPuedeDecirQueNoIncluyeAUnUsuario() {
		assertFalse(sistema.contieneElUsuario(user));
	}
	
	@Test
	void testSistemaPuedeAñadirUnProyecto() {
		sistema.addProyecto(proyecto);
		assertTrue(sistema.getProyectos().contains(proyecto));
	}
	
	@Test
	void testSistemaPuedeRemoverUnProyecto() {
		sistema.addProyecto(proyecto);
		sistema.removeProyecto(proyecto);
		assertFalse(sistema.getProyectos().contains(proyecto));
	}
	
	@Test
	void testSistemaPuedeDecirQueIncluyeAUnProyecto() {
		sistema.addProyecto(proyecto);;

		assertTrue(sistema.contieneElProyecto(proyecto));
	}
	
	@Test
	void testSistemaPuedeDecirQueNoIncluyeAUnProyecto() {
		assertFalse(sistema.contieneElProyecto(proyecto));
	}
}
