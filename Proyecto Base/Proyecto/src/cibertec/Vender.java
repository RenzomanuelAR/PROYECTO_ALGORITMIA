package cibertec;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import cibertec.Tienda;
import javax.swing.ScrollPaneConstants;

public class Vender extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblmodelo;
	private JLabel lblprecio;
	private JLabel lblcantidad;
	private JComboBox cmbModelo;
	private JTextField textPrecio;
	private JTextField textCantidad;
	private JButton btnvender;
	private JButton btncerrar;
	private JScrollPane scrollPane_1;
	private JTextArea textResultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vender frame = new Vender();
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
	public Vender() {
		setTitle("Vender");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblmodelo = new JLabel("Modelo");
		lblmodelo.setBounds(10, 14, 64, 17);
		contentPane.add(lblmodelo);

		lblprecio = new JLabel("Precio (S/)");
		lblprecio.setBounds(10, 42, 64, 20);
		contentPane.add(lblprecio);

		lblcantidad = new JLabel("Cantidad");
		lblcantidad.setBounds(10, 73, 64, 20);
		contentPane.add(lblcantidad);

		cmbModelo = new JComboBox();
		cmbModelo.setModel(new DefaultComboBoxModel(
				new String[] { "Mabe EMP6120PG0", "Indurama Parma", "Sole COSOL027", "Coldex CX602", "Reco Dakota" }));
		cmbModelo.setBounds(84, 11, 131, 22);
		contentPane.add(cmbModelo);

		cmbModelo.addActionListener(e -> {
			String seleccion = (String) cmbModelo.getSelectedItem();
			mostrarDatosCocina(seleccion);
		});

		textPrecio = new JTextField();
		textPrecio.setEditable(false);
		textPrecio.setBounds(84, 42, 131, 20);
		contentPane.add(textPrecio);
		textPrecio.setColumns(10);

		textCantidad = new JTextField();
		textCantidad.setColumns(10);
		textCantidad.setBounds(84, 73, 131, 20);
		contentPane.add(textCantidad);

		btnvender = new JButton("Vender");
		btnvender.addActionListener(this);
		btnvender.setBounds(335, 11, 89, 23);
		contentPane.add(btnvender);

		btncerrar = new JButton("Cerrar");
		btncerrar.addActionListener(this);
		btncerrar.setBounds(335, 70, 89, 23);
		contentPane.add(btncerrar);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(10, 104, 414, 146);
		contentPane.add(scrollPane_1);

		textResultado = new JTextArea();
		scrollPane_1.setViewportView(textResultado);

		// Mostrar automáticamente los datos de la primera cocina al iniciar la ventana
		mostrarDatosCocina((String) Tienda.datosCocinas[0][0]);
	}

	public void cerrar() {
		try {
			this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					confirmarSalida();
				}
			});
			this.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void confirmarSalida() {
		int valor = JOptionPane.showConfirmDialog(this, "¿Esta seguro de cerrar la aplicación?", "Advertencia",
				JOptionPane.YES_NO_OPTION);
		if (valor == JOptionPane.YES_OPTION) {
			JOptionPane.showMessageDialog(null, "Gracias", "Gracias", JOptionPane.INFORMATION_MESSAGE);
			dispose();
		}
	}

	// Buscar el Precio de la Cocina seleccionada

	private void mostrarDatosCocina(String seleccion) {
		for (Object[] datos : Tienda.datosCocinas) {
			String modelo = (String) datos[0];
			if (modelo.equals(seleccion)) {
				double precio = (double) datos[1];

				textPrecio.setText(String.valueOf(precio));

			}
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btncerrar) {
			actionPerformedBtncerrar(e);
		}
		if (e.getSource() == btnvender) {
			actionPerformedBtnvender(e);
		}
	}

	protected void actionPerformedBtnvender(ActionEvent e) {
		// Inicio
		// Entrada de Datos
		int modelo, cantidad;

		// declaración de variables internas
		Double precio, impCompra, impDescuento, impPagar, portDescuento;
		String descripcionModelo, obsequio, mensaje, desBoleta;

		// lectura de variables
		modelo = cmbModelo.getSelectedIndex();
		descripcionModelo = cmbModelo.getSelectedItem().toString();

		// Validad Cantidad ingresa Sea Diferente que Vacio y 0 unidades

		if (textCantidad.getText().equals("0") || textCantidad.getText().equals("")) {

			JOptionPane.showMessageDialog(null, "Debe ingresar una cantidad válida.", "Mensaje de Vadilación",  JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		//Validad que los datos ingresados sean de tipo numéricos
		try {
			if (textCantidad.getText() != null) {
				Integer.parseInt(textCantidad.getText());
			}
		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, "Debe ingresar un número entero.", "Mensaje de Vadilación",  JOptionPane.ERROR_MESSAGE);
			textCantidad.setText("");
			textCantidad.grabFocus();
			return;
		}

		cantidad = Integer.parseInt(textCantidad.getText());

		// Utilizando el Metodo buscarPrecio
		precio = buscarPrecio();

		// calcular importe compra
		impCompra = precio * cantidad;

		// Ulitizando el Metodod buscarPorcentajeDescuento
		portDescuento = buscarPorcentajeDescuento(cantidad);

		// Utilizando el Metodo buscarObsequio
		obsequio = buscarObsequio(cantidad);

		// Calcular el Importe descuento
		impDescuento = (impCompra * (portDescuento / 100));

		// Calcular Importe a Pagar
		impPagar = impCompra - impDescuento;

		// Acumular Ventas
		// totalVentas es una variable global para acumular las ventas
		Tienda.totalVentas += impPagar;

		// porcentajeVentas es una variable global para calcular la proporcion de ventas
		// sobre la cuota diaria
		Tienda.porcentajeVentas = ((Tienda.totalVentas * 100) / Tienda.cuotaDiaria);

		// Mostrar mensaje de Ventas (cada 5 ventas)
		mostraAlertaCantidadVentas();

		// Guardar registro Ventas
		guardarVenta(descripcionModelo, precio, cantidad, impCompra, impDescuento, impPagar, obsequio);

		// Imprimir Boleta
		imprimirBoleta(descripcionModelo, precio, cantidad, impCompra, impDescuento, impPagar, obsequio);

		// Limpiar Controles
		textCantidad.setText("");
		textCantidad.grabFocus();

		// Fin
	}

	// Metodo para Buscar el Precio
	Double buscarPrecio() {
		Double precio = Double.parseDouble(textPrecio.getText());

		
		return precio;
	}

	// Metodo para Hallar el Porcentaje de Descuento
	Double buscarPorcentajeDescuento(int cantidad) {
		Double portDescuento = 0.0;
		// Hallar porcentaje Descuento (porcentaje1,
		// porcentaje2,porcentaje3,porcentaje4, son Variables Globales)
		if (cantidad >= 1 && cantidad <= 5) {
			portDescuento = Tienda.porcentaje1;
		} else if (cantidad >= 6 && cantidad <= 10) {
			portDescuento = Tienda.porcentaje2;
		} else if (cantidad >= 11 && cantidad <= 15) {
			portDescuento = Tienda.porcentaje3;
		} else {
			portDescuento = Tienda.porcentaje4;
		}
		return portDescuento;
	}

	// Metodo para Hallar Obsequio
	String buscarObsequio(int cantidad) {
		String obsequio = "";

		// Hallar obsequio (obsequio1, obsequio2,obsequio3, son Variables Globales)
		if (cantidad == 1) {
			obsequio = Tienda.obsequio1;
		} else if (cantidad >= 2 && cantidad <= 5) {
			obsequio = Tienda.obsequio2;
		} else {
			obsequio = Tienda.obsequio3;
		}
		return obsequio;
	}

	void mostraAlertaCantidadVentas() {
		String mensaje = "";
		// Mostrar mensaje de Ventas (cada 5 ventas)
		// contarVentas es una variable global
		Tienda.contarVentas++;
		if (Tienda.contarVentas == 5) {
			mensaje = "Venta Nro." + Tienda.contarVentas + "\n";
			mensaje = mensaje + "Importe Total general acumulado: S/." + Tienda.totalVentas + "\n";
			mensaje = mensaje + "Porcentaje de la Cuota diaria: " + Tienda.porcentajeVentas + "% \n";
			JOptionPane.showMessageDialog(null, mensaje);

			Tienda.contarVentas = 0;
		}

	}

	// Metodo para Guardar Ventas
	void guardarVenta(String descripcionModelo, Double precio, int cantidad, Double impCompra, Double impDescuento,
			Double impPagar, String obsequio) {
		// Guardar registro Ventas
		Object[] datoVenta = new Object[7];
		datoVenta[0] = descripcionModelo;
		datoVenta[1] = precio;
		datoVenta[2] = cantidad;
		datoVenta[3] = impCompra;
		datoVenta[4] = impDescuento;
		datoVenta[5] = impPagar;
		datoVenta[6] = obsequio;

		// Agregar a la Lista de Ventas (Variable Global)
		Tienda.datosVentas.add(datoVenta);
	}

	// Metodo Para Imprimir Boleta
	void imprimirBoleta(String descripcionModelo, Double precio, int cantidad, Double impCompra, Double impDescuento,
			Double impPagar, String obsequio) {
		String desBoleta = "";
		// Imprimir Boleta
		desBoleta = "BOLETA DE VENTA \n\n";

		desBoleta = desBoleta + "Modelo \t\t: " + descripcionModelo + "\n";
		desBoleta = desBoleta + "Precio \t\t: " + precio + "\n";
		desBoleta = desBoleta + "Cantidad \t\t: " + cantidad + "\n";
		desBoleta = desBoleta + "Importe compra \t: " + impCompra + "\n";
		desBoleta = desBoleta + "Importe descuento \t: " + impDescuento + "\n";
		desBoleta = desBoleta + "Importe pagar \t\t: " + impPagar + "\n";
		desBoleta = desBoleta + "Obsequio \t\t: " + obsequio;

		textResultado.setText(desBoleta);
	}

	protected void actionPerformedBtncerrar(ActionEvent e) {
		dispose();
	}
}
