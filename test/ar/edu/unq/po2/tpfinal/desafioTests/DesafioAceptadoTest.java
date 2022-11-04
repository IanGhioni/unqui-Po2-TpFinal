package ar.edu.unq.po2.tpfinal.desafioTests;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;
import java.time.LocalTime;

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
		desafio = new DesafioAceptado(area, 5, 2, 500, usuario, estado);
		desafio.getEstado();
		verify(estado).descripcion();
	}

	@Test
	void testDesafioAceptadoDevuelveUsuario() {
		desafio = new DesafioAceptado(area, 5, 2, 500, usuario, estado);
		assertEquals(usuario, desafio.getUsuario());
	}

	@Test
	void testDesafioAceptadoDevuelveMuestrasTomadas() {
		desafio = new DesafioAceptado(area, 5, 2, 500, usuario, estado);
		assertEquals(0, desafio.getMuestrasTomadas());
	}

	@Test
	void testDesafioAceptadoAgregaMuestra() {
		desafio = new DesafioAceptado(area, 5, 2, 500, usuario, estado);
		desafio.agregarMuestra(1, desafio);
		verify(estado).agregarMuestra(1, desafio);
	}

	@Test
	void testDesafioAceptadoFaltaUnaMuestra() {
		desafio = new DesafioAceptado(area, 5, 2, 500, usuario, estado);
		desafio.setMuestrasTomadas(4);
		assertTrue(desafio.faltaUnaMuestra());
	}

	@Test
	void testDesafioAceptadoFaltaMasDeUnaMuestra() {
		desafio = new DesafioAceptado(area, 5, 2, 500, usuario, estado);
		assertFalse(desafio.faltaUnaMuestra());
	}

	@Test
	void testDesafioAceptadoPorcentajeCompletitud() {
		desafio = new DesafioAceptado(area, 5, 2, 500, usuario, estado);
		desafio.porcentajeCompletitud(desafio);
		verify(estado).porcentajeCompletitud(desafio);
	}

	@Test
	void testDesafioAceptadoSetFechaCompletado() {
		LocalDate fechaCompletado = LocalDate.now();
		desafio = new DesafioAceptado(area, 5, 2, 500, usuario, estado);
		desafio.setFechaCompletado(fechaCompletado);
		assertEquals(fechaCompletado, desafio.getFechaCompletado());
	}

	@Test
	void testDesafioAceptadoSetHoraCompletado() {
		LocalTime horaCompletado = LocalTime.now();
		desafio = new DesafioAceptado(area, 5, 2, 500, usuario, estado);
		desafio.setHoraCompletado(horaCompletado);
		assertEquals(horaCompletado, desafio.getHoraCompletado());
	}

	@Test
	void testDesafioAceptadoSetMuestrasTomadas() {
		desafio = new DesafioAceptado(area, 5, 2, 500, usuario, estado);
		desafio.setMuestrasTomadas(15);
		assertEquals(15, desafio.getMuestrasTomadas());
	}

	@Test
	void testDesafioAceptadoSetCalificacionValida() {
		desafio = new DesafioAceptado(area, 5, 2, 500, usuario, estado);
		desafio.setCalificacion(5);
		assertEquals(5, desafio.getCalificacion());
	}

	@Test
	void testDesafioAceptadoSetCalificacionInvalida() {
		desafio = new DesafioAceptado(area, 5, 2, 500, usuario, estado);
		Throwable exception = assertThrows(Exception.class, () -> {
			desafio.setCalificacion(6);
		});
		assertEquals(exception.getMessage(), "La calificación ingresada debe estar entre 0 y 5.");
	}

}
