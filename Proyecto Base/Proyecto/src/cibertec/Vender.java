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
		String descripcionModelo, obsequio;

		// lectura de controles
		modelo = cmbModelo.getSelectedIndex();
		descripcionModelo = cmbModelo.getSelectedItem().toString();

		// Validar la Cantidad ingresada Sea Diferente de Vacio o 0 unidades
		boolean esVacio = validacionEsVacioEsCero(textCantidad.getText(), "Debe ingresar una cantidad válida.");
		if(esVacio == true) {
			textCantidad.setText("");
			textCantidad.grabFocus();	
			return;
		}
	
		//Validar la cantidad ingresada sea diferente se un dato númerico
		boolean esNumero = esNumero(textCantidad.getText());
		
		//negamos el valor logico devuelto por el metodo validacion.esNumero
		if(esNumero == false) {
			textCantidad.setText("");
			textCantidad.grabFocus();	
			return;
		}

		//leer la cantidad ingresada
		cantidad = Integer.parseInt(textCantidad.getText());

		// Utilizando el Metodo buscarPrecio
		precio = buscarPrecio();

		// calcular importe compra
		impCompra = precio * cantidad;

		// Ulitizando el Metodo buscarPorcentajeDescuento
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

		// Guardar registro Ventas
		guardarVenta(descripcionModelo, precio, cantidad, impCompra, impDescuento, impPagar, obsequio);

		// Imprimir Boleta
		imprimirBoleta(descripcionModelo, precio, cantidad, impCompra, impDescuento, impPagar, obsequio,portDescuento);

		// Limpiar Controles
		textCantidad.setText("");
		textCantidad.grabFocus();
		
		// Mostrar mensaje de Ventas (cada 5 ventas)
		mostraAlertaCantidadVentas();		

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
		//Para armar el mensaje que se va a mostrar
		String mensaje = "";
		
		// Contar las ventas que se registran, es una variable global
		Tienda.contarVentas++;
	
		// Evaluar las 5 ventas
		if (Tienda.contarVentas == 5) {
			mensaje = "Venta Nro." + Tienda.contarVentas + "\n";
			mensaje = mensaje + "Importe Total general acumulado: S/." + Tienda.totalVentas + "\n";
			mensaje = mensaje + "Porcentaje de la Cuota diaria: " + Tienda.porcentajeVentas + "% \n";
			
			//mostrar mensaje en el cuadro de dialogo
			JOptionPane.showMessageDialog(null, mensaje);
			
			//reinicar la variable global contarVentas = 0
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
			Double impPagar, String obsequio, double porDescuento) {
		String desBoleta = "";
		// Imprimir Boleta
		desBoleta = "BOLETA DE VENTA \n\n";

		desBoleta +=  "Modelo \t\t: " + descripcionModelo + "\n";
		desBoleta +=  "Precio \t\t: " + precio + "\n";
		desBoleta +=  "Cantidad \t\t: " + cantidad + "\n";
		desBoleta +=  "Importe compra \t: " + impCompra + "\n";
		desBoleta +=  "Importe descuento ("+ porDescuento +" %) \t: " + impDescuento + "\n";
		desBoleta +=  "Importe pagar \t\t: " + impPagar + "\n";
		desBoleta +=  "Obsequio \t\t: " + obsequio;

		textResultado.setText(desBoleta);
	}
	
	//metodo validacionEsVacioEsCero: para validar si el dato ingresado es 0 o esta vacio
	//--Parametros: 
	//----datoEntrada: es el contenido a evaluar
	//----mensaje: es lo que se mostrará en el cuadro de dialogo
	public boolean validacionEsVacioEsCero(String datoEntrada,String mensaje) {
		//Eliminar los espacios en blanco antes y despues de una cadena de texto
		datoEntrada = datoEntrada.trim();
		
		//Si el contenido de la variable datoEntrada es igual a '0' o vacio 
		if (datoEntrada.equals("0") || datoEntrada.equals("")) {
			//muestra el cuadro dialogo de validación
			JOptionPane.showMessageDialog(null, mensaje, "Mensaje de Vadilación",  JOptionPane.ERROR_MESSAGE);
			return true;
		}
		return false;
	}
	
	//metodo esNumero: para validar si el dato ingresado es un numero
	//--Parametros: 
	//----datoEntrada: es el contenido a evaluar
	public boolean esNumero(String datoEntrada) {
		boolean retornar = true;
		//Validad que los datos ingresados sean de tipo numéricos
		try {
			//si el contenido es diferente de nulo
			if (datoEntrada != null) {
				//convertir a entero
				Integer.parseInt(datoEntrada);
			}
		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, "Debe ingresar un número entero.", "Mensaje de Vadilación",  JOptionPane.ERROR_MESSAGE);
			retornar = false;
		}
		
		return retornar;
	}
	
	

	protected void actionPerformedBtncerrar(ActionEvent e) {
		dispose();
	}
}
