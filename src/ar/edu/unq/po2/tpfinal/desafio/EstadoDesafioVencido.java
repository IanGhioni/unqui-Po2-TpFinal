package ar.edu.unq.po2.tpfinal.desafio;

public class EstadoDesafioVencido extends EstadoDesafio {

	private DesafioAceptado desafioAceptado;

	public EstadoDesafioVencido(DesafioAceptado desafioAceptado) {
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
		return "Desafío vencido";
	}

	@Override
	public void agregarMuestra(int cantidad) {
		// no pueden agregarse muestras porque ya está vencido
	}

}
