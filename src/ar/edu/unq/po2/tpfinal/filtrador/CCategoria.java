package ar.edu.unq.po2.tpfinal.CCategoria;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.List;
import ar.edu.unq.po2.tpfinal.filtrador.*;
import ar.edu.unq.po2.tpfinal.evaluable.*;
import ar.edu.unq.po2.tpfinal.condicion.*;
import java.util.List; // import the ArrayList class
import java.util.ArrayList; // import the ArrayList class 


public class  CCategoria extends Condicion{
	private Pattern pattern;
	public CCategoria(String regexString) {
		this.pattern = Pattern.compile(regexString);
	}
	public ArrayList<Evaluable> evaluar(ArrayList<Evaluable> lista) {
		return   (ArrayList<Evaluable>) lista
			      .stream()
			      .filter(e -> pattern.matcher(e.getCategoriaName()).matches())
			      .collect(Collectors.toList());
	}
}
