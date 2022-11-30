package ar.edu.unq.po2.tpfinal.desafioTests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpfinal.desafio.Desafio;
import ar.edu.unq.po2.tpfinal.desafio.DesafioAceptado;
import ar.edu.unq.po2.tpfinal.desafio.EstadoDesafioCompletado;
import ar.edu.unq.po2.tpfinal.desafio.EstadoDesafioEnCurso;
import ar.edu.unq.po2.tpfinal.desafio.RestriccionFechas;

class EstadoDesafioEnCursoTest {
	DesafioAceptado desafio;
	EstadoDesafioEnCurso estado;
	RestriccionFechas restriccion;
	Desafio desafioInicial;

	@BeforeEach
	void setUp() {
		desafioInicial = mock(Desafio.class);
		desafio = mock(DesafioAceptado.class);
		estado = new EstadoDesafioEnCurso(desafio);
		restriccion = mock(RestriccionFechas.class);
	}

	@Test
	void testEstadoDesafioEnCursoDevuelveDescripcion() {
		assertEquals("Desafío en curso", estado.descripcion());
	}

	@Test
	void testPorcentajeCompletitudEnCurso() {
		when(desafio.getMuestrasTomadas()).thenReturn(20);
		when(desafio.getDesafio()).thenReturn(desafioInicial);
		when(desafio.getDesafio().getCantidadMinimaMuestras()).thenReturn(32);
		assertEquals(62.5, estado.porcentajeCompletitud());
	}

	@Test
	void testPorcentajeCompletitudEnCurso2() {
		when(desafio.getMuestrasTomadas()).thenReturn(14);
		when(desafio.getDesafio()).thenReturn(desafioInicial);
		when(desafio.getDesafio().getCantidadMinimaMuestras()).thenReturn(20);
		assertEquals(70, estado.porcentajeCompletitud());
	}

	@Test
	void testAgregarUnaMuestraEnCurso() {
		when(desafio.getMuestrasTomadas()).thenReturn(75);
		when(desafio.getDesafio()).thenReturn(desafioInicial);
		when(desafio.getDesafio().getCantidadMinimaMuestras()).thenReturn(100);
		assertFalse(desafio.faltaUnaMuestra());
		estado.agregarMuestra(1);
		verify(desafio).setMuestrasTomadas(76);
	}

	@Test
	void testAgregarUltimaMuestraEnCurso() {
		when(desafio.faltaUnaMuestra()).thenReturn(true);
		when(desafio.getMuestrasTomadas()).thenReturn(4);
		when(desafio.getDesafio()).thenReturn(desafioInicial);
		when(desafio.getDesafio().getCantidadMinimaMuestras()).thenReturn(5);
		estado.agregarMuestra(1);
		verify(desafio, times(1)).setMuestrasTomadas(5);
	}
}
