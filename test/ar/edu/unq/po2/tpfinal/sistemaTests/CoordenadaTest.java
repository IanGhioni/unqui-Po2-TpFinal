package ar.edu.unq.po2.tpfinal.sistemaTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpfinal.sistema.Coordenada;

class CoordenadaTest {
	
	private Coordenada coord;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testGetX() {
		float x = 10;
		float y = 0;
		coord = new Coordenada(x,y);
		assertEquals(coord.getX(),10);
	}
	@Test
	void testGetY() {
		float x = 0;
		float y = 3;
		coord = new Coordenada(x,y);
		assertEquals(coord.getY(),3);
	}

}
