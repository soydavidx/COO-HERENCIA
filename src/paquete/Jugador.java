package paquete;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Jugador extends Persona {
	private static int contador = 1;

	private String posicion;
	private double TotalSanciones;
	private double TotalMarcados;

	// estos atributo se modificara cada vez que se cargue la aplicacion leyendo
	// datos de la carpeta temporal
	private double sanciones;
	private int marcados;
	private double valor;
	private int PuestoInteriorEquipo;
	private boolean titular;

	public Jugador(String nombre, String apellido, String profesion, int equipo, String posicion, double TotalSanciones, double TotalMarcados) {
		super(nombre, apellido, profesion, equipo);
		this.posicion = posicion;
		this.TotalSanciones = TotalSanciones;
		this.TotalMarcados = TotalMarcados;
		super.setId(contador);
		this.valor = CalcularValor();
		contador++;
	}

	// despues de haber jugado una partida
	private double CalcularValor() {
		return (marcados * 1000) - (sanciones * 500);
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public double getTotalSanciones() {
		return TotalSanciones;
	}

	public void setTotalSanciones(double totalSanciones) {
		TotalSanciones = totalSanciones;
	}

	public double getTotalMarcados() {
		return TotalMarcados;
	}

	public void setTotalMarcados(double totalMarcados) {
		TotalMarcados = totalMarcados;
	}

	public double getSanciones() {
		return sanciones;
	}

	public void setSanciones(double sanciones) {
		this.sanciones = sanciones;
	}

	public int getMarcados() {
		return marcados;
	}

	public void setMarcados(int marcados) {
		this.marcados = marcados;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public boolean isTitular() {
		return titular;
	}

	public void setTitular(boolean titular) {
		this.titular = titular;
	}

	public int getPuestoInteriorEquipo() {
		return PuestoInteriorEquipo;
	}

	public void setPuestoInteriorEquipo(int puestoInteriorEquipo) {
		PuestoInteriorEquipo = puestoInteriorEquipo;
	}

	// termina el getter y setter

}
