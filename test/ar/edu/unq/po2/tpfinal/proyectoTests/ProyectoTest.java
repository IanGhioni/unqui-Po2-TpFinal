package ar.edu.unq.po2.tpfinal.proyectoTests;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpfinal.muestra.Muestra;
import ar.edu.unq.po2.tpfinal.proyecto.Proyecto;
import ar.edu.unq.po2.tpfinal.usuario.Usuario;

import static org.mockito.Mockito.*;

class ProyectoTest {
	private Proyecto proyecto;
	private Usuario usuario;
	private Muestra muestra;
	
	@BeforeEach
	void setUp() throws Exception {
		
	}

	@Test
	void testProyectoSabeDevolverSuNombre() {
		
		proyecto = new Proyecto("nombre", "descripcion");
		assertEquals(proyecto.getNombre(), "nombre");
	}
	
	@Test
	void testProyectoSabeDevolverSuDescripcion() {
		proyecto = new Proyecto("nombre","descripcion");
		assertEquals(proyecto.getDescripcion(), "descripcion");
	}
	
	@Test
	void testProyectoAñadeCategorias() {
		proyecto = new Proyecto("nombre","descripcion");
		proyecto.añadirCategoria("Una categoria");
		
		assertTrue(proyecto.getListaDeCategorias().contains("Una categoria"));
	}
	
	@Test
	void testProyectoAñadeUsuario() {
		usuario = mock(Usuario.class);
		proyecto = new Proyecto("nombre","descripcion");
		proyecto.suscribirUsuario(usuario);
		
		assertTrue(proyecto.getListaDeUsuarios().contains(usuario));
	}
	
	@Test
	void testProyectoAñadeMuestra() {
		muestra = mock(Muestra.class);
		proyecto = new Proyecto("nombre","descripcion");
		proyecto.añadirMuestra(muestra);
		
		assertTrue(proyecto.getListaDeMuestras().contains(muestra));
	}
	
	@Test
	void testProyectoDesuscribeUsuario() {
		usuario = mock(Usuario.class);
		proyecto = new Proyecto("nombre","descripcion");
		proyecto.desuscribirUsuario(usuario);
		
		assertFalse(proyecto.getListaDeUsuarios().contains(usuario));
	}
	
}
