import java.awt.Point;
import java.awt.Window;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JDialog;
import javax.swing.JFrame;

// Clase para la interaccion entre dialogos y ventana
class ListenerVentanas extends ComponentAdapter {
	private Window ventana, dialogo;

	public ListenerVentanas(JFrame ventana, JDialog dialogo) {
		this.ventana = ventana;
		this.dialogo = dialogo;
		this.ventana.addComponentListener(this);
		this.ventana.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				ventanaActivada(e);
			}
		});
		this.dialogo.addComponentListener(this);
	}

	protected void ventanaActivada(WindowEvent e) {	this.dialogo.toFront();	}
	
	public void componentMoved(ComponentEvent e) {
		Window win = (Window) e.getComponent();
		if (win == this.ventana) {
			this.dialogo.removeComponentListener(this);
			this.dialogo.setLocation(new Point(this.ventana.getLocation().x, this.ventana.getLocation().y+39));
			this.dialogo.addComponentListener(this);
		}
	}

}