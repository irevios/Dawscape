import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.util.HashMap;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.filechooser.FileNameExtensionFilter;
//TODO Necesita refactorización (reducir en subclases)
public class VentanaPrincipal extends JFrame {
	private Vista vista;
	private Point puntoInicial;
	// Colores
	private Color negro = new Color(11, 11, 11, 220);
	private Color negroHover = new Color(22, 22, 22, 220);
	private Color transparente = new Color(0, 0, 0, 0);
	private Color azul = new Color(52, 125, 110);
	private Color azulHover = new Color(53, 162, 141);

	private JFileChooser selectorFichero;

	// Lista de Escenas
	private HashMap<String, JPanel> listaBotonesEscenas = new HashMap<String, JPanel>();

	private JPanel contentPane;
	private JPanel pnBarraArriba;
	private JButton btnCerrar;
	private JButton btnGuardar;
	private JPanel inicio;
	private JLabel titulo;
	private JLabel continuar;
	private JLabel nuevaPartida;
	private JLabel salir;
	private JLabel importar;
	private JLabel exportar;
	private JLabel lbFondo;
	private JLayeredPane escenas;
	private JPanel botonesSalon;
	private JLabel izquierda;
	private JLabel irAEstanteria;
	private JLabel btnSofa;
	private JPanel pnEscenas;
	private JLabel btnMesa;
	private JLabel btnMueble;
	private JPanel botonesEstanteria;
	private JLabel derecha;
	private JLabel abajo;
	private JButton btnInicio;
	private JPanel botonesCuadros;
	private JPanel botonesEntrada;
	private JPanel botonesVentana;
	private JLabel btnPuertasIzq;
	private JLabel btnPuertasDer;
	private JLabel btnInventario;
	private JLabel btnMando;
	private JLabel btnPlanta;
	private JLabel btnRecibidor;
	private JLabel btnPuertaCirculo;
	private JLabel btnPercheroPuerta;
	private JPanel botonesPlanta;
	private JLabel btnLlavePlanta;
	private JPanel botonesSofa;
	private JPanel botonesRecibidor;
	private JLabel btnRecibidorArriba;
	private JLabel btnRecibidorAbajo;
	private JPanel botonesMueble;
	private JLabel btnNota;
	private JLabel btnCajaTornillo;
	private JLabel btnCajaCandado;
	private JPanel botonesCajaCandado;
	private JPanel botonesCajaTornillos;
	private JLabel btnTV;
	private JLabel btnPC;
	private JLabel btnCajaTriangulos;
	private JPanel botonesTV;
	private JPanel botonesPC;
	private JPanel botonesCajaTriangulos;
	private JPanel botonesPerchero;
	private JPanel botonesPuertaCirculo;
	private JPanel botonesPuertaCuadrado;
	private JLabel btnDestornilladorParte;
	private JLabel btnPuertaCuadrado;
	private JLabel btnCajaCandadoAbrir;
	private JLabel btnCajaCandadoVaciar;
	private JLabel btnCajaTornillosAbrir;
	private JLabel btnCajaTornillosVaciar;
	private JLabel btnRecibidorArribaVaciar;
	private JToggleButton btnTriangulo1;
	private JToggleButton btnTriangulo2;
	private JToggleButton btnTriangulo3;
	private JToggleButton btnTriangulo4;
	private JToggleButton btnTriangulo5;
	private JToggleButton btnTriangulo6;
	private JToggleButton btnTriangulo7;
	private JToggleButton btnTriangulo8;
	private JToggleButton btnTriangulo9;
	private JToggleButton btnTriangulo10;
	private JToggleButton btnTriangulo11;
	private JToggleButton btnTriangulo12;
	private JLabel btnCajaTriangulosVaciar;
	private JLabel btnPcEncender;
	private JTextField txCodigo;
	private JLabel lbMensajeError;
	private JButton btnEnviar;
	private JLabel btnEncenderTV;
	private JLabel btnMandoCirculo;
	private JLabel btnMandoCuadrado;
	private JLabel btnCarta;
	private JPasswordField pwPuertaCirculo;
	private JButton btnAbrirPuertaCirculo;
	private JButton btnAbrirPuertaCuadrado;
	private JPasswordField pwPuertaCuadrado;
	private JPanel botonesFinal;
	private JButton btnFinalActivado;
	private JButton btnFinalActivado2;

	public VentanaPrincipal(Vista vista) {
		setTitle("Dawscape");

		this.setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/img/Interfaz/logo.png")).getScaledInstance(32, 32, Image.SCALE_SMOOTH));
		this.vista = vista;
		setUndecorated(true);
		getContentPane().setBackground(new Color(0, 0, 0, 0));
		setBackground(new Color(0, 0, 0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 759);
		this.contentPane = new JPanel();
		this.contentPane.setOpaque(false);
		this.contentPane.setBorder(null);
		this.contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(this.contentPane);
		this.setLocationRelativeTo(this.getParent());

		selectorFichero = new JFileChooser();
		this.selectorFichero.setFileFilter(new FileNameExtensionFilter("Fichero de guardado (.sav)", "sav"));
		this.selectorFichero.setAcceptAllFileFilterUsed(false);

		this.pnBarraArriba = new JPanel();
		this.pnBarraArriba.setBorder(null);
		this.pnBarraArriba.setBackground(negro);
		this.pnBarraArriba.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				moverVentana(arg0);
			}
		});
		this.pnBarraArriba.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				obtenerPuntoInicialRaton(arg0);
			}
		});
		FlowLayout fl_pnBarraArriba = (FlowLayout) this.pnBarraArriba.getLayout();
		fl_pnBarraArriba.setVgap(0);
		fl_pnBarraArriba.setHgap(0);
		fl_pnBarraArriba.setAlignment(FlowLayout.RIGHT);
		this.contentPane.add(this.pnBarraArriba, BorderLayout.NORTH);

		this.btnInicio = new JButton("");
		this.btnInicio.setSize(new Dimension(25, 25));
		this.btnInicio.setMargin(new Insets(0, 0, 0, 0));
		this.btnInicio.setIcon(new ImageIcon(
				new ImageIcon(this.getClass().getResource("/img/Interfaz/botonInicio.png")).getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
		this.btnInicio.setContentAreaFilled(false);
		this.btnInicio.setBorder(new EmptyBorder(7, 7, 7, 7));
		this.btnInicio.setBackground(negro);
		this.btnInicio.setOpaque(true);
		this.pnBarraArriba.add(this.btnInicio);
		this.btnInicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnInicioHoverIn();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnInicioHoverOut();
			}
		});
		this.btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnInicioActivado();
			}
		});

		this.btnGuardar = new JButton("");
		this.btnGuardar.setSize(new Dimension(25, 25));
		this.btnGuardar.setMargin(new Insets(0, 0, 0, 0));
		this.btnGuardar.setIcon(new ImageIcon(
				new ImageIcon(this.getClass().getResource("/img/Interfaz/save.png")).getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
		this.btnGuardar.setContentAreaFilled(false);
		this.btnGuardar.setBorder(new EmptyBorder(7, 7, 7, 7));
		this.btnGuardar.setBackground(azul);
		this.btnGuardar.setOpaque(true);
		this.pnBarraArriba.add(this.btnGuardar);
		this.btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnGuardarHoverIn();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnGuardarHoverOut();
			}
		});
		this.btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnGuardarActivado();
			}
		});

		this.btnCerrar = new JButton("");
		this.btnCerrar.setMargin(new Insets(0, 0, 0, 0));
		this.btnCerrar.setBorder(new EmptyBorder(7, 7, 7, 7));
		this.btnCerrar.setSize(new Dimension(50, 50));
		this.btnCerrar.setIcon(new ImageIcon(
				new ImageIcon(this.getClass().getResource("/img/Interfaz/close.png")).getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
		this.btnCerrar.setContentAreaFilled(false);
		this.btnCerrar.setBorderPainted(false);
		this.btnCerrar.setBackground(negro);
		this.btnCerrar.setOpaque(true);
		this.pnBarraArriba.add(this.btnCerrar);

		this.btnCerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnCerrarHoverIn();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnCerrarHoverOut();
			}
		});
		this.btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnCerrarActivado();
			}
		});

		new JButton("New button");

		this.pnEscenas = new JPanel();
		this.contentPane.add(this.pnEscenas, BorderLayout.CENTER);
		this.pnEscenas.setLayout(null);

		// Boton Derecho
		this.derecha = new JLabel("");
		this.derecha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				derechaActivado(e);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				derechaHoverInActivado(e);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				derechaHoverOutActivado(e);
			}
		});
		this.derecha.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.derecha.setVisible(false);

		this.btnInventario = new JLabel("");
		this.btnInventario.setBounds(556, 0, 167, 47);
		this.pnEscenas.add(this.btnInventario);
		this.btnInventario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnInventarioActivado(e);
			}
		});
		this.btnInventario.setVisible(false);
		this.btnInventario.setIcon(new ImageIcon(
				new ImageIcon(this.getClass().getResource("/img/Interfaz/inventario.png")).getImage()
				.getScaledInstance(167, 47, Image.SCALE_SMOOTH)));
		this.derecha.setBounds(1197, 0, 83, 720);
		this.pnEscenas.add(this.derecha);
		this.derecha.setIcon(new ImageIcon(
				new ImageIcon(this.getClass().getResource("/img/Interfaz/der.png")).getImage()
				.getScaledInstance(83, 720, Image.SCALE_SMOOTH)));

		// Boton Abajo
		this.abajo = new JLabel("");
		this.abajo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				abajoActivado(e);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				abajoHoverInActivado(e);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				abajoHoverOutActivado(e);
			}
		});
		this.abajo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.abajo.setVisible(false);
		this.abajo.setBounds(0, 637, 1280, 83);
		this.pnEscenas.add(this.abajo);
		this.abajo.setIcon(new ImageIcon(
				new ImageIcon(this.getClass().getResource("/img/Interfaz/aba.png")).getImage()
				.getScaledInstance(1280, 83, Image.SCALE_SMOOTH)));

		// Boton Izquierda
		this.izquierda = new JLabel("");
		this.izquierda.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.izquierda.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				izquierdaActivado(e);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				izquierdaHoverInActivado(e);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				izquierdaHoverOutActivado(e);
			}
		});
		this.izquierda.setVisible(false);
		this.izquierda.setBounds(0, 0, 83, 720);
		this.pnEscenas.add(this.izquierda);
		this.izquierda.setIcon(new ImageIcon(
				new ImageIcon(this.getClass().getResource("/img/Interfaz/izq.png")).getImage()
				.getScaledInstance(83, 720, Image.SCALE_SMOOTH)));

		this.escenas = new JLayeredPane();
		this.escenas.setBackground(transparente);
		this.escenas.setOpaque(true);
		this.escenas.setAlignmentY(0.0f);
		this.escenas.setAlignmentX(0.0f);
		this.escenas.setBounds(0, 0, 1280, 720);
		this.pnEscenas.add(this.escenas);
		this.escenas.setLayout(new CardLayout());

		this.inicio = new JPanel();
		this.inicio.setBorder(null);
		this.inicio.setBackground(new Color(0, 0, 0, 0));
		this.inicio.setAlignmentY(0.0f);
		this.inicio.setAlignmentX(0.0f);
		this.escenas.add(this.inicio, "inicio");

		this.titulo = new JLabel("");
		this.titulo.setFocusable(false);
		this.titulo.setFocusTraversalKeysEnabled(false);
		this.titulo.setVerifyInputWhenFocusTarget(false);
		this.titulo.setRequestFocusEnabled(false);
		this.titulo.setInheritsPopupMenu(false);
		this.titulo.setIcon(new ImageIcon(
				new ImageIcon(this.getClass().getResource("/img/Interfaz/titulo.png")).getImage().getScaledInstance(609, 277, Image.SCALE_SMOOTH)));

		this.continuar = new JLabel("Continuar");
		this.continuar.setFocusable(false);
		this.continuar.setFocusTraversalKeysEnabled(false);
		this.continuar.setVerifyInputWhenFocusTarget(false);
		this.continuar.setRequestFocusEnabled(false);
		this.continuar.setInheritsPopupMenu(false);
		this.continuar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.continuar.setHorizontalAlignment(SwingConstants.CENTER);
		this.continuar.setForeground(Color.WHITE);
		this.continuar.setFont(new Font("Arial Unicode MS", Font.PLAIN, 26));
		this.continuar.setHorizontalTextPosition(JLabel.CENTER);
		this.continuar.setVerticalTextPosition(JLabel.CENTER);
		this.continuar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				botonIncioPasaPorEncima("continuar");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				botonIncioSaleDeEncima("continuar");
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				continuarActivado(e);
			}
		});

		this.nuevaPartida = new JLabel("Nueva Partida");
		this.nuevaPartida.setRequestFocusEnabled(false);
		this.nuevaPartida.setInheritsPopupMenu(false);
		this.nuevaPartida.setFocusable(false);
		this.nuevaPartida.setFocusTraversalKeysEnabled(false);
		this.nuevaPartida.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.nuevaPartida.setHorizontalAlignment(SwingConstants.CENTER);
		this.nuevaPartida.setForeground(Color.WHITE);
		this.nuevaPartida.setFont(new Font("Arial Unicode MS", Font.PLAIN, 26));
		this.nuevaPartida.setHorizontalTextPosition(JLabel.CENTER);
		this.nuevaPartida.setVerticalTextPosition(JLabel.CENTER);
		this.nuevaPartida.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				botonIncioPasaPorEncima("nuevaPartida");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				botonIncioSaleDeEncima("nuevaPartida");
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				nuevaPartidaActivado(e);
			}
		});

		this.salir = new JLabel("Salir");
		this.salir.setInheritsPopupMenu(false);
		this.salir.setFocusTraversalKeysEnabled(false);
		this.salir.setFocusable(false);
		this.salir.setRequestFocusEnabled(false);
		this.salir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.salir.setHorizontalAlignment(SwingConstants.CENTER);
		this.salir.setForeground(Color.WHITE);
		this.salir.setFont(new Font("Arial Unicode MS", Font.PLAIN, 26));
		this.salir.setHorizontalTextPosition(JLabel.CENTER);
		this.salir.setVerticalTextPosition(JLabel.CENTER);
		this.salir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				botonIncioPasaPorEncima("salir");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				botonIncioSaleDeEncima("salir");
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				salirActivado(e);
			}
		});

		this.importar = new JLabel("");
		this.importar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				importarActivado(e);
			}
		});
		this.importar.setVerifyInputWhenFocusTarget(false);
		this.importar.setRequestFocusEnabled(false);
		this.importar.setInheritsPopupMenu(false);
		this.importar.setFocusable(false);
		this.importar.setFocusTraversalKeysEnabled(false);
		this.importar.setToolTipText("Importar Partida");
		this.importar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.importar.setIcon(new ImageIcon(
				new ImageIcon(this.getClass().getResource("/img/Interfaz/importar.png")).getImage().getScaledInstance(71, 71, Image.SCALE_SMOOTH)));

		this.exportar = new JLabel("");
		this.exportar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				exportarActivado(e);
			}
		});
		this.exportar.setFocusable(false);
		this.exportar.setFocusTraversalKeysEnabled(false);
		this.exportar.setVerifyInputWhenFocusTarget(false);
		this.exportar.setRequestFocusEnabled(false);
		this.exportar.setInheritsPopupMenu(false);
		this.exportar.setToolTipText("Exportar Partida");
		this.exportar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.exportar.setIcon(new ImageIcon(
				new ImageIcon(this.getClass().getResource("/img/Interfaz/exportar.png")).getImage().getScaledInstance(71, 71, Image.SCALE_SMOOTH)));
		GroupLayout gl_inicio = new GroupLayout(this.inicio);
		gl_inicio.setHorizontalGroup(
				gl_inicio.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_inicio.createSequentialGroup()
						.addGap(495)
						.addGroup(gl_inicio.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_inicio.createSequentialGroup()
										.addGroup(gl_inicio.createParallelGroup(Alignment.LEADING)
												.addComponent(this.nuevaPartida, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE)
												.addComponent(this.salir, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.RELATED, 392, Short.MAX_VALUE)
										.addGroup(gl_inicio.createParallelGroup(Alignment.LEADING)
												.addComponent(this.importar, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
												.addComponent(this.exportar, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
										.addGap(32))
								.addGroup(gl_inicio.createSequentialGroup()
										.addComponent(this.continuar, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE)
										.addContainerGap(495, Short.MAX_VALUE))))
				.addGroup(gl_inicio.createSequentialGroup()
						.addGap(335)
						.addComponent(this.titulo, GroupLayout.PREFERRED_SIZE, 606, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(339, Short.MAX_VALUE)));
		gl_inicio.setVerticalGroup(
				gl_inicio.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_inicio.createSequentialGroup()
						.addGap(152)
						.addComponent(this.titulo, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE)
						.addGap(43)
						.addComponent(this.continuar, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(this.nuevaPartida, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(this.salir, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(65, Short.MAX_VALUE))
				.addGroup(gl_inicio.createSequentialGroup()
						.addContainerGap(527, Short.MAX_VALUE)
						.addComponent(this.importar, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(this.exportar, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
						.addGap(33)));
		this.inicio.setLayout(gl_inicio);

		this.botonesSalon = new JPanel();
		this.botonesSalon.setBackground(transparente);
		this.escenas.setLayer(this.botonesSalon, 0);
		this.escenas.add(this.botonesSalon, "salon");
		this.botonesSalon.setBorder(null);
		this.botonesSalon.setAlignmentY(0.0f);
		this.botonesSalon.setAlignmentX(0.0f);
		this.botonesSalon.setLayout(null);

		this.irAEstanteria = new JLabel("");
		this.irAEstanteria.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				irAEstanteriaActivado(e);
			}
		});
		this.irAEstanteria.setBackground(transparente);
		this.irAEstanteria.setFocusable(false);
		this.irAEstanteria.setBounds(300, 127, 547, 385);
		this.irAEstanteria.setOpaque(false);

		this.btnSofa = new JLabel("");
		this.btnSofa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnSofaActivado(e);
			}
		});
		this.btnSofa.setBackground(transparente);
		this.btnSofa.setFocusable(false);
		this.btnSofa.setBounds(82, 409, 340, 311);
		this.botonesSalon.add(this.btnSofa);

		this.btnMesa = new JLabel("");
		this.btnMesa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnSofaActivado(e);
			}
		});
		this.btnMesa.setBackground(transparente);
		this.btnMesa.setFocusable(false);
		this.btnMesa.setBounds(460, 508, 230, 212);
		this.botonesSalon.add(this.btnMesa);
		this.botonesSalon.add(this.irAEstanteria);

		this.btnMueble = new JLabel("");
		this.btnMueble.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnMuebleActivado(e);
			}
		});
		this.btnMueble.setBackground(transparente);
		this.btnMueble.setFocusable(false);
		this.btnMueble.setBorder(null);
		this.btnMueble.setBounds(857, 0, 340, 720);
		this.botonesSalon.add(this.btnMueble);

		this.botonesEstanteria = new JPanel();
		this.escenas.add(this.botonesEstanteria, "tarjeta2");
		this.botonesEstanteria.setBackground(transparente);
		this.escenas.setLayer(this.botonesEstanteria, 0);
		this.botonesEstanteria.setLayout(null);
		this.botonesEstanteria.setBorder(null);
		this.botonesEstanteria.setAlignmentY(0.0f);
		this.botonesEstanteria.setAlignmentX(0.0f);

		this.btnCajaTornillo = new JLabel("");
		this.btnCajaTornillo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnCajaTornilloActivado(e);
			}
		});
		this.btnCajaTornillo.setFocusable(false);
		this.btnCajaTornillo.setBackground(new Color(0, 0, 0, 0));
		this.btnCajaTornillo.setBounds(346, 597, 87, 40);
		this.botonesEstanteria.add(this.btnCajaTornillo);

		this.btnCajaCandado = new JLabel("");
		this.btnCajaCandado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnCajaCandadoActivado(e);
			}
		});
		this.btnCajaCandado.setFocusable(false);
		this.btnCajaCandado.setBackground(new Color(0, 0, 0, 0));
		this.btnCajaCandado.setBounds(596, 183, 95, 52);
		this.botonesEstanteria.add(this.btnCajaCandado);

		this.lbFondo = new JLabel("");
		this.lbFondo.setBounds(0, 0, 1280, 720);
		this.pnEscenas.add(this.lbFondo);
		this.lbFondo.setOpaque(true);
		this.lbFondo.setBackground(Color.BLACK);
		this.lbFondo.setIcon(new ImageIcon(
				new ImageIcon(this.getClass().getResource("/img/Fondos/inicio.png")).getImage()
				.getScaledInstance(lbFondo.getWidth(), lbFondo.getHeight(), Image.SCALE_SMOOTH)));
		this.botonesCuadros = new JPanel();
		this.botonesCuadros.setLayout(null);
		this.botonesCuadros.setBorder(null);
		this.botonesCuadros.setBackground(new Color(0, 0, 0, 0));
		this.botonesCuadros.setAlignmentY(0.0f);
		this.botonesCuadros.setAlignmentX(0.0f);
		this.escenas.add(this.botonesCuadros, "botonesCuadros");

		this.botonesEntrada = new JPanel();
		this.botonesEntrada.setLayout(null);
		this.botonesEntrada.setBorder(null);
		this.botonesEntrada.setBackground(new Color(0, 0, 0, 0));
		this.botonesEntrada.setAlignmentY(0.0f);
		this.botonesEntrada.setAlignmentX(0.0f);
		this.escenas.add(this.botonesEntrada, "botonesEntrada");

		this.botonesVentana = new JPanel();
		this.botonesVentana.setLayout(null);
		this.botonesVentana.setBorder(null);
		this.botonesVentana.setBackground(new Color(0, 0, 0, 0));
		this.botonesVentana.setAlignmentY(0.0f);
		this.botonesVentana.setAlignmentX(0.0f);
		this.escenas.add(this.botonesVentana, "botonesVentana");

		this.btnPuertasIzq = new JLabel("");
		this.btnPuertasIzq.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnPuertasIzqActivado(e);
			}
		});

		this.btnMando = new JLabel("");
		this.btnMando.setVisible(false);
		this.btnMando.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnMandoActivado(e);
			}
		});
		this.btnMando.setEnabled(false);
		this.btnMando.setRequestFocusEnabled(false);
		this.btnMando.setFocusTraversalKeysEnabled(false);
		this.btnMando.setFocusable(false);
		this.btnMando.setBounds(716, 456, 39, 27);
		this.botonesVentana.add(this.btnMando);
		this.btnPuertasIzq.setFocusable(false);
		this.btnPuertasIzq.setBackground(new Color(0, 0, 0, 0));
		this.btnPuertasIzq.setBounds(332, 430, 310, 184);
		this.botonesVentana.add(this.btnPuertasIzq);

		this.btnPuertasDer = new JLabel("");
		this.btnPuertasDer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnPuertasDerActivado(e);
			}
		});
		this.btnPuertasDer.setFocusable(false);
		this.btnPuertasDer.setBackground(new Color(0, 0, 0, 0));
		this.btnPuertasDer.setBounds(635, 430, 290, 184);
		this.botonesVentana.add(this.btnPuertasDer);
		this.listaBotonesEscenas.put("entrada", this.botonesEntrada);

		this.btnPlanta = new JLabel("");
		this.btnPlanta.setRequestFocusEnabled(false);
		this.btnPlanta.setOpaque(true);
		this.btnPlanta.setInheritsPopupMenu(false);
		this.btnPlanta.setFocusTraversalKeysEnabled(false);
		this.btnPlanta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnPlantaActivado(e);
			}
		});

		this.btnRecibidor = new JLabel("");
		this.btnRecibidor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnRecibidorActivado(e);
			}
		});
		this.btnRecibidor.setRequestFocusEnabled(false);
		this.btnRecibidor.setOpaque(true);
		this.btnRecibidor.setInheritsPopupMenu(false);
		this.btnRecibidor.setFocusTraversalKeysEnabled(false);
		this.btnRecibidor.setFocusable(false);
		this.btnRecibidor.setBackground(new Color(0, 0, 0, 0));
		this.btnRecibidor.setBounds(896, 443, 175, 277);
		this.botonesEntrada.add(this.btnRecibidor);
		this.btnPlanta.setFocusable(false);
		this.btnPlanta.setBackground(new Color(0, 0, 0, 0));
		this.btnPlanta.setBounds(805, 328, 175, 315);
		this.botonesEntrada.add(this.btnPlanta);

		this.btnPuertaCirculo = new JLabel("");
		this.btnPuertaCirculo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnPuertaCirculoActivado(e);
			}
		});
		this.btnPuertaCirculo.setFocusable(false);
		this.btnPuertaCirculo.setBackground(new Color(0, 0, 0, 0));
		this.btnPuertaCirculo.setBounds(529, 11, 234, 597);
		this.botonesEntrada.add(this.btnPuertaCirculo);

		this.btnPercheroPuerta = new JLabel("");
		this.btnPercheroPuerta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnPercheroPuertaActivado(e);
			}
		});
		this.btnPercheroPuerta.setFocusable(false);
		this.btnPercheroPuerta.setBackground(new Color(0, 0, 0, 0));
		this.btnPercheroPuerta.setBounds(331, 0, 167, 692);
		this.botonesEntrada.add(this.btnPercheroPuerta);

		this.btnCarta = new JLabel("");
		this.btnCarta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnCartaActivado(e);
			}
		});
		this.btnCarta.setRequestFocusEnabled(false);
		this.btnCarta.setOpaque(true);
		this.btnCarta.setInheritsPopupMenu(false);
		this.btnCarta.setFocusable(false);
		this.btnCarta.setFocusTraversalKeysEnabled(false);
		this.btnCarta.setBackground(new Color(0, 0, 0, 0));
		this.btnCarta.setBounds(508, 605, 62, 38);
		this.botonesEntrada.add(this.btnCarta);

		this.botonesPlanta = new JPanel();
		this.botonesPlanta.setLayout(null);
		this.botonesPlanta.setBorder(null);
		this.botonesPlanta.setBackground(new Color(0, 0, 0, 0));
		this.botonesPlanta.setAlignmentY(0.0f);
		this.botonesPlanta.setAlignmentX(0.0f);
		this.escenas.add(this.botonesPlanta, "botonesPlanta");

		this.btnLlavePlanta = new JLabel("");
		this.btnLlavePlanta.setVisible(false);
		this.btnLlavePlanta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnLlavePlantaActivado(e);
			}
		});
		this.btnLlavePlanta.setFocusable(false);
		this.btnLlavePlanta.setBackground(new Color(0, 0, 0, 0));
		this.btnLlavePlanta.setBounds(552, 474, 30, 47);
		this.botonesPlanta.add(this.btnLlavePlanta);

		this.botonesSofa = new JPanel();
		this.botonesSofa.setLayout(null);
		this.botonesSofa.setBorder(null);
		this.botonesSofa.setBackground(new Color(0, 0, 0, 0));
		this.botonesSofa.setAlignmentY(0.0f);
		this.botonesSofa.setAlignmentX(0.0f);
		this.escenas.add(this.botonesSofa, "botonesSofa");

		this.btnNota = new JLabel("");
		this.btnNota.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnNotaActivado(e);
			}
		});
		this.btnNota.setFocusable(false);
		this.btnNota.setBackground(new Color(0, 0, 0, 0));
		this.btnNota.setBounds(426, 604, 122, 36);
		this.botonesSofa.add(this.btnNota);

		this.botonesRecibidor = new JPanel();
		this.botonesRecibidor.setLayout(null);
		this.botonesRecibidor.setBorder(null);
		this.botonesRecibidor.setBackground(new Color(0, 0, 0, 0));
		this.botonesRecibidor.setAlignmentY(0.0f);
		this.botonesRecibidor.setAlignmentX(0.0f);
		this.escenas.add(this.botonesRecibidor, "botonesRecibidor");

		this.btnRecibidorArribaVaciar = new JLabel("");
		this.btnRecibidorArribaVaciar.setVisible(false);
		this.btnRecibidorArribaVaciar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnRecibidorArribaVaciarActivado(e);
			}
		});
		this.btnRecibidorArribaVaciar.setFocusable(false);
		this.btnRecibidorArribaVaciar.setBackground(new Color(0, 0, 0, 0));
		this.btnRecibidorArribaVaciar.setBounds(764, 498, 117, 96);
		this.botonesRecibidor.add(this.btnRecibidorArribaVaciar);

		this.btnRecibidorArriba = new JLabel("");
		this.btnRecibidorArriba.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnRecibidorArribaActivado(e);
			}
		});
		this.btnRecibidorArriba.setFocusable(false);
		this.btnRecibidorArriba.setBackground(new Color(0, 0, 0, 0));
		this.btnRecibidorArriba.setBounds(250, 488, 754, 70);
		this.botonesRecibidor.add(this.btnRecibidorArriba);

		this.btnRecibidorAbajo = new JLabel("");
		this.btnRecibidorAbajo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnRecibidorAbajoActivado(e);
			}
		});
		this.btnRecibidorAbajo.setFocusable(false);
		this.btnRecibidorAbajo.setBackground(new Color(0, 0, 0, 0));
		this.btnRecibidorAbajo.setBounds(262, 554, 732, 70);
		this.botonesRecibidor.add(this.btnRecibidorAbajo);

		this.botonesMueble = new JPanel();
		this.botonesMueble.setLayout(null);
		this.botonesMueble.setBorder(null);
		this.botonesMueble.setBackground(new Color(0, 0, 0, 0));
		this.botonesMueble.setAlignmentY(0.0f);
		this.botonesMueble.setAlignmentX(0.0f);
		this.escenas.add(this.botonesMueble, "botonesMueble");

		this.btnTV = new JLabel("");
		this.btnTV.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnTVActivado(e);
			}
		});
		this.btnTV.setFocusable(false);
		this.btnTV.setBackground(new Color(0, 0, 0, 0));
		this.btnTV.setBounds(192, 95, 497, 292);
		this.botonesMueble.add(this.btnTV);

		this.btnPC = new JLabel("");
		this.btnPC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnPCActivado(e);
			}
		});
		this.btnPC.setFocusable(false);
		this.btnPC.setBackground(new Color(0, 0, 0, 0));
		this.btnPC.setBounds(859, 347, 144, 124);
		this.botonesMueble.add(this.btnPC);

		this.btnCajaTriangulos = new JLabel("");
		this.btnCajaTriangulos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnCajaTriangulosActivado(e);
			}
		});
		this.btnCajaTriangulos.setFocusable(false);
		this.btnCajaTriangulos.setBackground(new Color(0, 0, 0, 0));
		this.btnCajaTriangulos.setBounds(548, 407, 107, 84);
		this.botonesMueble.add(this.btnCajaTriangulos);

		this.botonesCajaCandado = new JPanel();
		this.botonesCajaCandado.setLayout(null);
		this.botonesCajaCandado.setBorder(null);
		this.botonesCajaCandado.setBackground(new Color(0, 0, 0, 0));
		this.botonesCajaCandado.setAlignmentY(0.0f);
		this.botonesCajaCandado.setAlignmentX(0.0f);
		this.escenas.add(this.botonesCajaCandado, "botonesCajaCandado");

		this.btnCajaCandadoAbrir = new JLabel("");
		this.btnCajaCandadoAbrir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnCajaCandadoAbrirActivado(e);
			}
		});
		this.btnCajaCandadoAbrir.setVerifyInputWhenFocusTarget(false);
		this.btnCajaCandadoAbrir.setRequestFocusEnabled(false);
		this.btnCajaCandadoAbrir.setInheritsPopupMenu(false);
		this.btnCajaCandadoAbrir.setFocusable(false);
		this.btnCajaCandadoAbrir.setFocusTraversalKeysEnabled(false);
		this.btnCajaCandadoAbrir.setBounds(469, 232, 381, 312);
		this.botonesCajaCandado.add(this.btnCajaCandadoAbrir);

		this.btnCajaCandadoVaciar = new JLabel("");
		this.btnCajaCandadoVaciar.setVisible(false);
		this.btnCajaCandadoVaciar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnCajaCandadoVaciarActivado(e);
			}
		});
		this.btnCajaCandadoVaciar.setVerifyInputWhenFocusTarget(false);
		this.btnCajaCandadoVaciar.setRequestFocusEnabled(false);
		this.btnCajaCandadoVaciar.setInheritsPopupMenu(false);
		this.btnCajaCandadoVaciar.setFocusable(false);
		this.btnCajaCandadoVaciar.setFocusTraversalKeysEnabled(false);
		this.btnCajaCandadoVaciar.setBounds(519, 365, 244, 88);
		this.botonesCajaCandado.add(this.btnCajaCandadoVaciar);

		this.botonesCajaTornillos = new JPanel();
		this.botonesCajaTornillos.setLayout(null);
		this.botonesCajaTornillos.setBorder(null);
		this.botonesCajaTornillos.setBackground(new Color(0, 0, 0, 0));
		this.botonesCajaTornillos.setAlignmentY(0.0f);
		this.botonesCajaTornillos.setAlignmentX(0.0f);
		this.escenas.add(this.botonesCajaTornillos, "botonesCajaTornillos");

		this.btnCajaTornillosAbrir = new JLabel("");
		this.btnCajaTornillosAbrir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnCajaTornillosAbrirActivado(e);
			}
		});
		this.btnCajaTornillosAbrir.setVerifyInputWhenFocusTarget(false);
		this.btnCajaTornillosAbrir.setRequestFocusEnabled(false);
		this.btnCajaTornillosAbrir.setInheritsPopupMenu(false);
		this.btnCajaTornillosAbrir.setFocusable(false);
		this.btnCajaTornillosAbrir.setFocusTraversalKeysEnabled(false);
		this.btnCajaTornillosAbrir.setBounds(379, 383, 485, 256);
		this.botonesCajaTornillos.add(this.btnCajaTornillosAbrir);

		this.btnCajaTornillosVaciar = new JLabel("");
		this.btnCajaTornillosVaciar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnCajaTornillosVaciarActivado(e);
			}
		});
		this.btnCajaTornillosVaciar.setVerifyInputWhenFocusTarget(false);
		this.btnCajaTornillosVaciar.setRequestFocusEnabled(false);
		this.btnCajaTornillosVaciar.setInheritsPopupMenu(false);
		this.btnCajaTornillosVaciar.setFocusable(false);
		this.btnCajaTornillosVaciar.setFocusTraversalKeysEnabled(false);
		this.btnCajaTornillosVaciar.setBounds(464, 495, 323, 123);
		this.botonesCajaTornillos.add(this.btnCajaTornillosVaciar);

		this.botonesTV = new JPanel();
		this.botonesTV.setLayout(null);
		this.botonesTV.setBorder(null);
		this.botonesTV.setBackground(new Color(0, 0, 0, 0));
		this.botonesTV.setAlignmentY(0.0f);
		this.botonesTV.setAlignmentX(0.0f);
		this.escenas.add(this.botonesTV, "botonesTV");

		this.btnEncenderTV = new JLabel("");
		this.btnEncenderTV.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnEncenderTVActivado(e);
			}
		});

		this.btnMandoCirculo = new JLabel("");
		this.btnMandoCirculo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnMandoCirculoActivado(e);
			}
		});
		this.btnMandoCirculo.setVerifyInputWhenFocusTarget(false);
		this.btnMandoCirculo.setRequestFocusEnabled(false);
		this.btnMandoCirculo.setInheritsPopupMenu(false);
		this.btnMandoCirculo.setFocusable(false);
		this.btnMandoCirculo.setFocusTraversalKeysEnabled(false);
		this.btnMandoCirculo.setBounds(380, 460, 100, 54);
		this.botonesTV.add(this.btnMandoCirculo);

		this.btnMandoCuadrado = new JLabel("");
		this.btnMandoCuadrado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnMandoCuadradoActivado(e);
			}
		});
		this.btnMandoCuadrado.setVerifyInputWhenFocusTarget(false);
		this.btnMandoCuadrado.setRequestFocusEnabled(false);
		this.btnMandoCuadrado.setInheritsPopupMenu(false);
		this.btnMandoCuadrado.setFocusable(false);
		this.btnMandoCuadrado.setFocusTraversalKeysEnabled(false);
		this.btnMandoCuadrado.setBounds(380, 536, 100, 54);
		this.botonesTV.add(this.btnMandoCuadrado);
		this.btnEncenderTV.setVerifyInputWhenFocusTarget(false);
		this.btnEncenderTV.setRequestFocusEnabled(false);
		this.btnEncenderTV.setInheritsPopupMenu(false);
		this.btnEncenderTV.setFocusable(false);
		this.btnEncenderTV.setFocusTraversalKeysEnabled(false);
		this.btnEncenderTV.setBounds(114, 11, 1106, 623);
		this.botonesTV.add(this.btnEncenderTV);

		this.botonesPC = new JPanel();
		this.botonesPC.setLayout(null);
		this.botonesPC.setBorder(null);
		this.botonesPC.setBackground(new Color(0, 0, 0, 0));
		this.botonesPC.setAlignmentY(0.0f);
		this.botonesPC.setAlignmentX(0.0f);
		this.escenas.add(this.botonesPC, "botonesPC");

		this.txCodigo = new JTextField();
		this.txCodigo.setVisible(false);
		this.txCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		this.txCodigo.setFont(new Font("Tahoma", Font.PLAIN, 38));
		this.txCodigo.setBounds(425, 130, 497, 79);
		this.botonesPC.add(this.txCodigo);
		this.txCodigo.setColumns(10);

		this.lbMensajeError = new JLabel("");
		this.lbMensajeError.setVisible(false);
		this.lbMensajeError.setHorizontalAlignment(SwingConstants.CENTER);
		this.lbMensajeError.setFont(new Font("Tahoma", Font.PLAIN, 35));
		this.lbMensajeError.setBounds(424, 220, 352, 98);
		this.botonesPC.add(this.lbMensajeError);

		this.btnEnviar = new JButton("Enviar");
		this.btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEnviarActivado(e);
			}
		});
		this.btnEnviar.setVisible(false);
		this.btnEnviar.setFont(new Font("Tahoma", Font.PLAIN, 19));
		this.btnEnviar.setBounds(814, 257, 89, 40);
		this.botonesPC.add(this.btnEnviar);

		this.btnPcEncender = new JLabel("");
		this.btnPcEncender.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnPcEncenderActivado(e);
			}
		});
		this.btnPcEncender.setVerifyInputWhenFocusTarget(false);
		this.btnPcEncender.setRequestFocusEnabled(false);
		this.btnPcEncender.setInheritsPopupMenu(false);
		this.btnPcEncender.setFocusable(false);
		this.btnPcEncender.setFocusTraversalKeysEnabled(false);
		this.btnPcEncender.setBounds(302, 11, 717, 634);
		this.botonesPC.add(this.btnPcEncender);

		this.botonesCajaTriangulos = new JPanel();
		this.botonesCajaTriangulos.setLayout(null);
		this.botonesCajaTriangulos.setBorder(null);
		this.botonesCajaTriangulos.setBackground(new Color(0, 0, 0, 0));
		this.botonesCajaTriangulos.setAlignmentY(0.0f);
		this.botonesCajaTriangulos.setAlignmentX(0.0f);
		this.escenas.add(this.botonesCajaTriangulos, "botonesCajaTriangulos");

		this.btnTriangulo1 = new JToggleButton("");
		this.btnTriangulo1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				btnTriangulo1Activado(e);
			}
		});

		this.btnCajaTriangulosVaciar = new JLabel("");
		this.btnCajaTriangulosVaciar.setVisible(false);
		this.btnCajaTriangulosVaciar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnCajaTriangulosVaciarActivado(e);
			}
		});
		this.btnCajaTriangulosVaciar.setVerifyInputWhenFocusTarget(false);
		this.btnCajaTriangulosVaciar.setRequestFocusEnabled(false);
		this.btnCajaTriangulosVaciar.setInheritsPopupMenu(false);
		this.btnCajaTriangulosVaciar.setFocusable(false);
		this.btnCajaTriangulosVaciar.setFocusTraversalKeysEnabled(false);
		this.btnCajaTriangulosVaciar.setBounds(569, 334, 132, 138);
		this.botonesCajaTriangulos.add(this.btnCajaTriangulosVaciar);

		this.btnTriangulo1.setRolloverEnabled(false);
		this.btnTriangulo1.setFocusPainted(false);
		this.btnTriangulo1.setBorder(null);
		this.btnTriangulo1.setBorderPainted(false);
		this.btnTriangulo1.setContentAreaFilled(false);
		this.btnTriangulo1.setVerifyInputWhenFocusTarget(false);
		this.btnTriangulo1.setRequestFocusEnabled(false);
		this.btnTriangulo1.setInheritsPopupMenu(false);
		this.btnTriangulo1.setFocusable(false);
		this.btnTriangulo1.setFocusTraversalKeysEnabled(false);
		this.btnTriangulo1.setBounds(532, 294, 22, 22);
		this.botonesCajaTriangulos.add(this.btnTriangulo1);

		this.btnTriangulo2 = new JToggleButton("");
		this.btnTriangulo2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				btnTriangulo2Activado(e);
			}
		});
		this.btnTriangulo2.setRolloverEnabled(false);
		this.btnTriangulo2.setFocusPainted(false);
		this.btnTriangulo2.setBorder(null);
		this.btnTriangulo2.setBorderPainted(false);
		this.btnTriangulo2.setContentAreaFilled(false);
		this.btnTriangulo2.setVerifyInputWhenFocusTarget(false);
		this.btnTriangulo2.setRequestFocusEnabled(false);
		this.btnTriangulo2.setInheritsPopupMenu(false);
		this.btnTriangulo2.setFocusable(false);
		this.btnTriangulo2.setFocusTraversalKeysEnabled(false);
		this.btnTriangulo2.setBounds(578, 254, 22, 22);
		this.botonesCajaTriangulos.add(this.btnTriangulo2);

		this.btnTriangulo3 = new JToggleButton("");
		this.btnTriangulo3.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				btnTriangulo3Activado(e);
			}
		});
		this.btnTriangulo3.setRolloverEnabled(false);
		this.btnTriangulo3.setFocusPainted(false);
		this.btnTriangulo3.setBorder(null);
		this.btnTriangulo3.setBorderPainted(false);
		this.btnTriangulo3.setContentAreaFilled(false);
		this.btnTriangulo3.setVerifyInputWhenFocusTarget(false);
		this.btnTriangulo3.setRequestFocusEnabled(false);
		this.btnTriangulo3.setInheritsPopupMenu(false);
		this.btnTriangulo3.setFocusable(false);
		this.btnTriangulo3.setFocusTraversalKeysEnabled(false);
		this.btnTriangulo3.setBounds(545, 348, 22, 22);
		this.botonesCajaTriangulos.add(this.btnTriangulo3);

		this.btnTriangulo4 = new JToggleButton("");
		this.btnTriangulo4.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				btnTriangulo4Activado(e);
			}
		});
		this.btnTriangulo4.setRolloverEnabled(false);
		this.btnTriangulo4.setFocusPainted(false);
		this.btnTriangulo4.setBorder(null);
		this.btnTriangulo4.setBorderPainted(false);
		this.btnTriangulo4.setContentAreaFilled(false);
		this.btnTriangulo4.setVerifyInputWhenFocusTarget(false);
		this.btnTriangulo4.setRequestFocusEnabled(false);
		this.btnTriangulo4.setInheritsPopupMenu(false);
		this.btnTriangulo4.setFocusable(false);
		this.btnTriangulo4.setFocusTraversalKeysEnabled(false);
		this.btnTriangulo4.setBounds(594, 307, 22, 22);
		this.botonesCajaTriangulos.add(this.btnTriangulo4);

		this.btnTriangulo5 = new JToggleButton("");
		this.btnTriangulo5.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				btnTriangulo5Activado(e);
			}
		});
		this.btnTriangulo5.setRolloverEnabled(false);
		this.btnTriangulo5.setFocusPainted(false);
		this.btnTriangulo5.setBorder(null);
		this.btnTriangulo5.setBorderPainted(false);
		this.btnTriangulo5.setContentAreaFilled(false);
		this.btnTriangulo5.setVerifyInputWhenFocusTarget(false);
		this.btnTriangulo5.setRequestFocusEnabled(false);
		this.btnTriangulo5.setInheritsPopupMenu(false);
		this.btnTriangulo5.setFocusable(false);
		this.btnTriangulo5.setFocusTraversalKeysEnabled(false);
		this.btnTriangulo5.setBounds(642, 266, 22, 22);
		this.botonesCajaTriangulos.add(this.btnTriangulo5);

		this.btnTriangulo6 = new JToggleButton("");
		this.btnTriangulo6.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				btnTriangulo6Activado(e);
			}
		});
		this.btnTriangulo6.setRolloverEnabled(false);
		this.btnTriangulo6.setFocusPainted(false);
		this.btnTriangulo6.setBorder(null);
		this.btnTriangulo6.setBorderPainted(false);
		this.btnTriangulo6.setContentAreaFilled(false);
		this.btnTriangulo6.setVerifyInputWhenFocusTarget(false);
		this.btnTriangulo6.setRequestFocusEnabled(false);
		this.btnTriangulo6.setInheritsPopupMenu(false);
		this.btnTriangulo6.setFocusable(false);
		this.btnTriangulo6.setFocusTraversalKeysEnabled(false);
		this.btnTriangulo6.setBounds(610, 360, 22, 22);
		this.botonesCajaTriangulos.add(this.btnTriangulo6);

		this.btnTriangulo7 = new JToggleButton("");
		this.btnTriangulo7.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				btnTriangulo7Activado(e);
			}
		});
		this.btnTriangulo7.setRolloverEnabled(false);
		this.btnTriangulo7.setFocusPainted(false);
		this.btnTriangulo7.setBorder(null);
		this.btnTriangulo7.setBorderPainted(false);
		this.btnTriangulo7.setContentAreaFilled(false);
		this.btnTriangulo7.setVerifyInputWhenFocusTarget(false);
		this.btnTriangulo7.setRequestFocusEnabled(false);
		this.btnTriangulo7.setInheritsPopupMenu(false);
		this.btnTriangulo7.setFocusable(false);
		this.btnTriangulo7.setFocusTraversalKeysEnabled(false);
		this.btnTriangulo7.setBounds(662, 319, 22, 22);
		this.botonesCajaTriangulos.add(this.btnTriangulo7);

		this.btnTriangulo8 = new JToggleButton("");
		this.btnTriangulo8.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				btnTriangulo8Activado(e);
			}
		});
		this.btnTriangulo8.setRolloverEnabled(false);
		this.btnTriangulo8.setFocusPainted(false);
		this.btnTriangulo8.setBorder(null);
		this.btnTriangulo8.setBorderPainted(false);
		this.btnTriangulo8.setContentAreaFilled(false);
		this.btnTriangulo8.setVerifyInputWhenFocusTarget(false);
		this.btnTriangulo8.setRequestFocusEnabled(false);
		this.btnTriangulo8.setInheritsPopupMenu(false);
		this.btnTriangulo8.setFocusable(false);
		this.btnTriangulo8.setFocusTraversalKeysEnabled(false);
		this.btnTriangulo8.setBounds(627, 419, 22, 22);
		this.botonesCajaTriangulos.add(this.btnTriangulo8);

		this.btnTriangulo9 = new JToggleButton("");
		this.btnTriangulo9.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				btnTriangulo9Activado(e);
			}
		});
		this.btnTriangulo9.setRolloverEnabled(false);
		this.btnTriangulo9.setFocusPainted(false);
		this.btnTriangulo9.setBorder(null);
		this.btnTriangulo9.setBorderPainted(false);
		this.btnTriangulo9.setContentAreaFilled(false);
		this.btnTriangulo9.setVerifyInputWhenFocusTarget(false);
		this.btnTriangulo9.setRequestFocusEnabled(false);
		this.btnTriangulo9.setInheritsPopupMenu(false);
		this.btnTriangulo9.setFocusable(false);
		this.btnTriangulo9.setFocusTraversalKeysEnabled(false);
		this.btnTriangulo9.setBounds(677, 376, 22, 22);
		this.botonesCajaTriangulos.add(this.btnTriangulo9);

		this.btnTriangulo10 = new JToggleButton("");
		this.btnTriangulo10.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				btnTriangulo10Activado(e);
			}
		});
		this.btnTriangulo10.setRolloverEnabled(false);
		this.btnTriangulo10.setFocusPainted(false);
		this.btnTriangulo10.setBorder(null);
		this.btnTriangulo10.setBorderPainted(false);
		this.btnTriangulo10.setContentAreaFilled(false);
		this.btnTriangulo10.setVerifyInputWhenFocusTarget(false);
		this.btnTriangulo10.setRequestFocusEnabled(false);
		this.btnTriangulo10.setInheritsPopupMenu(false);
		this.btnTriangulo10.setFocusable(false);
		this.btnTriangulo10.setFocusTraversalKeysEnabled(false);
		this.btnTriangulo10.setBounds(723, 332, 22, 22);
		this.botonesCajaTriangulos.add(this.btnTriangulo10);

		this.btnTriangulo11 = new JToggleButton("");
		this.btnTriangulo11.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				btnTriangulo11Activado(e);
			}
		});
		this.btnTriangulo11.setRolloverEnabled(false);
		this.btnTriangulo11.setFocusPainted(false);
		this.btnTriangulo11.setBorder(null);
		this.btnTriangulo11.setBorderPainted(false);
		this.btnTriangulo11.setContentAreaFilled(false);
		this.btnTriangulo11.setVerifyInputWhenFocusTarget(false);
		this.btnTriangulo11.setRequestFocusEnabled(false);
		this.btnTriangulo11.setInheritsPopupMenu(false);
		this.btnTriangulo11.setFocusable(false);
		this.btnTriangulo11.setFocusTraversalKeysEnabled(false);
		this.btnTriangulo11.setBounds(695, 435, 22, 22);
		this.botonesCajaTriangulos.add(this.btnTriangulo11);

		this.btnTriangulo12 = new JToggleButton("");
		this.btnTriangulo12.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				btnTriangulo12Activado(e);
			}
		});
		this.btnTriangulo12.setRolloverEnabled(false);
		this.btnTriangulo12.setFocusPainted(false);
		this.btnTriangulo12.setBorder(null);
		this.btnTriangulo12.setBorderPainted(false);
		this.btnTriangulo12.setContentAreaFilled(false);
		this.btnTriangulo12.setVerifyInputWhenFocusTarget(false);
		this.btnTriangulo12.setRequestFocusEnabled(false);
		this.btnTriangulo12.setInheritsPopupMenu(false);
		this.btnTriangulo12.setFocusable(false);
		this.btnTriangulo12.setFocusTraversalKeysEnabled(false);
		this.btnTriangulo12.setBounds(745, 390, 22, 22);
		this.botonesCajaTriangulos.add(this.btnTriangulo12);

		this.botonesPerchero = new JPanel();
		this.botonesPerchero.setLayout(null);
		this.botonesPerchero.setBorder(null);
		this.botonesPerchero.setBackground(new Color(0, 0, 0, 0));
		this.botonesPerchero.setAlignmentY(0.0f);
		this.botonesPerchero.setAlignmentX(0.0f);
		this.escenas.add(this.botonesPerchero, "botonesPerchero");

		this.btnDestornilladorParte = new JLabel("");
		this.btnDestornilladorParte.setVisible(false);
		this.btnDestornilladorParte.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnDestornilladorParteActivado(e);
			}
		});
		this.btnDestornilladorParte.setVerifyInputWhenFocusTarget(false);
		this.btnDestornilladorParte.setRequestFocusEnabled(false);
		this.btnDestornilladorParte.setInheritsPopupMenu(false);
		this.btnDestornilladorParte.setFocusable(false);
		this.btnDestornilladorParte.setFocusTraversalKeysEnabled(false);
		this.btnDestornilladorParte.setBounds(443, 182, 56, 21);
		this.botonesPerchero.add(this.btnDestornilladorParte);

		this.btnPuertaCuadrado = new JLabel("");
		this.btnPuertaCuadrado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnPuertaCuadradoActivado(e);
			}
		});
		this.btnPuertaCuadrado.setVerifyInputWhenFocusTarget(false);
		this.btnPuertaCuadrado.setRequestFocusEnabled(false);
		this.btnPuertaCuadrado.setInheritsPopupMenu(false);
		this.btnPuertaCuadrado.setFocusable(false);
		this.btnPuertaCuadrado.setFocusTraversalKeysEnabled(false);
		this.btnPuertaCuadrado.setBounds(607, 0, 386, 638);
		this.botonesPerchero.add(this.btnPuertaCuadrado);

		this.botonesPuertaCirculo = new JPanel();
		this.botonesPuertaCirculo.setLayout(null);
		this.botonesPuertaCirculo.setBorder(null);
		this.botonesPuertaCirculo.setBackground(new Color(0, 0, 0, 0));
		this.botonesPuertaCirculo.setAlignmentY(0.0f);
		this.botonesPuertaCirculo.setAlignmentX(0.0f);
		this.escenas.add(this.botonesPuertaCirculo, "botonesPuertaCirculo");

		this.pwPuertaCirculo = new JPasswordField();
		this.pwPuertaCirculo.setSelectedTextColor(UIManager.getColor("Button.focus"));
		this.pwPuertaCirculo.setSelectionColor(UIManager.getColor("Button.background"));
		this.pwPuertaCirculo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				pwPuertaCirculoActivado(e);
			}
		});
		this.pwPuertaCirculo.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				pwPuertaCirculoActivado(e);
			}
		});
		this.pwPuertaCirculo.setCaretColor(Color.GREEN);
		this.pwPuertaCirculo.setEchoChar('*');
		this.pwPuertaCirculo.setForeground(new Color(66, 244, 128));
		this.pwPuertaCirculo.setBackground(new Color(0,0,0,0));
		this.pwPuertaCirculo.setBorder(null);
		this.pwPuertaCirculo.setFont(new Font("Tahoma", Font.PLAIN, 33));
		this.pwPuertaCirculo.setHorizontalAlignment(SwingConstants.CENTER);
		this.pwPuertaCirculo.setBounds(625, 106, 88, 33);
		this.botonesPuertaCirculo.add(this.pwPuertaCirculo);

		this.btnAbrirPuertaCirculo = new JButton("");
		this.btnAbrirPuertaCirculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAbrirPuertaCirculoActivado(e);
			}
		});
		this.btnAbrirPuertaCirculo.setIconTextGap(0);
		this.btnAbrirPuertaCirculo.setAlignmentY(0.0f);
		this.btnAbrirPuertaCirculo.setVerifyInputWhenFocusTarget(false);
		this.btnAbrirPuertaCirculo.setRolloverEnabled(false);
		this.btnAbrirPuertaCirculo.setRequestFocusEnabled(false);
		this.btnAbrirPuertaCirculo.setHorizontalTextPosition(SwingConstants.CENTER);
		this.btnAbrirPuertaCirculo.setBackground(new Color(0,0,0,0));
		this.btnAbrirPuertaCirculo.setContentAreaFilled(false);
		this.btnAbrirPuertaCirculo.setBorderPainted(false);
		this.btnAbrirPuertaCirculo.setBorder(null);
		this.btnAbrirPuertaCirculo.setBounds(635, 329, 68, 68);
		this.botonesPuertaCirculo.add(this.btnAbrirPuertaCirculo);
		this.btnAbrirPuertaCirculo.setOpaque(true);
		
		this.btnFinalActivado = new JButton("");
		this.btnFinalActivado.setVisible(false);
		this.btnFinalActivado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnFinalActivadoActivado(e);
			}
		});
		this.btnFinalActivado.setVerifyInputWhenFocusTarget(false);
		this.btnFinalActivado.setRolloverEnabled(false);
		this.btnFinalActivado.setRequestFocusEnabled(false);
		this.btnFinalActivado.setOpaque(true);
		this.btnFinalActivado.setIconTextGap(0);
		this.btnFinalActivado.setHorizontalTextPosition(SwingConstants.CENTER);
		this.btnFinalActivado.setContentAreaFilled(false);
		this.btnFinalActivado.setBorderPainted(false);
		this.btnFinalActivado.setBorder(null);
		this.btnFinalActivado.setBackground(new Color(0, 0, 0, 0));
		this.btnFinalActivado.setAlignmentY(0.0f);
		this.btnFinalActivado.setBounds(0, 0, 1280, 720);
		this.botonesPuertaCirculo.add(this.btnFinalActivado);

		this.botonesPuertaCuadrado = new JPanel();
		this.botonesPuertaCuadrado.setLayout(null);
		this.botonesPuertaCuadrado.setBorder(null);
		this.botonesPuertaCuadrado.setBackground(new Color(0, 0, 0, 0));
		this.botonesPuertaCuadrado.setAlignmentY(0.0f);
		this.botonesPuertaCuadrado.setAlignmentX(0.0f);
		this.escenas.add(this.botonesPuertaCuadrado, "botonesPuertaCuadrado");

		this.pwPuertaCuadrado = new JPasswordField();
		this.pwPuertaCuadrado.setSelectedTextColor(UIManager.getColor("Button.focus"));
		this.pwPuertaCuadrado.setSelectionColor(UIManager.getColor("Button.background"));
		this.pwPuertaCuadrado.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				pwPuertaCuadradoCaretActivado(e);
			}
		});
		this.pwPuertaCuadrado.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				pwPuertaCuadradoActivado(e);
			}
		});
		
		this.pwPuertaCuadrado.setCaretColor(Color.GREEN);
		this.pwPuertaCuadrado.setEchoChar('*');
		this.pwPuertaCuadrado.setForeground(new Color(66, 244, 128));
		this.pwPuertaCuadrado.setBackground(new Color(0,0,0,0));
		this.pwPuertaCuadrado.setBorder(null);
		this.pwPuertaCuadrado.setFont(new Font("Tahoma", Font.PLAIN, 35));
		this.pwPuertaCuadrado.setHorizontalAlignment(SwingConstants.CENTER);
		this.pwPuertaCuadrado.setBounds(695, 99, 94, 40);
		this.botonesPuertaCuadrado.add(this.pwPuertaCuadrado);

		this.btnAbrirPuertaCuadrado = new JButton("");
		this.btnAbrirPuertaCuadrado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAbrirPuertaCuadradoActivado(e);
			}
		});
		this.btnAbrirPuertaCuadrado.setIconTextGap(0);
		this.btnAbrirPuertaCuadrado.setAlignmentY(0.0f);
		this.btnAbrirPuertaCuadrado.setVerifyInputWhenFocusTarget(false);
		this.btnAbrirPuertaCuadrado.setRolloverEnabled(false);
		this.btnAbrirPuertaCuadrado.setRequestFocusEnabled(false);
		this.btnAbrirPuertaCuadrado.setHorizontalTextPosition(SwingConstants.CENTER);
		this.btnAbrirPuertaCuadrado.setBackground(new Color(0,0,0,0));
		this.btnAbrirPuertaCuadrado.setContentAreaFilled(false);
		this.btnAbrirPuertaCuadrado.setBorderPainted(false);
		this.btnAbrirPuertaCuadrado.setBorder(null);
		this.btnAbrirPuertaCuadrado.setBounds(695, 354, 78, 74);
		this.botonesPuertaCuadrado.add(this.btnAbrirPuertaCuadrado);
		this.btnAbrirPuertaCuadrado.setOpaque(true);
		
		this.btnFinalActivado2 = new JButton("");
		this.btnFinalActivado2.setVisible(false);
		this.btnFinalActivado2.setVerifyInputWhenFocusTarget(false);
		this.btnFinalActivado2.setRolloverEnabled(false);
		this.btnFinalActivado2.setRequestFocusEnabled(false);
		this.btnFinalActivado2.setOpaque(true);
		this.btnFinalActivado2.setIconTextGap(0);
		this.btnFinalActivado2.setHorizontalTextPosition(SwingConstants.CENTER);
		this.btnFinalActivado2.setContentAreaFilled(false);
		this.btnFinalActivado2.setBorderPainted(false);
		this.btnFinalActivado2.setBorder(null);
		this.btnFinalActivado2.setBackground(new Color(0, 0, 0, 0));
		this.btnFinalActivado2.setAlignmentY(0.0f);
		this.btnFinalActivado2.setBounds(0, 0, 1280, 720);
		this.botonesPuertaCuadrado.add(this.btnFinalActivado2);
		this.btnFinalActivado2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnFinalActivado2Activado(e);
			}
		});
		this.botonesFinal = new JPanel();
		this.botonesFinal.setLayout(null);
		this.botonesFinal.setBorder(null);
		this.botonesFinal.setBackground(new Color(0, 0, 0, 0));
		this.botonesFinal.setAlignmentY(0.0f);
		this.botonesFinal.setAlignmentX(0.0f);
		this.escenas.add(this.botonesFinal, "name_130137824334800");
		
		this.agregarEscenasALista();
	}

	protected void agregarEscenasALista() {
		this.listaBotonesEscenas.put("inicio", this.inicio);
		this.listaBotonesEscenas.put("salon", this.botonesSalon);
		this.listaBotonesEscenas.put("estanteria", this.botonesEstanteria);
		this.listaBotonesEscenas.put("cuadros", this.botonesCuadros);
		this.listaBotonesEscenas.put("ventana", this.botonesVentana);
		this.listaBotonesEscenas.put("planta", this.botonesPlanta);
		this.listaBotonesEscenas.put("sofa", this.botonesSofa);
		this.listaBotonesEscenas.put("recibidor", this.botonesRecibidor);
		this.listaBotonesEscenas.put("mueble", this.botonesMueble);
		this.listaBotonesEscenas.put("cajacandado", this.botonesCajaCandado);
		this.listaBotonesEscenas.put("cajatornillos", this.botonesCajaTornillos);
		this.listaBotonesEscenas.put("cajatriangulos", this.botonesCajaTriangulos);
		this.listaBotonesEscenas.put("ordenador", this.botonesPC);
		this.listaBotonesEscenas.put("television", this.botonesTV);
		this.listaBotonesEscenas.put("puertacirculo", this.botonesPuertaCirculo);
		this.listaBotonesEscenas.put("puertacuadrado", this.botonesPuertaCuadrado);
		this.listaBotonesEscenas.put("perchero", this.botonesPerchero);
		this.listaBotonesEscenas.put("final", this.botonesFinal);
	}

	//////////////////// Interfaz /////////////////////////////////////

	// Mover la ventana
	protected void obtenerPuntoInicialRaton(MouseEvent arg0) {puntoInicial = arg0.getPoint();}
	protected void moverVentana(MouseEvent arg0) {this.setLocation(this.getLocation().x + arg0.getX() - puntoInicial.x, this.getLocation().y + arg0.getY() - puntoInicial.y);}

	// Boton cerrar
	protected void btnCerrarActivado() {System.exit(0);}
	protected void btnCerrarHoverIn() {	this.btnCerrar.setBackground(negroHover);	}
	protected void btnCerrarHoverOut() {this.btnCerrar.setBackground(negro);}

	// Boton guardar
	protected void btnGuardarActivado() {this.vista.guardarPartida(); }
	protected void btnGuardarHoverOut() {this.btnGuardar.setBackground(azul);	}
	protected void btnGuardarHoverIn() {this.btnGuardar.setBackground(azulHover);	}

	// Boton Inicio
	protected void btnInicioActivado() {
		this.vista.mostrarInventario(false);
		this.vista.mostrarInfoObjeto(false);
		this.vista.mostrarMensaje(false);
		cambiarEscena("inicio", "normal");
	}

	protected void btnInicioHoverOut() { this.btnInicio.setBackground(negro);}
	protected void btnInicioHoverIn() {	this.btnInicio.setBackground(negroHover);	}

	// Botones de dirección
	protected void izquierdaActivado(MouseEvent e) {
		String izquierda = this.vista.getEscena(this.vista.getEscenaActual()).getIzquierda();
		this.cambiarEscena(izquierda, this.vista.getEscena(izquierda).getEstado());
	}
	protected void izquierdaHoverInActivado(MouseEvent e) {
		this.izquierda.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/img/Interfaz/izqHover.png")).getImage().getScaledInstance(83, 720, Image.SCALE_SMOOTH)));
	}
	protected void izquierdaHoverOutActivado(MouseEvent e) {
		this.izquierda.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/img/Interfaz/izq.png")).getImage().getScaledInstance(83, 720, Image.SCALE_SMOOTH)));
	}
	protected void derechaActivado(MouseEvent e) {
		String derecha = this.vista.getEscena(this.vista.getEscenaActual()).getDerecha();
		this.cambiarEscena(derecha, this.vista.getEscena(derecha).getEstado());
	}
	protected void derechaHoverInActivado(MouseEvent e) {
		this.derecha.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/img/Interfaz/derHover.png")).getImage().getScaledInstance(83, 720, Image.SCALE_SMOOTH)));
	}
	protected void derechaHoverOutActivado(MouseEvent e) {
		this.derecha.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/img/Interfaz/der.png")).getImage().getScaledInstance(83, 720, Image.SCALE_SMOOTH)));
	}
	protected void abajoActivado(MouseEvent e) {
		String abajo = this.vista.getEscena(this.vista.getEscenaActual()).getAbajo();
		this.cambiarEscena(abajo, this.vista.getEscena(abajo).getEstado());
	}
	protected void abajoHoverInActivado(MouseEvent e) {
		this.abajo.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/img/Interfaz/abaHover.png")).getImage().getScaledInstance(1280, 83, Image.SCALE_SMOOTH)));
	}
	protected void abajoHoverOutActivado(MouseEvent e) {
		this.abajo.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/img/Interfaz/aba.png")).getImage().getScaledInstance(1280, 83, Image.SCALE_SMOOTH)));
	}

	// Boton de inventario
	protected void btnInventarioActivado(MouseEvent e) { this.vista.mostrarInventario(true); }

	private void repintarBotonesInterfaz(String nombreEscena) {
		this.derecha.setVisible(false);
		this.izquierda.setVisible(false);
		this.abajo.setVisible(false);
		this.btnInventario.setVisible(false);
		if (!nombreEscena.equals("inicio")) {
			this.btnInventario.setVisible(true);
		}
		if (this.vista.getEscena(nombreEscena).getAbajo() != null) {
			this.abajo.setVisible(true);
		}
		if (this.vista.getEscena(nombreEscena).getDerecha() != null) {
			this.derecha.setVisible(true);
		}
		if (this.vista.getEscena(nombreEscena).getIzquierda() != null) {
			this.izquierda.setVisible(true);
		}
	}

	// Menu inicial
	protected void botonIncioPasaPorEncima(String boton) {
		ImageIcon icono = new ImageIcon(
				new ImageIcon(this.getClass().getResource("/img/Interfaz/boton.png")).getImage().getScaledInstance(290, 57, Image.SCALE_SMOOTH));
		pasarRatonInicio(boton, icono);
	}
	protected void botonIncioSaleDeEncima(String boton) {	pasarRatonInicio(boton, null);}

	protected void pasarRatonInicio(String boton, ImageIcon icono) {
		this.lbFondo.setVisible(false);
		if (boton.equals("continuar")) {
			this.continuar.setIcon(icono);
		}
		if (boton.equals("nuevaPartida")) {
			this.nuevaPartida.setIcon(icono);
		}
		if (boton.equals("salir")) {
			this.salir.setIcon(icono);
		}
		this.lbFondo.setVisible(true);
	}

	protected void nuevaPartidaActivado(MouseEvent e) {
		this.vista.iniciarPartida();
		this.cambiarEscena("salon", "normal");
		this.reactivarBotones();
		this.vista.actualizaInventario();
		this.vista.mostrarInventario(false);
	}

	protected void continuarActivado(MouseEvent e) {
		if(this.vista.cargarPartida() == Modelo.CORRECTO) {
			this.actualizaEscena();
			this.vista.actualizaInventario();
			this.reactivarBotones();
		}
	}
	protected void salirActivado(MouseEvent e) {System.exit(0);}

	protected void exportarActivado(MouseEvent e) {
		int opcion = this.selectorFichero.showSaveDialog(this);
		if (opcion == JFileChooser.APPROVE_OPTION) {
			File ficheroSeleccionado = this.selectorFichero.getSelectedFile();
			this.vista.exportarPartida(ficheroSeleccionado);
		}
	}

	protected void importarActivado(MouseEvent e) {
		int opcion = this.selectorFichero.showOpenDialog(this);
		if (opcion == JFileChooser.APPROVE_OPTION) {
			File ficheroSeleccionado = this.selectorFichero.getSelectedFile();
			this.vista.importarPartida(ficheroSeleccionado);
		}
	}

	// Métodos de Escenas
	protected void cambiarFondo(String nombre, String estado) {
		this.lbFondo.setVisible(false);
		this.lbFondo.setIcon(new ImageIcon(
				new ImageIcon(this.getClass().getResource(this.vista.getFondoEscena(nombre, estado))).getImage()
				.getScaledInstance(lbFondo.getWidth(), lbFondo.getHeight(), Image.SCALE_SMOOTH)));
		repintarBotonesInterfaz(nombre);
		this.lbFondo.setVisible(true);
	}

	protected void cambiarEscena(String escena, String estado) {
		for (String esc : this.listaBotonesEscenas.keySet()) {
			this.listaBotonesEscenas.get(esc).setVisible(false);
		}
		this.listaBotonesEscenas.get(escena).setVisible(true);
		this.cambiarFondo(escena, estado);
		this.vista.setEscenaActual(escena);
	}

	protected void actualizaEscena() {this.cambiarEscena(this.vista.getEscenaActual(), this.vista.getEscena(this.vista.getEscenaActual()).getEstado());}

	protected void reactivarBotonesObjetos(String objeto,JLabel boton) {
		if(this.vista.getObjeto(objeto).isObtenido() || this.vista.getObjeto(objeto).isUsado()) {	boton.setVisible(false);}
		else {boton.setVisible(true);	}
	}
	protected void reactivarBotones() {
		this.reactivarBotonesObjetos("Nota",this.btnNota);
		this.reactivarBotonesObjetos("Destornillador plano",this.btnDestornilladorParte);
		this.reactivarBotonesObjetos("Llave",this.btnLlavePlanta);

		if(this.vista.getEscenaActual().equals("ordenador") && this.vista.getEscena("ordenador").getEstado().equals("ventanaCodigo")) {
			this.txCodigo.setVisible(true);
			this.lbMensajeError.setVisible(true);
			this.btnEnviar.setVisible(true);
		}
	}

	//////////////// Interacción con objetos //////////////////////////

	////// Salón ///////
	// Estantería
	protected void irAEstanteriaActivado(MouseEvent e) {this.cambiarEscena("estanteria", "normal");	}

	// Caja Candado
	protected void btnCajaCandadoActivado(MouseEvent e) {
		this.cambiarEscena("cajacandado", this.vista.getEscena("cajacandado").getEstado());
		if(this.vista.getEscena("cajacandado").getEstado().equals("cerrada") && !this.vista.getObjeto("Llave").isUsado()) {
			this.btnCajaCandadoAbrir.setVisible(true);
		}
	}
	protected void btnCajaCandadoAbrirActivado(MouseEvent e) {
		if(this.vista.objetoSeleccionado().equals("Llave") && this.vista.getEscena("cajacandado").getEstado().equals("cerrada") ) {
			this.vista.cambiarEstado("cajacandado", "abierta");
			this.btnCajaCandadoVaciar.setVisible(true);
			this.btnCajaCandadoAbrir.setVisible(false);
			this.actualizaEscena();
			this.vista.quitarObjeto("Llave");
			this.vista.objetoUsado("Llave");
			this.vista.actualizaInventario();

		}
		else if(this.vista.getEscena("cajacandado").getEstado().equals("abierta")){
			this.btnCajaCandadoAbrir.setVisible(false);
			this.btnCajaCandadoVaciar.setVisible(true);
		}
	}
	protected void btnCajaCandadoVaciarActivado(MouseEvent e) {

		this.vista.cambiarEstado("cajacandado", "vacia");
		this.btnCajaCandadoVaciar.setVisible(false);
		this.actualizaEscena();
		this.vista.obtenerObjeto("Mango");
		this.vista.obtenerObjeto("Llave modular");
		this.vista.actualizaInventario();
	}

	// Caja Tornillos
	protected void btnCajaTornilloActivado(MouseEvent e) {
		this.cambiarEscena("cajatornillos", this.vista.getEscena("cajatornillos").getEstado());
		if(this.vista.getEscena("cajatornillos").getEstado().equals("cerrada") && !this.vista.getObjeto("Destornillador").isUsado()) {
			this.btnCajaTornillosAbrir.setVisible(true);
		}
	}
	protected void btnCajaTornillosAbrirActivado(MouseEvent e) {
		if(this.vista.objetoSeleccionado().equals("Destornillador") && this.vista.getEscena("cajatornillos").getEstado().equals("cerrada")) {
			this.vista.cambiarEstado("cajatornillos", "abierta");
			this.btnCajaTornillosVaciar.setVisible(true);
			this.btnCajaTornillosAbrir.setVisible(false);
			this.actualizaEscena();
			this.vista.quitarObjeto("Destornillador");
			this.vista.objetoUsado("Destornillador");
		}
	}

	protected void btnCajaTornillosVaciarActivado(MouseEvent e) {
		this.vista.cambiarEstado("cajatornillos", "vacia");
		this.btnCajaTornillosVaciar.setVisible(false);
		this.actualizaEscena();
		this.vista.obtenerObjeto("Batería");
		this.vista.obtenerObjeto("Nota adhesiva");
		this.vista.actualizaInventario();
	}
	// Sofa y mesita
	protected void btnSofaActivado(MouseEvent e) {this.cambiarEscena("sofa", this.vista.getEscena("sofa").getEstado());}
	protected void btnNotaActivado(MouseEvent e) {
		this.btnNota.setVisible(false);
		this.vista.cambiarEstado("salon", "vacio");
		this.vista.cambiarEstado("sofa", "vacio");
		this.actualizaEscena();
		this.vista.obtenerObjeto("Nota");
		this.vista.actualizaInventario();
	}

	// Mueble
	protected void btnMuebleActivado(MouseEvent e) {this.cambiarEscena("mueble", this.vista.getEscena("mueble").getEstado());}
	protected void btnPCActivado(MouseEvent e) {
		this.cambiarEscena("ordenador", this.vista.getEscena("ordenador").getEstado());
		if(this.vista.getEscena("ordenador").getEstado().equals("normal") && !this.vista.getObjeto("Tarjeta de memoria").isUsado()) {
			this.btnPcEncender.setVisible(true);
		}
		if(this.vista.getEscena("ordenador").getEstado().equals("ventanaCodigo")) {
			this.btnEnviar.setVisible(true);
			this.txCodigo.setVisible(true);
			this.lbMensajeError.setVisible(true);
		}
		else {
			this.btnEnviar.setVisible(false);
			this.txCodigo.setVisible(false);
			this.lbMensajeError.setVisible(false);
		}
	}
	protected void btnTVActivado(MouseEvent e) {
		this.cambiarEscena("television", this.vista.getEscena("television").getEstado());
		if(this.vista.getEscena("television").getEstado().equals("apagada") && !this.vista.getObjeto("Mando a distancia").isUsado()) {
			this.btnEncenderTV.setVisible(true);
		}
	}

	// Caja triangulo
	protected void btnCajaTriangulosActivado(MouseEvent e) {
		this.cambiarEscena("cajatriangulos", this.vista.getEscena("cajatriangulos").getEstado());
		if(this.vista.getEscena("cajatriangulos").getEstado().equals("cerrada")) {
			this.btnTriangulo1.setVisible(true);
			this.btnTriangulo2.setVisible(true);
			this.btnTriangulo3.setVisible(true);
			this.btnTriangulo4.setVisible(true);
			this.btnTriangulo5.setVisible(true);
			this.btnTriangulo6.setVisible(true);
			this.btnTriangulo7.setVisible(true);
			this.btnTriangulo8.setVisible(true);
			this.btnTriangulo9.setVisible(true);
			this.btnTriangulo10.setVisible(true);
			this.btnTriangulo11.setVisible(true);
			this.btnTriangulo12.setVisible(true);
		}
	}
	private void activarDesactivarTriangulo(JToggleButton triangulo) {
		triangulo.setVisible(false);
		if(triangulo.isSelected()) {
			triangulo.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/img/Interfaz/pulsado.png")).getImage().getScaledInstance(22, 22, Image.SCALE_SMOOTH)));
		}
		else {
			triangulo.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/img/Interfaz/vacio.png")).getImage().getScaledInstance(22, 22, Image.SCALE_SMOOTH)));
		}

		actualizaEscena();
		triangulo.setVisible(true);
	}
	protected void btnTriangulo1Activado(ItemEvent e) {activarDesactivarTriangulo(this.btnTriangulo1); comprobarTriangulos();}
	protected void btnTriangulo2Activado(ItemEvent e) {activarDesactivarTriangulo(this.btnTriangulo2); comprobarTriangulos();}
	protected void btnTriangulo3Activado(ItemEvent e) {activarDesactivarTriangulo(this.btnTriangulo3); comprobarTriangulos();}
	protected void btnTriangulo4Activado(ItemEvent e) {activarDesactivarTriangulo(this.btnTriangulo4); comprobarTriangulos();}
	protected void btnTriangulo5Activado(ItemEvent e) {activarDesactivarTriangulo(this.btnTriangulo5); comprobarTriangulos();}
	protected void btnTriangulo6Activado(ItemEvent e) {activarDesactivarTriangulo(this.btnTriangulo6); comprobarTriangulos();}
	protected void btnTriangulo7Activado(ItemEvent e) {activarDesactivarTriangulo(this.btnTriangulo7); comprobarTriangulos();}
	protected void btnTriangulo8Activado(ItemEvent e) {activarDesactivarTriangulo(this.btnTriangulo8); comprobarTriangulos();}
	protected void btnTriangulo9Activado(ItemEvent e) {activarDesactivarTriangulo(this.btnTriangulo9); comprobarTriangulos();}
	protected void btnTriangulo10Activado(ItemEvent e) {activarDesactivarTriangulo(this.btnTriangulo10); comprobarTriangulos();}
	protected void btnTriangulo11Activado(ItemEvent e) {activarDesactivarTriangulo(this.btnTriangulo11); comprobarTriangulos();}
	protected void btnTriangulo12Activado(ItemEvent e) {activarDesactivarTriangulo(this.btnTriangulo12); comprobarTriangulos();}

	private void comprobarTriangulos() {
		if(this.btnTriangulo1.isSelected() && this.btnTriangulo5.isSelected() && this.btnTriangulo6.isSelected() && this.btnTriangulo9.isSelected() && this.btnTriangulo12.isSelected()
				&& !this.btnTriangulo2.isSelected() && !this.btnTriangulo3.isSelected() && !this.btnTriangulo4.isSelected() && !this.btnTriangulo7.isSelected() && !this.btnTriangulo8.isSelected() 
				&& !this.btnTriangulo10.isSelected() && !this.btnTriangulo11.isSelected() ) {
			this.vista.cambiarEstado("cajatriangulos", "abierta");
			this.btnTriangulo1.setVisible(false);
			this.btnTriangulo2.setVisible(false);
			this.btnTriangulo3.setVisible(false);
			this.btnTriangulo4.setVisible(false);
			this.btnTriangulo5.setVisible(false);
			this.btnTriangulo6.setVisible(false);
			this.btnTriangulo7.setVisible(false);
			this.btnTriangulo8.setVisible(false);
			this.btnTriangulo9.setVisible(false);
			this.btnTriangulo10.setVisible(false);
			this.btnTriangulo11.setVisible(false);
			this.btnTriangulo12.setVisible(false);
			this.btnCajaTriangulosVaciar.setVisible(true);
			this.actualizaEscena();
		}
	}
	protected void btnCajaTriangulosVaciarActivado(MouseEvent e) {
		this.vista.cambiarEstado("cajatriangulos", "vacia");
		this.btnCajaTriangulosVaciar.setVisible(false);
		this.actualizaEscena();
		this.vista.obtenerObjeto("Hexágono");
		this.vista.actualizarVentanaInventario();
	}

	// Ordenador
	protected void btnPcEncenderActivado(MouseEvent e) {
		if(this.vista.objetoSeleccionado().equals("Tarjeta de memoria") && !this.vista.getObjeto("Tarjeta de memoria").isUsado()) {
			this.vista.cambiarEstado("ordenador", "ventanaCodigo");
			this.txCodigo.setText("");
			this.txCodigo.setVisible(true);
			this.lbMensajeError.setVisible(true);
			this.btnEnviar.setVisible(true);
			this.vista.quitarObjeto("Tarjeta de memoria");
			this.vista.objetoUsado("Tarjeta de memoria");
			this.btnPcEncender.setVisible(false);
			this.actualizaEscena();
		}
	}
	protected void btnEnviarActivado(ActionEvent e) {
		if(this.txCodigo.getText().equalsIgnoreCase("daw-ivo")){
			if(!this.vista.getObjeto("Mando a distancia").isUsado()) {
				this.lbMensajeError.setText("¿TV apagada?");
				this.txCodigo.setText("");
			}
			else if(this.vista.getEleccion() == -1) {
				this.vista.cambiarEstado("television", "eleccion");
				this.lbMensajeError.setText("Código Aceptado");
				this.txCodigo.setText("");
				this.btnMandoCirculo.setVisible(true);
				this.btnMandoCuadrado.setVisible(true);
			}
		}
		else if(this.txCodigo.getText().equalsIgnoreCase("india") && this.vista.getEleccion() != -1){
			this.txCodigo.setVisible(false);
			this.lbMensajeError.setVisible(false);
			this.btnEnviar.setVisible(false);
			this.vista.cambiarEstado("ordenador", "ventanaInforme");
		}
		else {
			this.lbMensajeError.setText("Código erróneo");
			this.lbMensajeError.setVisible(false);
			this.lbMensajeError.setVisible(true);
			this.txCodigo.setText("");
		}
		this.actualizaEscena();
	}

	// Televisión
	protected void btnEncenderTVActivado(MouseEvent e) {
		if(this.vista.objetoSeleccionado().equals("Mando a distancia") && this.vista.getObjeto("Batería").isUsado()) {
			this.vista.cambiarEstado("television", "encendida");
			this.vista.quitarObjeto("Mando a distancia");
			this.vista.objetoUsado("Mando a distancia");
			this.vista.actualizaInventario();
			this.btnEncenderTV.setVisible(false);
			this.actualizaEscena();
		}
	}

	protected void btnMandoCuadradoActivado(MouseEvent e) {
		this.vista.setEleccion(Modelo.CUADRADO);
		this.enviarCarta();
		this.vista.cambiarEstado("television", "ecuacionCuadrado");
		this.actualizaEscena();
	}

	protected void btnMandoCirculoActivado(MouseEvent e) {
		this.vista.setEleccion(Modelo.CIRCULO);
		this.enviarCarta();
		this.vista.cambiarEstado("television", "ecuacionCirculo");
		this.actualizaEscena();
	}

	private void enviarCarta() {
		this.btnMandoCirculo.setVisible(false);
		this.btnMandoCuadrado.setVisible(false);
		if(this.vista.getEleccion() == Modelo.CIRCULO) {
			this.vista.cambiarEstado("entrada", "sobreCirculo");
		}
		else {
			this.vista.cambiarEstado("entrada", "sobreCuadrado");
		}
		this.btnCarta.setVisible(true);
	}
	////// Ventana ///////
	protected void btnPuertasIzqActivado(MouseEvent e) {
		if (!this.vista.getEscena("ventana").getEstado().equals("abiertoIzq")) {
			this.vista.cambiarEstado("ventana", "abiertoIzq");
		}
		else {
			this.vista.cambiarEstado("ventana", "normal");
		}
		this.actualizaEscena();
	}

	protected void btnPuertasDerActivado(MouseEvent e) {
		if (!this.vista.getEscena("ventana").getEstado().equals("abiertoDer")) {
			if (!this.vista.getObjeto("Mando a distancia").isObtenido()) {
				this.btnMando.setVisible(true);
			}
			this.vista.cambiarEstado("ventana", "abiertoDer");
		}
		else {
			this.vista.cambiarEstado("ventana", "normal");
			this.btnMando.setVisible(false);
		}
		this.actualizaEscena();
	}

	protected void btnMandoActivado(MouseEvent e) {
		if(!this.vista.getObjeto("Mando a distancia").isObtenido() && !this.vista.getObjeto("Mando a distancia").isUsado()) {
		this.btnMando.setVisible(false);
		String vaciar = this.vista.getEscena("ventana").getFondos().get("abiertoDer").replace("ventanaDerAbierto", "ventanaDerVacio");
		this.vista.getEscena("ventana").getFondos().remove("abiertoDer");
		this.vista.getEscena("ventana").getFondos().put("abiertoDer", vaciar);
		this.actualizaEscena();	
		this.vista.obtenerObjeto("Mando a distancia");
		this.vista.actualizaInventario();
		}
	}

	////// Entrada ///////
	// Planta
	protected void btnPlantaActivado(MouseEvent e) {this.cambiarEscena("planta", this.vista.getEscena("planta").getEstado());}

	protected void btnLlavePlantaActivado(MouseEvent e) {
		if(!this.vista.getObjeto("Llave").isObtenido() && !this.vista.getObjeto("Llave").isUsado()) {
			this.btnLlavePlanta.setVisible(false);
			this.vista.cambiarEstado("planta", "vacio");
			this.actualizaEscena();
			this.vista.obtenerObjeto("Llave");
			this.vista.actualizaInventario();
		}
	}

	// Recibidor
	protected void btnRecibidorActivado(MouseEvent e) {this.cambiarEscena("recibidor", this.vista.getEscena("recibidor").getEstado());}

	protected void btnRecibidorArribaActivado(MouseEvent e) {
		if (this.vista.objetoSeleccionado().equals("Llave modular") && !this.vista.getEscena("recibidor").getEstado().equals("abiertoArriba")) {
			this.vista.cambiarEstado("recibidor", "abiertoArriba");
			if(!this.vista.getObjeto("Cámara").isObtenido() && !this.vista.getObjeto("Cámara").isUsado()) {
				this.btnRecibidorArribaVaciar.setVisible(true);
			}
			this.vista.quitarObjeto("Llave modular");
			this.vista.objetoUsado("Llave modular");
			this.vista.actualizaInventario();
		}
		else if (this.vista.getObjeto("Llave modular").isUsado() && !this.vista.getEscena("recibidor").getEstado().equals("abiertoArriba")) {
			this.vista.cambiarEstado("recibidor", "abiertoArriba");
			if(!this.vista.getObjeto("Cámara").isObtenido() && !this.vista.getObjeto("Cámara").isUsado()) {
				this.btnRecibidorArribaVaciar.setVisible(true);
			}
		}
		else {
			this.vista.cambiarEstado("recibidor", "normal");
			this.btnRecibidorArribaVaciar.setVisible(false);
		}
		this.actualizaEscena();
	}
	protected void btnRecibidorArribaVaciarActivado(MouseEvent e) {
		this.btnRecibidorArribaVaciar.setVisible(false);
		String vaciar = this.vista.getEscena("recibidor").getFondos().get("abiertoArriba").replace("Arriba", "ArribaVacio");
		this.vista.getEscena("recibidor").getFondos().remove("abiertoArriba");
		this.vista.getEscena("recibidor").getFondos().put("abiertoArriba", vaciar);		
		this.vista.obtenerObjeto("Cámara");
		this.vista.actualizaInventario();
		this.actualizaEscena();
	}

	protected void btnRecibidorAbajoActivado(MouseEvent e) {
		if (!this.vista.getEscena("recibidor").getEstado().equals("abiertoAbajo")) {
			this.vista.cambiarEstado("recibidor", "abiertoAbajo");
			this.btnRecibidorArribaVaciar.setVisible(false);
		}
		else {
			this.vista.cambiarEstado("recibidor", "normal");
		}
		this.actualizaEscena();

	}
	// Perchero
	protected void btnPercheroPuertaActivado(MouseEvent e) {this.cambiarEscena("perchero", this.vista.getEscena("perchero").getEstado());}
	protected void btnDestornilladorParteActivado(MouseEvent e) {
		this.btnDestornilladorParte.setVisible(false);
		this.vista.cambiarEstado("perchero", "vacio");
		this.actualizaEscena();
		this.vista.obtenerObjeto("Destornillador plano");
		this.vista.actualizaInventario();
	}

	// Carta
	protected void btnCartaActivado(MouseEvent e) {
		if(this.vista.getEleccion() != -1 && !this.vista.getObjeto("Sobre colorido").isObtenido() && !this.vista.getObjeto("Sobre blanco").isObtenido()) {
			if(this.vista.getEleccion() == Modelo.CIRCULO) {
				this.vista.obtenerObjeto("Sobre colorido");
			}
			else {
				this.vista.obtenerObjeto("Sobre blanco");
			}
			this.vista.actualizaInventario();
			this.vista.cambiarEstado("entrada", "normal");
			this.btnCarta.setVisible(false);
			this.actualizaEscena();
		}
	}
	// Puerta circulo
	protected void btnPuertaCirculoActivado(MouseEvent e) {this.cambiarEscena("puertacirculo", this.vista.getEscena("puertacirculo").getEstado());}
	protected void pwPuertaCirculoActivado(CaretEvent e) {
		this.lbFondo.setVisible(false);
		this.lbFondo.setVisible(true);
	}

	protected void pwPuertaCirculoActivado(KeyEvent e) {
		if(this.pwPuertaCirculo.getPassword().length > 4) {
			this.pwPuertaCirculo.setText("");
		}
	}
	protected void btnAbrirPuertaCirculoActivado(ActionEvent e) {
		if(this.pwPuertaCirculo.getText()!="" && this.pwPuertaCirculo.getText().matches("[0-9]+")) {
			int respuesta = Integer.parseInt(this.pwPuertaCirculo.getText());
			int correcto = this.vista.getNumeroB() * this.vista.getNumeroD() + this.vista.getNumeroA();
			if( respuesta == correcto) {
				this.vista.cambiarEstado("puertacirculo", "abierta");
				this.pwPuertaCirculo.setVisible(false);
				this.btnAbrirPuertaCirculo.setVisible(false);
				this.btnFinalActivado.setVisible(true);
				this.actualizaEscena();
				
			}
		}
	}
	
	// Puerta cuadrado
	protected void btnPuertaCuadradoActivado(MouseEvent e) {this.cambiarEscena("puertacuadrado", this.vista.getEscena("puertacuadrado").getEstado());}
	protected void pwPuertaCuadradoCaretActivado(CaretEvent e) {
		this.lbFondo.setVisible(false);
		this.lbFondo.setVisible(true);
	}

	protected void pwPuertaCuadradoActivado(KeyEvent e) {
		if(this.pwPuertaCuadrado.getPassword().length > 4) {
			this.pwPuertaCuadrado.setText("");
		}
	}
	protected void btnAbrirPuertaCuadradoActivado(ActionEvent e) {
		if(this.pwPuertaCuadrado.getText()!="" && this.pwPuertaCuadrado.getText().matches("[0-9]+")) {
			int respuesta = Integer.parseInt(this.pwPuertaCuadrado.getText());
			int correcto = this.vista.getNumeroB() * this.vista.getNumeroC() + this.vista.getNumeroA();
			if( respuesta == correcto) {
				this.vista.cambiarEstado("puertacuadrado", "abierta");
				this.pwPuertaCuadrado.setVisible(false);
				this.btnAbrirPuertaCuadrado.setVisible(false);
				this.btnFinalActivado2.setVisible(true);
				this.actualizaEscena();
			}
		}
	}
	
	// Final
	private void activarfinal(String tipo) {
		this.cambiarEscena("final", tipo);
		this.abajo.setVisible(false);
		this.btnInicio.setVisible(false);
		this.btnGuardar.setVisible(false);
		this.vista.mostrarInventario(false);
		this.btnInventario.setVisible(false);
	}
	protected void btnFinalActivadoActivado(ActionEvent e) {
		if(this.vista.getEscena("ordenador").getEstado().equals("ventanaInforme")) {
			this.activarfinal("bueno");
		}
		else {
			this.activarfinal("circulo");
		}
	}
	protected void btnFinalActivado2Activado(ActionEvent e) {
		this.activarfinal("cuadrado");
	}
}