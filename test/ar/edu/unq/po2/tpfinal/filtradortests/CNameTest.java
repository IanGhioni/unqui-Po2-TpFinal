package ar.edu.unq.po2.tpfinal.filtradortests;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList; // import the ArrayList class

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpfinal.filtrador.CName;
import ar.edu.unq.po2.tpfinal.proyecto.Proyecto;
import ar.edu.unq.po2.tpfinal.filtrador.Evaluable;
import ar.edu.unq.po2.tpfinal.filtrador.Filtrador;
import static org.mockito.Mockito.*; 





class CNameTest {
    private ArrayList<Evaluable> lista ;
    private ArrayList<Evaluable> listaVacia;
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
        

        /*
        proyecto1=new Proyecto("","");
        proyecto2=new Proyecto("","");
        proyecto3=new Proyecto("","");
        proyecto4=new Proyecto("","");
        */

        //Test Double Configuration

        when(proyecto1.getNombre()).thenReturn("proyecto1");
        when(proyecto2.getNombre()).thenReturn("proyecto2");
        when(proyecto3.getNombre()).thenReturn("proyecto3");
        when(proyecto4.getNombre()).thenReturn("proyecto4");
        lista = new ArrayList<Evaluable>();
        lista.add(proyecto1);
        lista.add(proyecto2);
        lista.add(proyecto3);
        lista.add(proyecto4);
        
    }
        
    

    @Test
    void TestCName1() {
        //Testeo Ctrue sobre lista vacia

        evaluador=new CName("nombre1");

        assertTrue(listaVacia.equals(evaluador.evaluar(listaVacia)));

    }
    @Test
    void TestCName2() {
        //Testeo Ctrue sobre lista llena y patron .*
        evaluador=new CName(".*");
        assertTrue(lista.equals(evaluador.evaluar(lista)));
    }
    @Test
    void TestCName3() {
        ArrayList<Evaluable> listaTarget = new ArrayList<Evaluable>();
        //Testeo Ctrue sobre lista llena y patron e2
        evaluador=new CName(".*o2.*");
        listaTarget.add(proyecto2);
        assertTrue(listaTarget.equals(evaluador.evaluar(lista)));
    }
}