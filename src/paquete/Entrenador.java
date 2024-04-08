package paquete;

public class Entrenador extends Persona {
	private static int contador = 0;
	private int id;

	public Entrenador(String nombre, String apellido, int id) {
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
