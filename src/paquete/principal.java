package paquete;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class principal {
	public static String signo = "#";

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// actualizar los datos de los jugadores al la aplicacion
		System.out.println("Practica nº10: Herencia Cooperativa");
		System.out.println("Un video mas mi gente para perder el tiempo");
		// Hecho por David, Diego y Peter
		Deporte.crearDeportes();
		Persona.crearEquiposYJugadores();
		//Jugador.ActualizarEquipo();

	}

	public static void EscribirJugadoresMejoresPartidaSiguiente() {

	}

	public static void MostrarDatos() {
		System.out.println("Introduzca el nombre de un equipo para mostrar sus datos");
		Scanner scanner = new Scanner(System.in);
		String NombreEquipo = scanner.nextLine();
		// verificar si el equipo tecleado existe


		// procesos para mostrar informacion de un equipo

		scanner.close();
	}

	public static void intercambio() {
		// se debera indicar el equipo para fichar jugadores
		Scanner scanner = new Scanner(System.in);
		String NombreEquipo = scanner.nextLine();
	}

	public static Equipo verificarNombreEquipo(String Nombre) {
		// verificar si el equipo tecleado existe
		for (Equipo equipo : Equipo.getListaEquipos()) {
			if (equipo.getNombreEquipo().equals(Nombre)) {
				return equipo;
			}
		}
		return null;
	}

	public static void EscribirDatosJugador() throws IOException {

	}

}
