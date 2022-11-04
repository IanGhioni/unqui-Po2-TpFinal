package ar.edu.unq.po2.tpfinal.desafio;

import java.time.LocalDate;
import java.time.LocalTime;

public class EstadoDesafioEnCurso extends EstadoDesafio {

	@Override
	public double porcentajeCompletitud(DesafioAceptado desafio) {
		double x = (double) desafio.getMuestrasTomadas();
		double y = (double) desafio.getCantidadMinimaMuestras();
		return (x / y * 100);
	}

	@Override
	public String descripcion() {
		return "Desafío en curso";
	}

	@Override
	public void agregarMuestra(int cantidad, DesafioAceptado desafio) {
		if (desafio.faltaUnaMuestra()) {
			desafio.setMuestrasTomadas(desafio.getCantidadMinimaMuestras());
			desafio.setEstado(new EstadoDesafioCompletado());
			desafio.setFechaCompletado(LocalDate.now());
			desafio.setHoraCompletado(LocalTime.now());
		}
		desafio.setMuestrasTomadas(desafio.getMuestrasTomadas() + cantidad);
	}

}
