package paquete;

import java.util.ArrayList;

public class Equipo {
	private static ArrayList<Equipo> ListaEquipos = new ArrayList<>();
	private static int contador = 0;

	private int id;

	private String nombreEquipo;
	private int nJugadores;

	private ArrayList<Jugador> grupoJugadores = new ArrayList<>();
	private Director director;
	private Entrenador entrenador;
	private Deporte deporte;
	private int UltimoPuestoRanking;// este atributo se modificara cada vez que se cargue la aplicacion leyendo
	// datos de la carpeta temporal

	public Equipo(int id, String nombreEquipo, int nJugadores, ArrayList<Jugador> grupoJugadores, Director director,
			Entrenador entrenador, Deporte deporte) {
		id = contador;
		this.nombreEquipo = nombreEquipo;
		this.nJugadores = nJugadores;
		this.grupoJugadores = grupoJugadores;
		this.director = director;
		this.entrenador = entrenador;
		this.deporte = deporte;
		contador++;
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

	public ArrayList<Jugador> getGrupoJugadores() {
		return grupoJugadores;
	}

	public void setGrupoJugadores(ArrayList<Jugador> grupoJugadores) {
		this.grupoJugadores = grupoJugadores;
	}

	public Director getDirector() {
		return director;
	}

	public void setDirector(Director director) {
		this.director = director;
	}

	public Entrenador getEntrenador() {
		return entrenador;
	}

	public void setEntrenador(Entrenador entrenador) {
		this.entrenador = entrenador;
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

	public int getUltimoPuestoRanking() {
		return UltimoPuestoRanking;
	}

	public void setUltimoPuestoRanking(int ultimoPuestoRanking) {
		UltimoPuestoRanking = ultimoPuestoRanking;
	}

}
