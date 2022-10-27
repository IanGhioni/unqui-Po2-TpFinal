package ar.edu.unq.po2.tpfinal.BAndTest;
import java.util.List; // import the ArrayList class
import java.util.ArrayList; // import the ArrayList class

import static org.junit.jupiter.api.Assertions.*;
import ar.edu.unq.po2.tpfinal.evaluable.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ar.edu.unq.po2.tpfinal.BAnd.*;
import ar.edu.unq.po2.tpfinal.condicion.Condicion;



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

class BAndTest {
	private ArrayList<Evaluable> lista ;
	private ArrayList<Evaluable> listaVacia;
	private ArrayList<Evaluable> listaCorta;
	private ArrayList<Evaluable>listaResto;
	private ArrayList<Evaluable>lista1;
	private ArrayList<Evaluable>lista2;
	private Evaluable evaluable1;
	private Evaluable evaluable2;
	private Evaluable evaluable3;
	private Evaluable evaluable4;
	private Filtrador evaluador;
	private ArrayList<Evaluable> resultado;
	private ArrayList<Evaluable> resultadoEsperado;


	class CCustom extends Condicion{
		
		ArrayList<Evaluable> lista;
		
		
		public CCustom(ArrayList<Evaluable> lista) {
			super();
			this.lista = lista;
		}


		public ArrayList<Evaluable> evaluar(ArrayList<Evaluable> listanueva) {
		return this.lista;
	}
}
	
	@BeforeEach
	void setUp() {

		listaVacia = new ArrayList<Evaluable>();
		lista = new ArrayList<Evaluable>();
		listaCorta = new ArrayList<Evaluable>();
		listaResto = new ArrayList<Evaluable>();
		lista1 = new ArrayList<Evaluable>();
		lista2 = new ArrayList<Evaluable>();		
		resultadoEsperado = new ArrayList<Evaluable>();	
		evaluable1=new EvaluableDumy("nombre1","clase1");
		evaluable2=new EvaluableDumy("nombre2","clase2");
		evaluable3=new EvaluableDumy("nombre3","clase3");
		evaluable4=new EvaluableDumy("nombre4","clase4");
		lista.add(evaluable1);
		lista.add(evaluable2);
		lista.add(evaluable3);
		lista.add(evaluable4);
		
		listaCorta.add(evaluable1);
		listaCorta.add(evaluable2);
		
		listaResto.add(evaluable3);
		listaResto.add(evaluable4);
		
		
	}
		
	

	@Test
	void TestBand1() {
		//Testeo BOR listas disjuntas
		lista1.add(evaluable1);
		lista2.add(evaluable2);
		lista2.add(evaluable3);

		
		evaluador=new BAnd(new CCustom(lista1),new CCustom(lista2));
		resultado=evaluador.evaluar(lista);
		

		assertTrue(resultadoEsperado.equals(resultado));
	}



@Test
void TestBAnd2() {
	//Testeo Band listas con datos en la interseccion
	lista1.add(evaluable1);
	lista1.add(evaluable2);
	lista2.add(evaluable2);
	lista2.add(evaluable3);

	resultadoEsperado.add(evaluable2);

	
	evaluador=new BAnd(new CCustom(lista1),new CCustom(lista2));
	resultado=evaluador.evaluar(lista);
	

	assertTrue(resultadoEsperado.equals(resultado));
	}

}