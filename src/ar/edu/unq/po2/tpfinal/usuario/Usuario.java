package ar.edu.unq.po2.tpfinal.usuario;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.tpfinal.desafio.Desafio;
import ar.edu.unq.po2.tpfinal.desafio.DesafioAceptado;
import ar.edu.unq.po2.tpfinal.desafio.EstadoDesafioEnCurso;
import ar.edu.unq.po2.tpfinal.filtrador.Evaluable;
import ar.edu.unq.po2.tpfinal.filtrador.Filtrador;
import ar.edu.unq.po2.tpfinal.muestra.Muestra;
import ar.edu.unq.po2.tpfinal.sistema.Circunferencia;
import ar.edu.unq.po2.tpfinal.sistema.Sistema;
import ar.edu.unq.po2.tpfinal.proyecto.Proyecto;
import ar.edu.unq.po2.tpfinal.recomendadorDeDesafios.Recomendador;

public class Usuario {

	Sistema sistema;
	PerfilDeUsuario perfilDeUsuario;
	List<Proyecto> proyectos;
	List<Muestra> muestras;
	List<DesafioAceptado> desafios;
	Recomendador recomendador;
	List<MuestraAgregable> muestrasAgregables;

	public Usuario(Sistema sistema, PerfilDeUsuario perfil, Recomendador recomendador) throws Exception {
		this.sistema = sistema;
		this.proyectos = new ArrayList<Proyecto>();
		this.muestras = new ArrayList<Muestra>();
		this.desafios = new ArrayList<DesafioAceptado>();
		this.perfilDeUsuario = perfil;
		this.recomendador = recomendador;
		this.muestrasAgregables = new ArrayList<MuestraAgregable>();
	}

	public List<Proyecto> getProyectos() {
		return proyectos;
	}

	public List<Muestra> getMuestras() {
		return muestras;
	}

	public List<DesafioAceptado> getDesafios() {
		return desafios;
	}

	public Recomendador getRecomendador() {
		return recomendador;
	}

	public List<MuestraAgregable> getMuestrasAgregables() {
		return muestrasAgregables;
	}

	public Sistema getSistema() {
		return this.sistema;
	}

	public PerfilDeUsuario getPerfilDeUsuario() {
		return perfilDeUsuario;
	}

	public void suscribirseAProyecto(Proyecto proyecto) {
		this.proyectos.add(proyecto);
		this.muestrasAgregables.add(proyecto);
		proyecto.suscribirUsuario(this);
	}

	public void desuscribirseAProyecto(Proyecto proyecto) {
		this.proyectos.remove(proyecto);
		this.muestrasAgregables.remove(proyecto);
		proyecto.desuscribirUsuario(this);
	}

	public Desafio desafioMasGustado() {
		List<DesafioAceptado> listaAuxiliar = desafios;
		listaAuxiliar.sort((d1, d2) -> Double.compare(d1.getCalificacion(), d2.getCalificacion()));
		return listaAuxiliar.get(0);
	}

	public void tomarMuestra(Muestra muestra) {
		muestras.add(muestra);
		for (MuestraAgregable elemento : muestrasAgregables) {
			elemento.notify(this);
			;
		}
	}

	public void aceptarDesafio(Desafio desafio) {
		Circunferencia area = desafio.getArea();
		int dificultad = desafio.getDificultad();
		int cantMinMuestras = desafio.getCantidadMinimaMuestras();
		int recompensa = desafio.getRecompensa();
		this.desafios.add(
				new DesafioAceptado(area, cantMinMuestras, dificultad, recompensa, this, new EstadoDesafioEnCurso()));
		this.muestrasAgregables.add(desafios.get(desafios.size() - 1));
	}

	public void calificarDesafio(DesafioAceptado desafio, int calificacion) {
		desafio.setCalificacion(calificacion);
	}

	public List<DesafioAceptado> getDesafiosCompletados() {
		List<DesafioAceptado> listaAuxiliar = desafios;

		return listaAuxiliar.stream().filter(x -> x.getEstado() == "Desafío completado").toList();
	}

	public int calcularPorcentajeDeCompletitud() {
		int x = 0;
		for (DesafioAceptado desafio : desafios) {
			x += desafio.porcentajeCompletitud(desafio);
		}

		x = x / desafios.size();

		return x;
	}

	public LocalTime getHoraDeCompletitudDeDesafio(DesafioAceptado desafio) {
		return desafio.getHoraCompletado();
	}

	public LocalDate getFechaDeCompletitudDeDesafio(DesafioAceptado desafio) {
		return desafio.getFechaCompletado();
	}

	public double getPorcentajeDeCompletitudDeDesafio(DesafioAceptado desafio) {
		return desafio.porcentajeCompletitud(desafio);
	}

	public void setDificultadPreferida(int numero) throws Exception {
		perfilDeUsuario.setDificultad(numero);
	}

	public void setCantMinMuestrasPreferida(int numero) throws Exception {
		perfilDeUsuario.setCantidadMinimaMuestras(numero);
	}

	public void setRecompensaPreferida(int numero) throws Exception {
		perfilDeUsuario.setRecompensa(numero);
	}

	public List<Desafio> recomendar() {
		return this.recomendador.recomendar();
	}

	public List<Evaluable> buscarProyectos(Filtrador filtrador) {
		ArrayList<Evaluable> listaAFiltrar = new ArrayList<Evaluable>();

		listaAFiltrar.addAll(proyectos);

		return filtrador.evaluar(listaAFiltrar);
	}
}
