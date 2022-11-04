package ar.edu.unq.po2.tpfinal.recomendadorDeDesafios;

import ar.edu.unq.po2.tpfinal.desafio.Desafio;
import ar.edu.unq.po2.tpfinal.usuario.Usuario;

public class RecomendadorFavoritos extends Recomendador {

	public RecomendadorFavoritos(Usuario user) {
		super(user);
	}

	@Override
	protected void seleccionarDesafios() {
		this.listaDeDesafios = this.listaDeDesafios.stream().limit(5).toList();
	}

	@Override
	public void ordenarDesafios() {
		this.ordenarDesafiosPorCoincidencia();
		this.listaDeDesafios = this.listaDeDesafios.stream().limit(20).toList();
		this.ordenarDesafiosPorSimilitud();

	}

	private void ordenarDesafiosPorSimilitud() {
		listaDeDesafios.sort((d1,d2) -> Double.compare(this.similitudConDesafio(d1), this.similitudConDesafio(d2)));
	}

	private double similitudConDesafio(Desafio d1) {
		return 
			d1.calcularSimilitudConDesafio(user.desafioMasGustado());
	}

	
	
}
