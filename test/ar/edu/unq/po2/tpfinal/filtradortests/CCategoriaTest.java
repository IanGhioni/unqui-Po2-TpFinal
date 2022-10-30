package ar.edu.unq.po2.tpfinal.filtradortests;
import java.util.ArrayList; // import the ArrayList class

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ar.edu.unq.po2.tpfinal.filtrador.*;


class EvaluableDumy implements Evaluable{
	private String nombre;
	private String clase;

	
	public EvaluableDumy(String nombre,String clase) {
		this.clase=clase;
		this.nombre=nombre;
	}

	public String getName() {
		return nombre;
	}

	public String getCategoriaName() {
		return clase;
	}
}

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
		evaluable1=new EvaluableDumy("nombre1","clase1");
		evaluable2=new EvaluableDumy("nombre2","clase2");
		evaluable3=new EvaluableDumy("nombre3","clase3");
		evaluable4=new EvaluableDumy("nombre4","clase4");
		lista.add(evaluable1);
		lista.add(evaluable2);
		lista.add(evaluable3);
		lista.add(evaluable4);
	}
		
	

	@Test
	void TestCCategoria1() {
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