package paquete;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Equipo {
	public static ArrayList<Equipo> ListaEquipos = new ArrayList<>();
	private static int contador = 1;
	private int SancionTotal;
	private int id;

	private String nombreEquipo;
	private int nJugadores;

	private ArrayList<Persona> GrupoPersonales = new ArrayList<>();
	private Deporte deporte;
	private int puntos;
	// datos de la carpeta temporal

	public Equipo(String nombreEquipo, Deporte deporte) {
		this.id = contador++;
		this.nombreEquipo = nombreEquipo;
		this.deporte = deporte;
		
	}

	private void EstablecerRankingInterior() {
		// Poblar los datos de valores de jugadores
		ArrayList<Double> Valores = new ArrayList<>();
		ArrayList<Integer> IdJugadores = new ArrayList<>(); 
		for (Persona persona : GrupoPersonales) {
			if (persona instanceof Jugador) {
				Jugador jugador = (Jugador) persona;
				Valores.add(jugador.getValor());
				IdJugadores.add(jugador.getId());
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
					if (jugador.getId() == RankingInter.get(i)) {
						jugador.setPuestoInteriorEquipo(i);
						break;
					}
				}
			}
		}
	}

	// metodo para actualizar el Datos del equipo cada vez que se inicie el programa
	public static void actualizarEquipos() throws IOException {
		for (Equipo equipo : ListaEquipos) {
			equipo.getGrupoPersonales().clear();
			for (Persona persona : Persona.ListaPersona) {
				if (persona.getIdEquipo()==equipo.getId())
					equipo.getGrupoPersonales().add(persona);
			}
		}
		Persona.ActualizarFicheroEquipos();
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

	public int getSancionTotal() {
		return SancionTotal;
	}

	public void setSancionTotal(int sancionTotal) {
		SancionTotal = sancionTotal;
	}


	

}
