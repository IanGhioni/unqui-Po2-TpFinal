package ar.edu.unq.po2.tpfinal.CFalse;
import ar.edu.unq.po2.tpfinal.filtrador.*;
import ar.edu.unq.po2.tpfinal.evaluable.*;
import ar.edu.unq.po2.tpfinal.condicion.*;
import java.util.List; // import the ArrayList class
import java.util.ArrayList; // import the ArrayList class


public class CFalse extends Condicion{
	public ArrayList<Evaluable> evaluar(ArrayList<Evaluable> lista) {
		return new ArrayList<Evaluable>();
	}
}