package ar.edu.unq.po2.tpfinal.desafio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import ar.edu.unq.po2.tpfinal.sistema.Circunferencia;
import ar.edu.unq.po2.tpfinal.usuario.MuestraAgregable;
import ar.edu.unq.po2.tpfinal.usuario.Usuario;

public class DesafioAceptado implements MuestraAgregable {
	private Desafio desafio;
	private Usuario usuario;
	private EstadoDesafio estado;
	private int muestrasTomadas;
	private LocalDate fechaCompletado;
	private LocalTime horaCompletado;
	private int calificacion;

//	public DesafioAceptado(Circunferencia area, int cantidadMinimaMuestras, int dificultad, int recompensa,
//			Usuario usuario, EstadoDesafio estado) {
//		super(area, cantidadMinimaMuestras, dificultad, recompensa);
//		this.usuario = usuario;
//		this.setEstado(estado);
//		this.muestrasTomadas = 0;
//	}

	public DesafioAceptado(Desafio desafio, Usuario usuario) {
		this.desafio = desafio;
		this.usuario = usuario;
		this.muestrasTomadas = 0;
		this.setEstado(new EstadoDesafioEnCurso());
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

	@Override
	public void notify(Usuario user) {
		this.agregarMuestra(1, this);
	}

//	public void agregarMuestra(int cantidad, DesafioAceptado desafio) {
//		if (restricciones.stream()
//				.allMatch(restriccion -> restriccion.verificarRestriccionAlDesafio(this, LocalDate.now()))) {
//			this.estado.agregarMuestra(cantidad, this);
//		}
//		this.verificarVencimiento();
//	}

	public Desafio getDesafio() {
		return desafio;
	}

	public void agregarMuestra(int cantidad, DesafioAceptado desafio) {
		if (this.getDesafio().getRestricciones().stream()
				.allMatch(restriccion -> restriccion.verificarRestriccionAlDesafio(this, LocalDate.now()))) {
			this.estado.agregarMuestra(cantidad, this);
		}
		this.verificarVencimiento();
	}

	public void verificarVencimiento() {
		if (this.estaVencido()) {
			this.setEstado(new EstadoDesafioVencido());
		}
	}

	private boolean estaVencido() {
		return (this.getDesafio().getRestricciones().stream().filter(RestriccionFechas.class::isInstance))
				.anyMatch(restriccion -> !restriccion.verificarRestriccionAlDesafio(this, LocalDate.now()));
	}

	public boolean faltaUnaMuestra() {
		return (this.getMuestrasTomadas() == (this.getDesafio().getCantidadMinimaMuestras() - 1));
	}

}
