import java.io.File;
import java.io.IOException;
import java.util.TreeSet;
import net.lingala.zip4j.exception.ZipException;

public class Principal {
	private Modelo modelo;
	@SuppressWarnings("unused")
	private Vista vista;

	public Principal() {
		this.modelo = new Modelo();
		this.vista = new Vista(this);
	}

	public static void main(String[] args) {
		new Principal();
	}

	// Métodos Escenas
	public Escena getEscena(String nombreEscena) {return this.modelo.getEscena(nombreEscena);	}
	public String getFondoEscena(String nombre, String estado) {return this.modelo.getFondoEscena(nombre, estado);	}
	public void setEscenaActual(String escena) {	this.modelo.setEscenaActual(escena);}
	public String getEscenaActual() {return this.modelo.getEscenaActual();}
	public void cambiarEstado(String escena, String estado) {this.modelo.cambiarEstado(escena, estado);}
	
	// Métodos Objetos
	public Objeto getObjeto(String objeto) {return this.modelo.getObjeto(objeto);	}
	public String getObjetoImg(String objeto) {return this.modelo.getObjetoImg(objeto);	}
	public void obtenerObjeto(String objeto) {this.modelo.obtenerObjeto(objeto);}
	
	public TreeSet<String> getinventario() {return this.modelo.getinventario();}
	
	// Métodos Partida
	public void iniciarPartida() {	this.modelo.iniciarPartida();	}
	public void cargarPartida() throws ClassNotFoundException, IOException {this.modelo.cargarPartida();}
	public void guardarPartida() throws IOException {this.modelo.guardarPartida();}
	public void exportarPartida(File ficheroSeleccionado) throws ZipException{	this.modelo.exportarPartida(ficheroSeleccionado);}
	public void importarPartida(File ficheroSeleccionado) throws ZipException {this.modelo.importarPartida(ficheroSeleccionado);}

	public int getNumeroB() {
		return this.modelo.getNumeroB();
	}

	public void objetoUsado(String objeto) {
		this.modelo.objetoUsado(objeto);
	}

	public int getNumeroA() {
		return this.modelo.getNumeroA();
	}

	public int getEleccion() {
		return this.modelo.getEleccion();
	}

	public void setEleccion(int eleccion) {
		this.modelo.setEleccion(eleccion);
	}

	public int getNumeroD() {
		return this.modelo.getNumeroD();
	}
	public int getNumeroC() {
		return this.modelo.getNumeroC();
	}
		
}
