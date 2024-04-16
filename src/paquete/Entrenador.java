package paquete;

import java.util.ArrayList;

public class Entrenador extends Persona {
	private static int contador = 0;
	private int id;

	public Entrenador(String nombre, String apellido, String profesion, int equipo) {
		super(nombre, apellido, profesion, equipo);
		id = contador;
		contador++;
	}

	private void EstablecerTitular() {
		// el establecimiento del titular depende del ranking interior de un equipo
		// Establecer referencia el equipo
		Equipo esteEquipo = null;
		for (Equipo equipo : Equipo.getListaEquipos()) {
			if (this.getId() == equipo.getId()) {
				esteEquipo = equipo;
				break;
			}
		}
		// Actualizar a todos aquellos participantes que tengan el puesto mayor o igual a titular 
		for (Persona persona : Persona.getListaPersona()) {
			if (persona instanceof Jugador) {
				Jugador jugador = (Jugador) persona;
				if (jugador.getPuestoInteriorEquipo() > esteEquipo.getDeporte().getNparticipantes()) {
					jugador.setTitular(true);
				}
			}
		}
	}
	
	public static void CasoEntrenador(String nombre, String apellido , String profesion, int idEquipo, ArrayList<Persona>MienbrosEquipo) {
		Entrenador entrenador = new Entrenador(nombre, apellido, profesion, idEquipo);
		MienbrosEquipo.add(entrenador);
		Persona.getListaPersona().add(entrenador);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
