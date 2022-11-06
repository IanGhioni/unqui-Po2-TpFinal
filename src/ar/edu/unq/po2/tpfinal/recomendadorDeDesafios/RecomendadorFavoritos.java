package ar.edu.unq.po2.tpfinal.recomendadorDeDesafios;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.tpfinal.desafio.Desafio;
import ar.edu.unq.po2.tpfinal.usuario.Usuario;

public class RecomendadorFavoritos extends RecomendadorDeDesafios  {
	
	public RecomendadorFavoritos(Usuario user) {
		super(user);
	}

	@Override
	public List<Desafio> recomendar() {
		listaDeDesafios = user.getSistema().getListaDeDesafios();
		
		this.ordenarDesafiosPorCoincidencia();
		this.listaDeDesafios = new ArrayList<Desafio>(this.listaDeDesafios.stream().limit(20).toList());
		this.ordenarDesafiosPorSimilitud();
		this.listaDeDesafios = new ArrayList<Desafio>(this.listaDeDesafios.stream().limit(5).toList());
		return this.listaDeDesafios;
	}

	private void ordenarDesafiosPorSimilitud() {
		listaDeDesafios.sort((d1,d2) -> Double.compare(this.similitudConDesafio(d1), this.similitudConDesafio(d2)));
	}

	private double similitudConDesafio(Desafio d1) {
		return 
			d1.calcularSimilitudConDesafio(user.desafioMasGustado());
	}

	
	
}
