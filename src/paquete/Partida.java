package paquete;

import java.util.ArrayList;

public class Partida {
	private static int contador = 0;

	private static ArrayList<Partida> ListaPartida = new ArrayList<>();

	private int IdPartida;
	// array de los equipos que han participado
	private Equipo[] EquiposParticipados = new Equipo[1];
	// array de la puntuacion final de la partida por ejemplo 1,3 -- 1:3
	private int[] puntuacion = new int[1];
	// el id del deporte
	private int deporte;

	public Partida(Equipo[] EquiposParticipados, int[] puntuacion, int deporte) {
		IdPartida = contador;
		this.EquiposParticipados = EquiposParticipados;
		this.puntuacion = puntuacion;
		this.deporte = deporte;
		contador++;
	}
	private static void EscribirPartida() {
		
	}
	

	private void EstablecerResultadosPartida() {

		// con un generador de numeros aleatorios establecer la puntuacion final de la
		// partida 3:1 por ejemplo

		for (Partida partida : ListaPartida) {
			// con ese resultado 3:1 estableces puntos de un equipo y luego en el interior
			// de un equipo establecer el ranking dependiendo de quien haya marcado (decidir
			// tambien con un random quien haya metido gol o recibido sancion)
			for (Equipo equipo : EquiposParticipados) {
				
			}
		}

	}

	public Equipo[] getEquiposParticipados() {
		return EquiposParticipados;
	}

	public void setEquiposParticipados(Equipo[] equiposParticipados) {
		EquiposParticipados = equiposParticipados;
	}

	public int[] getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int[] puntuacion) {
		this.puntuacion = puntuacion;
	}

	public int getDeporte() {
		return deporte;
	}

	public void setDeporte(int deporte) {
		this.deporte = deporte;
	}

	public static ArrayList<Partida> getListaPartida() {
		return ListaPartida;
	}

	public static void setListaPartida(ArrayList<Partida> listaPartida) {
		ListaPartida = listaPartida;
	}

	public int getIdPartida() {
		return IdPartida;
	}

	public void setIdPartida(int idPartida) {
		IdPartida = idPartida;
	}

}
