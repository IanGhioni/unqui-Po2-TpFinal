package ar.edu.unq.po2.tpfinal.desafioTests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpfinal.desafio.DesafioAceptado;
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
		
	}

	@Test
	void testAgregarUnaMuestraEnCurso() {

	}

	@Test
	void testAgregarUltimaMuestraEnCurso() {

	}

}
