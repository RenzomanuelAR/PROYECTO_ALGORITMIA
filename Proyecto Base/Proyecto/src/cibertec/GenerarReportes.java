package cibertec;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.util.List;
import java.awt.event.ItemEvent;

public class GenerarReportes extends JDialog implements ActionListener, ItemListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JScrollPane scpScroll;
	private JLabel btnReporte;
	private JButton btnCerrar;
	private JComboBox cboReporte;
	private JTextArea txtS;
	// Declaración de la matriz de datos de reportes
	public static Object[][] datosReportes = { 
			{ "Mabe EMP6120PG0", 0, 0, 0, 0 }, 
			{ "Indurama Parma", 0, 0, 0, 0 },
			{ "Sole COSOL027", 0, 0, 0, 0 }, 
			{ "Coldex CX602", 0, 0, 0, 0 }, 
			{ "Reco Dakota", 0, 0, 0, 0 } };
	
	// Declaración de variables globales
	String reportVenta, reportveoptm, txtcanopt, model;
	Integer canunven, canvenopt;
	// Lista de ventas tipo Objeto guardadas (Variable Global)
	List<Object[]> listaVentas = Tienda.datosVentas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GenerarReportes dialog = new GenerarReportes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Create the dialog.
	 */
	public GenerarReportes() {
		setTitle("Generar reportes");
		setBounds(100, 100, 666, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		scpScroll = new JScrollPane();
		scpScroll.setBounds(10, 55, 630, 195);
		contentPanel.add(scpScroll);

		txtS = new JTextArea();
		scpScroll.setViewportView(txtS);

		btnReporte = new JLabel("tipo de reportes");
		btnReporte.setBounds(10, 24, 93, 14);
		contentPanel.add(btnReporte);

		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(551, 20, 89, 23);
		contentPanel.add(btnCerrar);

		cboReporte = new JComboBox();
		cboReporte.addItemListener(this);
		cboReporte.setModel(
				new DefaultComboBoxModel(new String[] { "Ventas por modelo", "Ventas en relación a la venta óptima",
						"Precios en relación al precio promedio", "Promedios, menores y mayores" }));
		cboReporte.setBounds(113, 20, 336, 22);
		contentPanel.add(cboReporte);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnNewButton(e);
		}
	}
	protected void actionPerformedBtnNewButton(ActionEvent e) {
		dispose();
	}
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == cboReporte) {
			itemStateChangedCboReporte(e);
		}
	}
	protected void itemStateChangedCboReporte(ItemEvent e) {
	    // Declaración de variables locales
		int tipo;
	    // Entrada de datos y metodos
		tipo = tiporeporte();
		reportedeVentas();
		reporteVentaOptima();
		imprimirDatos(tipo);
	}
	int tiporeporte() {
		return cboReporte.getSelectedIndex();
	}
	// Metodo de reporte de ventas
	void reportedeVentas() {
		//Asignamos un texto a la variable Globla reportVenta como titulo
		reportVenta = "VENTAS POR MODELO :\n\n";
		 // Declaración de variables locales
		//La propiedad length se utiliza para obtener el número de elementos en un arreglo.
		int cantidadCocinas = datosReportes.length;
		//Se trata de un bucle for que itera sobre una matriz bidimensional llamada datosReportes
		//Este bucle se utiliza para iterar a través de cada fila
		for (Object[] filaReporte : datosReportes) {
			//Cada fila se asigna a la variable filaReporte
			//Asignación de valores
			filaReporte[1] = 0;
			filaReporte[2] = 0;
			filaReporte[3] = 0;
			filaReporte[4] = 0;
			//Este bucle se utiliza para iterar a través de cada fila en el arreglo bidimensional listaVentas
			for (Object[] filaVenta : listaVentas) {
		    //Se verifica si el primer elemento de filaReporte es igual al primer elemento de filaVenta, se ejecutan las siguientes acciones
				if (filaReporte[0].equals(filaVenta[0])) {
					//Se incrementa en la suma
					filaReporte[1] = Integer.parseInt(filaReporte[1].toString())+ Integer.parseInt(filaVenta[2].toString());
					filaReporte[2] = Double.parseDouble(filaReporte[2].toString())+ Double.parseDouble(filaVenta[5].toString());
					//Cálculo de porcentaje
					filaReporte[3] = Double.parseDouble(filaReporte[2].toString()) / cantidadCocinas / 100;
					//Incremento de contador
					filaReporte[4] = Integer.parseInt(filaReporte[4].toString()) + 1;
				}
			}
		}
		//El bucle for se utiliza para iterar sobre un conjunto de datos
		//Estamos iterando sobre un conjunto de objetos llamado datosReportes
		//Cada elemento de datosReportes se almacena en la variable filaReporte
		for (Object[] filaReporte : datosReportes) {
			// Generación del informe
			//Se concatena el valores en la variable reportVenta
			reportVenta += "Modelo                            : " + filaReporte[0] + "\n";
			reportVenta += "Cantidad de ventas               : " + filaReporte[4] + "\n";
			reportVenta += "Cantidad de unidades vendidas     : " + filaReporte[1] + "\n";
			reportVenta += "Importe total vendido             : " + "S/." + filaReporte[2] + "\n";
			reportVenta += "Aporte a la cuota diaria          : " + filaReporte[3] + "%" + "\n";
			reportVenta += "\n";
		}
	}
	// Método de reporte de ventas óptimas
	void reporteVentaOptima() {
		//Se trata de un bucle for que itera sobre una matriz bidimensional llamada datosReportes
		//Este bucle se utiliza para iterar a través de cada fila
		for (Object[] filaReporte : datosReportes) {
			filaReporte[1] = 0;
			filaReporte[2] = 0;
			filaReporte[3] = 0;
			//Este bucle se utiliza para iterar a través de cada fila en el arreglo bidimensional listaVentas
			for (Object[] filaVenta : listaVentas) {
			 //Se verifica si el primer elemento de filaReporte es igual al primer elemento de filaVenta, se ejecutan las siguientes acciones
				if (filaReporte[0].equals(filaVenta[0])) {
					//Se incrementa en la suma
					filaReporte[1] = Integer.parseInt(filaReporte[1].toString())+ Integer.parseInt(filaVenta[2].toString());
				}
			}
		}
		//Calcular y comparar la cantidad con la cantidad óptima
		reportveoptm = "VENTAS EN RELACIÓN A LA VENTA ÓPTIMA :\n\n";
		//El bucle for se utiliza para iterar sobre un conjunto de datos
		for (Object[] fila : datosReportes) {
			//Variable para volver de entero a cadena
			String cantidadStr = "";
			//Asignar un valor a cada fila
			canunven = Integer.parseInt(fila[1].toString());
			model = String.valueOf(fila[0].toString());
			//Calcular la cantidad optima usando selección doble if...else 
			if (canunven > Tienda.cantidadOptima) {
				canvenopt = (canunven - Tienda.cantidadOptima);
				txtcanopt = "más que la cantidad óptima";
			} else if (canunven < Tienda.cantidadOptima) {
				canvenopt = (Tienda.cantidadOptima - canunven);
				txtcanopt = "menos que la cantidad óptima";
			} else {
				canvenopt = (canunven - Tienda.cantidadOptima);
				txtcanopt = "igual a la cantidad óptima";
			}
			//Si el numero es 0 lo convertimos a string para que desaparezca
			if (canvenopt == 0) {
				cantidadStr = "";
			} else {
				cantidadStr = canvenopt.toString();
			}
			//Se concatena el valores en la variable reportveoptm
			reportveoptm += "Modelo                          : " + model + "\n";
			reportveoptm += "Cantidad de unidades vendidas   : " + canunven + "(" + cantidadStr + " " + txtcanopt + ")"+ "\n";
			reportveoptm += "\n";
		}
	}
	// Mostrar tipos de reporte
	void imprimirDatos(int tipo) {
		switch (tipo) {
		case 0:
			txtS.setText("");
			imprimir(reportVenta);
			break;
		case 1:
			txtS.setText("");
			imprimir(reportveoptm);
			break;
		case 2:
			//Declaración de variables locales
			double promedioPrecio = 0, sumaPrecios = 0;
			//Asignamos una variable a la propiedad length
			int cantidadCocinas = Tienda.datosCocinas.length;
			//Este bucle se utiliza para iterar a través de cada fila de datosCocinas
			for (Object[] filaCocina : Tienda.datosCocinas) {
			//La suma de los precios se acumulan en la variable sumaPrecio	
			sumaPrecios += Double.parseDouble(filaCocina[1].toString());
			}
			//Calcular precio promedio de todas las cocinas
			promedioPrecio = sumaPrecios / cantidadCocinas;
			//Imprimir en el textArea
			txtS.setText("");
			imprimir(" PRECIOS EN RELACIÓN AL PRECIO PROMEDIO  : ");
			imprimir(" Precio promnedio de una Cocina  : S/. " + promedioPrecio);
			imprimir("");
			//Este bucle se utiliza para iterar a través de cada fila de datosCocinas
			for (Object[] fila : Tienda.datosCocinas) {
				//Variable para volver de entero a cadena
				String descripcion = "";
				//Calcuño del mayor, menor, igual
				if (Double.parseDouble(fila[1].toString()) > promedioPrecio) {
					descripcion = " (Mayor al promedio)";
				} else if (Double.parseDouble(fila[1].toString()) < promedioPrecio) {
					descripcion = " (Menor al promedio)";
				} else {
					descripcion = " (Igual al promedio)";
				}
				//Imprimir en el textArea
				imprimir("");
				imprimir(" Modelo     : " + fila[0]);
				imprimir(" Precio     : " + "S/ ." + " " + fila[1] + descripcion);
			}
			break;
		default:
			txtS.setText("");
			imprimir(" PROMEDIOS, MENORES Y MAYORES  : ");
			// Inicio Promedio, mayor, menor del Precio
			//Inicialización de variables
			double precioPromedio = 0, precioMenor = 0, precioMayor = 0, sumaPrecio = 0;
			double precioActual = 0;
			//Se utiliza como un indicador para que la inicialización de los valores solo ocurra una vez al comienzo del bucle.
			int fila0 = 0;
			//Este bucle se utiliza para iterar a través de cada fila de datosCocinas
			for (Object[] fila : Tienda.datosCocinas) {
				//Asignar un valor a la fila
				precioActual = Double.parseDouble(fila[1].toString());
				//Incrementar el valor de sumaPrecio
				sumaPrecio += precioActual;
				if (fila0 == 0) {
					precioMenor = precioActual;
					precioMayor = precioActual;
					fila0 = 1;
				}
				// Hallar el precio menor
				if (precioActual < precioMenor) {
					precioMenor = precioActual;
				}
				// Hallar el precio mayor
				if (precioActual > precioMayor) {
					precioMayor = precioActual;
				}
			}
			//Calcular precio promedio
			precioPromedio = sumaPrecio / 5;
			//Imprimir en el textArea
			imprimir("");
			imprimir(" Precio promedio            : " + "S/." + precioPromedio);
			imprimir(" Precio menor               : " + "S/." + precioMenor);
			imprimir(" Precio mayor               : " + "S/." + precioMayor);
			// fin
			// Inicio Promedio, mayor, menor del Ancho
			double anchoPromedio = 0, anchoMenor = 0, anchoMayor = 0, sumaAncho = 0;
			double anchoActual = 0;
			int filat1 = 0;
			for (Object[] fila : Tienda.datosCocinas) {
				anchoActual = Double.parseDouble(fila[3].toString());
				sumaAncho += anchoActual;
				if (filat1 == 0) {
					anchoMenor = anchoActual;
					anchoMayor = anchoActual;
					filat1 = 1;
				}
				// Hallar el precio menor
				if (anchoActual < anchoMenor) {
					anchoMenor = anchoActual;
				}

				// Hallar el precio mayor
				if (anchoActual > anchoMayor) {
					anchoMayor = anchoActual;
				}
			}
			anchoPromedio = sumaAncho / 5;
			imprimir("");
			imprimir(" Ancho promedio             : " + "S/." + anchoPromedio);
			imprimir(" Ancho menor                : " + "S/." + anchoMenor);
			imprimir(" Ancho mayor                : " + "S/." + anchoMayor);
			// Fin.
			// Inicio Promedio, mayor, menor del Fondo
			double fondoPromedio = 0, fondoMenor = 0, fondoMayor = 0, sumaFondo = 0;
			double fondoActual = 0;
			int fila2 = 0;
			for (Object[] fila : Tienda.datosCocinas) {
				fondoActual = Double.parseDouble(fila[2].toString());
				sumaFondo += fondoActual;
				if (fila2 == 0) {
					fondoMenor = fondoActual;
					fondoMayor = fondoActual;
					fila2 = 1;
				}
				// Hallar el precio menor
				if (fondoActual < fondoMenor) {
					fondoMenor = fondoActual;
				}
				// Hallar el precio mayor
				if (fondoActual > fondoMayor) {
					fondoMayor = fondoActual;
				}
			}
			fondoPromedio = sumaFondo / 5;
			imprimir("");
			imprimir(" Fondo promedio             : " + "S/." + fondoPromedio);
			imprimir(" Fondo menor                : " + "S/." + fondoMenor);
			imprimir(" Fondo mayor                : " + "S/." + fondoMayor);
			// Fin.
			// Inicio Promedio, mayor, menor del Alto
			double altoPromedio = 0, altoMenor = 0, altoMayor = 0, sumaAlto = 0;
			double altoActual = 0;
			int fila3 = 0;
			for (Object[] fila : Tienda.datosCocinas) {
				altoActual = Double.parseDouble(fila[4].toString());
				sumaAlto += altoActual;
				if (fila3 == 0) {
					altoMenor = altoActual;
					altoMayor = altoActual;
					fila3 = 1;
				}
				// Hallar el precio menor
				if (altoActual < altoMenor) {
					altoMenor = altoActual;
				}
				// Hallar el precio mayor
				if (altoActual > altoMayor) {
					altoMayor = altoActual;
				}
			}
			altoPromedio = sumaAlto / 5;
			imprimir("");
			imprimir(" Alto promedio              : " + "S/." + altoPromedio);
			imprimir(" Alto menor                 : " + "S/." + altoMenor);
			imprimir(" Alto mayor                 : " + "S/." + altoMayor);
			// Fin.
			// Inicio Promedio, mayor, menor del Quemador
			int quemadoresPromedio = 0, quemadoresMenor = 0, quemadoresMayor = 0, sumaQuemadores = 0;
			int quemadoresActual = 0;
			int fila4 = 0;
			for (Object[] fila : Tienda.datosCocinas) {
				quemadoresActual = Integer.parseInt(fila[5].toString());
				sumaQuemadores += quemadoresActual;
				if (fila4 == 0) {
					quemadoresMenor = quemadoresActual;
					quemadoresMayor = quemadoresActual;
					fila4 = 1;
				}
				// Hallar el precio menor
				if (quemadoresActual < quemadoresMenor) {
					quemadoresMenor = quemadoresActual;
				}
				// Hallar el precio mayor
				if (quemadoresActual > quemadoresMayor) {
					quemadoresMayor = quemadoresActual;
				}
			}
			quemadoresPromedio = sumaQuemadores / 5;
			imprimir("");
			imprimir(" Quemadores promedio        : " + "S/." + quemadoresPromedio);
			imprimir(" Quemadores menor           : " + "S/." + quemadoresMenor);
			imprimir(" Quemadores mayor           : " + "S/." + quemadoresMayor);
			// Fin.
		}
	}
	void imprimir(String cad) {
		txtS.append(cad + "\n");
	}
}
