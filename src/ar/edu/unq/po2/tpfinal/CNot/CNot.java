package ar.edu.unq.po2.tpfinal.CNot;
import ar.edu.unq.po2.tpfinal.filtrador.*;
import ar.edu.unq.po2.tpfinal.evaluable.*;
import ar.edu.unq.po2.tpfinal.condicion.*;
import java.util.List; // import the ArrayList class
import java.util.ArrayList; // import the ArrayList class



public class  CNot extends   Filtrador{
	Filtrador filtradorANegar;
	public CNot(Filtrador filtradorANegar) {
		this.filtradorANegar = filtradorANegar;
	}
	public ArrayList<Evaluable> evaluar(ArrayList<Evaluable> lista) {
		
		ArrayList<Evaluable> listaNegada = lista;
		listaNegada.removeAll(this.filtradorANegar.evaluar(lista));
		return  listaNegada;
	}
}
