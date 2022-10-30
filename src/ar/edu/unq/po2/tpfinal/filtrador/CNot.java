package ar.edu.unq.po2.tpfinal.filtrador;
import java.util.ArrayList; // import the ArrayList class



public class  CNot extends   Filtrador{
	Filtrador filtradorANegar;
	public CNot(Filtrador filtradorANegar) {
		this.filtradorANegar = filtradorANegar;
	}
	public ArrayList<Evaluable> evaluar(ArrayList<Evaluable> lista) {
		ArrayList<Evaluable> listaANegar = this.filtradorANegar.evaluar(lista);
		
		ArrayList<Evaluable> listaNegada = lista;

		
		listaNegada.removeAll(listaANegar);
		
		return  listaNegada;
	}
}
