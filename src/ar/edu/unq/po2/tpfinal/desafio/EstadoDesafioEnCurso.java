package ar.edu.unq.po2.tpfinal.desafio;

import java.time.LocalDate;
import java.time.LocalTime;

public class EstadoDesafioEnCurso extends EstadoDesafio {

	private DesafioAceptado desafioAceptado;

	public EstadoDesafioEnCurso(DesafioAceptado desafioAceptado) {
		this.desafioAceptado = desafioAceptado;
	}

	@Override
	public double porcentajeCompletitud() {
		double x = (double) desafioAceptado.getMuestrasTomadas();
		double y = (double) desafioAceptado.getDesafio().getCantidadMinimaMuestras();
		return (x / y * 100);
	}

	@Override
	public String descripcion() {
		return "Desafío en curso";
	}

	@Override
	public void agregarMuestra(int cantidad) {
		if (desafioAceptado.faltaUnaMuestra()) {
			desafioAceptado.setMuestrasTomadas(desafioAceptado.getDesafio().getCantidadMinimaMuestras());
			desafioAceptado.setEstado(new EstadoDesafioCompletado());
			desafioAceptado.setFechaCompletado(LocalDate.now());
			desafioAceptado.setHoraCompletado(LocalTime.now());
		} else {
			desafioAceptado.setMuestrasTomadas(desafioAceptado.getMuestrasTomadas() + cantidad);
		}
	}

}
