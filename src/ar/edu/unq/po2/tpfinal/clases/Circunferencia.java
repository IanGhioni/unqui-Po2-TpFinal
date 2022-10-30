package ar.edu.unq.po2.tpfinal.clases;

public class Circunferencia {
	
	private Coordenada centro;
	private int radio;
	
	public Circunferencia(Coordenada centro, int radio) throws Exception {
		if (radio <= 0) {
			throw new Exception( this.mensajeDeErrorRadioMenorIgualA0() );
		}
		this.centro = centro;
		this.radio = radio;
	}

	private String mensajeDeErrorRadioMenorIgualA0() {
		return "El Radio no puede ser menor o igual a 0.";
	}

	public Coordenada getCentro() {
		return centro;
	}

	public int getRadio() {
		return radio;
	}
	
	public boolean verificarSiIncluyeCoordenada(Coordenada c) {
		float x = this.centro.getX();
		float y = this.centro.getY();
		float a = c.getX();
		float b = c.getY();
		float r = radio;
		
		return
			(Math.abs(a-x)*Math.abs(a-x))  +  (Math.abs(b-y)*Math.abs(b-y))	
			<= 
			r*r;
		
				
				
	}
}
