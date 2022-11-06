package ar.edu.unq.po2.tpfinal.desafio;

public class EstadoDesafioVencido extends EstadoDesafio {

	@Override
	public double porcentajeCompletitud(DesafioAceptado desafio) {
		double x = (double)desafio.getMuestrasTomadas();
		double y = (double)desafio.getCantidadMinimaMuestras();
		return (x/y * 100);
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
