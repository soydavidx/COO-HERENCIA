package paquete;

import java.util.ArrayList;
import java.util.Scanner;

public class Director extends Persona {
	private static int contador;

	private int id;

	public Director(String nombre, String apellido, String profesion, int equipo) {
		super(nombre, apellido, profesion, equipo);
		id = contador;
		contador++;
	}

	private void ficharJugador() {
		Scanner scanner = new Scanner(System.in);
		// que el usuario introduzca los datos del jugador para crear y anadir al equipo
	}

	private void venderJugador() {
		Scanner scanner = new Scanner(System.in);
		// que el usuario introduzca los datos del jugador para vender, eliminar del
		// equipo actual y anadir al equipo comprado

	}
	
	public static void CasoDirector(String nombre, String apellido , String profesion, int idEquipo, ArrayList<Persona>MienbrosEquipo) {
		Director director = new Director(nombre, apellido, profesion, idEquipo);
		MienbrosEquipo.add(director);
		Persona.getListaPersona().add(director);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
