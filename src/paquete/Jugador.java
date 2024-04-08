package paquete;

import java.util.ArrayList;

public class Jugador extends Persona {

	private static ArrayList<Jugador>ListaJugador;
	private static int contador;
	
	private int idJugador;
	
	private String posicion;
	private double sanciones;
	private int marcados;
	private double valor;
	
	
	
	public Jugador(String nombre, String apellido, int idJugador, String posicion, double sanciones, int marcados, double valor) {
		super(nombre,apellido);
		idJugador = contador;
		this.posicion = posicion;
		this.sanciones = sanciones;
		this.marcados = marcados;
		this.valor = valor;
		
		contador ++;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//empieza el getter y setter
	public int getIdJugador() {
		return idJugador;
	}
	public void setIdJugador(int idJugador) {
		this.idJugador = idJugador;
	}
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
	public static ArrayList<Jugador> getListaJugador() {
		return ListaJugador;
	}
	public static void setListaJugador(ArrayList<Jugador> listaJugador) {
		ListaJugador = listaJugador;
	}
	//termina el getter y setter

	
	

}
