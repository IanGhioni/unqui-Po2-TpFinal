package ar.edu.unq.po2.tpfinal.filtrador;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.ArrayList; // import the ArrayList class 


public class  CName extends Condicion{
	private Pattern pattern;
	public CName(String regexString) {
		this.pattern = Pattern.compile(regexString);
	}
	public ArrayList<Evaluable> evaluar(ArrayList<Evaluable> lista) {
		return   (ArrayList<Evaluable>) lista
			      .stream()
			      .filter(e -> pattern.matcher(e.getName()).matches())
			      .collect(Collectors.toList());
	}
}
