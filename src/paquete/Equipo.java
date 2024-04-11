package paquete;

import java.util.ArrayList;

public class Equipo {
	private static ArrayList<Equipo> ListaEquipos = new ArrayList<>();
	private static int contador = 0;

	private int id;

	private String nombreEquipo;
	private int nJugadores;

	private ArrayList<Persona> GrupoPersonales = new ArrayList<>();
	private Deporte deporte;
	private int PuestoRanking;// este atributo se modificara cada vez que se cargue la aplicacion leyendo
	private int puntos;
	// datos de la carpeta temporal

	public Equipo(int id, String nombreEquipo, int nJugadores, ArrayList<Persona> grupoJugadores, Deporte deporte) {
		id = contador;
		this.nombreEquipo = nombreEquipo;
		this.nJugadores = nJugadores;
		this.GrupoPersonales = GrupoPersonales;
		this.deporte = deporte;
		contador++;
	}
	
	private void EstablecerRankingInterior() {
		
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
