package ar.edu.unq.po2.tpfinal.proyecto;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.tpfinal.muestra.Muestra;
import ar.edu.unq.po2.tpfinal.sistema.Sistema;
import ar.edu.unq.po2.tpfinal.usuario.MuestraAgregable;
import ar.edu.unq.po2.tpfinal.usuario.Usuario;
import ar.edu.unq.po2.tpfinal.filtrador.Evaluable;
import ar.edu.unq.po2.tpfinal.categoria.Categoria;


public class Proyecto implements  Evaluable, MuestraAgregable{

	private String nombre;
	private String descripcion;
	private Sistema sistema;
	

	private List<Categoria> categorias;
	private List<Usuario> usuariosSuscriptos;
	private List<Muestra> muestras;

	public Proyecto(String nombre, String descripcion, Sistema sistema) {
		this.setNombre(nombre);
		this.setDescripcion(descripcion);
		this.sistema = sistema;
		this.categorias = new ArrayList<Categoria>();
		this.usuariosSuscriptos = new ArrayList<Usuario>();
		this.muestras = new ArrayList<Muestra>();
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

	public void añadirCategoria(Categoria categoria) throws Exception {
		if (sistema.contieneLaCategoria(categoria)) {
			this.categorias.add(categoria);
		}
		else {
			throw new Exception(this.mensajeExceptionDeCategoriaInexistente());
		}
	}
	
	private String mensajeExceptionDeCategoriaInexistente() {
		return "El sistema no incluye la categoria dada.";
	}

	public void eliminarCategoria(Categoria categoria) {
		this.categorias.remove(categoria);
	}

	public List<Categoria> getCategorias() {
		return this.categorias;
	}

	public List<Usuario> getUsuarios() {
		return this.usuariosSuscriptos;
	}

	public void suscribirUsuario(Usuario usuario) throws Exception {
		if (this.sistema.contieneElUsuario(usuario)) {
			this.usuariosSuscriptos.add(usuario);
		}
		else {
			throw new Exception(this.mensajeExceptionDeUsuarioInexistente());
		}
	}
	
	private String mensajeExceptionDeUsuarioInexistente() {
		return "El sistema no incluye el usuario dado.";
	}

	public void desuscribirUsuario(Usuario usuario) {
		this.usuariosSuscriptos.remove(usuario);
	}

	public void agregarMuestra(Muestra muestra) {
		this.muestras.add(muestra);
	}

	public List<Muestra> getMuestras() {
		return this.muestras;
	}

	@Override
	public void notify(Usuario user) {
		int ultimaMuestra = user.getMuestras().size() - 1;
		Muestra muestra = user.getMuestras().get(ultimaMuestra);
		this.agregarMuestra(muestra);
	}

	

	
}
