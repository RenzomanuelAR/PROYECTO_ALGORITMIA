package cibertec;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Vender extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblmodelo;
	private JLabel lblprecio;
	private JLabel lblcantidad;
	private JComboBox comboBox;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnvender;
	private JButton btncerrar;
	private JScrollPane scrollPane;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vender frame = new Vender();
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
	public Vender() {
		setTitle("Vender");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblmodelo = new JLabel("Modelo");
		lblmodelo.setBounds(10, 14, 64, 17);
		contentPane.add(lblmodelo);
		
		lblprecio = new JLabel("Precio (S/)");
		lblprecio.setBounds(10, 42, 64, 20);
		contentPane.add(lblprecio);
		
		lblcantidad = new JLabel("Cantidad");
		lblcantidad.setBounds(10, 73, 64, 20);
		contentPane.add(lblcantidad);
		
		comboBox = new JComboBox();
		comboBox.setBounds(84, 11, 131, 22);
		contentPane.add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(84, 42, 131, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(84, 73, 131, 20);
		contentPane.add(textField_1);
		
		btnvender = new JButton("Vender");
		btnvender.setBounds(335, 11, 89, 23);
		contentPane.add(btnvender);
		
		btncerrar = new JButton("Cerrar");
		btncerrar.setBounds(335, 70, 89, 23);
		contentPane.add(btncerrar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 110, 414, 140);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setBounds(12, 128, 412, 121);
		contentPane.add(textArea);
	}
}
