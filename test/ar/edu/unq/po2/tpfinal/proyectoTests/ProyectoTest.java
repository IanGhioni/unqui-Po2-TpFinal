package ar.edu.unq.po2.tpfinal.proyectoTests;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpfinal.muestra.Muestra;
import ar.edu.unq.po2.tpfinal.proyecto.Proyecto;
import ar.edu.unq.po2.tpfinal.sistema.Sistema;
import ar.edu.unq.po2.tpfinal.usuario.Usuario;

import static org.mockito.Mockito.*;

class ProyectoTest {
	private Proyecto proyecto;
	private Usuario usuario;
	private Muestra muestra;
	private Sistema sistema;
	
	@BeforeEach
	void setUp() throws Exception {
		sistema = mock(Sistema.class);
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
		
		when(sistema.contieneLaCategoria("Una categoria")).thenReturn(true);
		
		proyecto.añadirCategoria("Una categoria");
		
		assertTrue(proyecto.getListaDeCategorias().contains("Una categoria"));
	}
	
	@Test
	void testProyectoEliminaCategorias() {
		proyecto = new Proyecto("nombre","descripcion", sistema);
		proyecto.eliminarCategoria("Una categoria");
		
		assertFalse(proyecto.getListaDeCategorias().contains("Una categoria"));
	}
	
	@Test
	void testProyectoAñadeUsuario() {
		usuario = mock(Usuario.class);
		proyecto = new Proyecto("nombre","descripcion", sistema);
		proyecto.suscribirUsuario(usuario);
		
		assertTrue(proyecto.getListaDeUsuarios().contains(usuario));
	}
	
	@Test
	void testProyectoDesuscribeUsuario() {
		usuario = mock(Usuario.class);
		proyecto = new Proyecto("nombre","descripcion", sistema);
		proyecto.desuscribirUsuario(usuario);
		
		assertFalse(proyecto.getListaDeUsuarios().contains(usuario));
	}
	
	@Test
	void testProyectoAñadeMuestra() {
		muestra = mock(Muestra.class);
		proyecto = new Proyecto("nombre","descripcion", sistema);
		proyecto.agregarMuestra(muestra);
		
		assertTrue(proyecto.getListaDeMuestras().contains(muestra));
	}
	
	
	@Test
	void testExceptionCuandoSistemaNoTieneLaCategoriaAAñadir() {
		proyecto = new Proyecto("nombre","descripcion", sistema);
		
		when(sistema.contieneLaCategoria("Una categoria")).thenReturn(false);
		
		Throwable exception = assertThrows(Exception.class, () -> {
			proyecto.añadirCategoria("Una categoria");
		});
		assertEquals(exception.getMessage(), "El sistema no incluye la categoria dada.");
	}
	
	@Test
	void testNoExceptionCuandoSistemaTieneLaCategoriaAAñadir() {
		proyecto = new Proyecto("nombre","descripcion", sistema);
		
		when(sistema.contieneLaCategoria("Una categoria")).thenReturn(true);
		
		assertDoesNotThrow(() -> {
			proyecto.añadirCategoria("Una categoria");
		});
	}
}
