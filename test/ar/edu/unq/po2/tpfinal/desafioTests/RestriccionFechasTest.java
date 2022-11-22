package ar.edu.unq.po2.tpfinal.desafioTests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpfinal.desafio.DesafioAceptado;
import ar.edu.unq.po2.tpfinal.desafio.Restriccion;
import ar.edu.unq.po2.tpfinal.desafio.RestriccionFechas;

class RestriccionFechasTest {

	DesafioAceptado desafio;
	RestriccionFechas restriccion;

	@BeforeEach
	void setUp() {
		List<Restriccion> restricciones = Arrays.asList(restriccion);
		desafio = mock(DesafioAceptado.class);
		when(desafio.getRestricciones()).thenReturn(restricciones);
	}

	@Test
	void testRestriccionFechasVerificacionTrue() {
		restriccion = new RestriccionFechas(LocalDate.of(2022, 10, 31), LocalDate.of(2023, 12, 31));
		assertTrue(restriccion.verificarRestriccionAlDesafio(desafio, LocalDate.now()));
	}

	@Test
	void testRestriccionFechasVerificacionFalse() {
		restriccion = new RestriccionFechas(LocalDate.of(2022, 10, 15), LocalDate.of(2022, 10, 31));
		assertFalse(restriccion.verificarRestriccionAlDesafio(desafio, LocalDate.now()));
	}

	@Test
	void testRestriccionFechasGetFechaInicio() {
		restriccion = new RestriccionFechas(LocalDate.of(2022, 10, 15), LocalDate.of(2022, 10, 31));
		assertEquals(LocalDate.of(2022, 10, 15), restriccion.getFechaInicio());
	}

	@Test
	void testRestriccionFechasGetFechaFin() {
		restriccion = new RestriccionFechas(LocalDate.of(2022, 10, 15), LocalDate.of(2022, 10, 31));
		assertEquals(LocalDate.of(2022, 10, 31), restriccion.getFechaFin());
	}

}
