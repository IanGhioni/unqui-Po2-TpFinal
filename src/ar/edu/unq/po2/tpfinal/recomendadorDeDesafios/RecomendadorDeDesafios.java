package ar.edu.unq.po2.tpfinal.recomendadorDeDesafios;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.tpfinal.desafio.Desafio;
import ar.edu.unq.po2.tpfinal.usuario.Usuario;

public abstract class RecomendadorDeDesafios {
	Usuario user;
	List<Desafio> desafios;
	
	public RecomendadorDeDesafios(Usuario user) {
		desafios = new ArrayList<Desafio>();
		this.user = user;
	}
	
	public List<Desafio> recomendar() {
		desafios = user.getSistema().getDesafios();
		
		this.ordenarDesafiosPorCoincidencia();
		this.seleccionarDesafios();
		return this.desafios;
	}

	protected void seleccionarDesafios() {
		this.desafios = new ArrayList<Desafio>(this.desafios.stream().limit(5).toList());
	}

	public void ordenarDesafiosPorCoincidencia() {
		desafios.sort((d1,d2) -> Double.compare(this.coincidenciaConDesafio(d1), this.coincidenciaConDesafio(d2)));;
	}

	protected double coincidenciaConDesafio(Desafio d1) {
		return user.getPerfilDeUsuario().calcularCoincidenciaConDesafio(d1);
	}
}
