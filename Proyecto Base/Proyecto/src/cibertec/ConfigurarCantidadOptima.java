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

public class ConfigurarCantidadOptima extends JFrame implements ActionListener {


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
		
		 // Mostrar el valor actual de cantidadOptima en el JTextField al abrir la ventana
        textCantidad.setText(String.valueOf(Tienda.cantidadOptima)); 
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(332, 14, 89, 23);
		contentPane.add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(332, 48, 89, 23);
		contentPane.add(btnCancelar);
	}
	
	

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
		if (e.getSource() == btnAceptar) {
			
		}
	}
	
	protected void actionPerformedBtnProcesar(ActionEvent e) {
		
		 // Obtener el valor ingresado en el JTextField
        String cantidadStr = textCantidad.getText();

        try {
            // Convertir el valor a entero y actualizar cantidadOptima en Tienda
            int nuevaCantidad = Integer.parseInt(cantidadStr);
            Tienda.cantidadOptima = nuevaCantidad;
        } catch (NumberFormatException ex) {
            System.err.println("Error: Ingrese un número válido.");
        }

        dispose(); // Cerrar la ventana después de actualizar cantidadOptima
		
	}
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		
		dispose ();
		
	}
}
