package paquete;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Equipo {
	private static ArrayList<Equipo> ListaEquipos = new ArrayList<>();
	private static int contador = 0;
	private ArrayList<Persona> GrupoPersonales = new ArrayList<>();
	private int id;

	private String nombreEquipo;
	private int nJugadores;

	private ArrayList<Persona> RankingInter = new ArrayList<>();
	private Deporte deporte;
	private int PuestoRanking;// este atributo se modificara cada vez que se cargue la aplicacion leyendo
	private int puntos;
	// datos de la carpeta temporal

	public Equipo(int id, String nombreEquipo, int nJugadores, ArrayList<Persona> GrupoPersonales, Deporte deporte) {
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
		for (Persona persona : GrupoPersonales) {
			if (persona instanceof Jugador) {
				Jugador jugador = (Jugador) persona;
				Valores.add(jugador.getValor());
			}
		}
		// ordenar de mayo a menor
		ArrayList<Double> RankingInter = new ArrayList<>();
		for (int i = 0; i < Valores.size(); i++) {
			double ActualMax = Collections.max(Valores);
			RankingInter.add(ActualMax);
			// quitar el primero de valores para buscar el siguiente puesto
			Valores.remove(Valores.indexOf(ActualMax));
		}
		//Actualizar el puesto del jugador
		for (Double double1 : RankingInter) {
			int i = 0;
			for (Persona persona : GrupoPersonales) {
				Jugador jugador = (Jugador) persona;
				if (persona instanceof Jugador) {
					if (jugador.getValor() == double1) {
						jugador.setPuestoInteriorEquipo(i);
					}
				}
			}
			i++;
		}

	}

	// metodo para actualizar el Datos del equipo cada vez que se inicie el programa
	private void ActualizarEquipo() throws IOException {
		BufferedReader bfr = new BufferedReader(new FileReader("Equipo.txt"));
		String linea = "";
		while (linea != null) {
			linea = bfr.readLine();
		}
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

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
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
