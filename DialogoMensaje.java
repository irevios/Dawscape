import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

public class DialogoMensaje extends JDialog {
	private JButton btnAceptar;
	private JScrollPane spn;
	private JTextArea txtrAwrawrawr;
	@SuppressWarnings("unused")
	private Vista vista;

	public DialogoMensaje(Vista vista) {
		setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
		setModal(true);
		this.vista = vista;
		setUndecorated(true);
		setBounds(0, 0, 1280, 720);
		this.setBackground(new Color(0,0,0,0));
		JPanel pn = new JPanel();
		pn.setBackground(new Color(20, 20, 20));

		this.btnAceptar = new JButton("Aceptar");
		this.btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAceptarActivado(e);
			}
		});
		this.btnAceptar.setForeground(Color.WHITE);
		this.btnAceptar.setFont(new Font("Montserrat Medium", Font.PLAIN, 13));
		this.btnAceptar.setBackground(new Color(53, 162, 141));
		this.btnAceptar.setSize(new Dimension(50, 50));
		this.btnAceptar.setMargin(new Insets(0, 0, 0, 0));
		this.btnAceptar.setContentAreaFilled(false);
		this.btnAceptar.setBorderPainted(false);
		this.btnAceptar.setBorder(new EmptyBorder(7, 7, 7, 7));
		this.btnAceptar.setOpaque(true);

		this.spn = new JScrollPane();
		this.spn.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		this.spn.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		this.spn.setBorder(new EmptyBorder(10, 10, 10, 10));
		this.spn.setVerifyInputWhenFocusTarget(false);
		this.spn.setRequestFocusEnabled(false);
		this.spn.setOpaque(false);
		this.spn.setFocusable(false);
		this.spn.setFocusTraversalKeysEnabled(false);
		GroupLayout gl_pn = new GroupLayout(pn);
		gl_pn.setHorizontalGroup(
			gl_pn.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pn.createSequentialGroup()
					.addGap(157)
					.addComponent(this.btnAceptar, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
					.addGap(156))
				.addGroup(gl_pn.createSequentialGroup()
					.addGap(31)
					.addComponent(this.spn, GroupLayout.PREFERRED_SIZE, 389, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(30, Short.MAX_VALUE))
		);
		gl_pn.setVerticalGroup(
			gl_pn.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pn.createSequentialGroup()
					.addContainerGap(20, Short.MAX_VALUE)
					.addComponent(this.spn, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(this.btnAceptar, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(19))
		);

		this.txtrAwrawrawr = new JTextArea();
		this.txtrAwrawrawr.setSelectionColor(new Color(255,255,255,150));
		this.txtrAwrawrawr.setWrapStyleWord(true);
		this.txtrAwrawrawr.setLineWrap(true);
		this.txtrAwrawrawr.setEditable(false);
		this.txtrAwrawrawr.setForeground(Color.WHITE);
		this.txtrAwrawrawr.setFont(new Font("Tahoma", Font.PLAIN, 19));
		this.txtrAwrawrawr.setCaretColor(Color.WHITE);
		this.txtrAwrawrawr.setBackground(new Color(20, 20, 20));
		this.spn.setViewportView(this.txtrAwrawrawr);
		pn.setLayout(gl_pn);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(415)
					.addComponent(pn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(415, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(296)
					.addComponent(pn, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(222, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
	}
	protected void btnAceptarActivado(ActionEvent e) {
		this.mostrar(false);
	}
	public void mostrar(boolean opcion) {
		this.setVisible(opcion);
	}
	
	public void setMensaje(String mensaje){
		this.txtrAwrawrawr.setText(mensaje);
	}
}
