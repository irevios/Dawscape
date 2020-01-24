import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.TreeSet;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import net.lingala.zip4j.exception.ZipException;

public class Vista {
	private Principal controlador;
	private VentanaPrincipal ventanaPrincipal;
	private DialogoInventario dialogoInventario;
	@SuppressWarnings("unused")
	private ListenerVentanas listenerVentana;
	private DialogoInfoObjeto dialogoInfoObjeto;
	private DialogoMensaje dialogoMensaje;

	public Vista(Principal controlador) {
		// Look and feel
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		this.controlador = controlador;
		this.ventanaPrincipal = new VentanaPrincipal(this);
		this.dialogoInventario = new DialogoInventario(this);
		this.dialogoInfoObjeto = new DialogoInfoObjeto(this);
		this.dialogoMensaje = new DialogoMensaje(this);
		this.listenerVentana = new ListenerVentanas(ventanaPrincipal, dialogoInventario);
		this.listenerVentana = new ListenerVentanas(ventanaPrincipal, dialogoInfoObjeto);
		this.listenerVentana = new ListenerVentanas(ventanaPrincipal, dialogoMensaje);
		this.ventanaPrincipal.setVisible(true);
	}

	public ImageIcon getIcono(String archivo, int ancho, int alto) {
		return new ImageIcon(new ImageIcon(this.getClass().getResource(archivo)).getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH));
	}
	public String getFondoEscena(String nombre, String estado) {return this.controlador.getFondoEscena(nombre, estado);}
	public Escena getEscena(String nombreEscena) {return this.controlador.getEscena(nombreEscena);}
	public void iniciarPartida() {this.controlador.iniciarPartida();
	this.ventanaPrincipal = new VentanaPrincipal(this);}

	public void mostrarInventario(boolean opcion) {
		if (!this.dialogoInventario.isVisible() && opcion) {this.dialogoInventario.setVisible(true);}
		else {this.dialogoInventario.setVisible(false);}
	}

	public String getObjetoImg(String objeto) {return this.controlador.getObjetoImg(objeto);}

	public void mostrarInfoObjeto(String objeto) {
		this.dialogoInfoObjeto.setObjeto(objeto);
		this.mostrarInfoObjeto(true);
	}

	public Objeto getObjeto(String objeto) {return this.controlador.getObjeto(objeto);}

	public void obtenerObjeto(String string) {this.dialogoInventario.obtenerObjeto(string);}

	public void quitarObjeto(String objeto) {this.dialogoInventario.quitarObjeto(objeto);}

	public void cambiarEstado(String escena, String estado) {this.controlador.cambiarEstado(escena, estado);}

	public String objetoSeleccionado() {
		return this.dialogoInventario.getObjetoSeleccionado();
	}

	public int cargarPartida() {
		try {
			this.controlador.cargarPartida();
			return Modelo.CORRECTO;
		} catch (ClassNotFoundException | IOException e) {
			this.dialogoMensaje.setMensaje("No hay partidas guardadas");
			this.mostrarMensaje(true);
			return Modelo.ERROR;
		}
	}

	public void objetoObtenido(String objeto) {this.controlador.obtenerObjeto(objeto);}

	public void guardarPartida() {
		try {
			this.controlador.guardarPartida();
			this.dialogoMensaje.setMensaje("Partida guardada");
			this.mostrarMensaje(true);
		} catch (IOException e) {
			this.dialogoMensaje.setMensaje("Error al guardar la partida: \n" + e.toString());
			this.mostrarMensaje(true);
		}

	}

	public void setEscenaActual(String escena) {this.controlador.setEscenaActual(escena);}

	public String getEscenaActual() {return this.controlador.getEscenaActual();
	}

	public void mostrarInfoObjeto(boolean opcion) {this.dialogoInfoObjeto.mostrar(opcion);
	}

	public void actualizaInventario() {	this.dialogoInventario.actualizaInventario();}

	public void exportarPartida(File ficheroSeleccionado) {
		try {
			this.controlador.exportarPartida(ficheroSeleccionado);
			this.dialogoMensaje.setMensaje("Partida exportada correctamente");
			this.mostrarMensaje(true);
		} catch (ZipException e) {
			this.dialogoMensaje.setMensaje("Error al exportar la partida: \n" + e.toString());
			this.mostrarMensaje(true);
		}
	}

	public void importarPartida(File ficheroSeleccionado) {
		try {
			this.controlador.importarPartida(ficheroSeleccionado);
			this.dialogoMensaje.setMensaje("Partida importada correctamente");
			this.mostrarMensaje(true);
		} catch (ZipException e) {
			this.dialogoMensaje.setMensaje("Error al importar la partida: \n" + e.toString());
			this.mostrarMensaje(true);
		}
	}

	public TreeSet<String> getinventario() {return this.controlador.getinventario();}

	public int getNumeroB() {return this.controlador.getNumeroB();}

	public void objetoUsado(String objeto) {this.controlador.objetoUsado(objeto);}

	public void mostrarMensaje(boolean opcion) {this.dialogoMensaje.mostrar(opcion);}

	public int getNumeroA() {return this.controlador.getNumeroA();}

	public void actualizarVentanaInventario() {this.dialogoInventario.actualizarVentanaInventario();}

	public int getEleccion() {
		return this.controlador.getEleccion();
	}

	public void setEleccion(int eleccion) {
		this.controlador.setEleccion(eleccion);
	}

	public int getNumeroD() {
		return this.controlador.getNumeroD();
	}
	public int getNumeroC() {
		return this.controlador.getNumeroC();
	}
	

}