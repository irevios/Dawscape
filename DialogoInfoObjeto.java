import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class DialogoInfoObjeto extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Vista vista;
	private Objeto objeto;
	private JPanel panelObjeto;
	private JToggleButton imgObjeto;
	private JLabel nombreObjeto;
	private JLabel btnCerrar;
	private JScrollPane spn;
	private JTextPane descripcionObjeto;
	private JLayeredPane capas;
	private JPanel capa;
	private JLabel numeroNota;
	private JLabel numeroHexa;
	private JLabel tarjetaCamara;
	private JLabel numeroCarta;

	public DialogoInfoObjeto(Vista vista) {
		this.vista = vista;
		setAutoRequestFocus(false);
		setFocusCycleRoot(false);
		setFocusTraversalKeysEnabled(false);
		setFocusable(false);
		setFocusableWindowState(false);
		setResizable(false);
		setBounds(0, 0, 1280, 720);
		setUndecorated(true);
		getContentPane().setBackground(new Color(0, 0, 0, 0));
		setBackground(new Color(0, 0, 0, 0));
		setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setOpaque(false);
		this.contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(this.contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		this.capas = new JLayeredPane();
		this.capas.setBounds(0, 721, 1280, -720);
		contentPanel.add(this.capas);

		this.capa = new JPanel();
		this.capa.setRequestFocusEnabled(false);
		this.capa.setOpaque(false);
		this.capa.setFocusable(false);
		this.capa.setFocusTraversalKeysEnabled(false);
		this.capa.setDoubleBuffered(false);
		this.capa.setBounds(454, 179, 370, 370);
		contentPanel.add(this.capa);
		this.capa.setLayout(null);

		this.numeroNota = new JLabel("0");

		this.numeroNota.setHorizontalTextPosition(SwingConstants.CENTER);
		this.numeroNota.setHorizontalAlignment(SwingConstants.CENTER);
		this.numeroNota.setForeground(new Color(20, 20, 20));
		this.numeroNota.setFont(new Font("Trebuchet MS", Font.BOLD, 38));
		this.numeroNota.setBounds(134, 139, 100, 105);
		this.capa.add(this.numeroNota);
		this.numeroNota.setVisible(false);
		
		this.numeroHexa = new JLabel("0");

		this.numeroHexa.setHorizontalTextPosition(SwingConstants.CENTER);
		this.numeroHexa.setHorizontalAlignment(SwingConstants.CENTER);
		this.numeroHexa.setForeground(new Color(20, 20, 20));
		this.numeroHexa.setFont(new Font("Trebuchet MS", Font.BOLD, 72));
		this.numeroHexa.setBounds(134, 127, 100, 105);
		this.capa.add(this.numeroHexa);
		
		this.tarjetaCamara = new JLabel("");
		this.tarjetaCamara.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tarjetaCamaraActivado(e);
			}
		});
		
		this.numeroCarta = new JLabel("");
		this.numeroCarta.setBounds(123, 127, 124, 89);
		this.numeroCarta.setForeground(new Color(20, 20, 20));
		this.numeroCarta.setFont(new Font("Trebuchet MS", Font.BOLD, 72));
		
		this.numeroCarta.setIconTextGap(0);
		this.numeroCarta.setHorizontalTextPosition(SwingConstants.CENTER);
		this.numeroCarta.setHorizontalAlignment(SwingConstants.CENTER);
		this.capa.add(this.numeroCarta);
		this.numeroCarta.setAlignmentY(0.0f);
		this.tarjetaCamara.setIconTextGap(0);
		this.tarjetaCamara.setHorizontalTextPosition(SwingConstants.CENTER);
		this.tarjetaCamara.setHorizontalAlignment(SwingConstants.CENTER);
		this.tarjetaCamara.setAlignmentY(0.0f);
		this.tarjetaCamara.setBounds(22, 195, 28, 49);
		this.capa.add(this.tarjetaCamara);
		this.numeroHexa.setVisible(false);

		this.panelObjeto = new JPanel();
		this.panelObjeto.setBounds(408, 56, 464, 607);
		contentPanel.add(this.panelObjeto);
		this.panelObjeto.setBackground(new Color(20, 20, 20));

		this.imgObjeto = new JToggleButton("");
		this.imgObjeto.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/img/Objetos/sobreCuadradoPosterior.png")).getImage().getScaledInstance(370, 370, Image.SCALE_SMOOTH)));

		this.imgObjeto.setContentAreaFilled(false);
		this.imgObjeto.setFocusPainted(false);
		this.imgObjeto.setRolloverEnabled(false);
		this.imgObjeto.setRequestFocusEnabled(false);
		this.imgObjeto.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				imgObjetoActivado(e);
			}
		});

		this.imgObjeto.setBorder(null);
		this.imgObjeto.setBorderPainted(false);
		this.imgObjeto.setFocusTraversalKeysEnabled(false);
		this.imgObjeto.setFocusable(false);
		this.imgObjeto.setVisible(true);

		this.nombreObjeto = new JLabel("");
		this.nombreObjeto.setForeground(Color.WHITE);
		this.nombreObjeto.setFont(new Font("Segoe UI Black", Font.PLAIN, 25));
		this.nombreObjeto.setOpaque(true);
		this.nombreObjeto.setBackground(new Color(53, 162, 141));
		this.nombreObjeto.setHorizontalAlignment(SwingConstants.CENTER);
		this.nombreObjeto.setHorizontalTextPosition(SwingConstants.CENTER);

		this.btnCerrar = new JLabel("");
		this.btnCerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnCerrarActivado(e);
			}
		});
		this.btnCerrar.setHorizontalAlignment(SwingConstants.CENTER);
		this.btnCerrar.setHorizontalTextPosition(SwingConstants.CENTER);
		this.btnCerrar.setIconTextGap(0);
		this.btnCerrar.setAlignmentY(0.0f);
		this.btnCerrar.setIcon(new ImageIcon(
				new ImageIcon(this.getClass().getResource("/img/Interfaz/close.png")).getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));

		this.spn = new JScrollPane();
		this.spn.setBorder(null);
		this.spn.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		this.spn.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		GroupLayout gl_panelObjeto = new GroupLayout(this.panelObjeto);
		gl_panelObjeto.setHorizontalGroup(
				gl_panelObjeto.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelObjeto.createSequentialGroup()
						.addContainerGap(419, Short.MAX_VALUE)
						.addComponent(this.btnCerrar, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
				.addGroup(gl_panelObjeto.createSequentialGroup()
						.addGap(47)
						.addComponent(this.spn, GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
						.addGap(47))
				.addGroup(Alignment.TRAILING, gl_panelObjeto.createSequentialGroup()
						.addGap(47)
						.addGroup(gl_panelObjeto.createParallelGroup(Alignment.TRAILING)
								.addComponent(this.nombreObjeto, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
								.addComponent(this.imgObjeto, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE))
						.addGap(47)));
		gl_panelObjeto.setVerticalGroup(
				gl_panelObjeto.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelObjeto.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(this.btnCerrar, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(this.nombreObjeto, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
						.addGap(11)
						.addComponent(this.imgObjeto, GroupLayout.PREFERRED_SIZE, 370, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(this.spn, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
						.addGap(34)));

		this.descripcionObjeto = new JTextPane();
		this.descripcionObjeto.setMargin(new Insets(15, 15, 15, 15));
		this.descripcionObjeto.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.descripcionObjeto.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		StyledDocument doc = descripcionObjeto.getStyledDocument();
		this.spn.setViewportView(this.descripcionObjeto);
		this.panelObjeto.setLayout(gl_panelObjeto);
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
	}

	public void setObjeto(String objeto) {
		this.objeto = this.vista.getObjeto(objeto);
		this.nombreObjeto.setText(this.objeto.getNombre().toUpperCase());
		this.descripcionObjeto.setText(this.objeto.getDescripcion());
		this.imgObjeto.setIcon(new ImageIcon(
				new ImageIcon(this.getClass().getResource(this.objeto.getImagenes().get("frente"))).getImage()
				.getScaledInstance(370, 370, Image.SCALE_SMOOTH)));
	}

	protected void btnCerrarActivado(MouseEvent e) {
		this.imgObjeto.setIcon(new ImageIcon(
				new ImageIcon(this.getClass().getResource(this.objeto.getImagenes().get("frente"))).getImage()
				.getScaledInstance(370, 370, Image.SCALE_SMOOTH)));
		this.setVisible(false);
	}

	protected void imgObjetoActivado(ItemEvent e) {
		
		if (this.objeto.getImagenes().containsKey("posterior")) {
			if (this.imgObjeto.isSelected()) {
				this.imgObjeto.setIcon(new ImageIcon(
						new ImageIcon(this.getClass().getResource(this.objeto.getImagenes().get("posterior"))).getImage()
						.getScaledInstance(370, 370, Image.SCALE_SMOOTH)));

				if(this.objeto.getNombre().equals("Nota")) {
					this.numeroNota.setText(this.vista.getNumeroB()+"");
					this.numeroNota.setVisible(true);
				}
				if(this.objeto.getNombre().equals("Hexágono")) {
					this.numeroHexa.setText(this.vista.getNumeroA()+"");
					this.numeroHexa.setVisible(true);
				}
				if(this.objeto.getNombre().equals("Sobre blanco")) {
					this.numeroCarta.setText(this.vista.getNumeroC()+"");
					this.numeroCarta.setVisible(true);
				}
				if(this.objeto.getNombre().equals("Sobre colorido")) {
					this.numeroCarta.setText(this.vista.getNumeroD()+"");
					this.numeroCarta.setVisible(true);
				}
				
				if(this.objeto.getNombre().equals("Mando a distancia") && this.vista.objetoSeleccionado().equals("Batería")) {
					this.mostrar(false);
					String vacio = this.objeto.getImagenes().get("posterior").replace("SinBateria","ConBateria");
					this.objeto.setDescripcion(this.objeto.getDescripcion().replace(" No hace nada.", ""));
					this.descripcionObjeto.setText(this.objeto.getDescripcion());
					this.objeto.getImagenes().remove("posterior");
					this.objeto.getImagenes().put("posterior", vacio);
					this.vista.quitarObjeto("Batería");
					this.vista.objetoUsado("Batería");
					this.vista.actualizaInventario();
					this.mostrar(true);
				}
				if(this.objeto.getNombre().equals("Cámara")) {
					this.tarjetaCamara.setVisible(true);
				}
			}
			else {
				this.imgObjeto.setIcon(new ImageIcon(
						new ImageIcon(this.getClass().getResource(this.objeto.getImagenes().get("frente"))).getImage()
						.getScaledInstance(370, 370, Image.SCALE_SMOOTH)));
				this.numeroNota.setVisible(false);
				this.numeroHexa.setVisible(false);
				this.numeroCarta.setVisible(false);
			}
		}
		else {
			this.numeroNota.setVisible(false);
			this.numeroHexa.setVisible(false);
			this.numeroCarta.setVisible(false);
			if (this.imgObjeto.isSelected() && this.objeto.getNombre().equals("Mango") && this.vista.objetoSeleccionado().equals("Destornillador plano")) {
				this.mostrar(false);
				this.vista.quitarObjeto("Mango");
				this.vista.objetoUsado("Mango");
				this.vista.quitarObjeto("Destornillador plano");
				this.vista.objetoUsado("Destornillador plano");
				this.setObjeto("Destornillador");
				this.vista.obtenerObjeto("Destornillador");
				this.vista.actualizaInventario();
				this.mostrar(true);
				
			}
		}

	}

	public void mostrar(boolean opcion) {
		this.contentPanel.setVisible(!opcion);
		this.setVisible(!opcion);
		this.imgObjeto.setSelected(false);
		this.contentPanel.setVisible(opcion);
		this.setVisible(opcion);
	}
	protected void tarjetaCamaraActivado(MouseEvent e) {
		this.mostrar(false);
		this.vista.quitarObjeto("Cámara");
		this.vista.objetoUsado("Cámara");
		this.vista.obtenerObjeto("Tarjeta de memoria");
		this.tarjetaCamara.setVisible(false);
		this.setObjeto("Tarjeta de memoria");
		this.vista.actualizarVentanaInventario();
		this.mostrar(true);
	}
}
