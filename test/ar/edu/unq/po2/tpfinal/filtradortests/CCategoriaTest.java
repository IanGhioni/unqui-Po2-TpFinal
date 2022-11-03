package test.ar.edu.unq.po2.tpfinal.filtradortests;
import java.util.ArrayList; // import the ArrayList class

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpfinal.filtrador.*;



class CCategoriaTest {
	private ArrayList<Evaluable> lista ;
	private ArrayList<Evaluable> listaVacia;
	private Evaluable evaluable1;
	private Evaluable evaluable2;
	private Evaluable evaluable3;
	private Evaluable evaluable4;
	private Filtrador evaluador;


	
	@BeforeEach
	void setUp() {

		listaVacia = new ArrayList<Evaluable>();
		lista = new ArrayList<Evaluable>();

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
		evaluador=new CCategoria(".*e2.*");
		listaTarget.add(evaluable2);
		assertTrue(listaTarget.equals(evaluador.evaluar(lista)));
	}
}
