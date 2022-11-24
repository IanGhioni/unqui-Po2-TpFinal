package ar.edu.unq.po2.tpfinal.proyectoTests;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpfinal.muestra.Muestra;
import ar.edu.unq.po2.tpfinal.proyecto.Proyecto;
import ar.edu.unq.po2.tpfinal.sistema.Sistema;
import ar.edu.unq.po2.tpfinal.usuario.Usuario;
import ar.edu.unq.po2.tpfinal.categoria.Categoria;

import static org.mockito.Mockito.*;

import java.util.ArrayList;

class ProyectoTest {
	private Proyecto proyecto;
	private Usuario usuario;
	private Muestra muestra;
	private Sistema sistema;
	public Categoria categoria1;
	public Categoria categoria2;
	public String nombreCategoria1;
	public String nombreCategoria2;
	
	@BeforeEach
	void setUp() throws Exception {
		sistema = mock(Sistema.class);
		categoria1 = mock(Categoria.class);
		categoria2 = mock(Categoria.class);
		nombreCategoria1 = "nombre1";
		nombreCategoria1 = "nombre2";
		when(categoria1.getNombre()).thenReturn(nombreCategoria1);
		when(categoria2.getNombre()).thenReturn(nombreCategoria2);
	}

	@Test
	void testProyectoSabeDevolverSuNombre() {
		
		proyecto = new Proyecto("nombre", "descripcion", sistema);
		assertEquals(proyecto.getNombre(), "nombre");
	}
	
	@Test
	void testProyectoSabeDevolverSuDescripcion() {
		proyecto = new Proyecto("nombre","descripcion", sistema);
		assertEquals(proyecto.getDescripcion(), "descripcion");
	}
	
	@Test
	void testProyectoSabeDevolverSuSistema() {
		proyecto = new Proyecto("nombre","descripcion", sistema);
		assertEquals(proyecto.getSistema(), sistema);
	}
	
	@Test
	void testProyectoAñadeCategorias() throws Exception {
		proyecto = new Proyecto("nombre","descripcion", sistema);
		
		when(sistema.contieneLaCategoria(categoria1)).thenReturn(true);
		
		proyecto.añadirCategoria(categoria1);
		
		assertTrue(proyecto.getCategorias().contains(categoria1));
	}
	
	@Test
	void testProyectoEliminaCategorias() {
		proyecto = new Proyecto("nombre","descripcion", sistema);
		proyecto.eliminarCategoria(categoria1);
		
		assertFalse(proyecto.getCategorias().contains(categoria1));
	}
	
	@Test
	void testProyectoAñadeUsuario() throws Exception {
		usuario = mock(Usuario.class);
		proyecto = new Proyecto("nombre","descripcion", sistema);
		when(sistema.contieneElUsuario(usuario)).thenReturn(true);
		proyecto.suscribirUsuario(usuario);
		
		assertTrue(proyecto.getUsuarios().contains(usuario));
	}
	
	@Test
	void testProyectoDesuscribeUsuario() {
		usuario = mock(Usuario.class);
		proyecto = new Proyecto("nombre","descripcion", sistema);
		proyecto.desuscribirUsuario(usuario);
		
		assertFalse(proyecto.getUsuarios().contains(usuario));
	}
	
	@Test
	void testProyectoAñadeMuestra() {
		muestra = mock(Muestra.class);
		proyecto = new Proyecto("nombre","descripcion", sistema);
		proyecto.agregarMuestra(muestra);
		
		assertTrue(proyecto.getMuestras().contains(muestra));
	}
	
	
	@Test
	void testExceptionCuandoSistemaNoTieneLaCategoriaAAñadir() {
		proyecto = new Proyecto("nombre","descripcion", sistema);
		
		when(sistema.contieneLaCategoria(categoria1)).thenReturn(false);
		
		Throwable exception = assertThrows(Exception.class, () -> {
			proyecto.añadirCategoria(categoria1);
		});
		assertEquals(exception.getMessage(), "El sistema no incluye la categoria dada.");
	}
	
	@Test
	void testNoExceptionCuandoSistemaTieneLaCategoriaAAñadir() {
		proyecto = new Proyecto("nombre","descripcion", sistema);
		
		when(sistema.contieneLaCategoria(categoria1)).thenReturn(true);
		
		assertDoesNotThrow(() -> {
			proyecto.añadirCategoria(categoria1);
		});
	}
	
	@Test
	void testProyectoEsNotificadoPorUsuario() {
		proyecto = new Proyecto("nombre","descripcion", sistema);
		usuario = mock(Usuario.class);
		muestra = mock(Muestra.class);
		ArrayList<Muestra> lista = new ArrayList<Muestra>();
		lista.add(muestra);
		
		when(usuario.getMuestras()).thenReturn(lista);
		
		proyecto.notify(usuario);
		
		verify(usuario, times(2)).getMuestras();

	}
	
	@Test
	void testExceptionCuandoSistemaNoTieneElUsuarioAAñadir() {
		proyecto = new Proyecto("nombre","descripcion", sistema);
		
		when(sistema.contieneElUsuario(usuario)).thenReturn(false);
		
		Throwable exception = assertThrows(Exception.class, () -> {
			proyecto.suscribirUsuario(usuario);
		});
		assertEquals(exception.getMessage(), "El sistema no incluye el usuario dado.");
	}
	
	@Test
	void testNoExceptionCuandoSistemaTieneElUsuarioAAñadir() {
		proyecto = new Proyecto("nombre","descripcion", sistema);
		
		when(sistema.contieneElUsuario(usuario)).thenReturn(true);
		
		assertDoesNotThrow(() -> {
			proyecto.suscribirUsuario(usuario);
		});
	}
}
