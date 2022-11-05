package ar.edu.unq.po2.tpfinal.desafio;

import java.time.LocalDate;

public class RestriccionFechas extends Restriccion {

	private LocalDate fechaInicio;
	private LocalDate fechaFin;

	public RestriccionFechas(LocalDate fechaInicio, LocalDate fechaFin) {
		super();
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}

	@Override
	public boolean verificarRestriccionAlDesafio(DesafioAceptado desafio, LocalDate fecha) {
		return ((fecha.isAfter(fechaInicio)) && (fecha.isBefore(fechaFin)));
	}

}
