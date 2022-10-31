package ar.edu.unq.po2.tpfinal.desafio;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.tpfinal.sistema.Circunferencia;

public class Desafio {
	protected Circunferencia area;
	protected List<Restriccion> restricciones = new ArrayList<Restriccion>();
	protected int cantidadMinimaMuestras;
	protected int dificultad;
	protected int recompensa;

//	public Desafio(Circunferencia area, int cantidadMinimaMuestras, int dificultad, int recompensa) {
//		this.area = area;
//		this.cantidadMinimaMuestras = cantidadMinimaMuestras;
//		this.dificultad = dificultad;
//		this.recompensa = recompensa;
//	}

	public Circunferencia getArea() {
		return area;
	}

	public int getCantidadMinimaMuestras() {
		return cantidadMinimaMuestras;
	}

	public int getDificultad() {
		return dificultad;
	}

	public int getRecompensa() {
		return recompensa;
	}

	public void agregarRestriccion(Restriccion restriccion) {
		restricciones.add(restriccion);
	}

}
