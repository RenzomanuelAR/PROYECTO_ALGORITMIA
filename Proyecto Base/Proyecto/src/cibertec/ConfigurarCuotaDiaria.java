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

public class ConfigurarCuotaDiaria extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblCuotaDiariaEsperada;
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
		
		textCantidad = new JTextField();
		textCantidad.setColumns(10);
		textCantidad.setBounds(166, 28, 86, 20);
		contentPane.add(textCantidad);
		
		textCantidad.setText(String.valueOf(Tienda.cuotaDiaria));
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(279, 11, 89, 23);
		contentPane.add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(279, 45, 89, 23);
		contentPane.add(btnCancelar);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
	}
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		
		// Obtener el valor ingresado en el JTextField
        String cantidadStr = textCantidad.getText();

        try {
            // Convertir el valor a entero y actualizar cantidadOptima en Tienda
            int nuevaCantidad = Integer.parseInt(cantidadStr);
            Tienda.cuotaDiaria = nuevaCantidad;
        	JOptionPane.showMessageDialog(null, "Configuracion grabada", "Informacion", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException ex) {
        	JOptionPane.showMessageDialog(null, "Dato no valido", "Error", JOptionPane.ERROR_MESSAGE);
        }

        dispose(); // Cerrar la ventana después de actualizar cantidadOptima
		
	}
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		
		dispose ();
	}
}
