package ar.edu.unq.po2.tpfinal.sistema;

import java.util.ArrayList;
import java.util.List;
import ar.edu.unq.po2.tpfinal.desafio.Desafio;
import ar.edu.unq.po2.tpfinal.proyecto.Proyecto;
import ar.edu.unq.po2.tpfinal.usuario.Usuario;
import ar.edu.unq.po2.tpfinal.categoria.Categoria;

public class Sistema {
	private List<Categoria> categorias;
	private List<Desafio> desafios;
	private List<Usuario> usuarios;
	private List<Proyecto> proyectos;
	
	public Sistema() {
		this.categorias = new ArrayList<Categoria>();
		this.desafios = new ArrayList<Desafio>();
		this.usuarios = new ArrayList<Usuario>();
		this.proyectos = new ArrayList<Proyecto>();
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public List<Desafio> getDesafios() {
		return desafios;
	}

	public void addCategoria(Categoria categoria) {
		categorias.add(categoria);
	}
	
	

	public void addDesafio(Desafio desafio) {
		desafios.add(desafio);
	}

	public boolean contieneLaCategoria(Categoria categoria) {
		return categorias.contains(categoria);
	}

	public boolean contieneElDesafio(Desafio desafio) {
		return desafios.contains(desafio);
	}

	public void removeCategoria(Categoria categoria) {
		categorias.remove(categoria);
	}

	public void removeDesafio(Desafio desafio) {
		desafios.remove(desafio);
	}

	public void addUsuario(Usuario user) {
		usuarios.add(user);
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void removeUsuario(Usuario user) {
		usuarios.remove(user);
	}

	public boolean contieneElUsuario(Usuario user) {
		return this.usuarios.contains(user);
	}

	public void addProyecto(Proyecto proyecto) {
		proyectos.add(proyecto);
	}

	public List<Proyecto> getProyectos() {
		return proyectos;
	}

	public void removeProyecto(Proyecto proyecto) {
		this.proyectos.remove(proyecto);
	}

	public boolean contieneElProyecto(Proyecto proyecto) {
		return this.proyectos.contains(proyecto);
	}
	
	
}
