package ar.edu.unq.po2.tpfinal.desafio;

public class EstadoDesafioVencido extends EstadoDesafio {

	@Override
	public double porcentajeCompletitud(DesafioAceptado desafio) {
		return (desafio.getCantidadMinimaMuestras() - desafio.getMuestrasTomadas())
				/ desafio.getCantidadMinimaMuestras();
	}

	@Override
	public String descripcion() {
		return "Desafío vencido";
	}

	@Override
	public void agregarMuestra(int cantidad, DesafioAceptado desafio) {
		// no pueden agregarse muestras porque ya está vencido
	}

}
