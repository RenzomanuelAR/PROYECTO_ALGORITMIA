package cibertec;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ConfigurarCuotaDiaria extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblCuotaDiariaEsperada;
	private JTextField textField;
	private JButton btnAceptar;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfigurarCuotaDiaria frame = new ConfigurarCuotaDiaria();
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
	public ConfigurarCuotaDiaria() {
		setTitle("Configurar cuota diaria");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 390, 116);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCuotaDiariaEsperada = new JLabel("Cuota diaria esperada (S/.)");
		lblCuotaDiariaEsperada.setBounds(10, 31, 146, 14);
		contentPane.add(lblCuotaDiariaEsperada);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(166, 28, 86, 20);
		contentPane.add(textField);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(279, 11, 89, 23);
		contentPane.add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(279, 45, 89, 23);
		contentPane.add(btnCancelar);
	}

}
