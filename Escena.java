import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public class Escena implements Serializable{
	private static final long serialVersionUID = 3L;
	
	private String nombre;
	private HashMap<String, String> fondos;
	private String estado;
	private String izquierda;
	private String derecha;
	private String abajo;

	public Escena(String nombre, String izquierda, String derecha, String abajo) {
		this.nombre = nombre;
		this.fondos = new HashMap<String, String>();
		this.izquierda = izquierda;
		this.derecha = derecha;
		this.abajo = abajo;
	}

	public Escena() {
	}

	public String getNombre() {
		return nombre;
	}

	public HashMap<String, String> getFondos() {
		return fondos;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getIzquierda() {
		return this.izquierda;
	}

	public String getDerecha() {
		return this.derecha;
	}

	public String getAbajo() {
		return this.abajo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!super.equals(obj)) return false;
		if (getClass() != obj.getClass()) return false;
		Escena other = (Escena) obj;
		return Objects.equals(nombre, other.nombre);
	}

	
}
