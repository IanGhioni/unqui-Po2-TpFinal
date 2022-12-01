package ar.edu.unq.po2.tpfinal.desafioTests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpfinal.desafio.Desafio;
import ar.edu.unq.po2.tpfinal.desafio.DesafioAceptado;
import ar.edu.unq.po2.tpfinal.desafio.Restriccion;
import ar.edu.unq.po2.tpfinal.desafio.RestriccionSemanal;

class RestriccionSemanalTest {
	Desafio desafioInicial;
	DesafioAceptado desafio;
	RestriccionSemanal restriccion;
	LocalDate diaDeSemana;
	LocalDate diaFinDeSemana;

	@BeforeEach
	void setUp() {
		List<Restriccion> restricciones = Arrays.asList(restriccion);
		desafio = mock(DesafioAceptado.class);
		desafioInicial = mock(Desafio.class);
		when(desafio.getDesafio()).thenReturn(desafioInicial);
		when(desafio.getDesafio().getRestricciones()).thenReturn(restricciones);
	}

	@Test
	void testRestriccionSemanalVerificacionTrue() {
		diaDeSemana = LocalDate.of(2022, 11, 4);
		restriccion = new RestriccionSemanal();
		assertTrue(restriccion.verificarRestriccionAlDesafio(desafio, diaDeSemana));
	}

	@Test
	void testRestriccionSemanalVerificacionFalse() {
		diaFinDeSemana = LocalDate.of(2022, 11, 6);
		restriccion = new RestriccionSemanal();
		assertFalse(restriccion.verificarRestriccionAlDesafio(desafio, diaFinDeSemana));
	}

}
