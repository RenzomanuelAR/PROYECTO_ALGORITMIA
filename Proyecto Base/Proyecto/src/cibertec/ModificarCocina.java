package cibertec;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

public class ModificarCocina extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblModelo;
	private JLabel lblPrecio;
	private JLabel lblAncho;
	private JLabel lblAlto;
	private JLabel lblFondo;
	private JLabel lblQuemadores;
	private JTextField textPrecio;
	private JTextField textAncho;
	private JTextField textAlto;
	private JTextField textFondo;
	private JTextField textQuemadores;
	private JComboBox comboBox;
	private JButton btnGrabar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarCocina frame = new ModificarCocina();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ModificarCocina() {
		setTitle("Modificar Cocina");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblModelo = new JLabel("Modelo");
		lblModelo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblModelo.setBounds(32, 42, 96, 13);
		contentPane.add(lblModelo);
		
		lblPrecio = new JLabel("Precio (S/.)");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPrecio.setBounds(32, 65, 96, 13);
		contentPane.add(lblPrecio);
		
		lblAncho = new JLabel("Ancho");
		lblAncho.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAncho.setBounds(32, 88, 96, 13);
		contentPane.add(lblAncho);
		
		lblAlto = new JLabel("Alto (cm)");
		lblAlto.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAlto.setBounds(32, 111, 96, 13);
		contentPane.add(lblAlto);
		
		lblFondo = new JLabel("Fondo (cm)");
		lblFondo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFondo.setBounds(32, 134, 96, 13);
		contentPane.add(lblFondo);
		
		lblQuemadores = new JLabel("Quemadores");
		lblQuemadores.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblQuemadores.setBounds(32, 157, 96, 13);
		contentPane.add(lblQuemadores);
		
		textPrecio = new JTextField();
		textPrecio.setBounds(156, 63, 154, 19);
		contentPane.add(textPrecio);
		textPrecio.setColumns(10);
		
		textAncho = new JTextField();
		textAncho.setBounds(156, 86, 154, 19);
		contentPane.add(textAncho);
		textAncho.setColumns(10);
		
		textAlto = new JTextField();
		textAlto.setBounds(156, 109, 154, 19);
		contentPane.add(textAlto);
		textAlto.setColumns(10);
		
		textFondo = new JTextField();
		textFondo.setBounds(156, 132, 154, 19);
		contentPane.add(textFondo);
		textFondo.setColumns(10);
		
		textQuemadores = new JTextField();
		textQuemadores.setBounds(156, 155, 154, 19);
		contentPane.add(textQuemadores);
		textQuemadores.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Mabe EMP6120PG0", "Indurama Parma", "Sole COSOL027", "Coldex CX602", "", "Reco Dakota"}));
		comboBox.setBounds(156, 39, 154, 21);
		contentPane.add(comboBox);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCerrar.setBounds(341, 39, 85, 21);
		contentPane.add(btnCerrar);
		
		btnGrabar = new JButton("Grabar");
		btnGrabar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnGrabar.setBounds(341, 62, 85, 21);
		contentPane.add(btnGrabar);
	}
}
