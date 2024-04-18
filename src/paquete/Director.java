package paquete;

import java.util.Scanner;

public class Director extends Persona {
	private static int contador = 1;

	public Director(String nombre, String apellido, String profesion, int equipo) {
		super(nombre, apellido, profesion, equipo);
		super.setId(contador);
		contador++;
	}

	private void intercambio() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("QUe equipo va a realizar el fichaje");
		String equipo = scanner.nextLine().toLowerCase();
		
		while (true) {
			for (Equipo Equipo: Equipo.ListaEquipos) {
				if (Equipo.getNombreEquipo().toLowerCase().equals(equipo)) {
					break;
				}
			}
		}
	}


}
