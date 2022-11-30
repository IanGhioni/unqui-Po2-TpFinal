package ar.edu.unq.po2.tpfinal.desafioTests;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpfinal.desafio.Desafio;
import ar.edu.unq.po2.tpfinal.desafio.DesafioAceptado;
import ar.edu.unq.po2.tpfinal.desafio.EstadoDesafio;
import ar.edu.unq.po2.tpfinal.desafio.EstadoDesafioVencido;
import ar.edu.unq.po2.tpfinal.desafio.RestriccionFechas;
import ar.edu.unq.po2.tpfinal.desafio.RestriccionFinDeSemana;
import ar.edu.unq.po2.tpfinal.desafio.RestriccionSemanal;
import ar.edu.unq.po2.tpfinal.sistema.Circunferencia;
import ar.edu.unq.po2.tpfinal.usuario.Usuario;

public class DesafioAceptadoTest {
	Desafio desafioInicial;
	DesafioAceptado desafio;
	Usuario usuario;
	RestriccionSemanal restriccionSemanal;
	RestriccionFechas restriccionFechas;
	RestriccionFinDeSemana restriccionFinDe;

	@BeforeEach
	void setUp() {
		desafioInicial = mock(Desafio.class);
		usuario = mock(Usuario.class);
		restriccionSemanal = mock(RestriccionSemanal.class);
		restriccionFechas = mock(RestriccionFechas.class);
		restriccionFinDe = mock(RestriccionFinDeSemana.class);
	}

	@Test
	void testDesafioAceptadoDevuelveEstado() {
		desafio = new DesafioAceptado(desafioInicial, usuario);
		desafio.getEstado();
		assertEquals(desafio.getEstado(), "Desafío en curso");

	}

	@Test
	void testDesafioAceptadoDevuelveUsuario() {
		desafio = new DesafioAceptado(desafioInicial, usuario);
		assertEquals(usuario, desafio.getUsuario());
	}

	@Test
	void testDesafioAceptadoDevuelveMuestrasTomadas() {
		desafio = new DesafioAceptado(desafioInicial, usuario);
		assertEquals(0, desafio.getMuestrasTomadas());
	}

	@Test
	void testDesafioAceptadoAgregaMuestra() {
		desafio = new DesafioAceptado(desafioInicial, usuario);
		desafio.agregarMuestra(1, desafio);
		assertEquals(desafio.getMuestrasTomadas(), 1);

	}

	@Test
	void testDesafioAceptadoFaltaUnaMuestra() {
		desafio = new DesafioAceptado(desafioInicial, usuario);
		desafio.setMuestrasTomadas(4);
		when(desafioInicial.getCantidadMinimaMuestras()).thenReturn(5);
		assertTrue(desafio.faltaUnaMuestra());
	}

	@Test
	void testDesafioAceptadoFaltaMasDeUnaMuestra() {
		desafio = new DesafioAceptado(desafioInicial, usuario);
		assertFalse(desafio.faltaUnaMuestra());
	}

//	@Test
//	void testDesafioAceptadoPorcentajeCompletitud() {
//		desafio = new DesafioAceptado(desafioInicial, usuario);
//		desafio.porcentajeCompletitud(desafio);
//		//verify(estado).porcentajeCompletitud(desafio);
//	}

	@Test
	void testDesafioAceptadoSetFechaCompletado() {
		LocalDate fechaCompletado = LocalDate.now();
		desafio = new DesafioAceptado(desafioInicial, usuario);
		desafio.setFechaCompletado(fechaCompletado);
		assertEquals(fechaCompletado, desafio.getFechaCompletado());
	}

	@Test
	void testDesafioAceptadoSetHoraCompletado() {
		LocalTime horaCompletado = LocalTime.now();
		desafio = new DesafioAceptado(desafioInicial, usuario);
		desafio.setHoraCompletado(horaCompletado);
		assertEquals(horaCompletado, desafio.getHoraCompletado());
	}

	@Test
	void testDesafioAceptadoSetMuestrasTomadas() {
		desafio = new DesafioAceptado(desafioInicial, usuario);
		desafio.setMuestrasTomadas(15);
		assertEquals(15, desafio.getMuestrasTomadas());
	}

	@Test
	void testDesafioAceptadoSetCalificacionValida() {
		desafio = new DesafioAceptado(desafioInicial, usuario);
		desafio.setCalificacion(5);
		assertEquals(5, desafio.getCalificacion());
	}

	@Test
	void testDesafioAceptadoSetCalificacionInvalida() {
		desafio = new DesafioAceptado(desafioInicial, usuario);
		Throwable exception = assertThrows(Exception.class, () -> {
			desafio.setCalificacion(6);
		});
		assertEquals(exception.getMessage(), "La calificación ingresada debe estar entre 0 y 5.");
	}

	@Test
	void testDesafioAceptadoAgregaMuestraPorRestriccionFechas() {
		desafio = new DesafioAceptado(desafioInicial, usuario);
		desafio.getDesafio().agregarRestriccion(restriccionFechas);
		when(restriccionFechas.verificarRestriccionAlDesafio(desafio, LocalDate.now())).thenReturn(true);
		when(desafioInicial.getCantidadMinimaMuestras()).thenReturn(5);
		desafio.agregarMuestra(1, desafio);
		assertEquals(desafio.getMuestrasTomadas(), 1);
	}

//	@Test
//	void testDesafioAceptadoNoAgregaMuestraPorRestriccionFechas() {
//		desafio = new DesafioAceptado(desafioInicial, usuario);
//		desafio.getDesafio().agregarRestriccion(restriccionFechas);
//		when(restriccionFechas.verificarRestriccionAlDesafio(desafio, LocalDate.now())).thenReturn(false);
//		desafio.agregarMuestra(1, desafio);
//		assertEquals(desafio.getMuestrasTomadas(), 0);
//	}

//	@Test
//	void testDesafioAceptadoNoAgregaMuestraPorRestriccionFinDeSemana() {
//		desafio = new DesafioAceptado(desafioInicial, usuario);
//		desafio.getDesafio().agregarRestriccion(restriccionFinDe);
//		when(restriccionFinDe.verificarRestriccionAlDesafio(desafio, LocalDate.now())).thenReturn(false);
//		desafio.agregarMuestra(1, desafio);
//		assertEquals(desafio.getMuestrasTomadas(), 0);
//	}

//	@Test
//	void testDesafioAceptadoNoAgregaMuestraPorRestriccionSemanal() {
//		desafio = new DesafioAceptado(desafioInicial, usuario);
//		desafio.getDesafio().agregarRestriccion(restriccionSemanal);
//		when(restriccionSemanal.verificarRestriccionAlDesafio(desafio, LocalDate.now())).thenReturn(false);
//		desafio.agregarMuestra(1, desafio);
//		assertEquals(desafio.getMuestrasTomadas(), 0);
//	}

//	@Test
//	void testDesafioAceptadoNoAgregaMuestraPorUnaRestriccionQueNoSeCumple() {
//		desafio = new DesafioAceptado(desafioInicial, usuario);
//		desafio.getDesafio().agregarRestriccion(restriccionSemanal);
//		desafio.getDesafio().agregarRestriccion(restriccionFechas);
//		when(restriccionSemanal.verificarRestriccionAlDesafio(desafio, LocalDate.now())).thenReturn(false);
//		when(restriccionFechas.verificarRestriccionAlDesafio(desafio, LocalDate.now())).thenReturn(true);
//		desafio.agregarMuestra(1, desafio);
//		assertEquals(desafio.getMuestrasTomadas(), 0);
//	}

	@Test
	void testDesafioAceptadoAgregaMuestraPorMasDeUnaRestriccionQueCumple() {
		desafio = new DesafioAceptado(desafioInicial, usuario);
		desafio.getDesafio().agregarRestriccion(restriccionFechas);
		desafio.getDesafio().agregarRestriccion(restriccionSemanal);
		when(restriccionFechas.verificarRestriccionAlDesafio(desafio, LocalDate.now())).thenReturn(true);
		when(restriccionSemanal.verificarRestriccionAlDesafio(desafio, LocalDate.now())).thenReturn(true);
		desafio.agregarMuestra(1, desafio);
		assertEquals(desafio.getMuestrasTomadas(), 1);
	}

//	@Test
//	void testDesafioAceptadoNoAgregaMuestraPorRestriccionFechasVencidaYCambiaEstadoAVencido() {
//		desafio = new DesafioAceptado(desafioInicial, usuario);
//		desafio.getDesafio().agregarRestriccion(restriccionFechas);
//		when(restriccionFechas.verificarRestriccionAlDesafio(desafio, LocalDate.now())).thenReturn(false);
//		desafio.agregarMuestra(1, desafio);
//		assertEquals(desafio.getMuestrasTomadas(), 0);
//		assertEquals(desafio.getEstado(), "Desafío vencido");
//	}

	@Test
	void testNotifyUser() {
		desafio = new DesafioAceptado(desafioInicial, usuario);
		desafio.getDesafio().agregarRestriccion(restriccionFechas);
		when(restriccionFechas.verificarRestriccionAlDesafio(desafio, LocalDate.now())).thenReturn(true);

		desafio.notify(usuario);

		assertEquals(desafio.getMuestrasTomadas(), 1);
	}
}
