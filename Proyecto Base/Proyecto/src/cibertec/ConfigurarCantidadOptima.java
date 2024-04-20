package cibertec;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ConfigurarCantidadOptima extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblCantidadptima;
	private JTextField textCantidad;
	private JButton btnAceptar;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfigurarCantidadOptima frame = new ConfigurarCantidadOptima();
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
	public ConfigurarCantidadOptima() {
		setTitle("Configurar cantidad óptima");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 449, 133);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCantidadptima = new JLabel("Cantidad óptima de unidades vendidas");
		lblCantidadptima.setBounds(10, 34, 197, 14);
		contentPane.add(lblCantidadptima);
		
		textCantidad = new JTextField();
		textCantidad.setColumns(10);
		textCantidad.setBounds(217, 31, 86, 20);
		contentPane.add(textCantidad);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(332, 14, 89, 23);
		contentPane.add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(332, 48, 89, 23);
		contentPane.add(btnCancelar);
	}

}
