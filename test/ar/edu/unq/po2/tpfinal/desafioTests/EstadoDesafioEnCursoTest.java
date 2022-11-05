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

import ar.edu.unq.po2.tpfinal.desafio.DesafioAceptado;
import ar.edu.unq.po2.tpfinal.desafio.EstadoDesafioCompletado;
import ar.edu.unq.po2.tpfinal.desafio.EstadoDesafioEnCurso;

class EstadoDesafioEnCursoTest {
	DesafioAceptado desafio;
	EstadoDesafioEnCurso estado;

	@BeforeEach
	void setUp() {
		desafio = mock(DesafioAceptado.class);
		estado = new EstadoDesafioEnCurso();
	}

	@Test
	void testEstadoDesafioEnCursoDevuelveDescripcion() {
		assertEquals("Desafío en curso", estado.descripcion());
	}

	@Test
	void testPorcentajeCompletitudEnCurso() {
		when(desafio.getMuestrasTomadas()).thenReturn(20);
		when(desafio.getCantidadMinimaMuestras()).thenReturn(32);
		assertEquals(62.5, estado.porcentajeCompletitud(desafio));
	}

	@Test
	void testAgregarUnaMuestraEnCurso() {
		when(desafio.getMuestrasTomadas()).thenReturn(75);
		when(desafio.getCantidadMinimaMuestras()).thenReturn(100);
		assertFalse(desafio.faltaUnaMuestra());
		estado.agregarMuestra(1, desafio);
		verify(desafio).setMuestrasTomadas(76);
	}

	@Test
	void testAgregarUltimaMuestraEnCurso() {

	}

}
