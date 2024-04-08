package paquete;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Jugador extends Persona {

	private static ArrayList<Jugador> ListaJugador;
	private static int contador;

	private static double TotalSanciones;
	private static double TotalMarcados;

	private int idJugador;

	private String posicion;
	private double sanciones;
	private int marcados;
	private double valor;

	public Jugador(String nombre, String apellido, String posicion) {
		super(nombre, apellido);
		idJugador = contador;
		this.posicion = posicion;
		contador++;
	}

	// formato : IdJugador, Marcados, Sanciones, Valor

	public static void ActualizarJugador() throws IOException {
		// leer de un archivo
		BufferedReader bfr = new BufferedReader(new FileReader("Temporal.txt"));
		try {
			String linea = "";
			while (linea != null) {
				linea = bfr.readLine();
				// declarar valores de los datos del jugador
				String[] datos = linea.split("#");
				int id = Integer.parseInt(datos[0]);
				int marcados = Integer.parseInt(datos[1]);
				double Sanciones = Double.parseDouble(datos[2]);
				double valor = Double.parseDouble(datos[3]);
				// actualizar los datos de cada jugador
				for (Jugador jugador : ListaJugador) {
					if (jugador.getIdJugador() == id) {
						jugador.setMarcados(marcados);
						jugador.setSanciones(Sanciones);
						jugador.setValor(valor);
						break;
					}
				}

			}
		} catch (Exception e) {
			System.err.println("Error en la lectura para actualizacion jugador");
		} finally {
			bfr.close();
		}

	}

	private double CalcularValor() {

		return 0;
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

	public static ArrayList<Jugador> getListaJugador() {
		return ListaJugador;
	}

	public static void setListaJugador(ArrayList<Jugador> listaJugador) {
		ListaJugador = listaJugador;
	}
	// termina el getter y setter

}
