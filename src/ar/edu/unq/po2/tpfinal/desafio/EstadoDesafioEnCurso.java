package ar.edu.unq.po2.tpfinal.desafio;

import java.time.LocalDate;

public class EstadoDesafioEnCurso extends EstadoDesafio {

	@Override
	public double porcentajeCompletitud(DesafioAceptado desafio) {
		return (desafio.getMuestrasTomadas() / desafio.getCantidadMinimaMuestras() * 100);
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
			desafio.setMomentoCompletado(LocalDate.now());
		}
		desafio.setMuestrasTomadas(desafio.getMuestrasTomadas() + cantidad);
	}

}
