package paquete;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Deporte {
	
	public static String barra = "-------------------------------------------------------";
	public static ArrayList<Deporte>ListaDeporte = new ArrayList<>();
	private String nombre;
	//numero de participantes
	private int Nparticipantes;
	
	public Deporte(String nombre, int nparticipantes) {
		this.nombre = nombre;
		Nparticipantes = nparticipantes;
	}
	
	
	public static void mostrarJugadoresDeportes() throws IOException {
		System.out.println(barra);
		System.out.println("Jugadores disponibles en los diferentes deportes: \n");
		BufferedReader br = new BufferedReader(new FileReader("F:\\worksplace\\COO-HERENCIA\\src\\deporte.txt"));
		try {	
			String linea;
			//Lee todas las lineas del archivo hasta encontrar una linea nulla
            while ((linea = br.readLine()) != null) {
            	String[] campos = linea.split(", ");
            	String deporte =  campos[0].trim();
            	int numeroJugadores = Integer.parseInt(campos[1].trim());
            	
            //Se imprime los datos
            	System.out.println("■ En el deporte "+deporte+" hay un total de "+numeroJugadores+" jugadores.");
            }
			System.out.println(barra);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			br.close();
		}
	}
	
	public static void crearDeportes() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("src/Deportes.txt"));
		// AQUI GUARDAREMOS LAS LINEAS DEL FICHERO
		String line;
		// CON ESTE WHILE PODREMOS LEER LOS DATOS DEL FICHERO
		while ((line = br.readLine()) != null) {
			String[] datos = line.split(", ");
			ListaDeporte.add(new Deporte(datos[0], Integer.parseInt(datos[1])));
		}
		br.close(); //Borrar si causa error
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
