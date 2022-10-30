package ar.edu.unq.po2.tpfinal.recomendadorDeDesafios;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.tpfinal.desafio.Desafio;
import ar.edu.unq.po2.tpfinal.usuario.Usuario;

public abstract class Recomendador {
	Usuario user;
	List<Desafio> listaDeDesafios;
	
	public Recomendador(Usuario user) {
		listaDeDesafios = new ArrayList<Desafio>();
		this.user = user;
	}
	
	public ArrayList<Desafio> recomendar() {
		this.ordenarDesafiosPorCoincidencia();
		return this.enviarDesafios();
	}

	protected abstract ArrayList<Desafio> enviarDesafios();

	public void ordenarDesafiosPorCoincidencia() {
		listaDeDesafios.sort((d1,d2) -> Integer.compare(this.coincidenciaConDesafio(d1), this.coincidenciaConDesafio(d2)));;
	}

	protected abstract int coincidenciaConDesafio(Desafio d2);
}
