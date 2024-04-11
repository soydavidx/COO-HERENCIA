package paquete;

public class Entrenador extends Persona {
	private static int contador = 0;
	private int id;

	public Entrenador(String nombre, String apellido, int id, String profesion,int equipo) {
		super(nombre, apellido,profesion,equipo);
		id = contador;
		contador++;
	}
	
	private void EstablecerTitular() {
		//el establecimiento del titular depende del ranking interior de un equipo
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
