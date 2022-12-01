package ar.edu.unq.po2.tpfinal.desafioTests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpfinal.desafio.Desafio;
import ar.edu.unq.po2.tpfinal.desafio.DesafioAceptado;
import ar.edu.unq.po2.tpfinal.desafio.EstadoDesafioVencido;

class EstadoDesafioVencidoTest {
	DesafioAceptado desafio;
	EstadoDesafioVencido estado;
	Desafio desafioInicial;

	@BeforeEach
	void setUp() {
		desafioInicial = mock(Desafio.class);
		desafio = mock(DesafioAceptado.class);
		estado = new EstadoDesafioVencido(desafio);
	}

	@Test
	void testEstadoDesafioVencidoDevuelveDescripcion() {
		assertEquals("Desafío vencido", estado.descripcion());
	}

	@Test
	void testPorcentajeCompletitudVencido() {
		when(desafio.getMuestrasTomadas()).thenReturn(50);
		when(desafio.getDesafio()).thenReturn(desafioInicial);
		when(desafio.getDesafio().getCantidadMinimaMuestras()).thenReturn(100);
		assertEquals(50, estado.porcentajeCompletitud());
	}

	@Test
	void testAgregarMuestraVencido() {
		estado.agregarMuestra(1);
		verifyNoMoreInteractions(desafio);
	}

}
