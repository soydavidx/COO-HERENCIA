package paquete;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class principal {
	public static String signo = "#";
	public static String barra = "------------------------------------------------";

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// actualizar los datos de los jugadores al la aplicacion
		System.out.println("Practica nº10: Herencia Cooperativa");
		System.out.println("Un video mas mi gente para perder el tiempo");
		// Hecho por David, Diego y Peter
		Deporte.crearDeportes();
		Persona.crearEquiposYJugadores();
		//leer el archivp LigaDeTodosDeportes
		//jugar todos los partidos de cada deporte
		Partida.LigaDeTodosDeportes();

	}

	public static void EscribirJugadoresMejoresPartidaSiguiente() {

	}

	public static void MostrarDatos() {
		System.out.println("Introduzca el nombre de un equipo para mostrar sus datos");
		Scanner scanner = new Scanner(System.in);
		String NombreEquipo = scanner.nextLine();
		// verificar si el equipo tecleado existe
		if (verificarNombreEquipo(NombreEquipo) == false) {
			System.out.println("Vuelva a introducir un nombre del equipo existente Porfavor");
			MostrarDatos();
		}else {
			// procesos para mostrar informacion de un equipo
			   for (Equipo equipo : Equipo.ListaEquipos) {
				if (equipo.getNombreEquipo().toLowerCase().equals(NombreEquipo.toLowerCase())) {
					System.out.println("Datos del equipo: "+equipo.getNombreEquipo());
					System.out.println("Deporte: "+equipo.getDeporte().getNombre());
					System.out.println("Jugadores en el equipo: "+equipo.getGrupoPersonales().size());
					System.out.println("Ranking del equipo: "+equipo.getPuntos());
					System.out.println(barra);
					for (Persona persona : equipo.getGrupoPersonales()) {
						System.out.println("Jugador: "+persona.getNombre()+" "+persona.getApellido());
					}
				}
			}
		  }
		scanner.close();
	}

	public static void intercambio() {
		// se debera indicar el equipo para fichar jugadores
		Scanner scanner = new Scanner(System.in);
		String NombreEquipo = scanner.nextLine();
	}

	public static boolean verificarNombreEquipo(String Nombre) {
		// verificar si el equipo tecleado existe
		for (Equipo equipo : Equipo.getListaEquipos()) {
			if (equipo.getNombreEquipo().equals(Nombre)) {
				return true;
			}
		}
		return false;
	}

	
	//MODIFICAR Y ACTUALIZAR ESTA CLASE A LA NUEVA ESTRUCTURA DE PETER (al final xd)
	public static void EscribirDatosJugador() throws IOException {
		BufferedWriter bfw = new BufferedWriter(new FileWriter("MiembrosEquipo.txt"));
		try {
			// escribir los datos de cada jugador en la carpeta temporal
			for (Equipo equipo : Equipo.getListaEquipos()) {
				// formato : id, nombre, nJugadores, nombre deporte, puntos, puesto
				bfw.write(equipo.getId() + signo + equipo.getNombreEquipo() + signo + equipo.getnJugadores() + signo
						+ equipo.getDeporte().getNombre() + signo + equipo.getPuntos());
				bfw.write(System.lineSeparator());
				for (Persona persona : equipo.getGrupoPersonales()) {
					// formato :Id, nombre, apellido, Profesion, Posicion, Marcados, Sanciones, valor , PuestoInterior, titular
					if (persona instanceof Jugador) {
						Jugador jugador = (Jugador) persona;
						bfw.write(jugador.getId() + signo + jugador.getNombre() + signo + jugador.getApellido()
								+ signo + jugador.getProfesion() + signo + jugador.getPosicion() + jugador.getMarcados()
								+ signo + jugador.getSanciones() + signo + jugador.getValor() + signo
								+ jugador.getPuestoInteriorEquipo() + signo + jugador.isTitular());
						bfw.write(System.lineSeparator());
					}
					// formato : Id, nombre, apellido, Profesion
					if (persona instanceof Entrenador) {
						Entrenador entrenador = (Entrenador) persona;
						bfw.write(entrenador.getNombre() + signo + entrenador.getApellido() + signo
								+ entrenador.getProfesion());
						bfw.write(System.lineSeparator());
					}
					// formato : Id, nombre, apellido, Profesion
					if (persona instanceof Director) {
						Director director = (Director) persona;
						bfw.write(director.getNombre() + signo + director.getApellido() + signo
								+ director.getProfesion());
						bfw.write(System.lineSeparator());
					}
					bfw.write("$");
					bfw.write(System.lineSeparator());
				}
				bfw.write("-");
				bfw.write(System.lineSeparator());
			}
		} catch (Exception e) {
			System.err.println("Error al escribir datos jugador");
		} finally {
			bfw.close();
		}

	}

	public static void EscribirDatosPartida() throws IOException {
		// escribir en la carpeta temporal y de temporal a Main
		BufferedWriter bfw = new BufferedWriter(new FileWriter("Temporal.txt"));
		try {
			for (Partida partida : Partida.getListaPartida()) {
				// formato: id,id equipo1 , id equipo2, puntuacion1, puntuacion2, nombre del
				// deporte
				bfw.write(partida.getIdPartida() + signo + partida.getEquiposParticipados()[0].getId() + signo
						+ partida.getEquiposParticipados()[1].getId() + signo + partida.getPuntuacion()[0] + signo
						+ partida.getPuntuacion()[1] + signo + partida.getDeporte());
				bfw.write(System.lineSeparator());
			}
		} catch (Exception e) {
			System.err.println("Error al escribir datos partida");
		} finally {
			bfw.close();
		}
	}

}
