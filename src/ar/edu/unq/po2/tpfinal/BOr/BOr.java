package ar.edu.unq.po2.tpfinal.BOr;
import ar.edu.unq.po2.tpfinal.filtrador.*;
import ar.edu.unq.po2.tpfinal.evaluable.*;


import java.util.ArrayList; // import the ArrayList class



public class  BOr extends   Filtrador{
	Filtrador filtrador1;
	Filtrador filtrador2;
	public BOr(Filtrador filtrador1, Filtrador filtrador2) {
		this.filtrador1 = filtrador1;
		this.filtrador2 = filtrador2;
	}
	public ArrayList<Evaluable> evaluar(ArrayList<Evaluable> lista) {
		
		ArrayList<Evaluable> resultado1 = this.filtrador1.evaluar(lista);
		ArrayList<Evaluable> resultado2 = this.filtrador2.evaluar(lista);
		ArrayList<Evaluable> resultado = resultado1;
		resultado.removeAll(resultado2);
		resultado.addAll(resultado2);
		return  resultado;
	}
}
