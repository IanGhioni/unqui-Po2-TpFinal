package ar.edu.unq.po2.tpfinal.clases;

public class Circunferencia {
	
	private Coordenada centro;
	private int radio;
	
	public Circunferencia(Coordenada centro, int radio) {
		this.centro = centro;
		this.radio = radio;
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
