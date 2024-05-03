package cibertec;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class EjemploReporte extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnVerVentas;
	private JScrollPane scrollPane;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EjemploReporte frame = new EjemploReporte();
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
	public EjemploReporte() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnVerVentas = new JButton("Ver Ventas");
		btnVerVentas.addActionListener(this);
		btnVerVentas.setBounds(54, 34, 131, 23);
		contentPane.add(btnVerVentas);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 87, 377, 163);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnVerVentas) {
			actionPerformedBtnVerVentas(e);
		}
	}
	protected void actionPerformedBtnVerVentas(ActionEvent e) {
		List<Object[]> listaVentas = Tienda.datosVentas;
		String desBoleta = "";
		Double totalVentas = 0.0;
		Integer unidadesVendidas = 0;
		desBoleta = "BOLETA DE VENTA \n\n";
		for(Object[] fila : listaVentas) {
			totalVentas += Double.parseDouble(fila[5].toString());
			unidadesVendidas += Integer.parseInt(fila[2].toString());
			
			desBoleta +=  "Modelo \t\t: " + fila[0] +"\n";
			desBoleta +=  "Precio \t\t: " + fila[1] +"\n";
			desBoleta +=  "Cantidad \t\t: " + fila[2] +"\n";
			desBoleta +=  "Importe compra \t\t: " + fila[3] +"\n";
			desBoleta +=  "Importe descuento \t\t: " + fila[4] +"\n";
			desBoleta +=  "Importe pagar \t\t: " + fila[5] +"\n";
			desBoleta +=  "Obsequio \t\t: " + fila[6];
			
			desBoleta +=  "\n\n";
			
		}
		textArea.setText(desBoleta + "\n\n");
		textArea.append("Total Ventas: " + totalVentas + "\n");
		textArea.append("Unidades Vendidas: " + unidadesVendidas + "\n");
		
	}
	
}
