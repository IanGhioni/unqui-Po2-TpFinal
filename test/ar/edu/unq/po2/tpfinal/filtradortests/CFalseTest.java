package ar.edu.unq.po2.tpfinal.CFalseTest;
import java.util.List; // import the ArrayList class
import java.util.ArrayList; // import the ArrayList class

import static org.junit.jupiter.api.Assertions.*;
import ar.edu.unq.po2.tpfinal.evaluable.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpfinal.condicion.Condicion;
import ar.edu.unq.po2.tpfinal.CFalse.*;


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

class CFalseTest {
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
	void TestCFalse1() {
		//Testeo Ctrue sobre lista vacia
		evaluador=new CFalse();
		assertTrue(listaVacia.equals(evaluador.evaluar(listaVacia)));
	}
	@Test
	void TestCTrue2() {
		//Testeo Ctrue sobre lista llena
		evaluador=new CFalse();
		assertTrue(listaVacia.equals(evaluador.evaluar(lista)));
	}
}