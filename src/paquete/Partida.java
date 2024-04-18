package paquete;

import java.util.ArrayList;
import java.util.Random;

public class Partida {
	// No editada en el Pull Request
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
		contador++;
		IdPartida = contador;
		this.EquiposParticipados = EquiposParticipados;
		this.puntuacion = puntuacion;
		this.deporte = deporte;
	}

	private void LigaDeTodosDeportes() {

		for (Deporte deporte : Deporte.getListaDeporte()) {
			ArrayList<int[]> EquiposRestantes = new ArrayList<>();
			// anadir todos los equipos con mismo deporte
			for (Equipo equipo : Equipo.getListaEquipos()) {
				if (equipo.getDeporte() == deporte) {
					int[] equipoParticipante = { equipo.getId(), 0 };
					EquiposRestantes.add(equipoParticipante);
				}
			}
			boolean salir = false;
			do {
				// declarar valores equipos a competir
				int equipo1 = 0;
				int equipo2 = 0;
				// declarar valores veces competidos
				int veces0 = 0;
				int veces1 = 0;
				// contar cuantos equipos tienen partidas juagadas 1 vez y cuantas niguna vez
				for (int[] array : EquiposRestantes) {
					int vez = array[1];
					if (vez == 0) {
						veces0++;
					}
					if (vez == 1) {
						veces1++;
					}
				}

				// si el numero de equipos que no hayan jugado es mayor o igual que 2
				// (solamente puede ser pares)
				if (veces0 >= 2) {
					salir = false;
					// Escoger el equipo1
					equipo1 = Rng(veces0);
					// Escoger el equipo2 y asegurar que no se repitan
					equipo2 = 0;
					do {
						equipo2 = Rng(veces0);
					} while (equipo1 == equipo2);

					// si el numero de equipos que hayan jugado 1 vez es mayor o igual que 2
					// (solamente puede ser pares)
				} else if (veces1 >= 2) {
					salir = false;
					// Escoger el equipo1
					equipo1 = Rng(veces1);
					// Escoger el equipo2 y asegurar que no se repitan
					equipo2 = 0;
					do {
						equipo2 = Rng(veces1);
					} while (equipo1 == equipo2);

					// si ya no quedan equipos que jugar es decir todos los equipos han jugado 2 veces
				} else {
					salir = true;
				}

				// mientras que haya equipos para jugar , jugar partida
				if (salir != false) {
					JugarPartida(equipo1, equipo2);
					// encontrar y sumar 1 a las veces que ha participado los equipos combatientes
					for (int[] array : EquiposRestantes) {
						if (array.length > 1 && array[0] == equipo1) {
							array[1] = array[1] + 1;
						} else if (array.length > 1 && array[0] == equipo2) {
							array[1] = array[1] + 1;
						}
					}
				}
				// salir si ya no quedan equipos para jugar
			} while (salir == false);

		}

	}

	private void JugarPartida(int idEquipo1, int idEquipo2) {
		// encontrar referencia del equipo escogido
		Equipo equipo1 = ReferenciaEquipo(idEquipo1);
		Equipo equipo2 = ReferenciaEquipo(idEquipo2);
		
		int puntuacionEquipo1 = 0;
		int puntuacionEquipo2 = 0;
		int sancionEquipo1 = 0;
		int sancionEquipo2 = 0;
		//hacer que el jugador pueda marcar y ser sancionado en el equipo1
		for (Persona persona : equipo1.getGrupoPersonales()) {
			if (persona instanceof Jugador) {
				 Jugador jugador = (Jugador) persona;
				 
				 jugador.Marcar();
				 jugador.Sancionar();
				 
				 puntuacionEquipo1 = puntuacionEquipo1 + jugador.getMarcados();
				 equipo1.setSancionTotal(sancionEquipo1);
			}
		}
		//hacer que el jugador pueda marcar y ser sancionado en el equipo2
		for (Persona persona : equipo2.getGrupoPersonales()) {
			if (persona instanceof Jugador) {
				 Jugador jugador = (Jugador) persona;
				 //hacer que el jugador pueda marcar y ser sancionado
				 jugador.Marcar();
				 jugador.Sancionar();
				 
				 puntuacionEquipo2 = puntuacionEquipo2 + jugador.getMarcados();
				 equipo2.setSancionTotal(sancionEquipo2);
			}
		}
		
		// si gana el equipo1
		if (puntuacionEquipo1 > puntuacionEquipo2) {
			
		// si gana el equipo2
		}else if (puntuacionEquipo1 < puntuacionEquipo2) {
			
		// si empatan
		}else if (puntuacionEquipo1 == puntuacionEquipo2) {
			
		}


	}

	private Equipo ReferenciaEquipo(int idEquipo) {
		for (Equipo equipo : Equipo.getListaEquipos()) {
			if (equipo.getId() == idEquipo) {
				return equipo;
			}
		}
		return null;
	}

	public static int Rng(int rango) {
		Random random = new Random();
		// para asegurar que no coja el 0 ni sobresalga del rango
		int numeroAleatorio = random.nextInt(rango) + 1;
		return numeroAleatorio;
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
