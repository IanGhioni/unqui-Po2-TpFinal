package ar.edu.unq.po2.tpfinal.desafioTests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpfinal.desafio.DesafioAceptado;
import ar.edu.unq.po2.tpfinal.desafio.EstadoDesafio;
import ar.edu.unq.po2.tpfinal.sistema.Circunferencia;
import ar.edu.unq.po2.tpfinal.usuario.Usuario;

public class DesafioAceptadoTest {
	DesafioAceptado desafio;
	Usuario usuario;
	Circunferencia area;
	EstadoDesafio estado;

	@BeforeEach
	void setUp() {
		usuario = mock(Usuario.class);
		area = mock(Circunferencia.class);
		estado = mock(EstadoDesafio.class);
	}

	@Test
	void testDesafioAceptadoDevuelveEstado() {
		desafio = new DesafioAceptado(null, 5, 2, 500, usuario, estado, 0, null, 0);
		desafio.getEstado();
		verify(estado).descripcion();
	}

	@Test
	void testDesafioAceptadoDevuelveUsuario() {
		desafio = new DesafioAceptado(null, 5, 2, 500, usuario, estado, 0, null, 0);
		assertEquals(usuario, desafio.getUsuario());
	}

	@Test
	void testDesafioAceptadoDevuelveMuestrasTomadas() {
		desafio = new DesafioAceptado(null, 5, 2, 500, usuario, estado, 0, null, 0);
		assertEquals(0, desafio.getMuestrasTomadas());
	}

	@Test
	void testDesafioAceptadoAgregaMuestra() {
		desafio = new DesafioAceptado(null, 5, 2, 500, usuario, estado, 0, null, 0);
		desafio.agregarMuestra(1, desafio);
		verify(estado).agregarMuestra(1, desafio);
	}

	@Test
	void testDesafioAceptadoFaltaUnaMuestra() {
		desafio = new DesafioAceptado(null, 5, 2, 500, usuario, estado, 4, null, 0);
		assertTrue(desafio.faltaUnaMuestra());
	}

	@Test
	void testDesafioAceptadoFaltaMasDeUnaMuestra() {
		desafio = new DesafioAceptado(null, 5, 2, 500, usuario, estado, 2, null, 0);
		assertFalse(desafio.faltaUnaMuestra());
	}

	@Test
	void testDesafioAceptadoPorcentajeCompletitud() {
		desafio = new DesafioAceptado(null, 5, 2, 500, usuario, estado, 0, null, 0);
		desafio.porcentajeCompletitud(desafio);
		verify(estado).porcentajeCompletitud(desafio);
	}

	@Test
	void testDesafioAceptadoSetMomentoCompletado() {
		LocalDate momentoCompletado = LocalDate.now();
		desafio = new DesafioAceptado(null, 5, 2, 500, usuario, estado, 0, null, 0);
		desafio.setMomentoCompletado(momentoCompletado);
		assertEquals(momentoCompletado, desafio.getMomentoCompletado());
	}

	@Test
	void testDesafioAceptadoSetMuestrasTomadas() {
		desafio = new DesafioAceptado(null, 5, 2, 500, usuario, estado, 0, null, 0);
		desafio.setMuestrasTomadas(15);
		assertEquals(15, desafio.getMuestrasTomadas());
	}

	@Test
	void testDesafioAceptadoSetCalificacion() {
		desafio = new DesafioAceptado(null, 5, 2, 500, usuario, estado, 0, null, 0);
		desafio.setCalificacion(5);
		assertEquals(5, desafio.getCalificacion());
	}

}
