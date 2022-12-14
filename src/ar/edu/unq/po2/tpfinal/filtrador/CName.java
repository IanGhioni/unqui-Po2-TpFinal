package ar.edu.unq.po2.tpfinal.filtrador;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.ArrayList; // import the ArrayList class 


public class  CName extends Filtrador{
	private String regexString;
	private Pattern pattern;
	public CName(String regexString) {
		pattern =  Pattern.compile(regexString);
	}
	public ArrayList<Evaluable> evaluar(ArrayList<Evaluable> lista) {
		return   (ArrayList<Evaluable>) lista
		      .stream()
		      .filter(e -> pattern.matcher(e.getNombre()).matches())
		      .collect(Collectors.toList());
	}
}
