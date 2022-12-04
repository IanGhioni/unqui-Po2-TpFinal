package ar.edu.unq.po2.tpfinal.recomendadorDeDesafios;

import java.util.List;

import ar.edu.unq.po2.tpfinal.desafio.Desafio;
import ar.edu.unq.po2.tpfinal.usuario.Usuario;

public class RecomendadorMisPreferencias extends RecomendadorDeDesafios  {
	
	public RecomendadorMisPreferencias(Usuario user) {
		super(user);
	}

	@Override
	public List<Desafio> recomendar() {
			desafios = user.getSistema().getDesafios();
			
			this.sacarDesafiosQueYaRealizo();
			this.ordenarDesafiosPorCoincidencia();
			this.seleccionarDesafios();
			return this.desafios;
	}

	private void sacarDesafiosQueYaRealizo() {
		List<Desafio> desafiosUsuario = user.getDesafios().stream().map(s -> s.getDesafio()).toList();
		
		desafios.removeIf(s -> desafiosUsuario.contains(s));
	}
	

}
