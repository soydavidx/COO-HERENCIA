package paquete;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Equipo {
	private static ArrayList<Equipo> ListaEquipos = new ArrayList<>();
	private static int contador = 0;

	private int id;

	private String nombreEquipo;
	private int nJugadores;

	private ArrayList<Persona> GrupoPersonales = new ArrayList<>();
	private Deporte deporte;
	private int PuestoRanking;// este atributo se modificara cada vez que se cargue la aplicacion leyendo
	private double puntos;
	// datos de la carpeta temporal

	public Equipo(String nombreEquipo, int nJugadores, ArrayList<Persona> GrupoPersonales, Deporte deporte) {
		id = contador;
		this.nombreEquipo = nombreEquipo;
		this.nJugadores = nJugadores;
		this.GrupoPersonales = GrupoPersonales;
		this.deporte = deporte;
		contador++;
	}

	private void EstablecerRankingInterior() {
		// Poblar los datos de valores de jugadores
		ArrayList<Double> Valores = new ArrayList<>();
		ArrayList<Integer> IdJugadores = new ArrayList<>(); 
		for (Persona persona : GrupoPersonales) {
			if (persona instanceof Jugador) {
				Jugador jugador = (Jugador) persona;
				Valores.add(jugador.getValor());
				IdJugadores.add(jugador.getIdJugador());
			}
		}
		// ordenar de mayor a menor
		ArrayList<Integer> RankingInter = new ArrayList<>();
		for (int i = 0; i < Valores.size(); i++) {
			//Encontrar el jugador con mayor valor
			double ActualMax = Collections.max(Valores);
			//obtener el id del jugador del jugador con valor ActualMax
			int IDJ = IdJugadores.get(Valores.indexOf(ActualMax));
			//anadir al arraylist de puestos
			RankingInter.add(IDJ);
			// quitar de los arraylist para buscar el siguiente puesto
			IdJugadores.remove(Valores.indexOf(ActualMax));
			Valores.remove(Valores.indexOf(ActualMax));
		}
		// Actualizar el puesto del jugador
		for (int i = 0; i < RankingInter.size(); i++) {
			for (Persona persona : GrupoPersonales) {
				Jugador jugador = (Jugador) persona;
				if (persona instanceof Jugador) {
					if (jugador.getIdJugador() == RankingInter.get(i)) {
						jugador.setPuestoInteriorEquipo(i);
						break;
					}
				}
			}
			//sumar i para la siguiente reiteracion
		}
	}

	// metodo para actualizar el Datos del equipo cada vez que se inicie el programa
	public static void ActualizarTodoEquipo() throws IOException {
		BufferedReader bfr = new BufferedReader(new FileReader("MiembrosEquipo.txt"));
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
						CasoEquipo(linea, idEquipo, equipo, MienbrosEquipo);
					// caso Persona	
					} else {
						// actualizar los datos de cada jugador
						String[] datos = linea.split("#");
						String nombre = datos[1];
						String apellido = datos[2];
						String profesion = datos[3];
							// caso Jugador
						if (linea.contains("@")) {
							// crear el jugador y anadir al arraylist de miembrosEquipo
							Jugador.CasoJugador(datos, nombre, apellido, profesion, idEquipo, MienbrosEquipo);
							// caso Entrenador
						} else if (linea.contains("%")) {
							// crear el Entrenador y anadir al arraylist de miembrosEquipo
							Entrenador.CasoEntrenador(nombre, apellido, profesion, idEquipo, MienbrosEquipo);
							// caso Director
						} else if (linea.contains("&")) {
							// crear el Director y anadir al arraylist de miembrosEquipo
							Director.CasoDirector(nombre, apellido, profesion, idEquipo, MienbrosEquipo);
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

	private static void CasoEquipo(String linea, int idEquipo, Equipo equipo, ArrayList<Persona> MienbrosEquipo) {
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
		equipo = new Equipo(nombreEquipo, Njugadores, MienbrosEquipo, deporteEquipo);
	}
	
	public static void repartirMarcados() {
		
	}
	
	public static void repartirSanciones() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreEquipo() {
		return nombreEquipo;
	}

	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}

	public int getnJugadores() {
		return nJugadores;
	}

	public void setnJugadores(int nJugadores) {
		this.nJugadores = nJugadores;
	}

	public ArrayList<Persona> getGrupoPersonales() {
		return GrupoPersonales;
	}

	public void setGrupoPersonales(ArrayList<Persona> grupoPersonales) {
		GrupoPersonales = grupoPersonales;
	}

	public int getPuestoRanking() {
		return PuestoRanking;
	}

	public void setPuestoRanking(int puestoRanking) {
		PuestoRanking = puestoRanking;
	}

	public double getPuntos() {
		return puntos;
	}

	public void setPuntos(double puntos) {
		this.puntos = puntos;
	}

	public Deporte getDeporte() {
		return deporte;
	}

	public void setDeporte(Deporte deporte) {
		this.deporte = deporte;
	}

	public static ArrayList<Equipo> getListaEquipos() {
		return ListaEquipos;
	}

	public static void setListaEquipos(ArrayList<Equipo> listaEquipos) {
		ListaEquipos = listaEquipos;
	}

}
