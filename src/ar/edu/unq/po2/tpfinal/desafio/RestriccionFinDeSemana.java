package ar.edu.unq.po2.tpfinal.desafio;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class RestriccionFinDeSemana extends Restriccion {

	@Override
	public boolean verificarRestriccionAlDesafio(DesafioAceptado desafio, LocalDate fecha) {
		return ((fecha.getDayOfWeek() == DayOfWeek.SATURDAY) || (fecha.getDayOfWeek() == DayOfWeek.SUNDAY));
	}

}
