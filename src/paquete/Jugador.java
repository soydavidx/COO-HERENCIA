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

	public static void ActualizarEquipo() throws IOException {
		// leer de un archivo
		BufferedReader bfr = new BufferedReader(new FileReader("Temporal.txt"));
		try {
			String linea = "";
			while (linea != null) {

				while (!linea.contains("-")) {
					linea = bfr.readLine();
					int idEquipo = 0;
					ArrayList<Persona> MienbrosEquipo = new ArrayList<>();
					Equipo equipo = null;
					// caso equipo
					if (linea.contains("$")) {
						// declarar valores de los datos del equipo
						String[] datos = linea.split("#");
						idEquipo = Integer.parseInt(datos[0]);
						String nombreEquipo = datos[1];
						int Njugadores = Integer.parseInt(datos[2]);
						String nombreDeporte = datos[3];
						double puntos = Double.parseDouble(datos[4]);
						int puestoEquipo = Integer.parseInt(datos[5]);
						// encontrar la referencia del equipo
						Deporte deporteEquipo = null;
						for (Deporte deporte : Deporte.getListaDeporte()) {
							if (deporte.getNombre().equals(nombreDeporte)) {
								deporteEquipo = deporte;
								break;
							}
						}
						// crear el equipo
						equipo = new Equipo(idEquipo, nombreEquipo, Njugadores, MienbrosEquipo, deporteEquipo);
						// caso Persona
					} else {
						// actualizar los datos de cada jugador
						String[] datos = linea.split("#");
						String nombre = datos[1];
						String apellido = datos[2];
						String profesion = datos[3];
						// caso jugador
						if (linea.contains("@")) {
							// declarar valores de los datos del jugador
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
							// caso entrenador
						} else if (linea.contains("%")) {
							Entrenador entrenador = new Entrenador(nombre, apellido, profesion, idEquipo);
							MienbrosEquipo.add(entrenador);
							Persona.getListaPersona().add(entrenador);
							// caso director
						} else if (linea.contains("&")) {
							Director director = new Director(nombre, apellido, profesion, idEquipo);
							MienbrosEquipo.add(director);
							Persona.getListaPersona().add(director);
						}

					}
					Equipo.getListaEquipos().add(equipo);
				}

			}
		} catch (Exception e) {
			System.err.println("Error en la lectura para actualizacion jugador");
		} finally {
			bfr.close();
		}

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
