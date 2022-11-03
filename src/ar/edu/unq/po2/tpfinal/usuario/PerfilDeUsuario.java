package ar.edu.unq.po2.tpfinal.usuario;

import ar.edu.unq.po2.tpfinal.desafio.Desafio;

public class PerfilDeUsuario {
	int dificultad;
	int cantidadMinimaMuestras;
	int recompensa;
	
	public int getDificultad() {
		return dificultad;
	}

	public int getCantidadMinimaMuestras() {
		return cantidadMinimaMuestras;
	}

	public int getRecompensa() {
		return recompensa;
	}

	public double calcularCoincidenciaConDesafio(Desafio d) {
		return(
			Math.abs(d.getDificultad() - this.dificultad)
			+
			Math.abs(d.getCantidadMinimaMuestras() - this.cantidadMinimaMuestras)
			+
			Math.abs(d.getRecompensa() - this.recompensa)
		);
	}

}
