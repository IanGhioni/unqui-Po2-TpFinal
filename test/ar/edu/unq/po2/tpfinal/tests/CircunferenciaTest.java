package ar.edu.unq.po2.tpfinal.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import ar.edu.unq.po2.tpfinal.clases.Circunferencia;
import ar.edu.unq.po2.tpfinal.clases.Coordenada;

class CircunferenciaTest {
	private Circunferencia circunferencia;
	private Coordenada coordenada;
	
	@BeforeEach
	void setUp() throws Exception {
		coordenada = mock(Coordenada.class);
		circunferencia = new Circunferencia(coordenada,10);
	}
	
	
	@Test
	void testGetCentro() {
		assertTrue(circunferencia.getCentro() == coordenada);
	}
	
	@Test
	void testGetRadio() {
		assertTrue(circunferencia.getRadio() == 10);
	}
	
	// Caso de test con centro (20,12), radio 10 y coordenada (25,10)
	@Test
	void testVerificarCuandoCoordenadaEstaEnLaCircunferencia1() {
		when(coordenada.getX()).thenReturn((float) 20);
		when(coordenada.getY()).thenReturn((float) 12);
		
		Coordenada c = mock(Coordenada.class);
		when(c.getX()).thenReturn((float) 25);
		when(c.getY()).thenReturn((float) 10);
		assertTrue(circunferencia.verificarSiIncluyeCoordenada(c));
	}
	
	// Caso de test con centro (20,12), radio 10 y coordenada (25,10)
	@Test
	void testVerificarCuandoCoordenadaEstaEnLaCircunferencia2() {
		when(coordenada.getX()).thenReturn((float) 20);
		when(coordenada.getY()).thenReturn((float) 12);
			
		Coordenada c = mock(Coordenada.class);
		when(c.getX()).thenReturn((float) 20);
		when(c.getY()).thenReturn((float) 10);
		assertTrue(circunferencia.verificarSiIncluyeCoordenada(c));
	}
	// Caso de test con centro (20,12), radio 10 y coordenada (22,14)
	@Test
	void testVerificarCuandoCoordenadaEstaEnLaCircunferencia3() {
		when(coordenada.getX()).thenReturn((float) 20);
		when(coordenada.getY()).thenReturn((float) 12);
			
		Coordenada c = mock(Coordenada.class);
		when(c.getX()).thenReturn((float) 22);
		when(c.getY()).thenReturn((float) 14);
		assertTrue(circunferencia.verificarSiIncluyeCoordenada(c));
	}
	
	// Caso de test con centro (0,0), radio 10 y coordenada (-3,5)
	@Test
	void testVerificarCuandoCoordenadaEstaEnLaCircunferencia4() {
		when(coordenada.getX()).thenReturn((float) 0);
		when(coordenada.getY()).thenReturn((float) 0);
			
		Coordenada c = mock(Coordenada.class);
		when(c.getX()).thenReturn((float) -3);
		when(c.getY()).thenReturn((float) 5);
		assertTrue(circunferencia.verificarSiIncluyeCoordenada(c));
	}
	
	// Caso de test con centro (0,0), radio 10 y coordenada (-3,-6)
	@Test
	void testVerificarCuandoCoordenadaEstaEnLaCircunferencia5() {
		when(coordenada.getX()).thenReturn((float) 0);
		when(coordenada.getY()).thenReturn((float) 0);
			
		Coordenada c = mock(Coordenada.class);
		when(c.getX()).thenReturn((float) -3);
		when(c.getY()).thenReturn((float) -6);
		assertTrue(circunferencia.verificarSiIncluyeCoordenada(c));
	}
	
	// CASOS FALSOS
	
	// Caso de test con centro (20,12), radio 10 y coordenada (22,23)
	@Test
	void testVerificarCuandoCoordenadaNoEstaEnLaCircunferencia1() {
		when(coordenada.getX()).thenReturn((float) 20);
		when(coordenada.getY()).thenReturn((float) 12);
				
		Coordenada c = mock(Coordenada.class);
		when(c.getX()).thenReturn((float) 22);
		when(c.getY()).thenReturn((float) 23);
		assertFalse(circunferencia.verificarSiIncluyeCoordenada(c));
	}
	
	// Caso de test con centro (20,12), radio 10 y coordenada (9,10)
	@Test
	void testVerificarCuandoCoordenadaNoEstaEnLaCircunferencia2() {
		when(coordenada.getX()).thenReturn((float) 20);
		when(coordenada.getY()).thenReturn((float) 12);
				
		Coordenada c = mock(Coordenada.class);
		when(c.getX()).thenReturn((float) 9);
		when(c.getY()).thenReturn((float) 10);
		assertFalse(circunferencia.verificarSiIncluyeCoordenada(c));
	}

	// Caso de test con centro (20,12), radio 10 y coordenada (31,13)
	@Test
	void testVerificarCuandoCoordenadaNoEstaEnLaCircunferencia3() {
		when(coordenada.getX()).thenReturn((float) 20);
		when(coordenada.getY()).thenReturn((float) 10);
				
		Coordenada c = mock(Coordenada.class);
		when(c.getX()).thenReturn((float) 31);
		when(c.getY()).thenReturn((float) 13);
		assertFalse(circunferencia.verificarSiIncluyeCoordenada(c));
	}
	// Caso de test con centro (-5,-5), radio 10 y coordenada (-16,6)
	@Test
	void testVerificarCuandoCoordenadaNoEstaEnLaCircunferencia4() {
		when(coordenada.getX()).thenReturn((float) 20);
		when(coordenada.getY()).thenReturn((float) 10);
				
		Coordenada c = mock(Coordenada.class);
		when(c.getX()).thenReturn((float) (-16));
		when(c.getY()).thenReturn((float) 6);
		assertFalse(circunferencia.verificarSiIncluyeCoordenada(c));
	}
	
	// CASOS DE ERROR
}
