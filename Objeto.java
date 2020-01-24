import java.io.Serializable;
import java.util.TreeMap;

public class Objeto implements Comparable<Objeto>, Serializable {
	private static final long serialVersionUID = 3L;
	public static final int NO_OBTENIDO = 0;
	public static final int OBTENIDO = 1;
	public static final int USADO = 2;
	
	private String nombre;
	private String descripcion;
	private TreeMap<String, String> imagenes;
	private int estado;

	public Objeto(String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.imagenes = new TreeMap<String, String>();
		this.estado = NO_OBTENIDO;				
	}

	public TreeMap<String, String> getImagenes() {
		return imagenes;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isObtenido() {
		return estado == OBTENIDO ? true : false;
	}
	
	public boolean isUsado() {
		return estado == USADO ? true : false;
	}

	public void setObtenido(boolean obtenido) {
		this.estado = OBTENIDO;
	}
	public void setUsado(boolean obtenido) {
		this.estado = USADO;
	}

	@Override
	public int compareTo(Objeto otro) {
		return this.nombre.compareTo(otro.getNombre());
	}
}
