package paquete;

public class Entrenador extends Persona {
	private static int contador = 1;

	public Entrenador(String nombre, String apellido, String profesion, int equipo) {
		super(nombre, apellido, profesion, equipo);
		super.setId(contador);
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


}
