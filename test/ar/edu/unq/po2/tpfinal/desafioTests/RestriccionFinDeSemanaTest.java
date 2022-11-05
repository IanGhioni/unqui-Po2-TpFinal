package ar.edu.unq.po2.tpfinal.desafioTests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpfinal.desafio.DesafioAceptado;
import ar.edu.unq.po2.tpfinal.desafio.Restriccion;
import ar.edu.unq.po2.tpfinal.desafio.RestriccionFinDeSemana;

class RestriccionFinDeSemanaTest {
	DesafioAceptado desafio;
	RestriccionFinDeSemana restriccion;
	LocalDate diaDeSemana;
	LocalDate diaFinDeSemana;

	@BeforeEach
	void setUp() {
		List<Restriccion> restricciones = Arrays.asList(restriccion);
		desafio = mock(DesafioAceptado.class);
		when(desafio.getRestricciones()).thenReturn(restricciones);
	}

	@Test
	void testRestriccionSemanalVerificacionTrue() {
		diaFinDeSemana = LocalDate.of(2022, 11, 6);
		restriccion = new RestriccionFinDeSemana();
		assertTrue(restriccion.verificarRestriccionAlDesafio(desafio, diaFinDeSemana));
	}

	@Test
	void testRestriccionSemanalVerificacionFalse() {
		diaDeSemana = LocalDate.of(2022, 11, 4);
		restriccion = new RestriccionFinDeSemana();
		assertFalse(restriccion.verificarRestriccionAlDesafio(desafio, diaDeSemana));
	}

}
