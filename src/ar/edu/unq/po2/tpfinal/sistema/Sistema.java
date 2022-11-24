package ar.edu.unq.po2.tpfinal.sistema;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.tpfinal.desafio.Desafio;
import ar.edu.unq.po2.tpfinal.categoria.Categoria;

public class Sistema {
	private List<Categoria> categorias;
	private List<Desafio> desafios;
	
	public Sistema() {
		this.categorias = new ArrayList<Categoria>();
		this.desafios = new ArrayList<Desafio>();
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public List<Desafio> getListaDeDesafios() {
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
	
	
}
