package paquete;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Persona {
	private static ArrayList<Persona>ListaPersona = new ArrayList<>();
	
	private int id;
	private String nombre;
	private String apellido;
	private String profesion;
	private int idEquipo;
	
	public Persona(String nombre, String apellido, String profesion, int idEquipo) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.profesion = profesion;
		this.idEquipo = idEquipo;
	}
	
	public static void crearEquiposYJugadores() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("src/MiembrosEquipo.txt"));
		// AQUI GUARDAREMOS LAS LINEAS DEL FICHERO
		String line;
		// CON ESTE WHILE PODREMOS LEER LOS DATOS DEL FICHERO
		while ((line = br.readLine()) != null) {
			String[] datos = line.split(", ");
			
			switch (datos[2]) {
			case "jugador" -> ListaPersona.add(new Jugador(datos[0], datos[1], datos[2], Integer.parseInt(datos[3]), datos[4], Double.parseDouble(datos[5]), Double.parseDouble(datos[6])));
			case "entrenador" -> ListaPersona.add(new Entrenador(datos[0], datos[1], datos[2], Integer.parseInt(datos[3])));
			case "director" -> ListaPersona.add(new Director(datos[0], datos[1], datos[2], Integer.parseInt(datos[3])));
			case "Sepak Takraw" -> Equipo.ListaEquipos.add(new Equipo(datos[0], Deporte.Deportes.get(0)));
			case "voleibol" -> Equipo.ListaEquipos.add(new Equipo(datos[0], Deporte.Deportes.get(1)));
			case "Rugby Subacuatico" -> Equipo.ListaEquipos.add(new Equipo(datos[0], Deporte.Deportes.get(2)));
			}
		}
		for (Equipo equipo : Equipo.ListaEquipos) {
			for (Persona persona : ListaPersona) {
				if (persona.getIdEquipo()==equipo.getId())
					equipo.getGrupoPersonales().add(persona);
			}
		}
		for (Persona persona : Equipo.ListaEquipos.get(1).getGrupoPersonales()) {
			System.out.println(persona.getNombre());
		}
	}

	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getProfesion() {
		return profesion;
	}
	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}
	public static ArrayList<Persona> getListaPersona() {
		return ListaPersona;
	}
	public static void setListaPersona(ArrayList<Persona> listaPersona) {
		ListaPersona = listaPersona;
	}
	public int getIdEquipo() {
		return idEquipo;
	}
	public void setIdEquipo(int idEquipo) {
		this.idEquipo = idEquipo;
	}


}
