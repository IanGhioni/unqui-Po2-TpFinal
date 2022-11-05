package ar.edu.unq.po2.tpfinal.proyecto;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.tpfinal.muestra.Muestra;
import ar.edu.unq.po2.tpfinal.sistema.Sistema;
import ar.edu.unq.po2.tpfinal.usuario.Usuario;
import ar.edu.unq.po2.tpfinal.filtrador.Evaluable;


public class Proyecto implements  Evaluable {

	private String nombre;
	private String descripcion;
	private Sistema sistema;
	

	private List<String> listaDeCategorias;
	private List<Usuario> listaDeUsuariosSuscriptos;
	private List<Muestra> listaDeMuestras;

	public Proyecto(String nombre, String descripcion, Sistema sistema) {
		this.setNombre(nombre);
		this.setDescripcion(descripcion);
		this.sistema = sistema;
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
	
	public Sistema getSistema() {
		return sistema;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}

	public void añadirCategoria(String categoria) throws Exception {
		if (sistema.contieneLaCategoria(categoria)) {
			this.listaDeCategorias.add(categoria);
		}
		else {
			throw new Exception(this.mensajeExceptionDeCategoriaInexistente());
		}
	}
	
	private String mensajeExceptionDeCategoriaInexistente() {
		return "El sistema no incluye la categoria dada.";
	}

	public void eliminarCategoria(String string) {
		this.listaDeCategorias.remove(string);
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
	
	public void desuscribirUsuario(Usuario usuario) {
		this.listaDeUsuariosSuscriptos.remove(usuario);
	}

	public void añadirMuestra(Muestra muestra) {
		this.listaDeMuestras.add(muestra);
	}

	public List<Muestra> getListaDeMuestras() {
		return this.listaDeMuestras;
	}

	

	
}
