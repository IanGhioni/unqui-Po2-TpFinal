package ar.edu.unq.po2.tpfinal.recomendadorDeDesafios;

import java.util.ArrayList;

import ar.edu.unq.po2.tpfinal.desafio.Desafio;
import ar.edu.unq.po2.tpfinal.usuario.Usuario;

public class RecomendadorMisPreferencias extends Recomendador {

	public RecomendadorMisPreferencias(Usuario user) {
		super(user);

	}

	@Override
	protected void seleccionarDesafios() {
		this.listaDeDesafios = new ArrayList<Desafio>(this.listaDeDesafios.stream().limit(5).toList());;
	}

	@Override
	public void ordenarDesafios() {
		this.ordenarDesafiosPorPreferencia();
	}

	private void ordenarDesafiosPorPreferencia() {
		listaDeDesafios.sort((d1,d2) -> Double.compare(this.similitudConPreferencia(d1), this.similitudConPreferencia(d2)));
	}

	private double similitudConPreferencia(Desafio d1) {
		return 
			d1.calcularSimilitudConPreferencia(user.getPerfildeUsuario());
	}

	
	
}
