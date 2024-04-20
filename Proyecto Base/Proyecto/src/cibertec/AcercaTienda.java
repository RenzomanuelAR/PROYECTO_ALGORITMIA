package cibertec;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AcercaTienda extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblAutores;
	private JButton btnCerrar;
	private JLabel lblAlumno1;
	private JLabel lblRenzo;
	private JLabel lblAlumno1_2;
	private JLabel lblAlumno1_3;
	private JLabel lblAlumno1_4;
	private JSeparator separator;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AcercaTienda frame = new AcercaTienda();
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
	public AcercaTienda() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Tienda 1.0");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(139, 11, 134, 14);
		contentPane.add(lblNewLabel);
		
		lblAutores = new JLabel("Autores");
		lblAutores.setHorizontalAlignment(SwingConstants.CENTER);
		lblAutores.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAutores.setBounds(139, 56, 134, 14);
		contentPane.add(lblAutores);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(162, 227, 89, 23);
		contentPane.add(btnCerrar);
		
		lblAlumno1 = new JLabel("Luis");
		lblAlumno1.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlumno1.setBounds(78, 81, 257, 14);
		contentPane.add(lblAlumno1);
		
		lblRenzo = new JLabel("Manuel Renzo Ancajima Romero");
		lblRenzo.setHorizontalAlignment(SwingConstants.CENTER);
		lblRenzo.setBounds(78, 106, 257, 14);
		contentPane.add(lblRenzo);
		
		lblAlumno1_2 = new JLabel("Luis");
		lblAlumno1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlumno1_2.setBounds(78, 131, 257, 14);
		contentPane.add(lblAlumno1_2);
		
		lblAlumno1_3 = new JLabel("Luis");
		lblAlumno1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlumno1_3.setBounds(78, 156, 257, 14);
		contentPane.add(lblAlumno1_3);
		
		lblAlumno1_4 = new JLabel("Luis");
		lblAlumno1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlumno1_4.setBounds(78, 181, 257, 14);
		contentPane.add(lblAlumno1_4);
		
		separator = new JSeparator();
		separator.setBounds(10, 36, 414, 2);
		contentPane.add(separator);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
}
