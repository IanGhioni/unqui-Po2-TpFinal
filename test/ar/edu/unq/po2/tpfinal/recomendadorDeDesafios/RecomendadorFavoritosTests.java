package ar.edu.unq.po2.tpfinal.recomendadorDeDesafios;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpfinal.desafio.Desafio;
import ar.edu.unq.po2.tpfinal.sistema.Sistema;
import ar.edu.unq.po2.tpfinal.usuario.PerfilDeUsuario;
import ar.edu.unq.po2.tpfinal.usuario.Usuario;
import static org.mockito.Mockito.*;


class RecomendadorFavoritosTests {

	ArrayList<Desafio> listaDeDesafios; 
	Recomendable recomendador;
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
		
		recomendador = new RecomendadorFavoritos(user);

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
		when(sistema.getListaDeDesafios()).thenReturn(listaDeDesafios);
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
	
	private void setupDesafioSimilitud(Desafio desafio, double similitud) {
		when(desafio.calcularSimilitudConDesafio(desafioMasGustado)).thenReturn(similitud);	
	}

	private void setupPerfilCoincidencia(Desafio desafio, double coincidencia) {
		when(perfil.calcularCoincidenciaConDesafio(desafio)).thenReturn(coincidencia);
	}
	
	
	
	@Test
	void testRecomendarDevuelve5Desafios() {
		assertTrue(recomendador.recomendar().size() == 5);
	}
	 
	@Test
	void testRecomendar1() {
		
		// Los primeros 5 desafios con mayor coincidencia y con mayor similitud son: d1,d3,d5,d7,d10
		this.setupPerfilCoincidencia(d1, 0);
		this.setupPerfilCoincidencia(d3, 0);
		this.setupPerfilCoincidencia(d5, 0);
		this.setupPerfilCoincidencia(d7, 0);
		this.setupPerfilCoincidencia(d10, 0);
		this.setupDesafioSimilitud(d1, 0);
		this.setupDesafioSimilitud(d3, 0);
		this.setupDesafioSimilitud(d5, 0);
		this.setupDesafioSimilitud(d7, 0);
		this.setupDesafioSimilitud(d10, 0);
		
		// Los demas desafios que no tienen la mayor coincidencia ni la mayor similitud.
		this.setupPerfilCoincidencia(d2, 10);
		this.setupPerfilCoincidencia(d4, 9);
		this.setupPerfilCoincidencia(d6, 7);
		this.setupPerfilCoincidencia(d8, 10);
		this.setupPerfilCoincidencia(d9, 12);
		this.setupPerfilCoincidencia(d15, 14);
		this.setupPerfilCoincidencia(d14, 10);
		this.setupPerfilCoincidencia(d13, 8);
		this.setupPerfilCoincidencia(d12, 4);
		this.setupPerfilCoincidencia(d11, 5);
		this.setupPerfilCoincidencia(d16, 7);
		this.setupPerfilCoincidencia(d17, 4);
		this.setupPerfilCoincidencia(d18, 8);
		this.setupPerfilCoincidencia(d19, 8);
		this.setupPerfilCoincidencia(d20, 7);
		this.setupPerfilCoincidencia(d23, 10);
		this.setupPerfilCoincidencia(d22, 12);
		this.setupPerfilCoincidencia(d21, 11);
		
		this.setupDesafioSimilitud(d2, 10);
		this.setupDesafioSimilitud(d4, 14);
		this.setupDesafioSimilitud(d6, 10);
		this.setupDesafioSimilitud(d8, 12);
		this.setupDesafioSimilitud(d9, 11);
		this.setupDesafioSimilitud(d15, 8);
		this.setupDesafioSimilitud(d14, 7);
		this.setupDesafioSimilitud(d13, 12);
		this.setupDesafioSimilitud(d12, 12);
		this.setupDesafioSimilitud(d11, 14);
		this.setupDesafioSimilitud(d16, 12);
		this.setupDesafioSimilitud(d17, 11);
		this.setupDesafioSimilitud(d18, 12);
		this.setupDesafioSimilitud(d19, 12);
		this.setupDesafioSimilitud(d20, 9);
		this.setupDesafioSimilitud(d23, 12);
		this.setupDesafioSimilitud(d22, 6);
		this.setupDesafioSimilitud(d21, 4);
		
		assertTrue(this.recomendador.recomendar().contains(d1));
		assertTrue(this.recomendador.recomendar().contains(d3));
		assertTrue(this.recomendador.recomendar().contains(d5));
		assertTrue(this.recomendador.recomendar().contains(d7));
		assertTrue(this.recomendador.recomendar().contains(d10));
	}
	
	@Test
	void testRecomendar2() {
		
		// Los primeros 5 desafios con mayor coincidencia y con mayor similitud son: d1,d3,d5,d7,d10
		this.setupPerfilCoincidencia(d1, 0.1);
		this.setupPerfilCoincidencia(d3, 0.2);
		this.setupPerfilCoincidencia(d5, 0);
		this.setupPerfilCoincidencia(d7, 0.6);
		this.setupPerfilCoincidencia(d10, 0.1);
		this.setupDesafioSimilitud(d1, 0.6);
		this.setupDesafioSimilitud(d3, 0.4);
		this.setupDesafioSimilitud(d5, 0.1);
		this.setupDesafioSimilitud(d7, 0.9);
		this.setupDesafioSimilitud(d10, 0.1);
		
		// Los demas desafios que no tienen la mayor coincidencia ni la mayor similitud.
		this.setupPerfilCoincidencia(d2, 10.1);
		this.setupPerfilCoincidencia(d4, 4.3);
		this.setupPerfilCoincidencia(d6, 7.66);
		this.setupPerfilCoincidencia(d8, 10.15);
		this.setupPerfilCoincidencia(d9, 12.15);
		this.setupPerfilCoincidencia(d15, 4.51);
		this.setupPerfilCoincidencia(d14, 10.12);
		this.setupPerfilCoincidencia(d13, 8.045);
		this.setupPerfilCoincidencia(d12, 4);
		this.setupPerfilCoincidencia(d11, 5);
		this.setupPerfilCoincidencia(d16, 7.6);
		this.setupPerfilCoincidencia(d17, 4);
		this.setupPerfilCoincidencia(d18, 8);
		this.setupPerfilCoincidencia(d19, 4.12);
		this.setupPerfilCoincidencia(d20, 7.3);
		this.setupPerfilCoincidencia(d23, 1.3);
		this.setupPerfilCoincidencia(d22, 12.47);
		this.setupPerfilCoincidencia(d21, 11.4);
		
		this.setupDesafioSimilitud(d2, 12.3);
		this.setupDesafioSimilitud(d4, 14.36);
		this.setupDesafioSimilitud(d6, 10.365);
		this.setupDesafioSimilitud(d8, 12.6);
		this.setupDesafioSimilitud(d9, 11.36);
		this.setupDesafioSimilitud(d15, 7.6);
		this.setupDesafioSimilitud(d14, 15.6);
		this.setupDesafioSimilitud(d13, 12.11);
		this.setupDesafioSimilitud(d12, 14.12);
		this.setupDesafioSimilitud(d11, 17.33);
		this.setupDesafioSimilitud(d16, 12.74);
		this.setupDesafioSimilitud(d17, 11.47);
		this.setupDesafioSimilitud(d18, 12.14);
		this.setupDesafioSimilitud(d19, 11.396);
		this.setupDesafioSimilitud(d20, 9.6);
		this.setupDesafioSimilitud(d23, 12.4);
		this.setupDesafioSimilitud(d22, 6.39);
		this.setupDesafioSimilitud(d21, 4.12);
		
		assertTrue(this.recomendador.recomendar().contains(d1));
		assertTrue(this.recomendador.recomendar().contains(d3));
		assertTrue(this.recomendador.recomendar().contains(d5));
		assertTrue(this.recomendador.recomendar().contains(d7));
		assertTrue(this.recomendador.recomendar().contains(d10));
	}
	
	@Test
	void testRecomendar3() {
		
		// Los primeros 5 desafios con mayor coincidencia y con mayor similitud son: d1,d3,d5,d7,d10
		// Los desafios d1, d3, d5, d7 y d10 tienen una diferencia de 0.1 con los demas.
		this.setupPerfilCoincidencia(d1, 0.9);
		this.setupPerfilCoincidencia(d3, 0.9);
		this.setupPerfilCoincidencia(d5, 0.9);
		this.setupPerfilCoincidencia(d7, 0.9);
		this.setupPerfilCoincidencia(d10, 0.9);
		this.setupDesafioSimilitud(d1, 0.9);
		this.setupDesafioSimilitud(d3, 0.9);
		this.setupDesafioSimilitud(d5, 0.9);
		this.setupDesafioSimilitud(d7, 0.9);
		this.setupDesafioSimilitud(d10, 0.9);
		
		// Los demas desafios que no tienen la mayor coincidencia ni la mayor similitud.
		this.setupPerfilCoincidencia(d2, 1);
		this.setupPerfilCoincidencia(d4, 1);
		this.setupPerfilCoincidencia(d6, 1);
		this.setupPerfilCoincidencia(d8, 1);
		this.setupPerfilCoincidencia(d9, 1);
		this.setupPerfilCoincidencia(d15, 1);
		this.setupPerfilCoincidencia(d14, 1);
		this.setupPerfilCoincidencia(d13, 1);
		this.setupPerfilCoincidencia(d12, 1);
		this.setupPerfilCoincidencia(d11, 1);
		this.setupPerfilCoincidencia(d16, 1);
		this.setupPerfilCoincidencia(d17, 1);
		this.setupPerfilCoincidencia(d18, 1);
		this.setupPerfilCoincidencia(d19, 1);
		this.setupPerfilCoincidencia(d20, 1);
		this.setupPerfilCoincidencia(d23, 1);
		this.setupPerfilCoincidencia(d22, 1);
		this.setupPerfilCoincidencia(d21, 1);
		
		this.setupDesafioSimilitud(d2, 1);
		this.setupDesafioSimilitud(d4, 1);
		this.setupDesafioSimilitud(d6, 1);
		this.setupDesafioSimilitud(d8, 1);
		this.setupDesafioSimilitud(d9, 1);
		this.setupDesafioSimilitud(d15, 1);
		this.setupDesafioSimilitud(d14, 1);
		this.setupDesafioSimilitud(d13, 1);
		this.setupDesafioSimilitud(d12, 1);
		this.setupDesafioSimilitud(d11, 1);
		this.setupDesafioSimilitud(d16, 1);
		this.setupDesafioSimilitud(d17, 1);
		this.setupDesafioSimilitud(d18, 1);
		this.setupDesafioSimilitud(d19, 1);
		this.setupDesafioSimilitud(d20, 1);
		this.setupDesafioSimilitud(d23, 1);
		this.setupDesafioSimilitud(d22, 1);
		this.setupDesafioSimilitud(d21, 1);
		
		assertTrue(this.recomendador.recomendar().contains(d1));
		assertTrue(this.recomendador.recomendar().contains(d3));
		assertTrue(this.recomendador.recomendar().contains(d5));
		assertTrue(this.recomendador.recomendar().contains(d7));
		assertTrue(this.recomendador.recomendar().contains(d10));
	}
	
	@Test
	void testRecomendarConUnaListaDeDesafiosCon6Elementos() {
		
		// Los primeros 5 desafios con mayor coincidencia y con mayor similitud son: d1,d2,d3,d4,d5
		// Los desafios d1, d2, d3, d4, d5 y d10 son los unicos que hay en la lista del sistema. 
		listaDeDesafios = new ArrayList<Desafio>();
		listaDeDesafios.add(d1);
		listaDeDesafios.add(d2);
		listaDeDesafios.add(d3);
		listaDeDesafios.add(d4);
		listaDeDesafios.add(d5);
		listaDeDesafios.add(d10);
		when(user.getSistema()).thenReturn(sistema);
		when(sistema.getListaDeDesafios()).thenReturn(listaDeDesafios);
		
		this.setupPerfilCoincidencia(d1, 1);
		this.setupPerfilCoincidencia(d2, 1.2);
		this.setupPerfilCoincidencia(d3, 2);
		this.setupPerfilCoincidencia(d4, 0);
		this.setupPerfilCoincidencia(d5, 0);
		this.setupDesafioSimilitud(d1, 1);
		this.setupDesafioSimilitud(d2, 1);
		this.setupDesafioSimilitud(d3, 3);
		this.setupDesafioSimilitud(d4, 2);
		this.setupDesafioSimilitud(d5, 1);
		
		this.setupPerfilCoincidencia(d10, 12);
		this.setupDesafioSimilitud(d10, 10);
		
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
		when(sistema.getListaDeDesafios()).thenReturn(listaDeDesafios);
		
		this.setupPerfilCoincidencia(d1, 1);
		this.setupPerfilCoincidencia(d2, 1.2);
		this.setupPerfilCoincidencia(d3, 2);
		this.setupPerfilCoincidencia(d4, 0);
		this.setupDesafioSimilitud(d1, 1);
		this.setupDesafioSimilitud(d2, 1);
		this.setupDesafioSimilitud(d3, 3);
		this.setupDesafioSimilitud(d4, 2);
		
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
		when(sistema.getListaDeDesafios()).thenReturn(listaDeDesafios);
		
		assertTrue(this.recomendador.recomendar().size() == 0);
	}
}
