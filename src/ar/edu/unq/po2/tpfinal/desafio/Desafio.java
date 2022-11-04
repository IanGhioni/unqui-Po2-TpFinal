package ar.edu.unq.po2.tpfinal.desafio;

import java.util.ArrayList;
import java.util.List;


import ar.edu.unq.po2.tpfinal.sistema.Circunferencia;
import ar.edu.unq.po2.tpfinal.usuario.PerfilDeUsuario;

public class Desafio {
	protected Circunferencia area;
	protected List<Restriccion> restricciones = new ArrayList<Restriccion>();
	protected int cantidadMinimaMuestras;
	protected int dificultad;
	protected int recompensa;

	public Desafio(Circunferencia area, int cantidadMinimaMuestras, int dificultad, int recompensa) {
		this.area = area;
		this.cantidadMinimaMuestras = cantidadMinimaMuestras;
		this.dificultad = dificultad;
		this.recompensa = recompensa;
	}

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

	public List<Restriccion> getRestricciones() {
		return restricciones;
	}

	public void agregarRestriccion(Restriccion restriccion) {
		restricciones.add(restriccion);
	}

	public double calcularSimilitudConDesafio(Desafio desafio) {
		return ((double) Math.abs(this.getDificultad() - desafio.getDificultad())
				+ (double) Math.abs(this.getCantidadMinimaMuestras() - desafio.getCantidadMinimaMuestras())
				+ (double) Math.abs(this.getRecompensa() - desafio.getRecompensa())) / 3;
	}
	public double calcularSimilitudConPreferencia(PerfilDeUsuario perfilDeUsuario) {
		return ((double) Math.abs(this.getDificultad() - perfilDeUsuario.getDificultad())
				+ (double) Math.abs(this.getCantidadMinimaMuestras() - perfilDeUsuario.getCantidadMinimaMuestras())
				+ (double) Math.abs(this.getRecompensa() - perfilDeUsuario.getRecompensa())) / 3;
	}

}
