package ar.edu.unq.po2.tpfinal.filtrador;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.ArrayList; // import the ArrayList class 
import java.util.List;




public class  CCategoria extends Filtrador{
	private String regexString;
	private Pattern pattern;
	public CCategoria(String regexString) {
		this.regexString = regexString;

		pattern =  Pattern.compile(regexString);
	}

	public ArrayList<Evaluable> evaluar(ArrayList<Evaluable> lista) {
		return   (ArrayList<Evaluable>) lista
		      .stream()
		      .filter(e -> e.getListaDeCategorias()
		    		       .stream()
		    		       .anyMatch(c -> pattern.matcher(c.getNombre()).matches())
		    		 )
		      		  .collect(Collectors.toList());
	}

}