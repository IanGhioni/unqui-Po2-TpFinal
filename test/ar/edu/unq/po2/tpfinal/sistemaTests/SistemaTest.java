package ar.edu.unq.po2.tpfinal.sistemaTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import ar.edu.unq.po2.tpfinal.desafio.Desafio;
import ar.edu.unq.po2.tpfinal.sistema.Sistema;

class SistemaTest {
	
	public Sistema sistema;
	
	@BeforeEach
	void setUp() throws Exception {
		sistema = new Sistema();
	}

	@Test
	void testSistemaPuedeAgregarUnaCategoria() {
		sistema.addCategoria("Categoria");
		assertTrue(sistema.getListaDeCategorias().contains("Categoria"));
	}
	
	@Test
	void testSistemaPuedeAgregarUnDesafio() {
		Desafio desafio;
		desafio = mock(Desafio.class);
		sistema.addDesafio(desafio);
		assertTrue(sistema.getListaDeDesafios().contains(desafio));
	}
	
	@Test
	void testSistemaPuedeDecirQueIncluyeUnaCategoria() {
		sistema.addCategoria("Categoria");
		assertTrue(sistema.contieneLaCategoria("Categoria"));
	}
	
	@Test
	void testSistemaPuedeDecirQueNoIncluyeUnaCategoria() {
		assertFalse(sistema.contieneLaCategoria("Categoria"));
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
		sistema.addCategoria("Categoria");
		sistema.removeCategoria("Categoria");
		assertFalse(sistema.getListaDeCategorias().contains("Categoria"));
		assertTrue(sistema.getListaDeCategorias().isEmpty());
	}
	
	@Test
	void testSistemaPuedeRemoverUnDesafio() {
		Desafio desafio;
		desafio = mock(Desafio.class);
		sistema.addDesafio(desafio);
		sistema.removeDesafio(desafio);
		assertFalse(sistema.getListaDeDesafios().contains(desafio));
		assertTrue(sistema.getListaDeDesafios().isEmpty());
	}
}
