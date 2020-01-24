import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.TreeMap;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class DialogoInventario extends JDialog {

	private final JPanel ladoIzquierdo = new JPanel();
	private Vista vista;
	private JLayeredPane capas;
	private JLabel btnInventario;
	private JPanel boton;
	private int contador = 0;
	private JPanel ladoDerecho;
	private TreeMap<String, JLayeredPane> inventario;
	private String objetoSeleccionado = "";

	public DialogoInventario(Vista vista) {
		inventario = new TreeMap<String, JLayeredPane>();
		setAutoRequestFocus(false);
		setFocusCycleRoot(false);
		setFocusTraversalKeysEnabled(false);
		setFocusable(false);
		setFocusableWindowState(false);
		setResizable(false);
		this.vista = vista;
		setBounds(0, 0, 1280, 115);
		setUndecorated(true);
		getContentPane().setBackground(new Color(0, 0, 0, 0));
		setBackground(new Color(0, 0, 0, 200));
		setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
		getContentPane().setLayout(new BorderLayout());

		this.capas = new JLayeredPane();
		this.capas.setAlignmentX(0.0f);
		this.capas.setAlignmentY(0.0f);
		this.capas.setOpaque(true);
		getContentPane().add(this.capas, BorderLayout.CENTER);

		this.boton = new JPanel();
		this.boton.setOpaque(false);
		this.capas.setLayer(this.boton, 5);
		FlowLayout fl_boton = (FlowLayout) this.boton.getLayout();
		fl_boton.setVgap(0);
		fl_boton.setHgap(0);
		this.boton.setBounds(0, 0, 1280, 115);
		this.capas.add(this.boton);

		this.btnInventario = new JLabel("");
		this.btnInventario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnInventarioActivado(e);
			}
		});
		this.btnInventario.setVerifyInputWhenFocusTarget(false);
		this.btnInventario.setRequestFocusEnabled(false);
		this.btnInventario.setInheritsPopupMenu(false);
		this.btnInventario.setIconTextGap(0);
		this.btnInventario.setHorizontalAlignment(SwingConstants.CENTER);
		this.btnInventario.setHorizontalTextPosition(SwingConstants.CENTER);
		this.btnInventario.setFocusable(false);
		this.btnInventario.setFocusTraversalKeysEnabled(false);
		this.btnInventario.setAlignmentY(0.0f);
		this.btnInventario.setBounds(556, 0, 167, 47);
		this.btnInventario.setIcon(new ImageIcon(
				new ImageIcon(this.getClass().getResource("/img/Interfaz/inventarioCerrar.png")).getImage()
						.getScaledInstance(167, 47, Image.SCALE_SMOOTH)));
		this.boton.add(this.btnInventario);

		ladoIzquierdo.setBounds(0, 0, 550, 115);
		this.capas.add(ladoIzquierdo);
		ladoIzquierdo.setOpaque(false);
		ladoIzquierdo.setAlignmentY(0.0f);
		ladoIzquierdo.setAlignmentX(0.0f);
		this.ladoIzquierdo.setBorder(new EmptyBorder(5, 10, 5, 0));
		ladoIzquierdo.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		this.ladoDerecho = new JPanel();
		this.ladoDerecho.setOpaque(false);
		this.ladoDerecho.setBorder(new EmptyBorder(5, 10, 5, 0));
		this.ladoDerecho.setAlignmentY(0.0f);
		this.ladoDerecho.setAlignmentX(0.0f);
		this.ladoDerecho.setBounds(730, 0, 550, 115);
		this.capas.add(this.ladoDerecho);
		this.ladoDerecho.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

	}

	protected void creaObjeto(String objeto) {
		JLayeredPane obj = new JLayeredPane();
		obj.setPreferredSize(new Dimension(95, 95));
		obj.setBorder(null);
		obj.setRequestFocusEnabled(false);
		obj.setFocusable(false);
		obj.setFocusTraversalKeysEnabled(false);
		obj.setAlignmentX(0.0f);
		obj.setAlignmentY(0.0f);

		JButton btn2 = new JButton("");
		btn2.setContentAreaFilled(false);
		btn2.setBounds(50, 50, 40, 40);
		btn2.setIcon(new ImageIcon(
				new ImageIcon(this.getClass().getResource("/img/Interfaz/zoom.png")).getImage()
						.getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		btn2.setBorder(null);
		btn2.setBorderPainted(false);
		btn2.setDefaultCapable(false);
		btn2.setFocusPainted(false);
		btn2.setFocusTraversalKeysEnabled(false);
		btn2.setFocusable(false);
		btn2.setRolloverEnabled(false);
		btn2.setRequestFocusEnabled(false);
		btn2.setOpaque(false);
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				infoObjeto(objeto);
			}

		});
		obj.add(btn2);

		JButton btn = new JButton("");
		btn.setBounds(0, 0, 95, 95);
		btn.setIcon(new ImageIcon(
				new ImageIcon(this.getClass().getResource(this.vista.getObjetoImg(objeto))).getImage()
						.getScaledInstance(95, 95, Image.SCALE_SMOOTH)));
		btn.setContentAreaFilled(false);
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				objetoSeleccionado(objeto);
			}

		});
		obj.add(btn);
		this.inventario.put(objeto, obj);
	}

	protected void objetoSeleccionado(String objeto) {
		this.objetoSeleccionado = objeto;
		Component lado;
		if (this.buscarObjetoInventario(objeto, ladoIzquierdo) != null) {lado = ladoIzquierdo;}
		else {lado = ladoDerecho;}
		for (Component btn : ((JLayeredPane) this.buscarObjetoInventario(objeto, lado)).getComponents()) {
			if (((JButton) btn).getBounds().getWidth() == 95) {((JButton) btn).setBorder(new LineBorder(new Color(255, 255, 255), 5, true));	}
		}
		deseleccionarRestoMenos(objeto);
		actualizarVentanaInventario();
	}

	protected void deseleccionarRestoMenos(String objeto) {
		Component lado;
		for (String obj : this.inventario.keySet()) {
			if (!obj.equals(objeto)) {
				if (this.buscarObjetoInventario(obj, ladoIzquierdo) != null) {	lado = ladoIzquierdo;}
				else {lado = ladoDerecho;}
				for (Component btn : ((JLayeredPane) this.buscarObjetoInventario(obj, lado)).getComponents()) {
					if (((JButton) btn).getBounds().getWidth() == 95) {((JButton) btn).setBorder(null);	}
				}
			}
		}
	}

	protected void actualizarVentanaInventario() {
		this.setVisible(false);
		this.setVisible(true);
	}

	protected void obtenerObjeto(String objeto) {
		creaObjeto(objeto);
		this.contador++;
		if (contador <= 5) {
			ladoIzquierdo.add(this.inventario.get(objeto));
		}
		else {
			ladoDerecho.add(this.inventario.get(objeto));
		}
		this.vista.objetoObtenido(objeto);
	}

	protected void quitarObjeto(String objeto) {
		Component[] objetosPanel1 = ladoIzquierdo.getComponents();
		for (Component obj : objetosPanel1) {
			if (obj.equals(this.inventario.get(objeto))) {
				ladoIzquierdo.remove(obj);

			}
		}
		Component[] objetosPanel2 = ladoDerecho.getComponents();
		for (Component obj : objetosPanel2) {
			if (obj.equals(this.inventario.get(objeto))) {
				ladoDerecho.remove(obj);
			}
		}
		this.inventario.remove(objeto);
		if(this.objetoSeleccionado.equals(objeto)) {
			this.objetoSeleccionado = "";
		}
		this.contador--;
		actualizarVentanaInventario();
	}

	protected Component buscarObjetoInventario(String objeto, Component lado) {
		Component[] objetosPanel = ((JComponent) lado).getComponents();
		for (Component obj : objetosPanel) {
			if (obj.equals(this.inventario.get(objeto))) { return obj; }
		}
		return null;
	}


	protected void infoObjeto(String objeto) {
		this.vista.mostrarInfoObjeto(objeto);
	}

	protected void btnInventarioActivado(MouseEvent e) {
		this.setVisible(false);
	}

	public String getObjetoSeleccionado() {
		return this.objetoSeleccionado;
	}

	public void actualizaInventario() {
		vaciarInventario();
		for (String obj : this.vista.getinventario()) {
			if(!this.vista.getObjeto(obj).isUsado()) {
				this.obtenerObjeto(obj);
			}
		}
		this.vista.actualizarVentanaInventario();
	}

	private void vaciarInventario() {
		this.inventario.clear();
		this.contador=0;
		this.ladoIzquierdo.removeAll();
		this.ladoDerecho.removeAll();
	}
}
