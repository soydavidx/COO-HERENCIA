package paquete;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Jugador extends Persona {

	private static int contador;

	private static double TotalSanciones;
	private static double TotalMarcados;

	private int idJugador;

	private String posicion;

	// estos atributo se modificara cada vez que se cargue la aplicacion leyendo
	// datos de la carpeta temporal
	private double sanciones;
	private int marcados;
	private double valor;
	private int PuestoInteriorEquipo;
	private boolean titular;
	private int IdEquipo;

	public Jugador(String nombre, String apellido, String posicion, String profesion, int equipo) {
		super(nombre, apellido, profesion, equipo);
		idJugador = contador;
		this.posicion = posicion;
		// valor calculado con el metodo CalcularValor
		valor = CalcularValor();
		contador++;
	}

	// formato : IdJugador, Marcados, Sanciones, Valor

	public static void CasoJugador(String[] datos,String nombre, String apellido , String profesion, int idEquipo, ArrayList<Persona>MienbrosEquipo) {
		int marcados = Integer.parseInt(datos[4]);
		double Sanciones = Double.parseDouble(datos[5]);
		double valor = Double.parseDouble(datos[6]);
		int PuestoInteriorEquipo = Integer.parseInt(datos[7]);
		String posicion = datos[8];
		boolean titular = Boolean.parseBoolean(datos[9]);
		Jugador elJugador = new Jugador(nombre, apellido, posicion, profesion, idEquipo);
		elJugador.setMarcados(marcados);
		elJugador.setSanciones(Sanciones);
		elJugador.setValor(valor);
		elJugador.setPuestoInteriorEquipo(PuestoInteriorEquipo);
		elJugador.setPosicion(posicion);
		elJugador.setTitular(titular);

		MienbrosEquipo.add(elJugador);
		Persona.getListaPersona().add(elJugador);
	}

	// despues de haber jugado una partida
	private void JugadorMarcar() {
		// poner un generador de numero aleatorio
		// con el numero generado actualizar marcados del jugador
	}

	// despues de haber jugado una partida
	private void JugadorSancion() {
		// poner un generador de numero aleatorio
		// con el numero generado actualizar marcados del jugador
	}

	// despues de haber jugado una partida
	private double CalcularValor() {
		return (marcados * 1000) - (sanciones * 500);
	}

	// empieza el getter y setter
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

	public static double getTotalSanciones() {
		return TotalSanciones;
	}

	public static void setTotalSanciones(double totalSanciones) {
		TotalSanciones = totalSanciones;
	}

	public static double getTotalMarcados() {
		return TotalMarcados;
	}

	public static void setTotalMarcados(double totalMarcados) {
		TotalMarcados = totalMarcados;
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

	// termina el getter y setter

}
