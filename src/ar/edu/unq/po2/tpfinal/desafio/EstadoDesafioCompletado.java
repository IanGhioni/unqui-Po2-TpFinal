package ar.edu.unq.po2.tpfinal.desafio;

public class EstadoDesafioCompletado extends EstadoDesafio {

	@Override
	public double porcentajeCompletitud() {
		return 100.0;
	}

	@Override
	public String descripcion() {
		return "Desafío completado";
	}

	@Override
	public void agregarMuestra(int cantidad) {
		// no pueden agregarse muestras porque ya está completo
	}

}
