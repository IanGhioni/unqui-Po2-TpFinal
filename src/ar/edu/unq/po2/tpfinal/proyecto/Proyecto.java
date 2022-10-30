package ar.edu.unq.po2.tpfinal.proyecto;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.tpfinal.muestra.Muestra;
import ar.edu.unq.po2.tpfinal.usuario.Usuario;


public class Proyecto {

	private String nombre;
	private String descripcion;
	private List<String> listaDeCategorias;
	private List<Usuario> listaDeUsuariosSuscriptos;
	private List<Muestra> listaDeMuestras;

	public Proyecto(String nombre, String descripcion) {
		this.setNombre(nombre);
		this.setDescripcion(descripcion);
		this.listaDeCategorias = new ArrayList<String>();
		this.listaDeUsuariosSuscriptos = new ArrayList<Usuario>();
		this.listaDeMuestras = new ArrayList<Muestra>();
	}

	private void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return this.nombre;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}

	public void añadirCategoria(String categoria) {
		this.listaDeCategorias.add(categoria);
	}

	public List<String> getListaDeCategorias() {
		return this.listaDeCategorias;
	}

	public List<Usuario> getListaDeUsuarios() {
		return this.listaDeUsuariosSuscriptos;
	}

	public void suscribirUsuario(Usuario usuario) {
		this.listaDeUsuariosSuscriptos.add(usuario);
	}

	public void añadirMuestra(Muestra muestra) {
		this.listaDeMuestras.add(muestra);
	}

	public List<Muestra> getListaDeMuestras() {
		return this.listaDeMuestras;
	}

	public void desuscribirUsuario(Usuario usuario) {
		this.listaDeUsuariosSuscriptos.remove(usuario);
	}
}
