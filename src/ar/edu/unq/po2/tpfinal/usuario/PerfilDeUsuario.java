package ar.edu.unq.po2.tpfinal.usuario;

import ar.edu.unq.po2.tpfinal.desafio.Desafio;

public class PerfilDeUsuario {
	int dificultad;
	int cantidadMinimaMuestras;
	int recompensa;
	
	public PerfilDeUsuario(int dificultadPreferida, int cantidadMinimaDeMuestrasPreferida, int recompensaPreferida) throws Exception {
		if (!(dificultadPreferida <=5 && dificultadPreferida >=1) 
			|| cantidadMinimaDeMuestrasPreferida <= 0 
			|| recompensaPreferida <= 0) {
			
		}
		this.setDificultad(dificultadPreferida);
		this.setCantidadMinimaMuestras(cantidadMinimaDeMuestrasPreferida);
		this.setRecompensa(recompensaPreferida);
	}
	
	public void setDificultad(int dificultad) throws Exception {
		if (!(dificultad <=5 && dificultad >=1)) {
			throw new Exception(this.valorInvalidoDeDificultad());
		}
		else { this.dificultad = dificultad; }
	}

	private String valorInvalidoDeDificultad() {
		return "La dificultad debe ser un numero entre 1 y 5.";
	}

	public void setCantidadMinimaMuestras(int cantidadMinimaMuestras) throws Exception {
		if (cantidadMinimaMuestras <= 0) {
			throw new Exception(this.cantMinMuestrasMenorIgualA0());
		}
		else { this.cantidadMinimaMuestras = cantidadMinimaMuestras; }
	}

	private String cantMinMuestrasMenorIgualA0() {
		return "La cantidad minima de muestras a recolectar no puede ser menor o igual a 0.";
	}

	public void setRecompensa(int recompensa) throws Exception {
		if (recompensa <= 0) {
			throw new Exception(this.recompensaMenorIgualA0());
		}
		else { this.recompensa = recompensa; }
	}

	private String recompensaMenorIgualA0() {
		return "La recompensa del desafio no puede ser menor o igual a 0.";
	}

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
