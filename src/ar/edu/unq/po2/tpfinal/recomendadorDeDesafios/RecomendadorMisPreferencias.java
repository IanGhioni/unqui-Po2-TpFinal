package ar.edu.unq.po2.tpfinal.recomendadorDeDesafios;

import ar.edu.unq.po2.tpfinal.desafio.Desafio;
import ar.edu.unq.po2.tpfinal.usuario.Usuario;

public class RecomendadorMisPreferencias extends Recomendador {

	public RecomendadorMisPreferencias(Usuario user) {
		super(user);

	}

	@Override
	protected void seleccionarDesafios() {
		this.listaDeDesafios = this.listaDeDesafios.subList(0, 5);
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
