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

	public static void LigaDeTodosDeportes() {
		// ---------------------------------------2
		//bucle que recorra todos los deporte
		for (Deporte deporte : Deporte.getListaDeporte()) {
			// ---------------------------------------1
			//arraylist de array de [1] (idEquipo y veces ) para anadir todos los equipos de un mismo deporte e ir suman 1 a veces cada vez que participe
			ArrayList<int[]> EquiposRestantes = new ArrayList<>();
			// anadir todos los equipos con mismo deporte
			for (Equipo equipo : Equipo.getListaEquipos()) {
				if (equipo.getDeporte() == deporte) {
					int[] equipoParticipante = { equipo.getId(), 0 };
					EquiposRestantes.add(equipoParticipante);
				}
			}
			boolean salir = false;
			// ---------------------------------------3
			//bucle para que vayan jugando hasta que en el arraylist las veces de cada equipo quede en 2 
			do {
				// declarar valores veces competidos
				// contar cuantos equipos tienen partidas juagadas 1 vez y cuantas niguna vez
				int veces0 = contarVecesParticipado(EquiposRestantes)[0];
				int veces1 = contarVecesParticipado(EquiposRestantes)[1];
				// declarar valores equipos a competir
				//decidir que equipos van a jugar en esta reiteracion
				int equipo1 = DecidirEquipoCompetir(veces0, veces1)[0];
				int equipo2 = DecidirEquipoCompetir(veces0, veces1)[1];
				// verificar si hay algun equipo restante por competir
				salir = VerificarEquipoRestante(veces0, veces1);
				// mientras que haya equipos para jugar , jugar partida
				if (salir != false) {
					// ---------------------------------------3.2
					// jugar el partido y generar marcados ,sanciones y actualizar datos
					JugarPartida(equipo1, equipo2);
					// ---------------------------------------3.4
					// encontrar y sumar 1 a las veces que ha participado los equipos combatientes
					sumarVeces(EquiposRestantes, equipo1, equipo2);
				}
				// salir si ya no quedan equipos para jugar
			} while (salir == false);

		}

	}

	private static void sumarVeces(ArrayList<int[]> EquiposRestantes, int equipo1, int equipo2) {
		for (int[] array : EquiposRestantes) {
			if (array.length > 1 && array[0] == equipo1) {
				array[1] = array[1] + 1;
			} else if (array.length > 1 && array[0] == equipo2) {
				array[1] = array[1] + 1;
			}
		}
	}
	
	private static int[] contarVecesParticipado(ArrayList<int[]>EquiposRestantes) {
		int veces0 = 0;
		int veces1 = 0;
		for (int[] array : EquiposRestantes) {
			int vez = array[1];
			if (vez == 0) {
				veces0++;
			}
			if (vez == 1) {
				veces1++;
			}
		}
		int[]array = {veces0 , veces1};
		return array;
	}

	private static int[] DecidirEquipoCompetir(int veces0, int veces1) {
		// si el numero de equipos que no hayan jugado es mayor o igual que 2
		// (solamente puede ser pares)
		int equipo1 = 0;
		int equipo2 = 0;
		if (veces0 >= 2) {
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
			// Escoger el equipo1
			equipo1 = Rng(veces1);
			// Escoger el equipo2 y asegurar que no se repitan
			equipo2 = 0;
			do {
				equipo2 = Rng(veces1);
			} while (equipo1 == equipo2);
		}
		int[] array = { equipo1, equipo2 };
		return array;
	}

	private static boolean VerificarEquipoRestante(int veces0, int veces1) {
		if (veces0 >= 2) {
			return false;
		} else if (veces1 >= 2) {
			return false;
		} else {
			return true;
		}
	}

	private static void JugarPartida(int idEquipo1, int idEquipo2) {
		// encontrar referencia del equipo escogido
		Equipo equipo1 = ReferenciaEquipo(idEquipo1);
		Equipo equipo2 = ReferenciaEquipo(idEquipo2);
		// declarar valores
		int puntuacionEquipo1 = 0;
		int puntuacionEquipo2 = 0;
		int sancionEquipo1 = 0;
		int sancionEquipo2 = 0;
		// hacer que el jugador pueda marcar y ser sancionado en el equipo1
		for (Persona persona : equipo1.getGrupoPersonales()) {
			if (persona instanceof Jugador) {
				Jugador jugador = (Jugador) persona;

				jugador.Marcar();
				jugador.Sancionar();

				puntuacionEquipo1 = puntuacionEquipo1 + jugador.getMarcados();
				equipo1.setSancionTotal(sancionEquipo1);
			}
		}
		// 3.2.
		// hacer que el jugador pueda marcar y ser sancionado en el equipo2
		for (Persona persona : equipo2.getGrupoPersonales()) {
			if (persona instanceof Jugador) {
				Jugador jugador = (Jugador) persona;
				// hacer que el jugador pueda marcar y ser sancionado
				jugador.Marcar();
				jugador.Sancionar();

				puntuacionEquipo2 = puntuacionEquipo2 + jugador.getMarcados();
				equipo2.setSancionTotal(sancionEquipo2);
			}
		}

		// 3.2.1 , 3.2.2 , 3.3
		// si gana el equipo1
		if (puntuacionEquipo1 > puntuacionEquipo2) {
			equipo1.setPuntos(puntuacionEquipo1 + 3);
			// si gana el equipo2
		} else if (puntuacionEquipo1 < puntuacionEquipo2) {
			equipo2.setPuntos(puntuacionEquipo2 + 3);
			// si empatan pues no se anade nada
		}

	}

	private static Equipo ReferenciaEquipo(int idEquipo) {
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
