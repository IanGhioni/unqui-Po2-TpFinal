package ar.edu.unq.po2.tpfinal.filtrador;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.ArrayList; // import the ArrayList class 

/*
public class  CCategoria extends Condicion{
	private String regexString;
	public CCategoria(String regexString) {
		this.regexString = regexString;
	}
	public ArrayList<Evaluable> evaluar(ArrayList<Evaluable> lista) {
		return   (ArrayList<Evaluable>) lista
			      .stream()
			      .filter(e -> e.machClase(this.regexString))
			      .collect(Collectors.toList());
	}
}
*/


public class  CCategoria extends Condicion{
	private String regexString;
	public CCategoria(String regexString) {
		this.regexString = regexString;
	}
	public ArrayList<Evaluable> evaluar(ArrayList<Evaluable> lista) {

		return   (ArrayList<Evaluable>) lista
		      .stream()
		      .filter(e -> e
		    		  .getListaDeCategorias()
		    		  .stream()
		    		  .anyMatch(c -> Pattern.matches(regexString,c)));
	}
}