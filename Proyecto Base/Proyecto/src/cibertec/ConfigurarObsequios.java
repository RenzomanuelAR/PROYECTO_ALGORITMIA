package cibertec;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConfigurarObsequios extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblUnidades;
	private JTextField textUnidad1;
	private JLabel lblUnidades_1;
	private JTextField textUnidad2;
	private JLabel lblAMs;
	private JTextField textUnidad3;
	private JButton btnAceptar;
	private JButton btnCancelar;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfigurarObsequios frame = new ConfigurarObsequios();
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
	public ConfigurarObsequios() {
		setTitle("Configurar obsequios");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 130);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblUnidades = new JLabel("1 unidad");
		lblUnidades.setBounds(10, 14, 99, 14);
		contentPane.add(lblUnidades);
		
		textUnidad1 = new JTextField();
		textUnidad1.setColumns(10);
		textUnidad1.setBounds(131, 11, 86, 20);
		contentPane.add(textUnidad1);
		
		lblUnidades_1 = new JLabel("2 a 5 unidades");
		lblUnidades_1.setBounds(10, 39, 99, 14);
		contentPane.add(lblUnidades_1);
		
		textUnidad2 = new JTextField();
		textUnidad2.setColumns(10);
		textUnidad2.setBounds(131, 36, 86, 20);
		contentPane.add(textUnidad2);
		
		lblAMs = new JLabel("6 a más unidades");
		lblAMs.setBounds(10, 64, 99, 14);
		contentPane.add(lblAMs);
		
		textUnidad3 = new JTextField();
		textUnidad3.setColumns(10);
		textUnidad3.setBounds(131, 61, 86, 20);
		contentPane.add(textUnidad3);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(306, 14, 89, 23);
		contentPane.add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(306, 48, 89, 23);
		contentPane.add(btnCancelar);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
	}
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		
		
	
	}
	

}
