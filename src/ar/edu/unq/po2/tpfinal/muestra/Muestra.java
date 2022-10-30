package ar.edu.unq.po2.tpfinal.muestra;

import java.util.Date;

import ar.edu.unq.po2.tpfinal.sistema.Coordenada;
import ar.edu.unq.po2.tpfinal.usuario.Usuario;

public class Muestra {
	private Usuario usuarioAutor;
	private Date fecha;
	private String hora;
	private Coordenada ubicacion;
	
	public Muestra(Usuario usuarioAutor, Date fecha, String hora, Coordenada ubicacion) {
		this.usuarioAutor = usuarioAutor;
		this.fecha = fecha;
		this.hora = hora;
		this.ubicacion = ubicacion;
	}

	public Usuario getUsuarioAutor() {
		return usuarioAutor;
	}

	public Date getFecha() {
		return fecha;
	}

	public String getHora() {
		return hora;
	}

	public Coordenada getUbicacion() {
		return ubicacion;
	}
	
	
}
