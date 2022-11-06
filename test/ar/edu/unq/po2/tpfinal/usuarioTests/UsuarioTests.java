package ar.edu.unq.po2.tpfinal.usuarioTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpfinal.desafio.Desafio;
import ar.edu.unq.po2.tpfinal.desafio.DesafioAceptado;
import ar.edu.unq.po2.tpfinal.filtrador.Evaluable;
import ar.edu.unq.po2.tpfinal.filtrador.Filtrador;
import ar.edu.unq.po2.tpfinal.muestra.Muestra;
import ar.edu.unq.po2.tpfinal.proyecto.Proyecto;
import ar.edu.unq.po2.tpfinal.recomendadorDeDesafios.Recomendador;
import ar.edu.unq.po2.tpfinal.sistema.Circunferencia;
import ar.edu.unq.po2.tpfinal.sistema.Sistema;
import ar.edu.unq.po2.tpfinal.usuario.PerfilDeUsuario;
import ar.edu.unq.po2.tpfinal.usuario.Usuario;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

class UsuarioTests {
	
	Usuario user;
	Proyecto p1;
	Desafio d1;	
	Muestra m1;
	Sistema sistema;
	PerfilDeUsuario perfil;
	Recomendador recomendador;
	Filtrador filtrador;

	@BeforeEach
	void setUp() throws Exception {
		sistema = mock(Sistema.class);
		p1 = mock(Proyecto.class);
		d1 = mock(Desafio.class);
		perfil = mock(PerfilDeUsuario.class);
		filtrador = mock(Filtrador.class);
		recomendador = mock(Recomendador.class);
		
		user = new Usuario(sistema, perfil, recomendador);
	}

	
	@Test
	void testGetPerfilDeUsuario() {
		assertEquals(user.getPerfilDeUsuario(), perfil);
	}


	@Test
	void testGetRecomendador() {
		assertEquals(user.getRecomendador(), recomendador);
	}

	@Test
	void testGetSistema() {
		assertEquals(user.getSistema(),sistema);
	}

	@Test
	void testSuscribirseAProyecto() {
		user.suscribirseAProyecto(p1);
		assertTrue(user.getProyectos().contains(p1));
		assertTrue(user.getMuestrasAgregables().contains(p1));
		verify(p1).suscribirUsuario(user);
	}

	@Test
	void testDesuscribirseAProyecto() {
		user.suscribirseAProyecto(p1);
		user.desuscribirseAProyecto(p1);
		assertFalse(user.getProyectos().contains(p1));
		assertFalse(user.getMuestrasAgregables().contains(p1));
		verify(p1).desuscribirUsuario(user);
	}
	
	@Test
	void testAceptarDesafio() {
		when(d1.getArea()).thenReturn(mock(Circunferencia.class));
		when(d1.getCantidadMinimaMuestras()).thenReturn(3);
		when(d1.getDificultad()).thenReturn(5);
		when(d1.getRecompensa()).thenReturn(200);
		
		user.aceptarDesafio(d1);
		
		verify(d1).getArea();
		verify(d1).getCantidadMinimaMuestras();
		verify(d1).getDificultad();
		verify(d1).getRecompensa();
		
		assertTrue(!user.getDesafios().isEmpty());
		assertTrue(!user.getMuestrasAgregables().isEmpty());
	}
	
	@Test
	void testCalificarDesafio() {
		DesafioAceptado desafioAceptado = mock(DesafioAceptado.class);
		user.calificarDesafio(desafioAceptado, 4);
		verify(desafioAceptado).setCalificacion(4);
	}
	
	@Test
	void testDesafioMasGustado() {
		DesafioAceptado desafioMenosGustado = mock(DesafioAceptado.class);
		DesafioAceptado desafioMasGustado = mock(DesafioAceptado.class);
		user.getDesafios().add(desafioMasGustado);
		user.getDesafios().add(desafioMenosGustado);
		user.calificarDesafio(desafioMenosGustado, 1);
		user.calificarDesafio(desafioMasGustado, 4);
		
		assertEquals(user.desafioMasGustado(), desafioMasGustado);
	}

	@Test
	void testTomarMuestra() {
		DesafioAceptado desafioAceptado = mock(DesafioAceptado.class);
		
		user.getDesafios().add(desafioAceptado);
		user.getProyectos().add(p1);
		
		user.getMuestrasAgregables().add(desafioAceptado);
		user.getMuestrasAgregables().add(p1);
		
		user.tomarMuestra(m1);
		
		assertTrue(user.getMuestras().contains(m1));
		verify(p1).notify(user);
		verify(desafioAceptado).notify(user);
	}
	
	
	
	
	
	
	@Test
	void testGetDesafiosCompletados() {
		DesafioAceptado desafioCompletado = mock(DesafioAceptado.class);
		DesafioAceptado desafioNoCompletado = mock(DesafioAceptado.class);
		DesafioAceptado desafioVencido = mock(DesafioAceptado.class);
		when(desafioCompletado.getEstado()).thenReturn("Desafío completado");
		when(desafioNoCompletado.getEstado()).thenReturn("Desafío en curso");
		when(desafioVencido.getEstado()).thenReturn("Desafío vencido");
		user.getDesafios().add(desafioCompletado);
		user.getDesafios().add(desafioNoCompletado);
		user.getDesafios().add(desafioVencido);
		
		
		List<DesafioAceptado> listaResultante = user.getDesafiosCompletados();
		
		
		assertTrue(listaResultante.size() == 1);	
		verify(desafioCompletado).getEstado();
		verify(desafioNoCompletado).getEstado();
		verify(desafioVencido).getEstado();
		assertTrue(user.getDesafiosCompletados().contains(desafioCompletado));
		assertFalse(user.getDesafiosCompletados().contains(desafioNoCompletado));
		assertFalse(user.getDesafiosCompletados().contains(desafioVencido));
	}
	
	
	
	
	
	
	@Test
	void testCalcularPorcentajeDeCompletitud() {
		DesafioAceptado desafioAceptado1 = mock(DesafioAceptado.class);
		user.getDesafios().add(desafioAceptado1);
		DesafioAceptado desafioAceptado2 = mock(DesafioAceptado.class);
		user.getDesafios().add(desafioAceptado2);
		
		when(desafioAceptado1.porcentajeCompletitud(desafioAceptado1)).thenReturn(50.0);
		when(desafioAceptado2.porcentajeCompletitud(desafioAceptado2)).thenReturn(50.0);
		assertEquals(user.calcularPorcentajeDeCompletitud(), 50.0);
		verify(desafioAceptado1).porcentajeCompletitud(desafioAceptado1);
	}
	
	@Test
	void testGetPorcentajeDeCompletitudDeDesafio() {
		
		DesafioAceptado desafioAceptado = mock(DesafioAceptado.class);
		when(desafioAceptado.porcentajeCompletitud(desafioAceptado)).thenReturn(50.0);
		
		assertTrue(user.getPorcentajeDeCompletitudDeDesafio(desafioAceptado) == 50.0);
	}

	@Test
	void testGetHoraDeCompletitudDeDesafio() {
		LocalTime hora = LocalTime.now();
		DesafioAceptado desafioAceptado = mock(DesafioAceptado.class);
		when(desafioAceptado.getHoraCompletado()).thenReturn(hora);
		assertEquals(user.getHoraDeCompletitudDeDesafio(desafioAceptado),hora);
	}

	@Test
	void testGetFechaDeCompletitudDeDesafio() {
		LocalDate fecha= LocalDate.now();
		DesafioAceptado desafioAceptado = mock(DesafioAceptado.class);
		
		when(desafioAceptado.getFechaCompletado()).thenReturn(fecha);
		assertEquals(user.getFechaDeCompletitudDeDesafio(desafioAceptado),fecha);
	}

	

	@Test
	void testSetDificultadPreferida() throws Exception {
		user.setDificultadPreferida(4);
		verify(perfil).setDificultad(4);
	}

	@Test
	void testSetCantMinMuestrasPreferida() throws Exception {
		user.setCantMinMuestrasPreferida(5);
		verify(perfil).setCantidadMinimaMuestras(5);
	}

	@Test
	void testSetRecompensaPreferida() throws Exception {
		user.setRecompensaPreferida(100);
		verify(perfil).setRecompensa(100);;
	}

	@Test
	void testRecomendar() {
		user.recomendar();
		verify(recomendador).recomendar();
	}

	@Test
	void testBuscarProyectos() {
		user.buscarProyectos(filtrador);
		verify(filtrador).evaluar(new ArrayList<Evaluable>());
	}

}
