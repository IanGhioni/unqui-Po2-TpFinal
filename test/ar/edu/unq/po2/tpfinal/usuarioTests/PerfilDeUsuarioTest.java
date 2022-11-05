package ar.edu.unq.po2.tpfinal.usuarioTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;


import ar.edu.unq.po2.tpfinal.desafio.Desafio;
import ar.edu.unq.po2.tpfinal.usuario.PerfilDeUsuario;

class PerfilDeUsuarioTest {
	
	PerfilDeUsuario perfilDePrueba;
	Desafio desafio;

	@BeforeEach
	void setUp() throws Exception {
		desafio = mock(Desafio.class);
	}
	
	
	
	@Test
	void testGetDificultad() throws Exception {
		perfilDePrueba = new PerfilDeUsuario(4,5,100);
		
		assertEquals(perfilDePrueba.getDificultad(),4);
	}

	@Test
	void testGetCantidadMinimaMuestras() throws Exception {
		perfilDePrueba = new PerfilDeUsuario(4,5,100);

		assertEquals(perfilDePrueba.getCantidadMinimaMuestras(),5);
	}

	@Test
	void testGetRecompensa() throws Exception {
		perfilDePrueba = new PerfilDeUsuario(4,5,100);

		assertEquals(perfilDePrueba.getRecompensa(),100);
	}

	@Test
	void testCalcularCoincidenciaConDesafio() throws Exception {
		perfilDePrueba = new PerfilDeUsuario(4,5,100);

		when(desafio.getDificultad()).thenReturn(5);
		when(desafio.getCantidadMinimaMuestras()).thenReturn(10);
		when(desafio.getRecompensa()).thenReturn(300);
		
		double resultadoEsperado = 1 + 5 + 200;
		
		double resultado = perfilDePrueba.calcularCoincidenciaConDesafio(desafio);
		assertEquals(resultadoEsperado, resultado);
	}
	
	@Test
	void testCalcularCoincidenciaConDesafio2() throws Exception {
		perfilDePrueba = new PerfilDeUsuario(5,5,300);

		when(desafio.getDificultad()).thenReturn(5);
		when(desafio.getCantidadMinimaMuestras()).thenReturn(5);
		when(desafio.getRecompensa()).thenReturn(300);
		
		double resultadoEsperado = 0;
		
		double resultado = perfilDePrueba.calcularCoincidenciaConDesafio(desafio);
		assertEquals(resultadoEsperado,resultado);
	}
	
	@Test
	void testConstructorNoRetornaException() throws Exception {
		assertDoesNotThrow(() -> {
			
		});
	}
	
	@Test
	void testRecompensaMenorA0RetornaException() throws Exception {
		Throwable exception = assertThrows(Exception.class, () -> {
			perfilDePrueba = new PerfilDeUsuario(5,5,-1);
		});
		assertEquals(exception.getMessage(),"La recompensa del desafio no puede ser menor o igual a 0.");
	}
	
	@Test
	void testRecompensaIgualA0RetornaException() throws Exception {
		Throwable exception = assertThrows(Exception.class, () -> {
			perfilDePrueba = new PerfilDeUsuario(5,5,0);
		});
		assertEquals(exception.getMessage(),"La recompensa del desafio no puede ser menor o igual a 0.");
	}
	
	@Test
	void testCantMinMuestrasMenorA0RetornaException() throws Exception {
		Throwable exception = assertThrows(Exception.class, () -> {
			perfilDePrueba = new PerfilDeUsuario(5,-1,1);
		});
		assertEquals(exception.getMessage(),"La cantidad minima de muestras a recolectar no puede ser menor o igual a 0.");
	}
	
	@Test
	void testCantMinMuestrasIgualA0RetornaException() throws Exception {
		Throwable exception = assertThrows(Exception.class, () -> {
			perfilDePrueba = new PerfilDeUsuario(5,0,1);
		});
		assertEquals(exception.getMessage(),"La cantidad minima de muestras a recolectar no puede ser menor o igual a 0.");
	}
	
	@Test
	void testDificultadMenorA1RetornaException() throws Exception {
		Throwable exception = assertThrows(Exception.class, () -> {
			perfilDePrueba = new PerfilDeUsuario(0,1,5);
		});
		assertEquals(exception.getMessage(),"La dificultad debe ser un numero entre 1 y 5.");
	}
	
	@Test
	void testDificultadMayorA5RetornaException() throws Exception {
		Throwable exception = assertThrows(Exception.class, () -> {
			perfilDePrueba = new PerfilDeUsuario(6,1,5);
		});
		assertEquals(exception.getMessage(),"La dificultad debe ser un numero entre 1 y 5.");
	}
}
