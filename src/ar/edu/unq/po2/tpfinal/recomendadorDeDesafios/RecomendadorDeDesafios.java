package ar.edu.unq.po2.tpfinal.recomendadorDeDesafios;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.tpfinal.desafio.Desafio;
import ar.edu.unq.po2.tpfinal.usuario.Usuario;

public abstract class RecomendadorDeDesafios {
	Usuario user;
	List<Desafio> listaDeDesafios;
	
	public RecomendadorDeDesafios(Usuario user) {
		listaDeDesafios = new ArrayList<Desafio>();
		this.user = user;
	}
	
	public List<Desafio> recomendar() {
		listaDeDesafios = user.getSistema().getListaDeDesafios();
		
		this.ordenarDesafiosPorCoincidencia();
		this.seleccionarDesafios();
		return this.listaDeDesafios;
	}

	protected void seleccionarDesafios() {
		this.listaDeDesafios = new ArrayList<Desafio>(this.listaDeDesafios.stream().limit(5).toList());
	}

	public void ordenarDesafiosPorCoincidencia() {
		listaDeDesafios.sort((d1,d2) -> Double.compare(this.coincidenciaConDesafio(d1), this.coincidenciaConDesafio(d2)));;
	}

	protected double coincidenciaConDesafio(Desafio d1) {
		return user.getPerfilDeUsuario().calcularCoincidenciaConDesafio(d1);
	}
}
