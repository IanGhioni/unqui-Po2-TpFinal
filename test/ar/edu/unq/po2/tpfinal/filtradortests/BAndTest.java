package ar.edu.unq.po2.tpfinal.filtradortests;
import java.util.ArrayList; // import the ArrayList class
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ar.edu.unq.po2.tpfinal.filtrador.*;
import ar.edu.unq.po2.tpfinal.proyecto.Proyecto;




class BAndTest {
    private ArrayList<Evaluable> lista ;
    private ArrayList<Evaluable> listaVacia;
    private ArrayList<Evaluable> lista1;
    private ArrayList<Evaluable> lista2;
    private ArrayList<Evaluable> resultadoEsperado;
    private ArrayList<Evaluable> listaCorta ;
    private ArrayList<Evaluable> listaResto;
    private ArrayList<Evaluable> resultado;
    private Proyecto proyecto1;
    private Proyecto proyecto2;
    private Proyecto proyecto3;
    private Proyecto proyecto4;
    private Filtrador evaluador;


    
    @BeforeEach
    void setUp() {
        listaVacia = new ArrayList<Evaluable>();
        // setUp

        proyecto1 = mock(Proyecto.class);

        proyecto2 = mock(Proyecto.class);
        proyecto3 = mock(Proyecto.class);
        proyecto4 = mock(Proyecto.class);
        
        //Test Double Configuration

        when(proyecto1.getNombre()).thenReturn("proyecto1");
        when(proyecto2.getNombre()).thenReturn("proyecto2");
        when(proyecto3.getNombre()).thenReturn("proyecto3");
        when(proyecto4.getNombre()).thenReturn("proyecto4");
        lista1 = new ArrayList<Evaluable>();
        lista2 = new ArrayList<Evaluable>();
        lista = new ArrayList<Evaluable>();
        resultadoEsperado = new ArrayList<Evaluable>();
        lista.add(proyecto1);
        lista.add(proyecto2);
        lista.add(proyecto3);
        lista.add(proyecto4);
        
        listaCorta = new ArrayList<Evaluable>();
        listaCorta.add(proyecto1);
        listaCorta.add(proyecto2);
        listaResto = new ArrayList<Evaluable>();
        listaResto.add(proyecto3);
        listaResto.add(proyecto4);
    }
	class CCustom extends Filtrador{
		
		ArrayList<Evaluable> lista;
		
		
		public CCustom(ArrayList<Evaluable> lista) {
			super();
			this.lista = lista;
		}


		public ArrayList<Evaluable> evaluar(ArrayList<Evaluable> listanueva) {
		return this.lista;
	 }
	}

		
	

		
	

	@Test
	void TestBand1() {
		//Testeo BOR listas disjuntas
		lista1.add(proyecto1);
		lista2.add(proyecto2);
		lista2.add(proyecto3);

		
		evaluador=new BAnd(new CCustom(lista1),new CCustom(lista2));
		resultado=evaluador.evaluar(lista);
		

		assertTrue(resultadoEsperado.equals(resultado));
	}



@Test
void TestBAnd2() {
	//Testeo Band listas con datos en la interseccion
	lista1.add(proyecto1);
	lista1.add(proyecto2);
	lista2.add(proyecto2);
	lista2.add(proyecto3);

	resultadoEsperado.add(proyecto2);

	
	evaluador=new BAnd(new CCustom(lista1),new CCustom(lista2));
	resultado=evaluador.evaluar(lista);
	

	assertTrue(resultadoEsperado.equals(resultado));
	}

}