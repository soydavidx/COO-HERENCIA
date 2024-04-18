package paquete;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Equipo {
	public static ArrayList<Equipo> ListaEquipos = new ArrayList<>();
	private static int contador = 1;

	private int id;

	private String nombreEquipo;
	private int nJugadores;

	private ArrayList<Persona> GrupoPersonales = new ArrayList<>();
	private Deporte deporte;
	private int PuestoRanking;// este atributo se modificara cada vez que se cargue la aplicacion leyendo
	private double puntos;
	
	private int SancionTotal;
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
			//sumar i para la siguiente reiteracion
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
		equipo = new Equipo(nombreEquipo, deporteEquipo);
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

	public int getSancionTotal() {
		return SancionTotal;
	}

	public void setSancionTotal(int sancionTotal) {
		SancionTotal = sancionTotal;
	}
	
	

}
