package ar.edu.unq.po2.tpfinal.desafio;

public abstract class EstadoDesafio {

	public abstract double porcentajeCompletitud(DesafioAceptado desafio);

	public abstract String descripcion();

	public abstract void agregarMuestra(int cantidad, DesafioAceptado desafio);

}
