package paquete;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Jugador extends Persona {

	
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
	private int IdEquipo;

	public Jugador(String nombre, String apellido, String profesion, int equipo, String posicion, double TotalSanciones, double TotalMarcados) {
		super(nombre, apellido, profesion, equipo);
		this.posicion = posicion;
		// valor calculado con el metodo CalcularValor
		this.TotalSanciones = TotalSanciones;
		this.TotalMarcados = TotalMarcados;
	}

	// formato : IdJugador, Marcados, Sanciones, Valor

	public static void ActualizarEquipo() throws IOException {
		// leer de un archivo
		BufferedReader bfr = new BufferedReader(new FileReader("Temporal.txt"));
		try {
			String linea = "";
			while (linea != null) {
				linea = bfr.readLine();
				do {
					if (linea.contains("-")) {
						// declarar valores de los datos del equipo
						String[] datos = linea.split("#");
						int idEquipo = Integer.parseInt(datos[0]);
					}
					if (linea.contains("$")) {
						// declarar valores de los datos del jugador
						String[] datos = linea.split("#");
						int id = Integer.parseInt(datos[0]);
						int marcados = Integer.parseInt(datos[1]);
						double Sanciones = Double.parseDouble(datos[2]);
						double valor = Double.parseDouble(datos[3]);
						int PuestoInteriorEquipo = Integer.parseInt(datos[4]);
						String posicion = datos[5];
						boolean titular = Boolean.parseBoolean(datos[6]);
						// actualizar los datos de cada jugador
						for (Persona persona : Persona.getListaPersona()) {
							if (persona instanceof Jugador) {
								Jugador jugador = (Jugador) persona;
								if (jugador.getId() == id) {
									jugador.setMarcados(marcados);
									jugador.setSanciones(Sanciones);
									jugador.setValor(valor);
									jugador.setPuestoInteriorEquipo(PuestoInteriorEquipo);
									jugador.setPosicion(posicion);
									jugador.setTitular(titular);
									break;
								}
							}
						}
					}
				} while (linea.contains("-"));
			}
		} catch (Exception e) {
			System.err.println("Error en la lectura para actualizacion jugador");
		} finally {
			bfr.close();
		}
		}
	
	

	// despues de haber jugado una partida
	private double CalcularValor() {
		return (marcados * 1000) - (sanciones * 500);
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

	public double getTotalSanciones() {
		return TotalSanciones;
	}
	
	public void setTotalSanciones(double totalSanciones) {
		TotalSanciones = totalSanciones;
	}
	
	public int getMarcados() {
		return marcados;
	}

	public void setMarcados(int marcados) {
		this.marcados = marcados;
	}

	public double getTotalMarcados() {
		return TotalMarcados;
	}
	
	public void setTotalMarcados(double totalMarcados) {
		TotalMarcados = totalMarcados;
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

	// termina el getter y setter

}
