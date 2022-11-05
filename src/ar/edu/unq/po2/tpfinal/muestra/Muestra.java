package ar.edu.unq.po2.tpfinal.muestra;

import java.time.LocalDate;
import java.time.LocalTime;

import ar.edu.unq.po2.tpfinal.sistema.Coordenada;
import ar.edu.unq.po2.tpfinal.usuario.Usuario;

public class Muestra {
	private Usuario usuarioAutor;
	private LocalDate fecha;
	private LocalTime hora;
	private Coordenada ubicacion;
	
	public Muestra(Usuario usuarioAutor, Coordenada ubicacion) {
		this.usuarioAutor = usuarioAutor;
		this.fecha = LocalDate.now();
		this.hora = LocalTime.now();
		this.ubicacion = ubicacion;
	}

	public Usuario getUsuarioAutor() {
		return usuarioAutor;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public LocalTime getHora() {
		return hora;
	}

	public Coordenada getUbicacion() {
		return ubicacion;
	}
	
	
}
