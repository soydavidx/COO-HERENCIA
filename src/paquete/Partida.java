package paquete;

import java.util.ArrayList;

public class Partida {
	private static int contador = 0;
	
	private static ArrayList<Partida> ListaPartida = new ArrayList<>();
	
	private int IdPartida;
	// array de los equipos que han participado
	private int[] idEquipos = new int[1];
	// array de la puntuacion final de la partida por ejemplo 1,3 -- 1:3
	private int[] puntuacion = new int[1];
	// el id del deporte
	private int deporte;
	
	public Partida(int[] idEquipos, int[] puntuacion, int deporte) {
		IdPartida = contador;
		this.idEquipos = idEquipos;
		this.puntuacion = puntuacion;
		this.deporte = deporte;
		contador++;
	}

	public int[] getIdEquipos() {
		return idEquipos;
	}

	public void setIdEquipos(int[] idEquipos) {
		this.idEquipos = idEquipos;
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
