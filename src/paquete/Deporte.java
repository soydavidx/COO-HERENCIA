package paquete;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Deporte {
	
	public static String barra = "---------------------------------------------------";
	
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
	
	public static void mostrarJugadoresDeportes() throws IOException {
		System.out.println(barra);
		System.out.println("Jugadores disponibles en los diferentes deportes: \n");
		BufferedReader br = new BufferedReader(new FileReader("F:\\worksplace\\COO-HERENCIA\\src\\deporte.txt"));
		try {	
			String linea;
			//Lee todas las lineas del archivo hasta encontrar una linea nulla
            while ((linea = br.readLine()) != null) {
            	String[] campos = linea.split(",");
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
}
