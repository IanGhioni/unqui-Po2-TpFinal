package ar.edu.unq.po2.tpfinal.desafioTests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpfinal.desafio.DesafioAceptado;
import ar.edu.unq.po2.tpfinal.desafio.EstadoDesafioCompletado;

class EstadoDesafioCompletadoTest {
	DesafioAceptado desafio;
	EstadoDesafioCompletado estado;

	@BeforeEach
	void setUp() {
		desafio = mock(DesafioAceptado.class);
		estado = new EstadoDesafioCompletado();
	}

	@Test
	void testEstadoDesafioCompletadoDevuelveDescripcion() {
		assertEquals("Desafío completado", estado.descripcion());
	}

	@Test
	void testPorcentajeCompletitudCompletado() {
		assertEquals(100, estado.porcentajeCompletitud(desafio));
	}

	@Test
	void testAgregarMuestraCompletado() {
		estado.agregarMuestra(1, desafio);
		verifyNoMoreInteractions(desafio);
	}

}
