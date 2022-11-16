package ar.edu.unq.po2.tpfinal.filtradortests;
import java.util.ArrayList; // import the ArrayList class

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpfinal.categoria.Categoria;
import ar.edu.unq.po2.tpfinal.filtrador.*;
import ar.edu.unq.po2.tpfinal.proyecto.Proyecto;
import ar.edu.unq.po2.tpfinal.categoria.Categoria;


class CCategoriaTest {

    private ArrayList<Evaluable> lista ;
    private ArrayList<Evaluable> listaVacia;
    private Proyecto proyecto1;
    private Proyecto proyecto2;
    private Proyecto proyecto3;
    private Proyecto proyecto4;
    private Filtrador evaluador;
    private ArrayList<Categoria> listaDeCategorias1;
    private ArrayList<Categoria> listaDeCategorias2;
    private ArrayList<Categoria> listaDeCategorias3;
    private ArrayList<Categoria> listaDeCategorias4;
	public Categoria categoriaA1;
	public Categoria categoriaB1;
	public String nombreCategoriaA1;
	public String nombreCategoriaB1;
	public Categoria categoriaA2;
	public Categoria categoriaB2;
	public String nombreCategoriaA2;
	public String nombreCategoriaB2;
	public Categoria categoriaA3;
	public Categoria categoriaB3;
	public String nombreCategoriaA3;
	public String nombreCategoriaB3;
	public Categoria categoriaA4;
	public Categoria categoriaB4;
	public String nombreCategoriaA4;
	public String nombreCategoriaB4;

    @BeforeEach
    void setUp() {
        listaVacia = new ArrayList<Evaluable>();
        // setUp

        proyecto1 = mock(Proyecto.class);

        proyecto2 = mock(Proyecto.class);
        proyecto3 = mock(Proyecto.class);
        proyecto4 = mock(Proyecto.class);
        listaDeCategorias1 = new ArrayList<Categoria>();
        listaDeCategorias2 = new ArrayList<Categoria>();
        listaDeCategorias3 = new ArrayList<Categoria>();
        listaDeCategorias4 = new ArrayList<Categoria>();
        categoriaA1 = mock(Categoria.class);
        categoriaB1 = mock(Categoria.class);
        categoriaA2 = mock(Categoria.class);
        categoriaB2 = mock(Categoria.class);
        categoriaA3 = mock(Categoria.class);
        categoriaB3 = mock(Categoria.class);
        categoriaA4 = mock(Categoria.class);
        categoriaB4 = mock(Categoria.class);
        
		nombreCategoriaA1 = "nombreA1";
		nombreCategoriaB1 = "nombreB1";
		when(categoriaA1.getNombre()).thenReturn(nombreCategoriaA1);
		when(categoriaB1.getNombre()).thenReturn(nombreCategoriaB1);
		
		nombreCategoriaA2 = "nombreA2";
		nombreCategoriaB2 = "nombreB2";
		when(categoriaA2.getNombre()).thenReturn(nombreCategoriaA2);
		when(categoriaB2.getNombre()).thenReturn(nombreCategoriaB2);
		
		nombreCategoriaA3 = "nombreA3";
		nombreCategoriaB3 = "nombreB3";
		when(categoriaA3.getNombre()).thenReturn(nombreCategoriaA3);
		when(categoriaB3.getNombre()).thenReturn(nombreCategoriaB3);
		
		nombreCategoriaA4 = "nombreA4";
		nombreCategoriaB4 = "nombreB4";
		when(categoriaA4.getNombre()).thenReturn(nombreCategoriaA4);
		when(categoriaB4.getNombre()).thenReturn(nombreCategoriaB4);

        listaDeCategorias1.add(categoriaA1);
        listaDeCategorias1.add(categoriaB1);
        listaDeCategorias2.add(categoriaA2);
        listaDeCategorias2.add(categoriaB2);
        listaDeCategorias3.add(categoriaA3);
        listaDeCategorias3.add(categoriaB3);
        listaDeCategorias4.add(categoriaA4);
        listaDeCategorias4.add(categoriaB4);
        //Test Double Configuration

        when(proyecto1.getNombre()).thenReturn("proyecto1");
        when(proyecto2.getNombre()).thenReturn("proyecto2");
        when(proyecto3.getNombre()).thenReturn("proyecto3");
        when(proyecto4.getNombre()).thenReturn("proyecto4");
        
        when(proyecto1.getListaDeCategorias()).thenReturn(listaDeCategorias1);
        when(proyecto2.getListaDeCategorias()).thenReturn(listaDeCategorias2);
        when(proyecto3.getListaDeCategorias()).thenReturn(listaDeCategorias3);
        when(proyecto4.getListaDeCategorias()).thenReturn(listaDeCategorias4);
        lista = new ArrayList<Evaluable>();
        lista.add(proyecto1);
        lista.add(proyecto2);
        lista.add(proyecto3);
        lista.add(proyecto4);
        
    }
	

	@Test
	void TestCCategoria() {
		//Testeo Ctrue sobre lista vacia
		evaluador=new CCategoria("nombre1");
		assertTrue(listaVacia.equals(evaluador.evaluar(listaVacia)));
	}
	@Test
	void TestCCategoria2() {
		//Testeo Ctrue sobre lista llena y patron .*
		evaluador=new CCategoria(".*");
		assertTrue(lista.equals(evaluador.evaluar(lista)));
	}
	@Test
	void TestCCategoria3() {
		ArrayList<Evaluable> listaTarget = new ArrayList<Evaluable>();
		//Testeo Ctrue sobre lista llena y patron e2
		evaluador=new CCategoria(".*B2.*");
		listaTarget.add(proyecto2);
		assertTrue(listaTarget.equals(evaluador.evaluar(lista)));
	}
}
