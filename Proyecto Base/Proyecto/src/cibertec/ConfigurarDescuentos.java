package cibertec;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConfigurarDescuentos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblUnidad1;
	private JLabel lblUnidad2;
	private JLabel lblUnidad3;
	private JLabel lblUnidad4;
	private JTextField txtUnidad1;
	private JTextField txtUnidad2;
	private JTextField txtUnidad3;
	private JTextField txtUnidad4;
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
		
		txtUnidad1 = new JTextField();
		txtUnidad1.setBounds(142, 8, 86, 20);
		contentPane.add(txtUnidad1);
		txtUnidad1.setColumns(10);
		
		txtUnidad2 = new JTextField();
		txtUnidad2.setColumns(10);
		txtUnidad2.setBounds(142, 33, 86, 20);
		contentPane.add(txtUnidad2);
		
		txtUnidad3 = new JTextField();
		txtUnidad3.setColumns(10);
		txtUnidad3.setBounds(142, 58, 86, 20);
		contentPane.add(txtUnidad3);
		
		txtUnidad4 = new JTextField();
		txtUnidad4.setColumns(10);
		txtUnidad4.setBounds(142, 84, 86, 20);
		contentPane.add(txtUnidad4);
		
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
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        if (txtUnidad1.getText().trim().equals("")) {
		            JOptionPane.showMessageDialog(null, "Dato no válido en 1 a 5 unidades", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }
		        if (txtUnidad2.getText().trim().equals("")) {
		            JOptionPane.showMessageDialog(null, "Dato no válido en 6 a 10 unidades", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }
		        if (txtUnidad3.getText().trim().equals("")) {
		            JOptionPane.showMessageDialog(null, "Dato no válido en 11 a 15 unidades", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }
		        if (txtUnidad4.getText().trim().equals("")) {
		            JOptionPane.showMessageDialog(null, "Dato no válido en Más de 15 unidades", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }

		        // Asignar los valores de los campos a las propiedades estáticas de Tienda
		        try {
		            Tienda.porcentaje1 = Double.parseDouble(txtUnidad1.getText());
		            Tienda.porcentaje2 = Double.parseDouble(txtUnidad2.getText());
		            Tienda.porcentaje3 = Double.parseDouble(txtUnidad3.getText());
		            Tienda.porcentaje4 = Double.parseDouble(txtUnidad4.getText());

		            JOptionPane.showMessageDialog(null, "Configuración GUARDADA", "Configuración", JOptionPane.INFORMATION_MESSAGE);
		        } catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(null, "Error al convertir porcentajes a números", "Error", JOptionPane.ERROR_MESSAGE);
		        }
		
			}
		});
		btnAceptar.setBounds(317, 11, 89, 23);
		contentPane.add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(317, 45, 89, 23);
		contentPane.add(btnCancelar);
		
		mostrarDescuento();
	}
	void mostrarDescuento() {
	    txtUnidad1.setText(String.valueOf(Tienda.porcentaje1));
	    txtUnidad2.setText(String.valueOf(Tienda.porcentaje2));
	    txtUnidad3.setText(String.valueOf(Tienda.porcentaje3));
	    txtUnidad4.setText(String.valueOf(Tienda.porcentaje4));
	}

}
