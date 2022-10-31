package ar.edu.unq.po2.tpfinal.desafio;

import java.time.LocalDate;
import ar.edu.unq.po2.tpfinal.sistema.Circunferencia;
import ar.edu.unq.po2.tpfinal.usuario.Usuario;

public class DesafioAceptado extends Desafio {
	private Usuario usuario;
	private EstadoDesafio estado;
	private int muestrasTomadas;
	private LocalDate momentoCompletado;
	private int calificacion;

//	public DesafioAceptado(Usuario usuario) {
//		super(area, muestrasTomadas, muestrasTomadas, muestrasTomadas);
//		this.usuario = usuario;
//		this.estado = new EstadoDesafioEnCurso();
//		this.muestrasTomadas = 0;
//	}

	public void setMomentoCompletado(LocalDate momento) {
		this.momentoCompletado = momento;
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
		this.estado.calificar(calificacion, this);
	}

	public double porcentajeCompletitud(DesafioAceptado desafio) {
		return this.estado.porcentajeCompletitud(this);
	}

	public void agregarMuestra(int cantidad, DesafioAceptado desafio) {
		this.estado.agregarMuestra(cantidad, this);
	}

}
