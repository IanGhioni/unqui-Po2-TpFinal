package ar.edu.unq.po2.tpfinal.sistema;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.tpfinal.desafio.Desafio;
import ar.edu.unq.po2.tpfinal.categoria.Categoria;

public class Sistema {
	private List<Categoria> categorias;
	private List<Desafio> listaDeDesafios;
	
	public Sistema() {
		this.categorias = new ArrayList<Categoria>();
		this.listaDeDesafios = new ArrayList<Desafio>();
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public List<Desafio> getListaDeDesafios() {
		return listaDeDesafios;
	}

	public void addCategoria(Categoria categoria) {
		categorias.add(categoria);
	}
	
	

	public void addDesafio(Desafio desafio) {
		listaDeDesafios.add(desafio);
	}

	public boolean contieneLaCategoria(Categoria categoria) {
		return categorias.contains(categoria);
	}

	public boolean contieneElDesafio(Desafio desafio) {
		return listaDeDesafios.contains(desafio);
	}

	public void removeCategoria(Categoria categoria) {
		categorias.remove(categoria);
	}

	public void removeDesafio(Desafio desafio) {
		listaDeDesafios.remove(desafio);
		
		
	}
	
	
}
