package paquete;

public class Director extends Persona{
	private static int contador;
	
	private int id;
	public Director(String nombre, String apellido, int id) {
		super(nombre, apellido);
		id = contador;
		contador++;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

}
