package ar.edu.unq.po2.tpfinal.categoriaTests;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpfinal.categoria.Categoria;
import ar.edu.unq.po2.tpfinal.muestra.Muestra;
import ar.edu.unq.po2.tpfinal.sistema.Coordenada;
import ar.edu.unq.po2.tpfinal.usuario.Usuario;




public class CategoriaTest {
	Categoria categoria;

	

	@BeforeEach
	void setUp() throws Exception {

	}


	@Test
	void testGetNombre() {
		String nombre="Nombre de prueba;";
		categoria = new Categoria(nombre);
		assertEquals(categoria.getNombre(), nombre);
	}
}
