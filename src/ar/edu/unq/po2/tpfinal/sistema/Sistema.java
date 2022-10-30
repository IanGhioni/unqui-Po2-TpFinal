package ar.edu.unq.po2.tpfinal.sistema;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.tpfinal.desafio.Desafio;

public class Sistema {
	private List<String> listaDeCategorias;
	private List<Desafio> listaDeDesafios;
	
	public Sistema() {
		this.listaDeCategorias = new ArrayList<String>();
		this.listaDeDesafios = new ArrayList<Desafio>();
	}

	public List<String> getListaDeCategorias() {
		return listaDeCategorias;
	}

	public List<Desafio> getListaDeDesafios() {
		return listaDeDesafios;
	}

	public void addCategoria(String categoria) {
		listaDeCategorias.add(categoria);
	}
	
	

	public void addDesafio(Desafio desafio) {
		listaDeDesafios.add(desafio);
	}

	public boolean contieneLaCategoria(String string) {
		return listaDeCategorias.contains(string);
	}

	public boolean contieneElDesafio(Desafio desafio) {
		return listaDeDesafios.contains(desafio);
	}

	public void removeCategoria(String string) {
		listaDeCategorias.remove(string);
	}

	public void removeDesafio(Desafio desafio) {
		listaDeDesafios.remove(desafio);
		
		
	}
	
	
}
