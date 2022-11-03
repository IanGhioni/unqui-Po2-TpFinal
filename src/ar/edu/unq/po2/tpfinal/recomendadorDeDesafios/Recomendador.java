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
	
	public List<Desafio> recomendar() {
		listaDeDesafios = user.getSistema().getListaDeDesafios();
		
		this.ordenarDesafios();
		this.seleccionarDesafios();
		return this.listaDeDesafios;
	}

	protected abstract void seleccionarDesafios();

	protected abstract void ordenarDesafios();

	public void ordenarDesafiosPorCoincidencia() {
		listaDeDesafios.sort((d1,d2) -> Double.compare(this.coincidenciaConDesafio(d1), this.coincidenciaConDesafio(d2)));;
	}

	protected double coincidenciaConDesafio(Desafio d1) {
		return user.getPerfildeUsuario().calcularCoincidenciaConDesafio(d1);
	}
}
