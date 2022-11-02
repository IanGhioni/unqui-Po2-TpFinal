package ar.edu.unq.po2.tpfinal.desafioTests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import ar.edu.unq.po2.tpfinal.desafio.Desafio;
import ar.edu.unq.po2.tpfinal.desafio.Restriccion;
import ar.edu.unq.po2.tpfinal.sistema.Circunferencia;

class DesafioTest {
	Desafio desafio;
	Circunferencia area;
	Restriccion restriccion;

	@BeforeEach
	void setUp() {
		area = mock(Circunferencia.class);
		restriccion = mock(Restriccion.class);
		desafio = new Desafio(area, 3, 1, 300);
	}

	@Test
	void testDesafioDevuelveSuArea() {
		assertEquals(desafio.getArea(), area);
	}

	@Test
	void testDesafioDevuelveCantidadMuestras() {
		assertEquals(desafio.getCantidadMinimaMuestras(), 3);
	}

	@Test
	void testDesafioDevuelveDificultad() {
		assertEquals(desafio.getDificultad(), 1);
	}

	@Test
	void testDesafioDevuelveRecompensa() {
		assertEquals(desafio.getRecompensa(), 300);
	}

	@Test
	void testDesafioAgregaRestriccion() {
		desafio.agregarRestriccion(restriccion);
		assertTrue(desafio.getRestricciones().contains(restriccion));
	}
}
