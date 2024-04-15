package paquete;

import java.util.ArrayList;

public class Deporte {
	private static ArrayList<Deporte>ListaDeporte = new ArrayList<>();
	private static int contador = 0;
	private int id;
	private String nombre;
	//numero de participantes
	private int Nparticipantes;
	
	public Deporte(String nombre, int nparticipantes) {
		id = contador;
		this.nombre = nombre;
		Nparticipantes = nparticipantes;
		contador++;
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
	public int getNparticipantes() {
		return Nparticipantes;
	}
	public void setNparticipantes(int nparticipantes) {
		Nparticipantes = nparticipantes;
	}

	public static ArrayList<Deporte> getListaDeporte() {
		return ListaDeporte;
	}

	public static void setListaDeporte(ArrayList<Deporte> listaDeporte) {
		ListaDeporte = listaDeporte;
	}
	
}
