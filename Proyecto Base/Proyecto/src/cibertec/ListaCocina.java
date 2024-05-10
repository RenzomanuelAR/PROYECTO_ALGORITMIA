package cibertec;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListaCocina extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JButton btnCerrar;
	private JButton btnListar;

<<<<<<< HEAD
=======

>>>>>>> 1c1794877c01b72473f11db8ff333db7354b1bde
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaCocina frame = new ListaCocina();
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
	public ListaCocina() {
		setTitle("Listado de Cocinas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 794);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 25, 387, 647);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCerrar.setBounds(95, 703, 95, 21);
		contentPane.add(btnCerrar);
		
		btnListar = new JButton("Listar");
		btnListar.addActionListener(this);
		btnListar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnListar.setBounds(270, 703, 95, 21);
		contentPane.add(btnListar);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
		if (e.getSource() == btnListar) {
			actionPerformedBtnListar(e);
		}
	}
	protected void actionPerformedBtnListar(ActionEvent e) {
		// Construir el texto para mostrar en el textArea
	    StringBuilder sb = new StringBuilder();
	    sb.append("Listado de Cocinas:\n\n");

	    // Iterar sobre los datos de cocinas y agregar cada cocina al texto
	    for (Object[] cocina : Tienda.datosCocinas) {
	        sb.append("Modelo: ").append(cocina[0]).append("\n");
	        sb.append("Precio: S/. ").append(cocina[1]).append("\n");
	        sb.append("Profundidad: ").append(cocina[2]).append(" cm\n");
	        sb.append("Ancho: ").append(cocina[3]).append(" cm\n");
	        sb.append("Alto: ").append(cocina[4]).append(" cm\n");
	        sb.append("Quemadores: ").append(cocina[5]).append("\n\n");
	    }

	    // Establecer el texto generado en el textArea
	    textArea.setText(sb.toString());
		
		
	}
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		
		dispose ();
	}
}
