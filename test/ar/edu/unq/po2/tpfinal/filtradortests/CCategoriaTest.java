package ar.edu.unq.po2.tpfinal.filtradortests;
import java.util.ArrayList; // import the ArrayList class

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpfinal.filtrador.*;
import ar.edu.unq.po2.tpfinal.proyecto.Proyecto;



class CCategoriaTest {

    private ArrayList<Evaluable> lista ;
    private ArrayList<Evaluable> listaVacia;
    private Proyecto proyecto1;
    private Proyecto proyecto2;
    private Proyecto proyecto3;
    private Proyecto proyecto4;
    private Filtrador evaluador;
    private ArrayList<String> listaDeCategorias1;
    private ArrayList<String> listaDeCategorias2;
    private ArrayList<String> listaDeCategorias3;
    private ArrayList<String> listaDeCategorias4;

    @BeforeEach
    void setUp() {
        listaVacia = new ArrayList<Evaluable>();
        // setUp

        proyecto1 = mock(Proyecto.class);

        proyecto2 = mock(Proyecto.class);
        proyecto3 = mock(Proyecto.class);
        proyecto4 = mock(Proyecto.class);
        listaDeCategorias1 = new ArrayList<String>();
        listaDeCategorias2 = new ArrayList<String>();
        listaDeCategorias3 = new ArrayList<String>();
        listaDeCategorias4 = new ArrayList<String>();
        listaDeCategorias1.add("A1");
        listaDeCategorias1.add("B1");
        listaDeCategorias2.add("A2");
        listaDeCategorias2.add("B2");
        listaDeCategorias3.add("A3");
        listaDeCategorias3.add("B3");
        listaDeCategorias4.add("A4");
        listaDeCategorias4.add("B4");
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
