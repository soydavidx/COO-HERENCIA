package paquete;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Jugador extends Persona {
	private static int contador = 1;	
	private String posicion;

	// estos atributo se modificara cada vez que se cargue la aplicacion leyendo
	// datos de la carpeta temporal
	private double sanciones;
	private int marcados;
	private double valor;
	private int PuestoInteriorEquipo;
	private boolean titular;
	private int IdEquipo;
	private int TotalSanciones;
	private int TotalMarcados;

	public Jugador(String nombre, String apellido, String profesion, int equipo, String posicion, double TotalSanciones, double TotalMarcados) {
		super(nombre, apellido, profesion, equipo);
		this.posicion = posicion;
		// valor calculado con el metodo CalcularValor
		super.setId(contador);
		this.valor = CalcularValor();
		contador++;
	}

	// despues de haber jugado una partida
	private double CalcularValor() {
		return (marcados * 1000) - (sanciones * 500);
	}
	
	public void Marcar() {
		//el jugador puede marcar de 0 a 3 
		marcados = Partida.Rng(3)-1;
	}
	
	public void Sancionar() {
		//un jugador puede recibir o no sanciones si recibe sanciones entonces recibira con un rango de 100
		int sancion = Partida.Rng(2) - 1;
		if (sancion == 0) {
			sanciones = 0;
		}
		else if (sancion == 1){
			sanciones = Partida.Rng(100);
		}
	}

	// empieza el getter y setter

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
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

	public int getIdEquipo() {
		return IdEquipo;
	}

	public void setIdEquipo(int idEquipo) {
		IdEquipo = idEquipo;
	}

	public int getTotalSanciones() {
		return TotalSanciones;
	}

	public void setTotalSanciones(int totalSanciones) {
		TotalSanciones = totalSanciones;
	}

	public int getTotalMarcados() {
		return TotalMarcados;
	}

	public void setTotalMarcados(int totalMarcados) {
		TotalMarcados = totalMarcados;
	}
	

	// termina el getter y setter

}
