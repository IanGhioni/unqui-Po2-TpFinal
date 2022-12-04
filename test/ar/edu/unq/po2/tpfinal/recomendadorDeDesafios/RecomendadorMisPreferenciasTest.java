package ar.edu.unq.po2.tpfinal.recomendadorDeDesafios;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpfinal.desafio.Desafio;
import ar.edu.unq.po2.tpfinal.desafio.DesafioAceptado;
import ar.edu.unq.po2.tpfinal.sistema.Sistema;
import ar.edu.unq.po2.tpfinal.usuario.PerfilDeUsuario;
import ar.edu.unq.po2.tpfinal.usuario.Usuario;
import static org.mockito.Mockito.*;


class RecomendadorMisPreferenciasTest {

	ArrayList<Desafio> listaDeDesafios; 
	RecomendadorDeDesafios recomendador;
	Usuario user;
	Sistema sistema;
	PerfilDeUsuario perfil;
	Desafio d1; 
	Desafio d2;
	Desafio d3;
	Desafio d4;
	Desafio d5;
	Desafio d6;
	Desafio d7;
	Desafio d8;
	Desafio d9;
	Desafio d10;
	Desafio d11;
	Desafio d12;
	Desafio d13;
	Desafio d14;
	Desafio d15;
	Desafio d16;
	Desafio d17;
	Desafio d18;
	Desafio d19;
	Desafio d20;
	Desafio d21;
	Desafio d22;
	Desafio d23;
	Desafio desafioMasGustado;
	
	
	@BeforeEach
	void setUp() throws Exception {
		listaDeDesafios = new ArrayList<Desafio>();
		user = mock(Usuario.class);
		sistema = mock(Sistema.class);
		perfil = mock(PerfilDeUsuario.class);
		this.setUpMockDesafios();
		this.setUpSistema();
		
		when(user.desafioMasGustado()).thenReturn(desafioMasGustado);
		when(user.getPerfilDeUsuario()).thenReturn(perfil);

		
		recomendador = new RecomendadorMisPreferencias(user);

	}
	 
	private void setUpSistema() {
		listaDeDesafios.add(d1);
		listaDeDesafios.add(d2);
		listaDeDesafios.add(d3);
		listaDeDesafios.add(d4);
		listaDeDesafios.add(d5);
		listaDeDesafios.add(d6);
		listaDeDesafios.add(d7);
		listaDeDesafios.add(d8);
		listaDeDesafios.add(d9);
		listaDeDesafios.add(d10);
		listaDeDesafios.add(d11);
		listaDeDesafios.add(d12);
		listaDeDesafios.add(d13);
		listaDeDesafios.add(d14);
		listaDeDesafios.add(d15);
		listaDeDesafios.add(d16);
		listaDeDesafios.add(d17);
		listaDeDesafios.add(d18);
		listaDeDesafios.add(d19);
		listaDeDesafios.add(d20);
		listaDeDesafios.add(d21);
		listaDeDesafios.add(d22);
		listaDeDesafios.add(d23);
		
		when(user.getSistema()).thenReturn(sistema);
		when(sistema.getDesafios()).thenReturn(listaDeDesafios);
	}

	private void setUpMockDesafios() {
		d1 = mock(Desafio.class);
		d2 = mock(Desafio.class);
		d3 = mock(Desafio.class);
		d4 = mock(Desafio.class);
		d5 = mock(Desafio.class);
		d6 = mock(Desafio.class);
		d7 = mock(Desafio.class);
		d8 = mock(Desafio.class);
		d9 = mock(Desafio.class);
		d10 = mock(Desafio.class);
		d11 = mock(Desafio.class);
		d12 = mock(Desafio.class);
		d13 = mock(Desafio.class);
		d14 = mock(Desafio.class);
		d15 = mock(Desafio.class);
		d16 = mock(Desafio.class);
		d17 = mock(Desafio.class);
		d18 = mock(Desafio.class);
		d19 = mock(Desafio.class);
		d20 = mock(Desafio.class);	
		d21 = mock(Desafio.class);
		d22 = mock(Desafio.class);
		d23 = mock(Desafio.class);
	}
	
	private void setupDesafioCoincidencia(Desafio desafio,  double coincidencia) {
		when(perfil.calcularCoincidenciaConDesafio(desafio)).thenReturn(coincidencia);	
	}

	

	
	@Test
	void testRecomendarDevuelve5Desafios() {
		assertTrue(recomendador.recomendar().size() == 5);
	}
	 
	@Test
	void testRecomendar1() {
		
		// Los primeros 5 desafios con mayor coincidencia son: d1,d3,d5,d7,d10

		this.setupDesafioCoincidencia(d1, 0);
		this.setupDesafioCoincidencia(d3, 0);
		this.setupDesafioCoincidencia(d5, 0);
		this.setupDesafioCoincidencia(d7, 0);
		this.setupDesafioCoincidencia(d10, 0);
		
		// Los demas desafios que no tienen la mayor coincidencia.

		
		this.setupDesafioCoincidencia(d2, 10);
		this.setupDesafioCoincidencia(d4, 14);
		this.setupDesafioCoincidencia(d6, 10);
		this.setupDesafioCoincidencia(d8, 12);
		this.setupDesafioCoincidencia(d9, 11);
		this.setupDesafioCoincidencia(d15, 8);
		this.setupDesafioCoincidencia(d14, 7);
		this.setupDesafioCoincidencia(d13, 12);
		this.setupDesafioCoincidencia(d12, 12);
		this.setupDesafioCoincidencia(d11, 14);
		this.setupDesafioCoincidencia(d16, 12);
		this.setupDesafioCoincidencia(d17, 11);
		this.setupDesafioCoincidencia(d18, 12);
		this.setupDesafioCoincidencia(d19, 12);
		this.setupDesafioCoincidencia(d20, 9);
		this.setupDesafioCoincidencia(d23, 12);
		this.setupDesafioCoincidencia(d22, 6);
		this.setupDesafioCoincidencia(d21, 4);
		
		assertTrue(this.recomendador.recomendar().contains(d1));
		assertTrue(this.recomendador.recomendar().contains(d3));
		assertTrue(this.recomendador.recomendar().contains(d5));
		assertTrue(this.recomendador.recomendar().contains(d7));
		assertTrue(this.recomendador.recomendar().contains(d10));
	}
	
	@Test
	void testRecomendar2() {
		
		// Los primeros 5 desafios con mayor coincidencia son: d1,d3,d5,d7,d10

		this.setupDesafioCoincidencia(d1, 0.6);
		this.setupDesafioCoincidencia(d3, 0.4);
		this.setupDesafioCoincidencia(d5, 0.1);
		this.setupDesafioCoincidencia(d7, 0.9);
		this.setupDesafioCoincidencia(d10, 0.1);
		
		// Los demas desafios que no tienen la mayor coincidencia.
		
		
		this.setupDesafioCoincidencia(d2, 12.3);
		this.setupDesafioCoincidencia(d4, 14.36);
		this.setupDesafioCoincidencia(d6, 10.365);
		this.setupDesafioCoincidencia(d8, 12.6);
		this.setupDesafioCoincidencia(d9, 11.36);
		this.setupDesafioCoincidencia(d15, 7.6);
		this.setupDesafioCoincidencia(d14, 15.6);
		this.setupDesafioCoincidencia(d13, 12.11);
		this.setupDesafioCoincidencia(d12, 14.12);
		this.setupDesafioCoincidencia(d11, 17.33);
		this.setupDesafioCoincidencia(d16, 12.74);
		this.setupDesafioCoincidencia(d17, 11.47);
		this.setupDesafioCoincidencia(d18, 12.14);
		this.setupDesafioCoincidencia(d19, 11.396);
		this.setupDesafioCoincidencia(d20, 9.6);
		this.setupDesafioCoincidencia(d23, 12.4);
		this.setupDesafioCoincidencia(d22, 6.39);
		this.setupDesafioCoincidencia(d21, 4.12);
		
		assertTrue(this.recomendador.recomendar().contains(d1));
		assertTrue(this.recomendador.recomendar().contains(d3));
		assertTrue(this.recomendador.recomendar().contains(d5));
		assertTrue(this.recomendador.recomendar().contains(d7));
		assertTrue(this.recomendador.recomendar().contains(d10));
	}
	
	@Test
	void testRecomendar3() {
		
		// Los primeros 5 desafios con mayor coincidencia  son: d1,d3,d5,d7,d10
		// CASO BORDE: los desafios d1, d3, d5, d7 y d10 tienen una diferencia de 0.1 con los demas.
		
		this.setupDesafioCoincidencia(d1, 0.9);
		this.setupDesafioCoincidencia(d3, 0.9);
		this.setupDesafioCoincidencia(d5, 0.9);
		this.setupDesafioCoincidencia(d7, 0.9);
		this.setupDesafioCoincidencia(d10, 0.9);
		
		// Los demas desafios que no tienen la mayor coincidencia.
		
		
		this.setupDesafioCoincidencia(d2, 1);
		this.setupDesafioCoincidencia(d4, 1);
		this.setupDesafioCoincidencia(d6, 1);
		this.setupDesafioCoincidencia(d8, 1);
		this.setupDesafioCoincidencia(d9, 1);
		this.setupDesafioCoincidencia(d15, 1);
		this.setupDesafioCoincidencia(d14, 1);
		this.setupDesafioCoincidencia(d13, 1);
		this.setupDesafioCoincidencia(d12, 1);
		this.setupDesafioCoincidencia(d11, 1);
		this.setupDesafioCoincidencia(d16, 1);
		this.setupDesafioCoincidencia(d17, 1);
		this.setupDesafioCoincidencia(d18, 1);
		this.setupDesafioCoincidencia(d19, 1);
		this.setupDesafioCoincidencia(d20, 1);
		this.setupDesafioCoincidencia(d23, 1);
		this.setupDesafioCoincidencia(d22, 1);
		this.setupDesafioCoincidencia(d21, 1);
		
		assertTrue(this.recomendador.recomendar().contains(d1));
		assertTrue(this.recomendador.recomendar().contains(d3));
		assertTrue(this.recomendador.recomendar().contains(d5));
		assertTrue(this.recomendador.recomendar().contains(d7));
		assertTrue(this.recomendador.recomendar().contains(d10));
	}
	
	@Test
	void testSacarDesafiosQueYaRealizo() {
		
		// Los desafios con mayor coincidencia son: d1,d3,d5,d7,d10,d2 y d4
		// D2 y d4 son desafios que el usuario ya tomo, por lo que se ignoran
		
		this.setupDesafioCoincidencia(d1, 0.9);
		this.setupDesafioCoincidencia(d3, 0.9);
		this.setupDesafioCoincidencia(d5, 0.9);
		this.setupDesafioCoincidencia(d7, 0.9);
		this.setupDesafioCoincidencia(d10, 0.9);
		this.setupDesafioCoincidencia(d2, 0.2);
		this.setupDesafioCoincidencia(d4, 0.2);
		
		DesafioAceptado d2Aceptado = mock(DesafioAceptado.class);
		DesafioAceptado d4Aceptado = mock(DesafioAceptado.class);
		List<DesafioAceptado> desafiosIgnoradosDeUsuario = new ArrayList<DesafioAceptado>();
		desafiosIgnoradosDeUsuario.add(d2Aceptado);
		desafiosIgnoradosDeUsuario.add(d4Aceptado);
		when(d2Aceptado.getDesafio()).thenReturn(d2);
		when(d4Aceptado.getDesafio()).thenReturn(d4);
		
		when(user.getDesafios()).thenReturn(desafiosIgnoradosDeUsuario);
		
		// Los demas desafios que no tienen la mayor coincidencia.
		
		this.setupDesafioCoincidencia(d6, 1);
		this.setupDesafioCoincidencia(d8, 1);
		this.setupDesafioCoincidencia(d9, 1);
		this.setupDesafioCoincidencia(d15, 1);
		this.setupDesafioCoincidencia(d14, 1);
		this.setupDesafioCoincidencia(d13, 1);
		this.setupDesafioCoincidencia(d12, 1);
		this.setupDesafioCoincidencia(d11, 1);
		this.setupDesafioCoincidencia(d16, 1);
		this.setupDesafioCoincidencia(d17, 1);
		this.setupDesafioCoincidencia(d18, 1);
		this.setupDesafioCoincidencia(d19, 1);
		this.setupDesafioCoincidencia(d20, 1);
		this.setupDesafioCoincidencia(d23, 1);
		this.setupDesafioCoincidencia(d22, 1);
		this.setupDesafioCoincidencia(d21, 1);
		
		assertTrue(this.recomendador.recomendar().contains(d1));
		assertTrue(this.recomendador.recomendar().contains(d3));
		assertTrue(this.recomendador.recomendar().contains(d5));
		assertTrue(this.recomendador.recomendar().contains(d7));
		assertTrue(this.recomendador.recomendar().contains(d10));
		
		assertFalse(this.recomendador.recomendar().contains(d4));
		assertFalse(this.recomendador.recomendar().contains(d2));
	}
	
	@Test
	void testRecomendarConUnaListaDeDesafiosCon6Elementos() {
		
		// Los primeros 5 desafios con mayor coincidencia son: d1,d2,d3,d4,d5
		// Los desafios d1, d2, d3, d4, d5 y d10 son los unicos que hay en la lista del sistema. 
		listaDeDesafios = new ArrayList<Desafio>();
		listaDeDesafios.add(d1);
		listaDeDesafios.add(d2);
		listaDeDesafios.add(d3);
		listaDeDesafios.add(d4);
		listaDeDesafios.add(d5);
		listaDeDesafios.add(d10);
		when(user.getSistema()).thenReturn(sistema);
		when(sistema.getDesafios()).thenReturn(listaDeDesafios);
		
		this.setupDesafioCoincidencia(d1, 1);
		this.setupDesafioCoincidencia(d2, 3);
		this.setupDesafioCoincidencia(d3, 0);
		this.setupDesafioCoincidencia(d4, 2);
		this.setupDesafioCoincidencia(d5, 3);
		
		this.setupDesafioCoincidencia(d10, 10);
		
		assertFalse(this.recomendador.recomendar().contains(d10));
		assertTrue(this.recomendador.recomendar().contains(d1));
		assertTrue(this.recomendador.recomendar().contains(d2));
		assertTrue(this.recomendador.recomendar().contains(d3));
		assertTrue(this.recomendador.recomendar().contains(d4));
		assertTrue(this.recomendador.recomendar().contains(d5));
		assertTrue(this.recomendador.recomendar().size() == 5);
	}
	
	@Test
	void testRecomendarConUnaListaDeDesafiosConMenosDe5Elementos() {
		
		// Los primeros 5 desafios con mayor coincidencia y con mayor similitud son: d1,d2,d3,d4,d5
		// Los desafios d1, d2, d3 y d4 son los unicos que hay en la lista del sistema. Retorna esos desafios
		listaDeDesafios = new ArrayList<Desafio>();
		listaDeDesafios.add(d1);
		listaDeDesafios.add(d2);
		listaDeDesafios.add(d3);
		listaDeDesafios.add(d4);
		
		when(user.getSistema()).thenReturn(sistema);
		when(sistema.getDesafios()).thenReturn(listaDeDesafios);
		
		this.setupDesafioCoincidencia(d1, 1);
		this.setupDesafioCoincidencia(d2, 3);
		this.setupDesafioCoincidencia(d3, 0);
		this.setupDesafioCoincidencia(d4, 2);
		
		assertTrue(this.recomendador.recomendar().contains(d1));
		assertTrue(this.recomendador.recomendar().contains(d2));
		assertTrue(this.recomendador.recomendar().contains(d3));
		assertTrue(this.recomendador.recomendar().contains(d4));
		assertTrue(this.recomendador.recomendar().size() == 4);
	}
	
	@Test
	void testRecomendarConUnaListaDeDesafiosVacia() {
		
		listaDeDesafios = new ArrayList<Desafio>();
		
		when(user.getSistema()).thenReturn(sistema);
		when(sistema.getDesafios()).thenReturn(listaDeDesafios);
		
		assertTrue(this.recomendador.recomendar().size() == 0);
	}
}
