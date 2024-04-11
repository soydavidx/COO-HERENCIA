package paquete;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class principal {
	public static String signo = "#";

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// actualizar los datos de los jugadores al la aplicacion
		Jugador.ActualizarJugador();

	}

	public static void EscribirJugadoresMejoresPartidaSiguiente() {

	}

	/* public static void */

	public static void EscribirDatosJugador() throws IOException {
		// escribir en la carpeta temporal y de temporal a Main
		BufferedWriter bfw = new BufferedWriter(new FileWriter("Temporal.txt"));
		try {
			// escribir los datos de cada jugador en la carpeta temporal
			for (Persona persona : Persona.getListaPersona()) {
				// formato : Id, nombre, apellido, Profesion, Posicion, Marcados, Sanciones,
				// Valor, PuestoInterior
				if (persona instanceof Jugador) {
					Jugador jugador = (Jugador) persona;
					bfw.write(jugador.getNombre() + signo + jugador.getApellido() + signo + jugador.getProfesion()
							+ signo + jugador.getPosicion() + jugador.getMarcados() + signo + jugador.getSanciones()
							+ signo + jugador.getValor());
					bfw.write(System.lineSeparator());
				}
				// formato : Id, nombre, apellido, Profesion
				if (persona instanceof Entrenador) {
					Entrenador entrenador = (Entrenador) persona;
					bfw.write(entrenador.getNombre() + signo + entrenador.getApellido() + signo + entrenador.getProfesion());
				}
				// formato : Id, nombre, apellido, Profesion
				if (persona instanceof Director) {
					Director director = (Director) persona;
					bfw.write(director.getNombre() + signo + director.getApellido() + signo + director.getProfesion());
				}

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
				bfw.write(partida.getIdPartida() + signo + partida.getEquiposParticipados()[0].getId() + signo + partida.getEquiposParticipados()[1].getId()
						+ signo + partida.getPuntuacion()[0] + signo + partida.getPuntuacion()[1] + signo
						+ partida.getDeporte());
				bfw.write(System.lineSeparator());
			}
		} catch (Exception e) {
			System.err.println("Error al escribir datos partida");
		} finally {
			bfw.close();
		}
	}

}
