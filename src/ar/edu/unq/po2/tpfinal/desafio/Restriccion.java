package ar.edu.unq.po2.tpfinal.desafio;

import java.time.LocalDate;

public abstract class Restriccion {
	public abstract boolean verificarRestriccionAlDesafio(DesafioAceptado desafio, LocalDate fecha);
}
