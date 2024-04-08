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

	public static void EscribirDatosJugador() throws IOException {
		// escribir en la carpeta temporal y de temporal a Main
		BufferedWriter bfw = new BufferedWriter(new FileWriter("Temporal.txt"));
		try {
			// escribir los datos de cada jugador en la carpeta temporal
			for (Jugador jugador : Jugador.getListaJugador()) {
			// formato : IdJugador, Marcados, Sanciones, Valor
				bfw.write(jugador.getIdJugador() + signo + jugador.getMarcados() + signo + jugador.getSanciones()
						+ signo + jugador.getValor());
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
				//formato: id,id equipo1 , id equipo2, puntuacion1, puntuacion2, nombre del deporte
				bfw.write(partida.getIdPartida() + signo + partida.getIdEquipos()[0] + signo + partida.getIdEquipos()[1] 
				+ signo + partida.getPuntuacion()[0] + signo + partida.getPuntuacion()[1] + signo + partida.getDeporte());
				bfw.write(System.lineSeparator());
			}
		} catch (Exception e) {
			System.err.println("Error al escribir datos partida");
		} finally {
			bfw.close();
		}
	}

}
