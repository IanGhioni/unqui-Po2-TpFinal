package ar.edu.unq.po2.tpfinal.desafio;

import java.time.LocalDate;
import java.time.LocalTime;

import ar.edu.unq.po2.tpfinal.sistema.Circunferencia;
import ar.edu.unq.po2.tpfinal.usuario.Usuario;

public class DesafioAceptado extends Desafio {
	private Usuario usuario;
	private EstadoDesafio estado;
	private int muestrasTomadas;
	private LocalDate fechaCompletado;
	private LocalTime horaCompletado;
	private int calificacion;

	public DesafioAceptado(Circunferencia area, int cantidadMinimaMuestras, int dificultad, int recompensa,
			Usuario usuario, EstadoDesafio estado) {
		super(area, cantidadMinimaMuestras, dificultad, recompensa);
		this.usuario = usuario;
		this.setEstado(estado);
		this.muestrasTomadas = 0;
	}

	public void setFechaCompletado(LocalDate fecha) {
		this.fechaCompletado = fecha;
	}

	public LocalDate getFechaCompletado() {
		return fechaCompletado;
	}

	public void setHoraCompletado(LocalTime hora) {
		this.horaCompletado = hora;
	}

	public LocalTime getHoraCompletado() {
		return horaCompletado;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public String getEstado() {
		return estado.descripcion();
	}

	public int getMuestrasTomadas() {
		return muestrasTomadas;
	}

	public void setMuestrasTomadas(int cantidad) {
		this.muestrasTomadas = cantidad;
	}

	public void setEstado(EstadoDesafio estado) {
		this.estado = estado;
	}

	public void setCalificacion(int calificacion) {
		if (calificacion < 0 || calificacion > 5) {
			throw new IllegalArgumentException("La calificación ingresada debe estar entre 0 y 5.");
		}
		this.calificacion = calificacion;
	}

	public int getCalificacion() {
		return calificacion;
	}

	public double porcentajeCompletitud(DesafioAceptado desafio) {
		return this.estado.porcentajeCompletitud(this);
	}

	public void agregarMuestra(int cantidad, DesafioAceptado desafio) {
		this.estado.agregarMuestra(cantidad, this);
	}

	public boolean faltaUnaMuestra() {
		return (this.getMuestrasTomadas() == (this.getCantidadMinimaMuestras() - 1));
	}

}
