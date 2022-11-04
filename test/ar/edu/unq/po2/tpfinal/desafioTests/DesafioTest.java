package ar.edu.unq.po2.tpfinal.desafioTests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import ar.edu.unq.po2.tpfinal.desafio.Desafio;
import ar.edu.unq.po2.tpfinal.desafio.Restriccion;
import ar.edu.unq.po2.tpfinal.sistema.Circunferencia;

public class DesafioTest {
	Desafio desafio;
	Circunferencia area;
	Restriccion restriccion;

	@BeforeEach
	public void setUp() {
		area = mock(Circunferencia.class);
		restriccion = mock(Restriccion.class);
	}

	@Test
	public void testDesafioSetDificultadValida() {
		desafio = new Desafio(area, 3, 5, 200);
		assertEquals(desafio.getDificultad(), 5);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testDesafioDificultadInvalida() {
		desafio = new Desafio(area, 3, 6, 1000);
	}

	@Test
	public void testDesafioDevuelveSuArea() {
		desafio = new Desafio(area, 3, 1, 300);
		assertEquals(area, desafio.getArea());
	}

	@Test
	public void testDesafioDevuelveCantidadMuestras() {
		desafio = new Desafio(area, 3, 1, 300);
		assertEquals(3, desafio.getCantidadMinimaMuestras());
	}

	@Test
	public void testDesafioDevuelveDificultad() {
		desafio = new Desafio(area, 3, 1, 300);
		assertEquals(1, desafio.getDificultad());
	}

	@Test
	public void testDesafioDevuelveRecompensa() {
		desafio = new Desafio(area, 3, 1, 300);
		assertEquals(300, desafio.getRecompensa());
	}

	@Test
	public void testDesafioAgregaRestriccion() {
		desafio = new Desafio(area, 3, 1, 300);
		desafio.agregarRestriccion(restriccion);
		assertTrue(desafio.getRestricciones().contains(restriccion));
	}

	@Test
	public void testCalcularSimilitudConOtroDesafio() {
		desafio = new Desafio(area, 3, 1, 300);
		Desafio desafio2 = new Desafio(area, 3, 1, 300);
		assertTrue(desafio.calcularSimilitudConDesafio(desafio2) == 0);
	}

	@Test
	public void testCalcularSimilitudConOtroDesafio2() {
		desafio = new Desafio(area, 5, 1, 300);
		Desafio desafio2 = new Desafio(area, 4, 3, 150);
		assertEquals(desafio.calcularSimilitudConDesafio(desafio2), 51);
	}

	@Test
	public void testCalcularSimilitudConOtroDesafio3() {
		desafio = new Desafio(area, 1, 3, 49);
		Desafio desafio2 = new Desafio(area, 4, 4, 150);
		assertEquals(desafio.calcularSimilitudConDesafio(desafio2), 35);
	}
}
