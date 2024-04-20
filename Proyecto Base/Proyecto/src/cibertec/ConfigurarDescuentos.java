package cibertec;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ConfigurarDescuentos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblUnidad1;
	private JLabel lblUnidad2;
	private JLabel lblUnidad3;
	private JLabel lblUnidad4;
	private JTextField textUnidad1;
	private JTextField textUnidad2;
	private JTextField textUnidad3;
	private JTextField textUnidad4;
	private JLabel lblUnidad1_1;
	private JLabel lblUnidad1_2;
	private JLabel lblUnidad1_3;
	private JLabel lblUnidad1_4;
	private JButton btnAceptar;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfigurarDescuentos frame = new ConfigurarDescuentos();
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
	public ConfigurarDescuentos() {
		setTitle("Configurar porcentajes de descuentos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 152);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblUnidad1 = new JLabel("1 a 5 unidades");
		lblUnidad1.setBounds(21, 11, 99, 14);
		contentPane.add(lblUnidad1);
		
		lblUnidad2 = new JLabel("6 a 10 unidades");
		lblUnidad2.setBounds(21, 36, 99, 14);
		contentPane.add(lblUnidad2);
		
		lblUnidad3 = new JLabel("11 a 15 unidades");
		lblUnidad3.setBounds(21, 61, 99, 14);
		contentPane.add(lblUnidad3);
		
		lblUnidad4 = new JLabel("Más de 15 unidades");
		lblUnidad4.setBounds(21, 87, 120, 14);
		contentPane.add(lblUnidad4);
		
		textUnidad1 = new JTextField();
		textUnidad1.setBounds(142, 8, 86, 20);
		contentPane.add(textUnidad1);
		textUnidad1.setColumns(10);
		
		textUnidad2 = new JTextField();
		textUnidad2.setColumns(10);
		textUnidad2.setBounds(142, 33, 86, 20);
		contentPane.add(textUnidad2);
		
		textUnidad3 = new JTextField();
		textUnidad3.setColumns(10);
		textUnidad3.setBounds(142, 58, 86, 20);
		contentPane.add(textUnidad3);
		
		textUnidad4 = new JTextField();
		textUnidad4.setColumns(10);
		textUnidad4.setBounds(142, 84, 86, 20);
		contentPane.add(textUnidad4);
		
		lblUnidad1_1 = new JLabel("%");
		lblUnidad1_1.setBounds(235, 11, 23, 14);
		contentPane.add(lblUnidad1_1);
		
		lblUnidad1_2 = new JLabel("%");
		lblUnidad1_2.setBounds(235, 36, 23, 14);
		contentPane.add(lblUnidad1_2);
		
		lblUnidad1_3 = new JLabel("%");
		lblUnidad1_3.setBounds(235, 61, 23, 14);
		contentPane.add(lblUnidad1_3);
		
		lblUnidad1_4 = new JLabel("%");
		lblUnidad1_4.setBounds(235, 87, 23, 14);
		contentPane.add(lblUnidad1_4);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(317, 11, 89, 23);
		contentPane.add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(317, 45, 89, 23);
		contentPane.add(btnCancelar);
	}
}
