package paquete;

import java.util.ArrayList;

public class Persona {
	private static ArrayList<Persona>ListaPersona = new ArrayList<>();
	
	private String nombre;
	private String apellido;
	private String profesion;
	private int idEquipo;
	
	public Persona(String nombre, String apellido,String profesion,int idEquipo) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.profesion = profesion;
		this.idEquipo = idEquipo;
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
