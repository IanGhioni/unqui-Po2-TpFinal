package ar.edu.unq.po2.tpfinal.muestraTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpfinal.muestra.Muestra;
import ar.edu.unq.po2.tpfinal.sistema.Coordenada;
import ar.edu.unq.po2.tpfinal.usuario.Usuario;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.time.LocalTime;

class MuestraTests {
	
	Muestra muestra;
	Usuario user;
	Coordenada coord;
	

	@BeforeEach
	void setUp() throws Exception {
		user = mock(Usuario.class);
		coord = mock(Coordenada.class);
	}


	@Test
	void testGetUsuarioAutor() {
		muestra = new Muestra(user,coord);
		assertEquals(muestra.getUsuarioAutor(), user);
	}

	@Test
	void testGetFecha() {
		muestra = new Muestra(user,coord);
		assertEquals(muestra.getFecha(), LocalDate.now());
	}

	@Test
	void testGetHora() {
		muestra = new Muestra(user,coord);
		assertEquals(muestra.getHora().withNano(0), LocalTime.now().withNano(0));
	}

	@Test
	void testGetUbicacion() {
		muestra = new Muestra(user,coord);
		assertEquals(muestra.getUbicacion(), coord);
	}

}
